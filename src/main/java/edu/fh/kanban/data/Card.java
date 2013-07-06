/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.data;

/**
 *
 * @author Ronald
 */
public class Card {
    private int ca_id;
    private int co_id;
    private String name;
    private String description;
    private int effort;
    private int value;
    private String status;

    public Card(int ca_id, int co_id, String name, String description, int effort, int value, String status) {
        this.ca_id = ca_id;
        this.co_id = co_id;
        this.name = name;
        this.description = description;
        this.effort = effort;
        this.value = value;
        this.status = status;
    }

    public int getCa_id() {
        return ca_id;
    }

    public int getCo_id() {
        return co_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEffort() {
        return effort;
    }

    public int getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
    
    
}
