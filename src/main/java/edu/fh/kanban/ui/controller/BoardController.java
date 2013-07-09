/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;
import edu.fh.kanban.ui.view.BoardView;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */

public class BoardController extends Controller{
    private Object src;
    private BoardView bv;
    
    
    public BoardController(BoardView bv){
       this.bv = bv;
       
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        src = e.getSource();
        
        //Getter - Methode für den Button und mit src vergleichen
        if(src == bv.getCard1()){
            System.out.println("test");
        }
        
    }
}
