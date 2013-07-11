/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import com.jgoodies.forms.factories.CC;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author KingDCB
 */
public class BacklogController extends Controller{

    private BacklogView blv;
    private CardView cv;
    private XMLCard xml;
    private ArrayList<Card> listCard = new ArrayList();
    private int j = 0;
    private int k = 0;
    private int i;
    private Object src;
    private String s = null;
    private int id;

    public BacklogController(BacklogView blv) {

        this.blv = blv;
        xml = new XMLCard();
    }

    public void showCards() {
        listCard = xml.readCards();

        for (i = 0; i < listCard.size(); i++) {
            //int k = 0;
            
            blv.getCards()[i] = new JButton(String.valueOf(listCard.get(i).getCa_id())+": "+listCard.get(i).getName());
            blv.getCards()[i].addActionListener(this);
            //JButton[listCard.size] = new JButton[i](listCard.get(i).getName());

            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + k, 6 + j, 1, 1));
            
            
            /*
            blv.getCards()[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println();
                    src[i] = e.getSource();
                    
                    if (src[i] == blv.getCards()[i]) {
                        System.out.println("test");
                        //System.out.println(blv.getCards()[i].getText());

                    }
                }
            });
            */

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
    
//    @Override
//     public void actionPerformed(ActionEvent e) {
//     
//         src = e.getSource();
//         System.out.println(e.getActionCommand());
//         //System.out.println(blv.getCards()[e.].getText());
//
//     
//     }
    
 /*   public void keyReleased(KeyEvent e) {
        if(blv.getSearch().getText().toString() == "Hallo"){
        	System.out.println("Suche");
        }
        }*/
    
    
/*    public void actionPerformed(ActionEvent e) {
    	listCard = xml.readCards();    	

		s = (String) blv.getSort().getSelectedItem();
		
//		System.out.println(s);
		
		if (s == "Creation time"){
			
			Collections.addAll(listCard);
			System.out.println(listCard);
			
			k=2;
			j=2;
			
			listCard = xml.readCards();
//			blv.getPanel().removeAll();
			blv.getPanel().revalidate();
			
	        for (i = 0; i < listCard.size(); i++) {
	            
	            blv.getCards()[i] = new JButton(String.valueOf(listCard.get(i).getCa_id())+": "+listCard.get(i).getName());
	            blv.getCards()[i].addActionListener(this);
	            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + k, 6 + j, 1, 1));
	            
	            
	            j++;
	            j++;

	            if (j== 20) {
	                k++;
	                k++;
	                j = 0;
	            }
	        }
		}
		else if (s == "Headline"){
			System.out.println("Test2");
		}
		else if (s == "Value"){
			System.out.println("Test3");
		}
		else if (s == "Size"){
			System.out.println("Test4");
		}
	}*/


    


        
    
    @Override
     public void actionPerformed(ActionEvent e) {
     
         src = e.getSource();
         id = parseId(e.getActionCommand());
         cv = new CardView(id);
         cv.getComponent();
     }
    
    private int parseId(String s){
        int s1 = s.indexOf(":");

        return Integer.parseInt(s.substring(0, s1));
    }
}
