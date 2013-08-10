package edu.fh.kanban.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.BacklogView;

/**
 *
 * @author Maxim
 *
 * Die Klasse CardCreateContoller ist der Controller für die Klasse
 * CardCreateView Diese Händelt die Button Klicks und die JTextfield Einträge
 */
public class CardCreateController implements ActionListener, KeyListener {

    private Object src;
    private CardCreateView cCreateView;
    private BacklogView bv;
    private XMLCard xml;

    public CardCreateController(CardCreateView cCreateView, BacklogView bv) {
        this.cCreateView = cCreateView;
        xml = new XMLCard();
        this.bv = bv;
    }

    public void actionPerformed(ActionEvent e) {
        src = e.getSource();	//welcher Button gedrückt wurde wird im src gespeichert


        //Create Button überprüft zunächst ob alle einträge vorhanden sind ist das der Fall wird in die XMLCard 
        //über die Methode addCard die Karte hinzugefügt
        //Sollte das nicht der Fall sein wird das Feld ROT markiert das nicht ausgefüllt ist

        if (src == cCreateView.getBtnCreate()) {
            if (cCreateView.getTxtHeadline().isEmpty() || cCreateView.getTxtEffort().isEmpty()) {
                JOptionPane.showMessageDialog(null, "nicht alle Felder sind ausgefüllt", "Fehlermelung", JOptionPane.WARNING_MESSAGE);
            } else {
                //Eintrag in die XMLCard
                xml.addCard(cCreateView.getTxtHeadline(), cCreateView.getTextDescription(), cCreateView.getTxtEffort(), cCreateView.getValue(), "false", "");
                xml.createCard();
                cCreateView.dispose();
                bv.getSort().setSelectedIndex(0);
            }
            //Cancel Button schließt das Fenster ohne änderungen vorzunehmen
        } else if (src == cCreateView.getBtnCancel()) {
            cCreateView.dispose();
        }
    }

    //In bestimmten JTextfield's werden nur Zahlen aktzeptiert diese sorgt dafür
    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
                e.consume();  //Alles außer Zahlen werden ignoriert
            }
        }
    }
}