package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


/**
 *
 * @author Maxim
 *
 * Die Klasse CardController ist der Controller für die Klasse CardView Diese
 * Händelt die Button Klicks
 */
public class CardController implements ActionListener {

    private Object src;
    private CardView cView;
    private CardEditView ceView;
    private XMLCard xml;
//    private XMLBoard xmlb;
    private BacklogView blv;
    private BoardView bv;

    
    public CardController(CardView cView, BacklogView blv, BoardView bv) {
        this.cView = cView;
        this.bv = bv;
        this.blv = blv;
        xml = new XMLCard();
//        xmlb = new XMLBoard();
    }

    public void actionPerformed(ActionEvent e) {
        src = e.getSource();
        if(src == cView.getTglbtnBlocker()){
        	if(cView.getTglbtnBlocker().isSelected()){
            	cView.getTglbtnBlocker().setToolTipText(JOptionPane.showInputDialog("Block Message"));
            	xml.editCard(cView.getcId(), "blocker", Boolean.toString(cView.getTglbtnBlocker().isSelected()));
            	xml.editCard(cView.getcId(), "blocker_tooltip", cView.getTglbtnBlocker().getToolTipText().toString());
        	}else{
            	xml.editCard(cView.getcId(), "blocker", Boolean.toString(cView.getTglbtnBlocker().isSelected()));
            	xml.editCard(cView.getcId(), "blocker_tooltip", "");
        	}
        }else 
//        	if (src == cView.getBtnAddCard()) {
//            xmlb.loadXML(Kanban.xmlPath);
//            xmlb.addCardToBoard(cView.getcId());
//            
//            refreshBoard();
//            refreshBacklog();
//            cView.dispose();
//            
//        } else 
        	if (src == cView.getBtnEdit()) {
            ceView = new CardEditView(cView.getHeadline(), cView.getcId(), cView.getEffort(), cView.getValue(), cView.getDescription());
            ceView.getComponent();
        } else if (src == cView.getBtnDelete()) {
            xml.deleteCard(cView.getcId());
            refreshBacklog();
            cView.dispose();
        } else if (src == cView.getBtnCancel()) {
            cView.dispose();
        } 
//        else if (src == cView.getBtnBackward()){
//            xmlb.loadXML(Kanban.xmlPath);
//            xmlb.prevCard(cView.getcId());
//            refreshBoard();
//            cView.dispose();
//        } else if (src == cView.getBtnForward()){
//            xmlb.loadXML(Kanban.xmlPath);
//            xmlb.forwardCard(cView.getcId());
//            refreshBoard();
//            cView.dispose();
//        }
    }

        public void refreshBoard(){
            bv.getBpanel().removeAll();
            bv.getComponent();
            bv.getBpanel().updateUI();
        }
        
        public void refreshBacklog(){
            blv.getPanel().removeAll();
            blv.getComponent();
            blv.getPanel().updateUI();
        }
}
