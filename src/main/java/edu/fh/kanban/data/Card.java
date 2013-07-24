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
    private String value;
    private String blocker;
    private String blocker_tooltip;
    private String createdDate;
    private String startedDate;
    private String doneDate;

    public Card(int ca_id, int co_id, String name, String description, int effort, String value, String blocker, String blocker_tooltip,String createdDate, String startedDate, String doneDate) {
        this.ca_id = ca_id;
        this.co_id = co_id;
        this.name = name;
        this.description = description;
        this.effort = effort;
        this.value = value;
        this.blocker = blocker;
        this.blocker_tooltip = blocker_tooltip;
        this.createdDate = createdDate;
        this.startedDate = startedDate;
        this.doneDate = doneDate;
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

    public String getValue() {
        return value;
    }

    public String getBlocker() {
        return blocker;
    }

    public String getBlocker_tooltip() {
        return blocker_tooltip;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public String getDoneDate() {
        return doneDate;
    }
    
    
}
