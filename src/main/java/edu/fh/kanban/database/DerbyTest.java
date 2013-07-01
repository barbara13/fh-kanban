/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  edu.fh.kanban.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class DerbyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Board b = new Board();
        Card c = new Card();
        
        ResultSet rs;
        db.createConnection();
        
        b.insertRow("board1", "red");
        c.insertRow(1, "card1", 2, 24, "started");
        
        rs = b.getRows();
        try {
            while(rs.next()){
                System.out.println(rs.getString("Name"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DerbyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        db.closeConnection();

    }
}
