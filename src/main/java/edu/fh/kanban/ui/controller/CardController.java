package edu.fh.kanban.ui.controller;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;

import javax.net.ssl.SSLEngineResult.Status;

/**
 *
 * @author Maxim
 *
 * Die Klasse CardController ist der Controller für die Klasse CardView Diese
 * Händelt die Button Klicks
 */
public class CardController extends Controller {

    private Object src;
    private CardView cView;
    private CardEditView ceView;
    private XMLCard xml;
    private XMLBoard xmlb;

    public CardController(CardView cView) {
        this.cView = cView;
        xml = new XMLCard();
        xmlb = new XMLBoard();
    }

    public void actionPerformed(ActionEvent e) {
        src = e.getSource();
        if (src == cView.getBtnAddCard()) {
           xmlb.loadXML(Kanban.xmlPath);
            xmlb.addCardToBoard(cView.getcId());
            cView.dispose();
        } else if (src == cView.getBtnEdit()) {
            ceView = new CardEditView(cView.getHeadline(), cView.getcId(), cView.getEffort(), cView.getValue(), cView.getDescription(), cView.getStatus());
                ceView.getComponent();
            
        } else if (src == cView.getBtnDelete()) {
            xml.deleteCard(cView.getcId());
            cView.dispose();
        } else if (src == cView.getBtnCancel()) {
            cView.dispose();
        } else if (src == cView.getBtnBackward()){
            xmlb.loadXML(Kanban.xmlPath);
            xmlb.prevCard(cView.getcId());
            cView.dispose();
        } else if (src == cView.getBtnForward()){
            xmlb.loadXML(Kanban.xmlPath);
            xmlb.forwardCard(cView.getcId());
            cView.dispose();
        }
            
    }
}
