package edu.fh.kanban.ui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;


/**
 * 
 * @author Maxim
 *
 */
public class CardController extends Controller{
	private Object src;
	private CardView cView;
	private CardCreateView cCreateView;
	private CardEditView cEditView;
	
	public CardController(CardView cView){
		this.cView = cView;
	}
	public CardController(CardCreateView cCreateView){
		this.cCreateView = cCreateView;
	}
	public CardController(CardEditView cEditView){
		this.cEditView = cEditView;
	}
	
	public void actionPerformed(ActionEvent e) {
		src = e.getSource();
		
		if(src == cCreateView.getBtnCreate()){
			if(cCreateView.getTxtCardId().getText().isEmpty() || cCreateView.getTxtHeadline().getText().isEmpty() || cCreateView.getTxtEffort().getText().isEmpty() || cCreateView.getTxtValue().getText().isEmpty()){
				if(cCreateView.getTxtCardId().getText().isEmpty()) cCreateView.getTxtCardId().setBackground(Color.RED);
				else cCreateView.getTxtCardId().setBackground(Color.WHITE);
				if(cCreateView.getTxtHeadline().getText().isEmpty()) cCreateView.getTxtHeadline().setBackground(Color.RED);
				else cCreateView.getTxtHeadline().setBackground(Color.WHITE);
				if(cCreateView.getTxtEffort().getText().isEmpty()) cCreateView.getTxtEffort().setBackground(Color.RED);
				else cCreateView.getTxtEffort().setBackground(Color.WHITE);
				if(cCreateView.getTxtValue().getText().isEmpty()) cCreateView.getTxtValue().setBackground(Color.RED);
				else cCreateView.getTxtValue().setBackground(Color.WHITE);
			}else{
				cCreateView.dispose();
				//in Datenbank Eintragen
			}	
		}else if(src == cCreateView.getBtnCancel()){
			cCreateView.dispose();
		}else if(src == cEditView.getBtnSave()) {
			if(cEditView.getTxtHeadline().getText().isEmpty() || cEditView.getTxtCardId().getText().isEmpty() || cEditView.getTxtEffort().getText().isEmpty() || cEditView.getTxtValue().getText().isEmpty()){
				if(cEditView.getTxtCardId().getText().isEmpty()) cEditView.getTxtCardId().setBackground(Color.RED);
				else cEditView.getTxtCardId().setBackground(Color.WHITE);
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
		}else if(src == cView.getBtnAddCard()){
			//Karte soll in den Board rein
		}else if(src == cView.getBtnEdit()){
			new CardEditView(cView.getHeadline(), Integer.toString(cView.getcID()), cView.getEffort(), cView.getValue(), cView.getDescription(), cView.getColor());
			cView.dispose();
		}else if(src == cView.getBtnDelete()){
			//Karte Löschen
		}else if(src == cView.getBtnCancel()){
			cView.dispose();
		}
	}
}
