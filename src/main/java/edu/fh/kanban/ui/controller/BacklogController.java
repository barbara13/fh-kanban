package edu.fh.kanban.ui.controller;

import com.jgoodies.forms.factories.CC;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;
import edu.fh.kanban.data.Sort;
import edu.fh.kanban.ui.view.SimpleCardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author David, Malte, Lorenz
 */
public class BacklogController extends Controller{
    
    private BoardView bv;
    private BacklogView blv;
    private CardView cv;
    private XMLCard xml;
    private XMLBoard xmlb;
    private ArrayList<Card> listCard = new ArrayList<Card>();
    private int j = 0;
    private int k = 0;
    private int i;
//    private Object src;
    private String s = null;
//    private int id;
//    private SimpleCardView cards;
    private JTextArea description;
    

    public BacklogController(BacklogView blv, BoardView bv) {
        this.bv = bv;
        this.blv = blv;
        xml = new XMLCard();
        xmlb = new XMLBoard();
    }

    public void showCards() {
        listCard = xml.readCards();
        for (i = 0; i < listCard.size(); i++) {
            cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
            
            description = new JTextArea(listCard.get(i).getDescription());
            description.setEnabled(false);
            blv.getCards()[i] = new SimpleCardView();
            blv.getCards()[i].add(description, CC.xywh(2, 3, 5, 2)); 
            blv.getCards()[i].add(new JLabel("" + listCard.get(i).getCa_id()), CC.xy(4, 2));
            blv.getShowcards()[i]= new JButton("SHOW");
            blv.getAddcards()[i]= new JButton("To Board");
            
            blv.getCards()[i].add(blv.getAddcards()[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
            blv.getCards()[i].add(blv.getShowcards()[i], CC.xy(6, 2));
            blv.getAddcards()[i].setEnabled(false);
           
            blv.getAddcards()[i].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                   xmlb.loadXML(Kanban.xmlPath);
                   xmlb.addCardToBoard(cv.getcId());
               } 
            });
            
            
            blv.getShowcards()[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i <= blv.getCards().length; i++){
						if(e.getSource() == blv.getShowcards()[i]){
							cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
			                cv.getComponent();
                                    
							break;
						}
					}
				}
			});
            
            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1 , 1));
            j+=2;

            if (j == 6) {
                k+=2;
                j = 0;
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
   	listCard = xml.readCards();
      	
   	s = (String) blv.getSort().getSelectedItem();
   	
   	if (s == "Creation time"){

   		blv.getPanel().removeAll();

   		int i=0;
   		int j=0;
   		int k=0;
   		
   		listCard = xml.readCards();
        for (i = 0; i < listCard.size(); i++) {
            cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
            
            description = new JTextArea(listCard.get(i).getDescription());
            description.setEnabled(false);
            blv.getCards()[i] = new SimpleCardView();
            blv.getCards()[i].add(description, CC.xywh(2, 3, 5, 2)); 
            blv.getCards()[i].add(new JLabel("" + listCard.get(i).getCa_id()), CC.xy(4, 2));
            blv.getShowcards()[i]= new JButton("SHOW");
            blv.getAddcards()[i]= new JButton("To Board");
            
            blv.getCards()[i].add(blv.getAddcards()[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
            blv.getCards()[i].add(blv.getShowcards()[i], CC.xy(6, 2));
            blv.getAddcards()[i].setEnabled(false);
           
            blv.getAddcards()[i].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                   xmlb.loadXML(Kanban.xmlPath);
                   xmlb.addCardToBoard(cv.getcId());
               } 
            });
            
            
            blv.getShowcards()[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i <= blv.getCards().length; i++){
						if(e.getSource() == blv.getShowcards()[i]){
							cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
			                cv.getComponent();
                                    
							break;
						}
					}
				}
			});
            
            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1 , 1));
            j+=2;

            if (j == 6) {
                k+=2;
                j = 0;
            }
        }
  		blv.getPanel().updateUI();

   	}
   	else if (s == "Headline"){								
   		List<Card> Card = Sort.sortByHeadline(listCard);
   		
   		Iterator<Card> ICH = Card.iterator();
     		while(ICH.hasNext()){
     			ICH.next();
     		}
     		   		
   		blv.getPanel().removeAll();
   		int i=0;
   		int j=0;
   		int k=0;
  		for (i = 1; i < listCard.size(); i++) {
            cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
            
            description = new JTextArea(listCard.get(i).getDescription());
            description.setEnabled(false);
            blv.getCards()[i] = new SimpleCardView();
            blv.getCards()[i].add(description, CC.xywh(2, 3, 5, 2)); 
            blv.getCards()[i].add(new JLabel("" + listCard.get(i).getCa_id()), CC.xy(4, 2));
            blv.getShowcards()[i]= new JButton("SHOW");
            blv.getAddcards()[i]= new JButton("To Board");
            
            blv.getCards()[i].add(blv.getAddcards()[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
            blv.getCards()[i].add(blv.getShowcards()[i], CC.xy(6, 2));
            blv.getAddcards()[i].setEnabled(false);
           
            blv.getAddcards()[i].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                   xmlb.loadXML(Kanban.xmlPath);
                   xmlb.addCardToBoard(cv.getcId());
               } 
            });
            
            
            blv.getShowcards()[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i <= blv.getCards().length; i++){
						if(e.getSource() == blv.getShowcards()[i]){
							cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
			                cv.getComponent();
                                    
							break;
						}
					}
				}
			});

            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1 , 1));
            j+=2;

            if (j == 6) {
                k+=2;
                j = 0;
            }
        }
  		blv.getPanel().updateUI();
   	}
   	else if (s == "Value"){
   		List<Card> Card = Sort.sortByValue(listCard);
   		
   		Iterator<Card> ICV = Card.iterator();
  		while(ICV.hasNext()){
  			ICV.next();
  			
   	}  		
  		blv.getPanel().removeAll();
  		int i=0;
   		int j=0;
   		int k=0;
  		for (i = 0; i < listCard.size(); i++) {
            cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
            
            description = new JTextArea(listCard.get(i).getDescription());
            description.setEnabled(false);
            blv.getCards()[i] = new SimpleCardView();
            blv.getCards()[i].add(description, CC.xywh(2, 3, 5, 2)); 
            blv.getCards()[i].add(new JLabel("" + listCard.get(i).getCa_id()), CC.xy(4, 2));
            blv.getShowcards()[i]= new JButton("SHOW");
            blv.getAddcards()[i]= new JButton("To Board");
            
            blv.getCards()[i].add(blv.getAddcards()[i], CC.xy(4, 6, CC.CENTER, CC.CENTER));
            blv.getCards()[i].add(blv.getShowcards()[i], CC.xy(6, 2));
            blv.getAddcards()[i].setEnabled(false);
           
            blv.getAddcards()[i].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent c) {
                   xmlb.loadXML(Kanban.xmlPath);
                   xmlb.addCardToBoard(cv.getcId());
               } 
            });
            
            
            blv.getShowcards()[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i <= blv.getCards().length; i++){
						if(e.getSource() == blv.getShowcards()[i]){
							cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
			                cv.getComponent();
                                    
							break;
						}
					}
				}
			});

            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1 , 1));
            j+=2;

            if (j == 6) {
                k+=2;
                j = 0;
            }
        }
  		blv.getPanel().updateUI();
  		
   	}
   	/*else if (s == "Size"){
   		List<Card> Card = Sort.sortBySize(listCard);
   		
   		Iterator<Card> ICS = Card.iterator();
  		while(ICS.hasNext()){
  			ICS.next();
  		}
    }*/
    }
    
//    private int parseId(String s){
//        int s1 = s.indexOf(":");
//
//        return Integer.parseInt(s.substring(0, s1));
//    }
    
}
