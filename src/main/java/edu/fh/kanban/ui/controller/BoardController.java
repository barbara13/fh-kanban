/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author David
 */

public class BoardController extends Controller{
    private Object src;
    private BoardView bv;
    private CardView cv;
    private int id;
    private XMLBoard xml;
    private ArrayList<Card> listCard = new ArrayList();
    
    
    public BoardController(BoardView bv){
       this.bv = bv;
       xml = new XMLBoard();
    }  
    
        
    @Override
     public void actionPerformed(ActionEvent e) {
         xml.loadXML(Kanban.xmlPath);
         listCard = xml.readCards();
         System.out.println(listCard.get(0).getName());
         src = e.getSource();
         id = parseId(e.getActionCommand());
         cv = new CardView(id, listCard);
         cv.getComponent();
     }
    
    private int parseId(String s){
        int s1 = s.indexOf(":");

        return Integer.parseInt(s.substring(0, s1));
    }
}