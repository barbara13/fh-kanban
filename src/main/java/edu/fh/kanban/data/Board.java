/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.data;

/**
 *
 * @author Ronald
 */
public class Board {
    private int b_id;
    private String name;
    private String color;

    
    public Board(int b_id, String name, String color) {
        this.b_id = b_id;
        this.name = name;
        this.color = color;
    }
    

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getName() {
        return name;
    }


    
    
}
