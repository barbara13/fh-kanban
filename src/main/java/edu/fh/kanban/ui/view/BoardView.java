package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.controller.BoardController;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.util.ArrayList;



public class BoardView extends JPanel implements View {
  
//BoardController definieren    
 private BoardController c = null;
 private XMLBoard xml;
 private ArrayList <Column> listSubColumns = new ArrayList();
 private ArrayList <Column> listMainColumns = new ArrayList();
 private ArrayList <Board> listBoard = new ArrayList();
 
    public BoardView() {
     //BoardController im Konstruktor
        c = new BoardController(this);
        xml = new XMLBoard();
        getComponents();
    }
    
    public JButton[] getCards() {
        return cards;
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


    
    

private JPanel bpanel;
private JTextField searchtext;
private JButton[] cards= new JButton[100];
private JLabel[] columns = new JLabel[100];
private String columnSize, rowSize;
private JLabel title;

    private String getRows(int rows) {
        String row = "4dlu, 20dlu, ";
			
        for (int i = 0; i < rows; i++){
            rowSize = rowSize + row;
        }
        
        return rowSize;
	}

        
    private String getColumns(int columns){
        String column = "4dlu, 50dlu, ";

        for (int i = 0; i < columns; i++){
            columnSize = columnSize + column;
        }
        
        return columnSize;
	}
    
    private void createColumns(ArrayList<Column> mainColumns, ArrayList<Column> subColumns) {
        int y = 4;
	int x = 4;
        int list = subColumns.size();
        JLabel NextLabel = new JLabel(subColumns.get(0).getName());
        JLabel DoneLabel = new JLabel(subColumns.get(list-1).getName());
        
        for (int j = 0; j < mainColumns.size(); j++){
            JLabel columnMainLabel = new JLabel(mainColumns.get(j).getName());
            bpanel.add(columnMainLabel, CC.xy(y, 4, CC.CENTER, CC.CENTER)); 
            
            y+=4;
        }	
        
        for (int i = 1; i < subColumns.size() - 1; i++){
            JLabel columnSubLabel = new JLabel(subColumns.get(i).getName());
            bpanel.add(columnSubLabel, CC.xy(x, 6, CC.CENTER, CC.CENTER));
            
            x+=2;
        }
        
        bpanel.add(NextLabel, CC.xy(2 , 4, CC.CENTER, CC.CENTER));
        bpanel.add(DoneLabel, CC.xy(y , 4, CC.CENTER, CC.CENTER));
        bpanel.add(searchtext, CC.xywh(y, 2, 2, 1));
        bpanel.add(title, CC.xywh(2 , 2, y , 1));
    }

    public JComponent getComponent() {
        int i = 0;
        xml.loadXML(Kanban.xmlPath);
        
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
 
        bpanel = new JPanel();
        searchtext = new JTextField();
        columnSize = new String("5dlu, 50dlu, ");
        rowSize = new String("5dlu, 20dlu, ");
        
        
        title = new JLabel(listBoard.get(i).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        
        bpanel.setLayout(new FormLayout(getColumns(listSubColumns.size()), getRows(15)));
        
        createColumns(listMainColumns, listSubColumns);
        return bpanel;
       
    }   
}