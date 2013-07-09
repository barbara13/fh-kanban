/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.view.BoardView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */

public class BoardController extends Controller{
    private Object src;
    private BoardView bv;
    private Kanban kbn;
    private XMLBoard xml;
    private ArrayList <Board> listBoard = new ArrayList();
    private ArrayList <Column> listColumn = new ArrayList();
    
    public BoardController(BoardView bv){
       this.bv = bv;
       kbn = new Kanban();
       xml = new XMLBoard();
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        src = e.getSource();
        
        //Getter - Methode für den Button und mit src vergleichen
   
    }
    
   public void createBoard(String name){
        xml.loadXML(kbn.getChooser().getSelectedFile().getName().toString());   
            
          
        listBoard = xml.readBoard();
        listColumn = xml.readColumns();
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
        
        for(int i = 0; i < listColumn.size(); i++){
            //ID auslesen
            System.out.println("Name: ");
            System.out.println(listColumn.get(i).getB_id());
            
            //Namen auslesen
            System.out.println("Name: ");
            System.out.println(listColumn.get(i).getName());
            
            //Beschreibung 
            System.out.println("Color: ");
            System.out.println(listColumn.get(i).getWip());
  
        }
        
        
        
        
          
      }
}
