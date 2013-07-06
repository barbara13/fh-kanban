/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;

/**
 *
 * @author KingDCB
 */
public class CardController extends Controller{
    private Object src;
    private CardView cView;
    private XMLCard xml;
    private XMLBoard xmlb;
    
    public CardController(CardView cView){
		this.cView = cView;
                xml = new XMLCard();
                xmlb = new XMLBoard();       
	}

    public void actionPerformed(ActionEvent e) {
		src = e.getSource();
                
               if(src == cView.getBtnAddCard()){
                        //xmlb.addCardToColumn(cView.getcID(), co_id);
			//Karte soll in den Board rein
		}else if(src == cView.getBtnEdit()){
			//new CardEditView(cView.getHeadline(), Integer.toString(cView.getcID()), cView.getEffort(), cView.getValue(), cView.getDescription(), cView.getColor());
			cView.dispose();
		}else if(src == cView.getBtnDelete()){
			//Karte Löschen
                        xml.deleteCard(cView.getcID());
		}else if(src == cView.getBtnCancel()){
			cView.dispose();
		}
    }
}

