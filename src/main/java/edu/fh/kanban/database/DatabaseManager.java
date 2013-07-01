package derbytest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malte
 */
public class DatabaseManager {

    private static Connection con;
    private ResultSet rs;
    private Statement stmnt;
    
    private static Properties prop = new Properties();
    
    
    public DatabaseManager() {
    }

    public void createConnection() {
        
        try {
            //Datenbanktreiber laden
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Lader der Configdatei
            prop.load(new FileInputStream("src\\derbyTest\\config.ini"));
            
            //Datenbankdaten aus config.ini auslesen
            String databaseDir = prop.getProperty("databaseDir");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            
            //Verbindung zur Datenbank aufbauen
            con = DriverManager.getConnection("jdbc:derby:"+databaseDir+";create=true;bootPassword=a@"+password+";user="+user+"");

            //Create Table Board
            createTableIfNotExist("Board", "CREATE TABLE Board (B_id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, Name varchar(50) NOT NULL,Color varchar(15))");

            //Create Table Column
            createTableIfNotExist("Column", "CREATE TABLE Column(Co_id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, B_id int CONSTRAINT fk_column REFERENCES Board(B_id),Name varchar(50) NOT NULL,Wip int)");

            //Create Table Card
            createTableIfNotExist("Card", "CREATE TABLE Card (Ca_id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, Co_id int CONSTRAINT fk_card REFERENCES Coloumn(Co_id),Name varchar(50) NOT NULL,Description varchar(300) ,Value int,Status varchar(10))");

        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Führt eine Datenbank Anweisung aus
     *
     * @param statement
     */
    public void executeUpdateStatement(String statement) {
        try {
            stmnt = con.createStatement();
            stmnt.executeUpdate(statement);
            stmnt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Führt eine Datenbank Abfrage aus und gibt das Ergebnis zurück
     *
     * @param query
     * @return
     */
    public ResultSet executeQueryStatement(String query) {
        try {
            stmnt = con.createStatement();
            rs = stmnt.executeQuery(query);
            //stmnt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    /**
     * @param connection
     * @throws SQLException
     */
    private static void showContentsOfTableTest(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM test");
        int columnCnt = resultSet.getMetaData().getColumnCount();
        boolean shouldCreateTable = true;
        while (resultSet.next() && shouldCreateTable) {
            for (int i = 1; i <= columnCnt; i++) {
                System.out.print(resultSet.getString(i) + " ");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
    }

    private static void populateTableTestIfItHasNotBeenPopulatedYet(Connection connection) throws Exception {

        boolean shouldPopulateTable = true;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test");
        if (resultSet.next()) {
            shouldPopulateTable = resultSet.getInt(1) == 0;
        }
        resultSet.close();
        statement.close();

        if (shouldPopulateTable) {
            System.out.println("Populating Table test...");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test VALUES (?,?)");
            String[] data = {"AAA", "BBB", "CCC", "DDD", "EEE"};
            for (int i = 0; i < data.length; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, data[i]);
                preparedStatement.execute();
            }
            preparedStatement.close();
        }
    }

    private void createTableIfNotExist(String tablename, String statement) {
        try {
            rs = con.getMetaData().getTables("%", "%", "%", new String[]{"TABLE"});
            int columnCnt = rs.getMetaData().getColumnCount();
            boolean shouldCreateTable = true;
            while (rs.next() && shouldCreateTable) {
                if (rs.getString("TABLE_NAME").equalsIgnoreCase(tablename)) {
                    shouldCreateTable = false;
                }
            }
            rs.close();
            if (shouldCreateTable) {
                System.out.println("Creating Table...");
                stmnt = con.createStatement();
                //stmnt.execute("create table test (id int not null, data varchar(32))");
                stmnt.execute(statement);
                stmnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
