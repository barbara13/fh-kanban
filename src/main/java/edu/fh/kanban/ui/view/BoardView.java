package edu.fh.kanban.ui.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import com.jgoodies.forms.layout.*;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.controller.BoardController;
import com.jgoodies.forms.factories.FormFactory;

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
	 private ArrayList<Column> listSubColumns = new ArrayList<Column>();
	 private ArrayList<Column> listMainColumns = new ArrayList<Column>();
	 private ArrayList<Board> listBoard = new ArrayList<Board>();
     private ArrayList<Card> listCards = new ArrayList<Card>();
 
	 private JTextField searchtext;
	 private JPanel boardPanel;
	 private JPanel[] cardpanel = new JPanel[100];
	 private JLabel title;
	 private JLabel[] columns = new JLabel[100];
	 private JScrollPane scrollpane = new JScrollPane();
	 private JTextField txtSearch;
	 private BacklogView blv;
         
     private JButton[] showCards = new JButton[100];

    public BoardView(BacklogView blv) {
     //BoardController im Konstruktor
        c = new BoardController(this, blv);
        xml = new XMLBoard();
        this.blv = blv;
        getComponent();
    }

    public JComponent getComponent() {
        xml.loadXML(Kanban.xmlPath);
        listBoard = xml.readBoard();
        
        
        setLayout(new FormLayout(new ColumnSpec[] {
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		FormFactory.DEFAULT_COLSPEC,
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("max(80dlu;default)"),
        		FormFactory.UNRELATED_GAP_COLSPEC,},
        	new RowSpec[] {
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		RowSpec.decode("fill:default:grow"),}));
        
        JLabel label = new JLabel("Board Name:");
        add(label, "2, 1");
        
        title = new JLabel(listBoard.get(0).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, "4, 1, left, default");
        
        txtSearch = new JTextField();
        add(txtSearch, "6, 1, fill, default");
        add(new JSeparator(), "2, 3, 5, 1");
        
        boardPanel = new JPanel();
        add(boardPanel, "2, 5, 5, 1");
        boardPanel.setLayout(new FormLayout(new ColumnSpec[] {
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),},
        	new RowSpec[] {
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,}));
        
        paintBoard();
        blv.setBv(this);
        return this;
    }
    
    public void paintBoard(){
        xml.loadXML(Kanban.xmlPath);
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
        listCards = xml.readCards();
        
    	c.showColumns(listMainColumns, listSubColumns);
    }

    public ArrayList<Board> getListBoard() {
        return listBoard;
    }

    public JPanel[] getCardpanel() {
        return cardpanel;
    }
    
    public JButton[] getShowCards(){
    	return showCards;
    }
    
    public ArrayList<Card> getListCards() {
        return listCards;
    }

    public JScrollPane getScrollpane() {
        return scrollpane;
    }

    public JLabel[] getColumns() {
        return columns;
    }

    public JPanel getBpanel() {
        return boardPanel;
    }

    public JTextField getSearchtext() {
        return searchtext;
    }
}