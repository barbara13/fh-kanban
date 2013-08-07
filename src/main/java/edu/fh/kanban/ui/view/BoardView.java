package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.controller.BoardController;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author David
 *
 */

public class BoardView extends JPanel implements View {
  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//BoardController definieren    
 private BoardController c = null;
 private XMLBoard xml;
 private BacklogView blv;
 private ArrayList<Column> listSubColumns = new ArrayList<Column>();
 private ArrayList<Column> listMainColumns = new ArrayList<Column>();
 private ArrayList<Board> listBoard = new ArrayList<Board>();
 private ArrayList<Card> listCards = new ArrayList<Card>();
 private ArrayList<Card> listAllCards = new ArrayList<Card>();
 private JPanel bpanel = new JPanel();

// private CardView cv;
 
    public BoardView(BacklogView blv) {
     //BoardController im Konstruktor
        c = new BoardController(this);
        this.blv = blv;
        xml = new XMLBoard();
        getComponents();
    }


    public JLabel[] getColumns() {
        return columns;
    }

    public JPanel getBpanel() {
        return bpanel;
    }

    public JTextField getSearchtext() {
        return searchtext;
    }


    
    


private JTextField searchtext;
private JButton[] showCards = new JButton[100];
private JButton[] forward = new JButton[100];
private JButton[] backward = new JButton[100];
private JPanel[] cardpanel = new JPanel[100];
private JLabel[] columns = new JLabel[100];
private JLabel[] cardID = new JLabel[100];
    
private String columnSize, rowSize;
private JLabel title;
private JTextArea description;
//private BoardView bv = this;

    private String getRows(int rows) {
        String row = "4dlu, 100dlu, ";
			
        for (int i = 0; i < rows; i++){
            rowSize = rowSize + row;
        }
        
        return rowSize;
	}

        
    private String getColumns(int columns){
        String column = "4dlu, 130dlu, ";

        for (int i = 0; i < columns; i++){
            columnSize = columnSize + column;
        }
        
        return columnSize;
	}

    



    

    
    
    public JComponent getComponent() {
        int i = 0;
        xml.loadXML(Kanban.xmlPath);
        listAllCards = xml.readCards();
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
        searchtext = new JTextField();
        columnSize = new String("5dlu, 130dlu, ");
        rowSize = new String("5dlu, 20dlu, 5dlu, 20dlu, 5dlu, 20dlu, ");
 
        
        title = new JLabel(listBoard.get(i).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        
        bpanel.setLayout(new FormLayout(getColumns(listSubColumns.size()), getRows(15)));
        //showColumns(listMainColumns, listSubColumns);
        c.showColumns(listMainColumns, listSubColumns);
        
        return bpanel;
       
    }   

    public ArrayList<Board> getListBoard() {
        return listBoard;
    }

    public JPanel[] getCardpanel() {
        return cardpanel;
    }
    
    public ArrayList<Card> getListAllCards() {
        return listAllCards;
    }

    public JButton[] getShowCards() {
        return showCards;
    }
    
    
    
    
}