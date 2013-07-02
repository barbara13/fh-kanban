/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  edu.fh.kanban.database;;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class Card implements DBFunctions{
    private DatabaseManager db;
    private ResultSet rs;
    private int id;
    
    public Card(){
        db = new DatabaseManager();
    }
    
    /**
     * Hinzufügen einer Card zu einer Column(Spalte) mit einem Status 
     * @param ca_id
     * @param co_id
     * @param name
     * @param description
     * @param effort
     * @param value
     * @param status
     * @return Die Id der hinzugefügten Datensatzes
     */
    public int insertRow(int co_id,String name, String description ,int effort, int value, String status) {
        return db.executeUpdateStatement("INSERT INTO Card (Co_id, Name, Description, Effort, Value, Status) VALUES("+co_id+",'"+name+"','"+description+"',"+effort+","+value+",'"+status+"')");
    }
    

    @Override
    public void deleteRow(int id) {
        db.executeUpdateStatement("DELETE FROM Card WHERE Ca_id = "+id);
    }

    @Override
    public ResultSet getRows() {
        return db.executeQueryStatement("SELECT * FROM Card");
    }

    @Override
    public ResultSet getRows(String name, String value) {
        return db.executeQueryStatement("SELECT * FROM Card WHERE "+name+" = '"+value+"'");
    }

    @Override
    public int getId(String value) {
        rs = db.executeQueryStatement("SELECT Ca_id FROM Card WHERE Name = '"+value+"'");
        try {
            id = Integer.parseInt(rs.getString("B_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    /**
     * Name einer Card ändern.
     * @param ca_id
     * @param name 
     */
    public void setName(int ca_id, String name){
        db.executeUpdateStatement("UPDATE Card SET Name = '"+name+"' WHERE Ca_id = "+ca_id);
    }
    
    /**
     * Beschreibung einer Card ändern.
     * @param ca_id
     * @param description 
     */
    public void setDescription(int ca_id, String description){
        db.executeUpdateStatement("UPDATE Card SET Description = '"+description+"' WHERE Ca_id = "+ca_id);
    }
    
    /**
     * Aufwand einer Card ändern.
     * @param ca_id
     * @param effort 
     */
    public void setEffort(int ca_id, int effort){
        db.executeUpdateStatement("UPDATE Card SET Effort = "+effort+" WHERE Ca_id = "+ca_id);
    }
    
    /**
     * Wert einer Card ändern.
     * @param ca_id
     * @param value 
     */
    public void setValue(int ca_id, int value){
        db.executeUpdateStatement("UPDATE Card SET Value = "+value+" WHERE Ca_id = "+ca_id);
    }
    
    /**
     * Status einer Card ändern.
     * @param ca_id
     * @param status 
     */
    public void setStatus(int ca_id, String status){
        db.executeUpdateStatement("UPDATE Card SET Statuts = '"+status+"' WHERE Ca_id = "+ca_id);
    }
}
