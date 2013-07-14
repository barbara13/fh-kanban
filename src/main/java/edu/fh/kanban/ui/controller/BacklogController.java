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
import java.util.ArrayList;
import javax.swing.JButton;


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
        //blv.getPanel().removeAll();
        
        for (i = 0; i < listCard.size(); i++) {
            //int k = 0;
            //blv.getPanel().removeAll();
            blv.getCards()[i] = new JButton(String.valueOf(listCard.get(i).getCa_id())+": "+listCard.get(i).getName());
            blv.getCards()[i].addActionListener(this);
            //JButton[listCard.size] = new JButton[i](listCard.get(i).getName());

            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1, 1));
            //blv.getPanel().removeAll();

            j+=2;

            if (j == 6) {
                k+=2;
                j = 0;
            }
        }
    }

    


        
    
    @Override
     public void actionPerformed(ActionEvent e) {
     
         src = e.getSource();
         id = parseId(e.getActionCommand());
         cv = new CardView(id, listCard);
         cv.getComponent();
         cv.getBtnBackward().setVisible(false);
         cv.getBtnForward().setVisible(false);
     }
    
    private int parseId(String s){
        int s1 = s.indexOf(":");

        return Integer.parseInt(s.substring(0, s1));
    }
}
