package edu.fh.kanban.ui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.dao.XMLCard;


/**
 * 
 * @author Maxim, David 
 *
 */
public class CardCreateController extends Controller{
	private Object src;
	private CardCreateView cCreateView;
        private XMLCard xml;
        private String status;
	

	public CardCreateController(CardCreateView cCreateView){
		this.cCreateView = cCreateView;
        xml = new XMLCard();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		src = e.getSource();
		status = new String();
              
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
                
                
		if(src == cCreateView.getBtnCreate()){
			if(cCreateView.getTxtHeadline().getText().isEmpty() || cCreateView.getTxtEffort().getText().isEmpty() || cCreateView.getTxtValue().getText().isEmpty()){
//				if(cCreateView.getTxtCardId().getText().isEmpty()) cCreateView.getTxtCardId().setBackground(Color.RED);
//				else cCreateView.getTxtCardId().setBackground(Color.WHITE);
				if(cCreateView.getTxtHeadline().getText().isEmpty()) cCreateView.getTxtHeadline().setBackground(Color.RED);
				else cCreateView.getTxtHeadline().setBackground(Color.WHITE);
				if(cCreateView.getTxtEffort().getText().isEmpty()) cCreateView.getTxtEffort().setBackground(Color.RED);
				else cCreateView.getTxtEffort().setBackground(Color.WHITE);
				if(cCreateView.getTxtValue().getText().isEmpty()) cCreateView.getTxtValue().setBackground(Color.RED);
				else cCreateView.getTxtValue().setBackground(Color.WHITE);
			}else{
	            xml.addCard(cCreateView.getTxtHeadline().getText().toString(), cCreateView.getTextDescription().getText().toString(), cCreateView.getTxtEffort().getText().toString(), cCreateView.getTxtValue().getText().toString(), status);
//	            System.out.println(cCreateView.getTxtHeadline().getText().toString()+ cCreateView.getTextDescription().getText().toString()+ cCreateView.getTxtEffort().getText().toString()+ cCreateView.getTxtValue().getText().toString()+ status);
	            xml.createCard();
	            cCreateView.dispose();
			}  
		}else if(src == cCreateView.getBtnCancel()){
			cCreateView.dispose();
		}
	}
}