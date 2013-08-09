package edu.fh.kanban.ui.controller;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;
import edu.fh.kanban.ui.view.BacklogCardView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author David
 * 
 */
public class BoardController extends Controller{
	
    private Board board = new Board();
    private BoardView bv;
    private BacklogView blv;
    private CardView cv;
    
    private XMLBoard xml;
    private ArrayList<Card> listCards = new ArrayList<Card>();
    private Color expediteColor, fixedDateColor, intangibleColor, standartColor;
   
    public BoardController(BoardView bv, BacklogView blv){
       this.bv = bv;
       xml = new XMLBoard();
       this.blv = blv;
    }  
    
   public void showColumns(ArrayList<Column> mainColumns, ArrayList<Column> subColumns) {
	   bv.getBpanel().removeAll();
	   
       xml.loadXML(Kanban.xmlPath); 
       board = xml.getBoard();
        
       String farbe;
        
       farbe = board.getExpedite();
       farbe = farbe.substring(2, farbe.length());
       farbe = ("#" + farbe);
       expediteColor = Color.decode(farbe);
        
       farbe = board.getFixedDate();
       farbe = farbe.substring(2, farbe.length());
       farbe = ("#" + farbe);
       fixedDateColor = Color.decode(farbe);
        
	   farbe = board.getStandart();
	   farbe = farbe.substring(2, farbe.length());
	   farbe = ("#" + farbe);
	   standartColor = Color.decode(farbe);
        
       farbe = board.getIntangible();
       farbe = farbe.substring(2, farbe.length());
       farbe = ("#" + farbe);
       intangibleColor = Color.decode(farbe);
        
       for (int i = 0, x = 4; i < mainColumns.size(); i++, x+=4){
           bv.getBpanel().add(new JLabel(mainColumns.get(i).getName()), x + ", 2, 3, 1 Center, Center"); 
       }
        
       for (int i = 0, x = 2; i < subColumns.size() - 1; i++, x+=2){
           bv.getBpanel().add(new JLabel(subColumns.get(i).getName() + " (" + subColumns.get(i).getWip() + ")"), x + ", 4, Center, Center");
           showCards(subColumns.get(i), x, i); 
       }
       bv.getBpanel().updateUI();
   }

  
    private void showCards(Column column, int sameColumn , int j) {
    	listCards = xml.readCardsFromColumn(column.getCo_id());
    
    	for (int i = 0, y = 6; i < listCards.size(); i++, y+=2) {
            JTextArea description = new JTextArea(listCards.get(i).getDescription());
            description.setEnabled(false);
            
            bv.getCardpanel()[i] = new BacklogCardView();
            bv.getCardpanel()[i].add(description, "2, 10, 9, 1, fill, fill"); 
            bv.getCardpanel()[i].add(new JLabel(Integer.toString(listCards.get(i).getCa_id())), "4, 2");
        
            if (listCards.get(i).getValue().equals("Expedite")){
            	bv.getCardpanel()[i].setBackground(expediteColor);
            } else if (listCards.get(i).getValue().equals("Fixed Date")){
            	bv.getCardpanel()[i].setBackground(fixedDateColor);
            } else if (listCards.get(i).getValue().equals("Intangible")){
            	bv.getCardpanel()[i].setBackground(intangibleColor);
            } else if (listCards.get(i).getValue().equals("Standart")){
            	bv.getCardpanel()[i].setBackground(standartColor);
            }
            bv.getCardpanel()[i].setBorder(BorderFactory.createLineBorder(Color.black));
            
            bv.getShowCards()[i]= new JButton("SHOW:" + listCards.get(i).getCa_id());
            bv.getCardpanel()[i].add(bv.getShowCards()[i], "10, 2");
            bv.getShowCards()[i].addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    for(int i = 0; i < bv.getShowCards().length; i++){
                    	if (e.getSource() == bv.getShowCards()[i]){
		            		cv = new CardView(bv.getListCards().get(i).getCa_id(), bv.getListCards(), blv, bv);
				            cv.getComponent();
							cv.getBtnAddCard().setVisible(false);
							cv.getBtnEdit().setVisible(false);  
							break;
                    	}
            		}
            	}    
            }); 
            bv.getBpanel().add(bv.getCardpanel()[i], sameColumn + ", " + y + ", Center, Center");
        }
    } 
    
//  private int parseId(String s){
//	  int s1 = s.indexOf(":");
//      return Integer.parseInt(s.substring(0, s1));
//  }
    
    public void actionPerformed(ActionEvent e) {
 /* 
  *      
  * xml.loadXML(Kanban.xmlPath);
  * listCard = xml.readCards();
  * id = bv.getId();
  * src = e.getSource();
  * 
  * id = parseId(e.getActionCommand());	//Das ist ja nicht mehr so!!!!!!!!
  * cv = new CardView(id[i], listCard, blv, bv);
  * cv.getComponent();
  * cv.getBtnEdit().setVisible(false);
  * cv.getBtnAddCard().setVisible(false);
  * cv.getBtnDelete().setVisible(false);
  * 
  * */
     }
}