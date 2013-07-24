package edu.fh.kanban.ui.controller;

import com.jgoodies.forms.factories.CC;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


/**
 *
 * @author David, Malte
 */
public class BacklogController extends Controller{
    
    private BoardView bv;
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
    
    

    public BacklogController(BacklogView blv, BoardView bv) {
        this.bv = bv;
        this.blv = blv;
        xml = new XMLCard();
    }

    public void showCards() {
        listCard = xml.readCards();
        
        for (i = 0; i < listCard.size(); i++) {
           
            blv.getCards()[i] = new JButton(String.valueOf(listCard.get(i).getCa_id())+": "+listCard.get(i).getName());
            blv.getCards()[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i <= blv.getCards().length; i++){
						if(e.getSource() == blv.getCards()[i]){
							new CardView(listCard.get(i).getCa_id(), listCard, blv, bv).getComponent();
							break;
						}
					}
				}
			});
            blv.getPanel().add(blv.getCards()[i], CC.xywh(2 + j, 6 + k, 1, 1));

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
         cv = new CardView(id, listCard, blv, bv);
         cv.getComponent();
         cv.getBtnBackward().setVisible(false);
         cv.getBtnForward().setVisible(false);
     }
    
    private int parseId(String s){
        int s1 = s.indexOf(":");

        return Integer.parseInt(s.substring(0, s1));
    }
}
