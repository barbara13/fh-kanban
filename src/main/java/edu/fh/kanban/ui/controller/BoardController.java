/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;
import com.jgoodies.forms.factories.CC;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BoardView;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    private XMLCard cxml;
    private ArrayList <Board> listBoard = new ArrayList();
    private ArrayList <Column> listColumn = new ArrayList();
    private ArrayList <Card> listCard = new ArrayList();
    private int j = 0;
    private int k = 0;
    private int i;
    
    public BoardController(BoardView bv){
       this.bv = bv;
       kbn = new Kanban();
       xml = new XMLBoard();
       cxml = new XMLCard();
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        src = e.getSource();
        
        //Getter - Methode für den Button und mit src vergleichen
   
    }
    
   public void paintBoard(String name){
        xml.loadXML(name);
          
        listBoard = xml.readBoard();
        listColumn = xml.readColumns();
        //listCard = cxml.readCards();
        //for (i = 0; i < listCard.size(); i++) {
            //int k = 0;
        //      System.out.println(listCard.get(i).getName());
        //    bv.getCards()[i] = new JButton(listCard.get(i).getName());
            //bv.getCards()[i].addActionListener(this);
            //JButton[listCard.size] = new JButton[i](listCard.get(i).getName());
            //bv.getComponent();
            
            JLabel title = new JLabel(listBoard.get(i).getName());
            title.setFont(new Font("Arial", Font.BOLD, 24));
            
            bv.getBpanel().add(title, CC.xy(2 , 2));
            


            j++;
            j++;

            if (j
                    == 20) {
                k++;
                k++;
                j = 0;
            }
        }
    }