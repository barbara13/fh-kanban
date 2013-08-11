package edu.fh.kanban.ui.controller;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.dao.XMLBoard;
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
    private XMLCard xml;
    private XMLBoard xmlb;
    private BacklogView blv;
    private BoardView bv;

    public CardController(CardView cView, BacklogView blv, BoardView bv) {
        this.cView = cView;
        this.bv = bv;
        this.blv = blv;
        xml = new XMLCard();
        xmlb = new XMLBoard();
        System.out.println(Boolean.toString(cView.getTglbtnBlocker().isSelected()));
    }

    public void actionPerformed(ActionEvent e) {
        src = e.getSource();
        if (src == cView.getTglbtnBlocker()) {
            if (cView.getTglbtnBlocker().isSelected()) {
                String message = JOptionPane.showInputDialog("Block Message");
                if (message != null) {
                    cView.getTglbtnBlocker().setToolTipText(message);
                    xmlb.editCard(cView.getcId(), "blocker", Boolean.toString(cView.getTglbtnBlocker().isSelected()));
                    xmlb.editCard(cView.getcId(), "blocker_tooltip", cView.getTglbtnBlocker().getToolTipText().toString());
                    cView.getBtnForward().setEnabled(false);
                    cView.getBtnBackward().setEnabled(false);
                    bv.paintBoard();
                } else {
                    cView.getTglbtnBlocker().doClick();
                }

            } else {
                xmlb.editCard(cView.getcId(), "blocker", Boolean.toString(cView.getTglbtnBlocker().isSelected()));
                xmlb.editCard(cView.getcId(), "blocker_tooltip", "");
                cView.getBtnForward().setEnabled(true);
                cView.getBtnBackward().setEnabled(true);
                bv.paintBoard();
            }
        } else if (src == cView.getBtnAddCard()) {
            xmlb.loadXML(Kanban.xmlPath);

            if (xmlb.checkCardAtBoard(cView.getcId()) == false) {
                xmlb.addCardToBoard(cView.getcId());
            } else {
                System.out.println("Card ist schon auf dem Board vorhanden");
            }
            cView.dispose();
            bv.paintBoard();

        } else if (src == cView.getBtnEdit()) {
            new CardEditView(blv, cView.getHeadline(), cView.getcId(), cView.getEffort(), cView.getValue(), cView.getDescription()).getComponent();
            cView.dispose();
        } else if (src == cView.getBtnDeleteFromBacklog()) {
            xml.deleteCard(cView.getcId());
            blv.getSort().setSelectedIndex(0);
            cView.dispose();
        } else if (src == cView.getBtnDeleteFromBoard()) {
            xmlb.loadXML(Kanban.xmlPath);
            xmlb.deleteCard(cView.getcId(), cView.getColumn());
            bv.paintBoard();
            cView.dispose();
        } else if (src == cView.getBtnCancel()) {
            cView.dispose();
        } else if (src == cView.getBtnBackward()) {
            xmlb.loadXML(Kanban.xmlPath);
            xmlb.prevCard(cView.getcId());
            bv.paintBoard();
            cView.dispose();
        } else if (src == cView.getBtnForward()) {
            xmlb.loadXML(Kanban.xmlPath);
            xmlb.forwardCard(cView.getcId());
            bv.paintBoard();
            cView.dispose();
        }
    }
}
