/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.ui.view.CardEditView;
import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author Maxim
 */
public class CardEditController extends Controller {
    private Object src;
    private CardEditView cEditView;
    
    public CardEditController(CardEditView cEditView){
		this.cEditView = cEditView;
	}
    
    public void actionPerformed(ActionEvent e) {
		src = e.getSource();
    
        	if(src == cEditView.getBtnSave()) {
				if(cEditView.getTxtHeadline().getText().isEmpty() || cEditView.getTxtCardId().getText().isEmpty() || cEditView.getTxtEffort().getText().isEmpty() || cEditView.getTxtValue().getText().isEmpty()){
//					if(cEditView.getTxtCardId().getText().isEmpty()) cEditView.getTxtCardId().setBackground(Color.RED);
//					else cEditView.getTxtCardId().setBackground(Color.WHITE);
					if(cEditView.getTxtHeadline().getText().isEmpty()) cEditView.getTxtHeadline().setBackground(Color.RED);
					else cEditView.getTxtHeadline().setBackground(Color.WHITE);
					if(cEditView.getTxtEffort().getText().isEmpty()) cEditView.getTxtEffort().setBackground(Color.RED);
					else cEditView.getTxtEffort().setBackground(Color.WHITE);
					if(cEditView.getTxtValue().getText().isEmpty()) cEditView.getTxtValue().setBackground(Color.RED);
					else cEditView.getTxtValue().setBackground(Color.WHITE);
				}else{
					cEditView.dispose();
					//Datenbank Eintrag ändern
				}	
		}else if(src == cEditView.getBtnCancel()){
			cEditView.dispose();
		}
    }   
}
