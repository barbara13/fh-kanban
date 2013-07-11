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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    private String[] columnNames;
    private static TableModel tableModel;
    private JTable table;
    
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
        listColumn = xml.readSubColumns();
        //listCard = cxml.readCards();
        columnNames = new String[listColumn.size()];
        
        JLabel title = new JLabel(listBoard.get(i).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
           
      for (i = 0; i < listColumn.size(); i++) {
           columnNames[i] = listColumn.get(i).getName().toString();
           System.out.println(columnNames[i]);  
           
         }       
        
        
        tableModel = new DefaultTableModel(
            new Object [][] {
                
            },
            columnNames) 
        {
            
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

           public Class getColumnClass(int columnIndex) {
               return types [columnIndex];
           }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        table = new JTable(tableModel);
     
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);   
        
        //An das Board Panel binden
        bv.getBpanel().add(scrollPane, CC.xywh(2, 6, 9, 10));
        bv.getBpanel().add(title, CC.xy(2 , 2));
        }
    }