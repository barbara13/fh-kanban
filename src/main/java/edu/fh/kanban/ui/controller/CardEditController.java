package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.CardEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

/**
 *
 * @author Maxim, David, Malte
 *
 * die Klasse CardEditControllerist ist der Controller für die Klasse
 * CardEditView Diese Händelt die Button Klicks und die JTextfield Einträge
 */
public class CardEditController implements ActionListener, KeyListener {

    private Object src;
    private CardEditView cEditView;
    private XMLCard card = new XMLCard();

    //Konstruktor
    public CardEditController(CardEditView cEditView) {
        this.cEditView = cEditView;
    }

    public void actionPerformed(ActionEvent e) {
        src = e.getSource();

        if (src == cEditView.getBtnSave()) {
            if (cEditView.getTxtHeadline().isEmpty() || cEditView.getTxtEffort().isEmpty()) {
                JOptionPane.showMessageDialog(null, "nicht alle Felder sind ausgefüllt", "Fehlermelung", JOptionPane.WARNING_MESSAGE);
            } else {
                card.editCard(cEditView.getCId(), "name", cEditView.getTxtHeadline());
                card.editCard(cEditView.getCId(), "effort", cEditView.getTxtEffort());
                card.editCard(cEditView.getCId(), "value", cEditView.getValue());
                card.editCard(cEditView.getCId(), "description", cEditView.getTextDescription());
//                bv.getPanel().removeAll();
//                bv.getComponent();
//                bv.getPanel().updateUI();
                cEditView.dispose();
                //Datenbank Eintrag ändern der cId --> cEditView.getCId()
            }
        } else if (src == cEditView.getBtnCancel()) {
            cEditView.dispose();
        }
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
                e.consume();  //Alles außer Zahlen werden ignoriert
            }
        }
    }
}
