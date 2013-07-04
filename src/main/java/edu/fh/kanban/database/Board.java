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
 * @author Malte
 */
public class Board implements DBFunctions{
    private DatabaseManager db;
    private ResultSet rs;
    private int id;
    
    public Board(){
        db = new DatabaseManager();
    }
    
    /**
     * Hinzufügen eines Boards in die DB.
     * @param name
     * @param red
     * @param yellow
     * @param green
     * @param blue
     */   
    public void insertRow(String name, String red, String yellow, String green, String blue) {
        db.executeUpdateStatementAndReturn("INSERT INTO Board (Name, Red, Yellow, Green, Blue) VALUES('"+name+"','"+red+"','"+yellow+"','"+green+"','"+blue+"')");   
    }
    
    /**
     * Hinzufügen eines Boards in die DB, wobei die id zurückkommt.
     * @param name
     * @param red
     * @param yellow
     * @param green
     * @param blue
     * @return Die Id der hinzugefügten Datensatzes
     */
    public int insertRowAndReturn(String name, String red, String yellow, String green, String blue) {
        return db.executeUpdateStatementAndReturn("INSERT INTO Board (Name, Red, Yellow, Green, Blue) VALUES('"+name+"','"+red+"','"+yellow+"','"+green+"','"+blue+"')");   
    }
    
    @Override
    public void deleteRow(int id) {
        db.executeUpdateStatement("DELETE FROM Board WHERE B_id = "+id);
    }

    @Override
    public ResultSet getRows() {
        return db.executeQueryStatement("SELECT * FROM Board");
    }
    
    @Override
    public ResultSet getRows(String name, String value) {
        return db.executeQueryStatement("SELECT * FROM Board WHERE "+name+" = '"+value+"'");
    }

    @Override
    public int getId(String value) {
        rs = db.executeQueryStatement("SELECT B_id FROM Board WHERE Name = '"+value+"'");
        try {
            id = Integer.parseInt(rs.getString("B_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    /**
     * Name des Boards in der DB ändern.
     * @param b_id
     * @param name 
     */
    public void setName(int b_id, String name){
        db.executeUpdateStatement("UPDATE Board SET Name = '"+name+"' WHERE B_id = "+b_id);
    }
    
    /**
     * Farbe des Boards in der DB ändern.
     * @param b_id
     * @param color 
     */
    public void setColor(int b_id, String color){
        db.executeUpdateStatement("UPDATE Board SET Color = '"+color+"' WHERE B_id = "+b_id);
    }
    
}
