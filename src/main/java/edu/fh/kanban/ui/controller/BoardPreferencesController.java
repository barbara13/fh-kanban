/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.database.Board;
import edu.fh.kanban.database.Column;
import edu.fh.kanban.database.DatabaseManager;
import edu.fh.kanban.ui.view.BoardPreferencesView;
import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author KingDCB
 */
public class BoardPreferencesController extends Controller{
    private Object src;
    private BoardPreferencesView bpv;
    
    
    public BoardPreferencesController(BoardPreferencesView bpv){
       this.bpv = bpv;
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        src = e.getSource();
        
        if(src == bpv.getBtnSpeichern()){
                
           	boolean panelfehler = false;
		for(int i=0; i<10; i++){
                                    
		if(bpv.getTxtColumname()[i]!= null){
			if(bpv.getTxtColumname()[i].getText().isEmpty()){
				bpv.getTxtColumname()[i].setBackground(Color.RED);
				panelfehler = true;
		}
		else bpv.getTxtColumname()[i].setBackground(Color.WHITE);	
		}else break;
		}
				
		if(bpv.getTxtName().getText().isEmpty() || (!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())){
			if(bpv.getTxtName().getText().isEmpty()) bpv.getTxtName().setBackground(Color.RED);
			else bpv.getTxtName().setBackground(Color.WHITE);
			if(!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())	
                              System.out.println("Mindestens eine Color MUSS selektiert sein!!!");
					
				}else if(panelfehler == false){
					int b_ID;
					DatabaseManager.createConnection();
					Board b = new Board();
					Column c = new Column();
					b_ID = b.insertRowAndReturn(bpv.getTxtName().getText(), bpv.getTglbtnRot().isSelected()? bpv.getTglbtnRot().getBackground().toString():"null", bpv.getTglbtnGelb().isSelected()? bpv.getTglbtnGelb().getBackground().toString():"null", bpv.getTglbtnGruen().isSelected()? bpv.getTglbtnGruen().getBackground().toString():"null", bpv.getTglbtnBlau().isSelected()? bpv.getTglbtnBlau().getBackground().toString():"null");
					for(int i = 0; i < 10; i++){
						if(bpv.getTxtColumname()[i] != null){
							c.insertRow(b_ID, bpv.getTxtColumname()[i].getText(), Integer.parseInt(bpv.getWip()[i].getValue().toString()));
						}else break;
					}
					DatabaseManager.closeConnection();
				}
        }
        
        
       else if(src == bpv.getBtnAbbrechen()){
            bpv.dispose();
        }
        
        
    }
}