/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbytest;

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
    
    public void insertRow(int b_id, String name, int value, int outlay, String status) {
        db.executeUpdateStatement("INSERT INTO Card (B_id, Name, Value, Outlay, Status) VALUES("+b_id+",'"+name+"',"+value+","+outlay+",'"+status+"')");
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
}
