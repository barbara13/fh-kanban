/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.data;

import edu.fh.kanban.dao.XMLBoard;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Column {
    private int co_id;
    private int b_id;
    private String name;
    private int wip;
    
    public Column(int co_id, int b_id, String name, int wip) {
        this.co_id = co_id;
        this.b_id = b_id;
        this.name = name;
        this.wip = wip;
        
    }

    
    
    public int getCo_id() {
        return co_id;
    }

    public int getB_id() {
        return b_id;
    }

    public String getName() {
        return name;
    }

    public int getWip() {
        return wip;
    }
    
    
}
