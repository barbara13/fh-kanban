package edu.fh.kanban.ui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.ui.view.BacklogView;


/**
 * 
 * @author Maxim 
 *
 *Die Klasse CardCreateContoller ist der Controller für die Klasse CardCreateView 
 *Diese Händelt die Button Klicks und die JTextfield Einträge
 */
public class CardCreateController implements ActionListener, KeyListener{
	private Object src;
	private CardCreateView cCreateView;
        private BacklogView bv;
    private XMLCard xml;
    private String status = "Standard";
	

	public CardCreateController(CardCreateView cCreateView){
		this.cCreateView = cCreateView;
        xml = new XMLCard();
        bv = new BacklogView();
        
	}
	
	public void actionPerformed(ActionEvent e) {
		src = e.getSource();	//welcher Button gedrückt wurde wird im src gespeichert
              
		//Je nachdem welcher JToggleButton betätigt wird, wird der status verändert und der Hintergrung gesetzt
        if(cCreateView.getTglbtnRed().isSelected()){
            status = ("Expedite");
            cCreateView.getContentPane().setBackground(Color.RED);
        }else if(cCreateView.getTglbtnYellow().isSelected()){
            status = ("Standard");
            cCreateView.getContentPane().setBackground(Color.YELLOW);
        }else if(cCreateView.getTglbtnGreen().isSelected()){
            status = ("Fixed Date");
            cCreateView.getContentPane().setBackground(Color.GREEN);
        }else if(cCreateView.getTglbtnBlue().isSelected()){
            status = ("Intangible");
            cCreateView.getContentPane().setBackground(Color.BLUE);
        }
        
        //Create Button überprüft zunächst ob alle einträge vorhanden sind ist das der Fall wird in die XMLCard 
        //über die Methode addCard die Karte hinzugefügt
        //Sollte das nicht der Fall sein wird das Feld ROT markiert das nicht ausgefüllt ist
		if(src == cCreateView.getBtnCreate()){
			if(cCreateView.getTxtHeadline().getText().isEmpty() || cCreateView.getTxtEffort().getText().isEmpty() || cCreateView.getTxtValue().getText().isEmpty()){
				if(cCreateView.getTxtHeadline().getText().isEmpty()) cCreateView.getTxtHeadline().setBackground(Color.RED);
				else cCreateView.getTxtHeadline().setBackground(Color.WHITE);
				if(cCreateView.getTxtEffort().getText().isEmpty()) cCreateView.getTxtEffort().setBackground(Color.RED);
				else cCreateView.getTxtEffort().setBackground(Color.WHITE);
				if(cCreateView.getTxtValue().getText().isEmpty()) cCreateView.getTxtValue().setBackground(Color.RED);
				else cCreateView.getTxtValue().setBackground(Color.WHITE);
			}else{
				//Eintrag in die XMLCard
	            xml.addCard(cCreateView.getTxtHeadline().getText().toString(), cCreateView.getTextDescription().getText().toString(), cCreateView.getTxtEffort().getText().toString(), cCreateView.getTxtValue().getText().toString(), status);
	            xml.createCard();
	            cCreateView.dispose();
                    bv.getComponent();
			}
		//Cancel Button schließt das Fenster ohne änderungen vorzunehmen
		}else if(src == cCreateView.getBtnCancel()){
			cCreateView.dispose();
		}
	}
	
	//In bestimmten JTextfield's werden nur Zahlen aktzeptiert diese sorgt dafür
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