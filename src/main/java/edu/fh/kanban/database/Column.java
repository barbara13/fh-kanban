/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronald
 */
public class Column implements DBFunctions{
    private DatabaseManager db;
    private ResultSet rs;
    private int id;
    
    public Column(){
        db = new DatabaseManager();
    }
    
    /**
     * Hinzufügen einer Spalte(Column) zum Board in die DB.
     * @param b_id
     * @param name
     * @param w_ip
     * @return Die Id der hinzugefügten Datensatzes
     */
    public int insertRow(int b_id, String name, int w_ip) {
        return db.executeUpdateStatement("INSERT INTO Col (B_id, Name, Wip) VALUES("+b_id+",'"+name+"',"+w_ip+")");
    }
    
    @Override
    public void deleteRow(int id) {
        db.executeUpdateStatement("DELETE FROM Col WHERE Co_id = "+id);
    }

    @Override
    public ResultSet getRows() {
        return db.executeQueryStatement("SELECT * FROM Col");
    }

    @Override
    public ResultSet getRows(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId(String value) {
        rs = db.executeQueryStatement("SELECT Co_id FROM Col WHERE Name = '"+value+"'");
        try {
            id = Integer.parseInt(rs.getString("Co_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    /**
     * Name der Spalte in der DB ändern.
     * @param co_id
     * @param name 
     */    
    public void setName(int co_id, String name){
        db.executeUpdateStatement("UPDATE Col SET Name = '"+name+"' WHERE Co_id = "+co_id);
    }
    
    /**
     * W_ip einer Spalte ändern.
     * @param co_id
     * @param wip 
     */
    public void setWip(int co_id, int wip){
        db.executeUpdateStatement("UPDATE Col SET Wip = "+wip+" WHERE Co_id = "+co_id);
    }   
      
  
    
}
