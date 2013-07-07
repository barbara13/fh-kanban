/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.example;

import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class ReadData {
    private ArrayList <Board> listBoard = new ArrayList();
    private ArrayList <Column> listColumn = new ArrayList();
    private ArrayList <Card> listCard = new ArrayList();
    
    /* Beispiel um cards aus der cards.xml auszulesen */
    public void readCard(){
        XMLCard card = new XMLCard();
        listCard = card.readCards();
        
        //Auslesen der cards
        for(int i = 0; i < listCard.size(); i++){
            //Namen auslesen
            System.out.println("Name: ");
            System.out.println(listCard.get(i).getName());
            
            //Beschreibung 
            System.out.println("Beschreibungen: ");
            System.out.println(listCard.get(i).getDescription());
  
        }
        
    }
    
    /* Beispiel um das Board aus einer xml datei auszulesen */
    public void readBoard(){
        XMLBoard board = new XMLBoard("Board2.xml");
        
        listBoard = board.readBoard();
        //Auslesen des boards
        for(int i = 0; i < listBoard.size(); i++){
            //Namen auslesen
            System.out.println("Name: ");
            System.out.println(listBoard.get(i).getName());
            
            //Beschreibung 
            System.out.println("Color: ");
            System.out.println(listBoard.get(i).getColor());
  
        }
    }
    
    
    
    
}
