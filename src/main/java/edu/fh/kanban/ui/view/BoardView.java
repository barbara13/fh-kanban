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
    
    private void showColumns(ArrayList<Column> mainColumns, ArrayList<Column> subColumns) {
        int y = 4;
	int x = 4;
        int columncount = 0;
        int list = subColumns.size();
        JLabel NextLabel = new JLabel(subColumns.get(0).getName());
        showCards(subColumns.get(0), 2, 0);
        
        for (int j = 0; j < mainColumns.size(); j++){
            JLabel columnMainLabel = new JLabel(mainColumns.get(j).getName());
            bpanel.add(columnMainLabel, CC.xy(y, 4, CC.CENTER, CC.CENTER)); 
            y+=4;
        }	
        
        for (int i = 1; i < subColumns.size() - 1; i++){
            JLabel columnSubLabel = new JLabel(subColumns.get(i).getName() + " (" + subColumns.get(i).getWip() + ")");
            bpanel.add(columnSubLabel, CC.xy(x, 6, CC.CENTER, CC.CENTER));
            showCards(subColumns.get(i), x, columncount); 
            columncount ++;
            x+=2;
        }
        
        JLabel DoneLabel = new JLabel(subColumns.get(list-1).getName());
        showCards(subColumns.get(list-1), x, columncount);
        
        
        bpanel.add(NextLabel, CC.xy(2 , 4, CC.CENTER, CC.CENTER));
        bpanel.add(DoneLabel, CC.xy(y , 4, CC.CENTER, CC.CENTER));
        bpanel.add(searchtext, CC.xywh(y, 2, 2, 1));
        bpanel.add(title, CC.xywh(2 , 2, y , 1));
        
    }

  
    public void showCards(Column column, int sameColumn, int columncount) {
        
        try{  
        listCards = xml.readCardsFromColumn(column.getCo_id());
        int k = 0;
        
        for (int i = 0; i < listCards.size(); i++) {
//            cv = new CardView(listCards.get(i).getCa_id(), listCards, blv, this);
        	new CardView(listCards.get(i).getCa_id(), listCards, blv, this);
            
            description = new JTextArea(listCards.get(i).getDescription());
            description.setEnabled(false);
            cardpanel[i] = new SimpleCardView().getComponent();
            cardpanel[i].add(description, CC.xywh(2, 3, 5, 2)); 
            cardpanel[i].add(new JLabel("" + listCards.get(i).getCa_id()), CC.xy(4, 2));
            showCards[i]= new JButton("SHOW");
            forward[i] = new JButton("Forward");
            backward[i] = new JButton("Back");
            
            
            
            
           //cardpanel[i].add(blv.getAddcards()[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
           cardpanel[i].add(showCards[i], CC.xy(6, 2));
           cardpanel[i].add(backward[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
           cardpanel[i].add(forward[i], CC.xy(6, 6, CC.CENTER, CC.CENTER));
            
            
            
            showCards[i].addActionListener(c);
            
            
            
            
         bpanel.add(cardpanel[i], CC.xy(sameColumn, 8 + k, CC.CENTER, CC.CENTER));
         k+=2;
        }
        
        }catch (java.lang.IndexOutOfBoundsException exc){
              return;
        }
   } 
    
    
    public JComponent getComponent() {
        int i = 0;
        xml.loadXML(Kanban.xmlPath);
        
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
        searchtext = new JTextField();
        columnSize = new String("5dlu, 130dlu, ");
        rowSize = new String("5dlu, 20dlu, 5dlu, 20dlu, 5dlu, 20dlu, ");
 
        
        title = new JLabel(listBoard.get(i).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        
        bpanel.setLayout(new FormLayout(getColumns(listSubColumns.size()), getRows(15)));
        showColumns(listMainColumns, listSubColumns);
        return bpanel;
       
    }   
}