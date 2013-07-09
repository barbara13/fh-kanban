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
public class XMLTest {
    private ArrayList <Board> listBoard = new ArrayList();
    private ArrayList <Column> listColumn = new ArrayList();
    private ArrayList <Card> listCard = new ArrayList();
    
    /* Board erstellen */
    public void createBoard(){
            XMLBoard board = new XMLBoard();
            board.loadXML("Board99.xml");
            board.addBoard("Board99", "red");
            board.addColumn("Column1", "2");
            board.addColumn("Column2", "2");
            //Muss ausgeführt werden um die xml Datei zu erstellen
            board.createBoard();
    }
    
    /* Card erstellen */
    public void createCard(){
        XMLCard card = new XMLCard();
        card.addCard("Card1", "Beschreinung", "2", "3", "Fixed");
        card.addCard("Card2", "Beschreinung", "5", "2", "Fixed");
        card.addCard("Card3", "Beschreinung", "8", "2", "Fixed");
        
        //Muss ausgeführt werden um die xml Datei zu aktualisieren
        card.createCard();
    }
    
    /* Card zu einer Column bzw ein Board zuweisen */
    public void cardToColumn(){
        XMLBoard board = new XMLBoard();
        board.loadXML("Board99.xml");
        
        /* erster Parameter = Card id
         * zweiter Parameter = Column id   
        */
        //board.addCardToColumn(26, 65);
    }
    
    /* Card in Board editieren */
    public void editCardInBoard(){
        XMLBoard board = new XMLBoard();
        board.loadXML("Board2.xml");
        
        /* erster Parameter = id der card welche geändert werden soll
         * zweiter Parameter = Attribut welcher geändert werden soll z.B. name oder description etc
         * dritter Parameter = Der Wert des Attributs
         */
        board.editCard(22, "description", "Hallooo");
        
        //gleiches Prinzip für board und columns
    }
    
    /* Card in cards.xml ändern */
    public void editCardInCards(){
        XMLCard card = new XMLCard();
        
        /* erster Parameter = id der card welche geändert werden soll
         * zweiter Parameter = Attribut welcher geändert werden soll z.B. name oder description etc
         * dritter Parameter = Der Wert des Attributs
         */
        card.editCard(30, "effort", "3");
    }
    
    /* Beispiel um cards aus der cards.xml auszulesen */
    public void readCard(){
        XMLCard card = new XMLCard();
        listCard = card.readCards();

        //Auslesen der cards
        for(int i = 0; i < listCard.size(); i++){
            //ID auslesen
            System.out.println("Name: ");
            System.out.println(listCard.get(i).getCa_id());
            
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
        XMLBoard board = new XMLBoard();
        board.loadXML("Board2.xml");
        listBoard = board.readBoard();
        //Auslesen des boards
        for(int i = 0; i < listBoard.size(); i++){
            //ID auslesen
            System.out.println("Name: ");
            System.out.println(listBoard.get(i).getB_id());
            
            //Namen auslesen
            System.out.println("Name: ");
            System.out.println(listBoard.get(i).getName());
            
            //Beschreibung 
            System.out.println("Color: ");
            System.out.println(listBoard.get(i).getColor());
  
        }
        
        //Gleiches Prinzip für Columns
    }    
    
}
