/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.example;

import edu.fh.kanban.database.Board;
import edu.fh.kanban.database.Card;
import edu.fh.kanban.database.Column;
import edu.fh.kanban.database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ronald
 */
public class DatabaseTest {
    private Board b;
    private Column co;
    private Card ca;
    
    private ResultSet rs;
    
    private int b_id = -1;
    
    /** Da 
     * 
     */
    
    
    public DatabaseTest(){
         b = new Board();
         co = new Column();
         ca = new Card();   
    }
    
    /**
     * Erstellt ein Beispiel Board
     */
    public void createBoard(){
        b_id = b.insertRowAndReturn("Board", "Red");
    }
    
    /**
     * Erstellt mehrere Beispiel Spalten (Columns)
     */
    public void createColumn(){
        //Wenn ein Board erstellt wurde
        if(b_id > -1){
            co.insertRow(b_id, "Next", 2);
            co.insertRow(b_id, "Dev", 5);
            co.insertRow(b_id, "Done", 6);
        }
    }
    
    /**
     * Schwer zu Simulieren und zu Testen, da die Columns id benötigt wird, welche man in der Praxis besser zur Laufzeit abfragen kann.
     */
    public void createCard(){
        //ca.insertRow(co_id, "Karte1", "Beschreibung", 2, 3, "Fixed Date");
    }
    
    public void getBoardRows(){
        try {
            rs = b.getRows();
            while(rs.next()){
                System.out.println("Board: " + rs.getString("Name")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
