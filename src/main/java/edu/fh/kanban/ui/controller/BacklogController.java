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
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author KingDCB
 */
public class BacklogController extends Controller {
    private BacklogView blv;
    private CardView cv;
    private XMLCard xml;
    private ArrayList <Card> listCard = new ArrayList();
    private int j = 0;
    private int k = 0;
    
   
    
    
    public BacklogController(BacklogView blv)
    {
        
        this.blv = blv;
        xml = new XMLCard();
    }
    
    public void showCards(){
        listCard = xml.readCards();
        
        for(int i = 0; i < listCard.size(); i++){
            //int k = 0;
            blv.getCards()[i] = new JButton(listCard.get(i).getName());
            //JButton[listCard.size] = new JButton[i](listCard.get(i).getName());
            
            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + k, 6 + j, 1, 1));
            
            blv.getCards()[i].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    
                } 
            });
            
            j++;
            j++;

            if (j == 20){
              k++;
              k++;
              j = 0;
            }
            
        }
        
    }
    
}
