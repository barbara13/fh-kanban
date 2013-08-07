package edu.fh.kanban.ui.controller;

//import com.jgoodies.forms.factories.CC;
//import com.jgoodies.forms.factories.FormFactory;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.CC;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
//import edu.fh.kanban.dao.XMLCard;
//import edu.fh.kanban.data.Board;
//import edu.fh.kanban.data.Column;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;

import edu.fh.kanban.ui.view.SimpleCardView;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Component;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableModel;

/**
 *
 * @author David
 */

public class BoardController extends Controller{
//    private Object src;
    private BoardView bv;
    private BacklogView blv;
    private CardView cv;
    
            
    private XMLBoard xml;
    private ArrayList<Card> listCards = new ArrayList<Card>();
     
    
    private JTextField searchtext;
    private JButton showCards[] = new JButton[100];
    private JPanel[] cards = new JPanel[100];
  //private JButton[] forward = new JButton[100];
  //  private JButton[] backward = new JButton[100];
    private JPanel cardpanel = new JPanel();
    private JLabel[] columns = new JLabel[100];
    private JLabel cardID[] = new JLabel[100];
    private JLabel title;
    private JTextArea description;
    public int id[] = new int[100];
    int cardcounter = 0;
   
    public BoardController(BoardView bv){
       this.bv = bv;
       xml = new XMLBoard();
       
    }  
    
   public void showColumns(ArrayList<Column> mainColumns, ArrayList<Column> subColumns) {
        cardcounter = 0;
        xml.loadXML(Kanban.xmlPath); 
        //listAllCards = xml.readCards();
        int w = 0;
        searchtext = new JTextField();
        
        title = new JLabel(bv.getListBoard().get(w).getName());
        title.setFont(new Font("Arial", Font.BOLD, 24));
        int y = 4;
	int x = 4;
        int columncount = 0;
        int list = subColumns.size();
        JLabel NextLabel = new JLabel(subColumns.get(0).getName());
        showCards(subColumns.get(0), 2, 0);
        
        for (int j = 0; j < mainColumns.size(); j++){
            JLabel columnMainLabel = new JLabel(mainColumns.get(j).getName());
            bv.getBpanel().add(columnMainLabel, CC.xy(y, 4, CC.CENTER, CC.CENTER)); 
            y+=4;
        }	
        
        for (int i = 1; i < subColumns.size() - 1; i++){
            JLabel columnSubLabel = new JLabel(subColumns.get(i).getName() + " (" + subColumns.get(i).getWip() + ")");
            bv.getBpanel().add(columnSubLabel, CC.xy(x, 6, CC.CENTER, CC.CENTER));
            showCards(subColumns.get(i), x, columncount); 
            columncount ++;
            x+=2;
        }
        
        JLabel DoneLabel = new JLabel(subColumns.get(list-1).getName());
        showCards(subColumns.get(list-1), x, columncount);
        
        
        bv.getBpanel().add(NextLabel, CC.xy(2 , 4, CC.CENTER, CC.CENTER));
        bv.getBpanel().add(DoneLabel, CC.xy(y , 4, CC.CENTER, CC.CENTER));
        bv.getBpanel().add(searchtext, CC.xywh(y, 2, 2, 1));
        bv.getBpanel().add(title, CC.xywh(2 , 2, y , 1));
        
    }

  
    private void showCards(Column column, int sameColumn, int columncount) {
        
        
        try{  
        listCards = xml.readCardsFromColumn(column.getCo_id());
        int m = 0;
        int k = 0;
        
        
        for (int i = 0; i < listCards.size(); i++) {
          final int cardcounter2 = cardcounter;
           cardID[cardcounter] = new JLabel("" + listCards.get(i).getCa_id());    
       
            
            
            description = new JTextArea(listCards.get(i).getDescription());
            description.setEnabled(false);
            cardpanel = new SimpleCardView().getComponent();
            cardpanel.add(description, CC.xywh(2, 3, 5, 2)); 
            cardpanel.add(cardID[cardcounter] , CC.xy(4, 2));
            showCards[i]= new JButton("SHOW");
            
        //    forward[cardcounter] = new JButton("Forward");
        //    backward[cardcounter] = new JButton("Back");
          
        //    forward[cardcounter].setEnabled(false);
        //    backward[cardcounter].setEnabled(false);
            
            
 
            
          
           cardpanel.add(showCards[i], CC.xy(6, 2));
    
            
            showCards[i].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                          
                                   // for(int i = 0; i <= bv.getCardpanel().length; i++){
						//if (e.getSource() == bv.getShowCards()[i]){
					cv = new CardView(bv.getListAllCards().get(cardcounter2).getCa_id(), bv.getListAllCards(), blv, bv);
			                cv.getComponent();
                                        //cv.getBtnBackward().setVisible(false);
                                        //cv.getBtnForward().setVisible(false);
					cv.getBtnAddCard().setVisible(false);
                                        
				}
                     
			}); 
    /*        
           backward[cardcounter].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                               //xml.loadXML(Kanban.xmlPath);
                               xml.prevCard(cv.getcId()); 
                               refreshBoard();
               } 
            });
            
           forward[cardcounter].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                               //xml.loadXML(Kanban.xmlPath);
                               xml.forwardCard(cv.getcId());
                               refreshBoard();
               } 
            });
            
           */
            
         bv.getBpanel().add(cardpanel, CC.xy(sameColumn, 8 + k, CC.CENTER, CC.CENTER));
         k+=2;
         cardcounter++; 
        }
        
        }catch (java.lang.IndexOutOfBoundsException exc){
              return;
        }
    
   } 
    
    
    
     public void actionPerformed(ActionEvent e) {
         
       
 /*        xml.loadXML(Kanban.xmlPath);
         listCard = xml.readCards();
         id = bv.getId();
//         src = e.getSource();
        
//         id = parseId(e.getActionCommand());	//Das ist ja nicht mehr so!!!!!!!!
         cv = new CardView(id[i], listCard, blv, bv);
         cv.getComponent();
         cv.getBtnEdit().setVisible(false);
//         cv.getBtnAddCard().setVisible(false);
         cv.getBtnDelete().setVisible(false);*/
     }
    
   // private int parseId(String s){
   //     int s1 = s.indexOf(":");

//        return Integer.parseInt(s.substring(0, s1));
   // }
}