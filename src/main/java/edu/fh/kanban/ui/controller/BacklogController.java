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
import javax.swing.JLabel;

/**
 *
 * @author KingDCB
 */
public class BacklogController extends Controller {

    private BacklogView blv;
    private CardView cv;
    private XMLCard xml;
    private ArrayList<Card> listCard = new ArrayList();
    private ArrayList<JLabel> id = new ArrayList();
    private int j = 0;
    private int k = 0;
    private int i;
    private Object src;

    public BacklogController(BacklogView blv) {

        this.blv = blv;
        xml = new XMLCard();
    }

    public void showCards() {
        listCard = xml.readCards();

        for (i = 0; i < listCard.size(); i++) {
            //int k = 0;
            blv.getCards()[i] = new JButton(listCard.get(i).getName());
            blv.getCards()[i].addActionListener(this);
            blv.getIds()[i] = new JLabel(String.valueOf(listCard.get(i).getCa_id()));

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
    
    @Override
     public void actionPerformed(ActionEvent e) {
     
         src = e.getSource();
         System.out.println(e.getActionCommand());
         //System.out.println(blv.getCards()[e.].getText());

     
     }
}
