package edu.fh.kanban.ui.controller;

//import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;

import javax.net.ssl.SSLEngineResult.Status;

/**
 *
 * @author Maxim
 * 
 * Die Klasse CardController ist der Controller für die Klasse CardView 
 * Diese Händelt die Button Klicks
 */
public class CardController extends Controller{
    private Object src;
    private CardView cView;
    private XMLCard xml;
//    private XMLBoard xmlb;
    
    public CardController(CardView cView){
		this.cView = cView;
        xml = new XMLCard();
//        xmlb = new XMLBoard();       
	}

    public void actionPerformed(ActionEvent e) {
		src = e.getSource();
                
        if(src == cView.getBtnAddCard()){
            //xmlb.addCardToColumn(cView.getcID(), co_id);
			/**Karte kann nur an die erste Stelle in den BOARD in die "Started Column"*/
		}else if(src == cView.getBtnEdit()){
			new CardEditView(cView.getHeadline(), cView.getcId(), cView.getEffort(), cView.getValue(), cView.getDescription(), cView.getStatus());
			cView.dispose();
		}else if(src == cView.getBtnDelete()){
			xml.deleteCard(cView.getcId());
		}else if(src == cView.getBtnCancel()){
			cView.dispose();
		}
    }
}

