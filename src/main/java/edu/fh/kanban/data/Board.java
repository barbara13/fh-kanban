/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.data;

import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Board {
    private int b_id;
    private String name;
    private String expedite;
    private String standart;
    private String fixedDate;
    private String intangible;

    
    public Board(int b_id, String name, String expedite, String standart, String fixedDate, String intangible) {
        this.b_id = b_id;
        this.name = name;
        this.expedite = expedite;
        this.standart = standart;
        this.fixedDate = fixedDate;
        this.intangible = intangible;
    }
    
        
    public Board() {

    }
    

    public int getB_id() {
        return b_id;
    }

    public String getName() {
        return name;
    }

    public String getExpedite() {
        return expedite;
    }

    public String getFixedDate() {
        return fixedDate;
    }

    public String getIntangible() {
        return intangible;
    }

    public String getStandart() {
        return standart;
    }
    
    

    
    

    

    
    
}
