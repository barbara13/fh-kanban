/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  edu.fh.kanban.database;

import java.sql.ResultSet;

/**
 *
 * @author Malte
 */
public interface DBFunctions {

    /**
     * Fügt einen Datensatz in den Datenbank ein
     *
     * @param discription
     *
     */
    //public void insertRow(int id);
    
    public void deleteRow(int id);

    /**
     * Gibt alle Datensätze der Tabelle zurück
     *
     * @return ResultSet
     */
    public  ResultSet getRows();

    /**
     * Gibt alle Datensätze der Tabelle zurück, die mit dem übergebenen
     * Parameter übereinstimmt
     *
     * @param name
     * @param value
     * @return
     */
    public abstract ResultSet getRows(String name, String value);

    /**
     * Gibt die ID des dazugehörigen Strings(Name) zurück
     *
     * @param value
     * @return
     */
    public  int getId(String value);
}
