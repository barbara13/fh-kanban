/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;

/**
 *
 * @author KingDCB
 */
public class CardController extends Controller{
    private Object src;
    private CardView cView;
    
    public CardController(CardView cView){
		this.cView = cView;
                       
	}

    public void actionPerformed(ActionEvent e) {
		src = e.getSource();
                
               if(src == cView.getBtnAddCard()){
			//Karte soll in den Board rein
		}else if(src == cView.getBtnEdit()){
			//new CardEditView(cView.getHeadline(), Integer.toString(cView.getcID()), cView.getEffort(), cView.getValue(), cView.getDescription(), cView.getColor());
			cView.dispose();
		}else if(src == cView.getBtnDelete()){
			//Karte Löschen
		}else if(src == cView.getBtnCancel()){
			cView.dispose();
		}
    }
}

