package edu.fh.kanban.ui.controller;

import edu.fh.kanban.ui.view.CardEditView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Maxim
 * 
 * die Klasse CardEditControllerist ist der Controller für die Klasse CardEditView 
 * Diese Händelt die Button Klicks und die JTextfield Einträge
 */
public class CardEditController implements ActionListener, KeyListener {
    private Object src;
    private CardEditView cEditView;
    private String status = "Standard";
    
    //Konstruktor
    public CardEditController(CardEditView cEditView){
		this.cEditView = cEditView;
	}
    
    public void actionPerformed(ActionEvent e) {
		src = e.getSource();
		
		if(cEditView.getTglbtnRed().isSelected()){
            status = ("Expedite");
            cEditView.getContentPane().setBackground(Color.RED);
        }else if(cEditView.getTglbtnYellow().isSelected()){
            status = ("Standard");
            cEditView.getContentPane().setBackground(Color.YELLOW);
        }else if(cEditView.getTglbtnGreen().isSelected()){
            status = ("Fixed Date");
            cEditView.getContentPane().setBackground(Color.GREEN);
        }else if(cEditView.getTglbtnBlue().isSelected()){
            status = ("Intangible");
            cEditView.getContentPane().setBackground(Color.BLUE);
        }
    
    	if(src == cEditView.getBtnSave()) {
			if(cEditView.getTxtHeadline().getText().isEmpty() || cEditView.getTxtCardId().getText().isEmpty() || cEditView.getTxtEffort().getText().isEmpty() || cEditView.getTxtValue().getText().isEmpty()){
				if(cEditView.getTxtHeadline().getText().isEmpty()) cEditView.getTxtHeadline().setBackground(Color.RED);
				else cEditView.getTxtHeadline().setBackground(Color.WHITE);
				if(cEditView.getTxtEffort().getText().isEmpty()) cEditView.getTxtEffort().setBackground(Color.RED);
				else cEditView.getTxtEffort().setBackground(Color.WHITE);
				if(cEditView.getTxtValue().getText().isEmpty()) cEditView.getTxtValue().setBackground(Color.RED);
				else cEditView.getTxtValue().setBackground(Color.WHITE);
			}else{
				cEditView.dispose();
				//Datenbank Eintrag ändern der cId --> cEditView.getCId()
			}	
		}else if(src == cEditView.getBtnCancel()){
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
