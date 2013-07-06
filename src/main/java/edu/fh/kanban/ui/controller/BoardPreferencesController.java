/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLBoard;
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
    private XMLBoard xml;
    
    
    public BoardPreferencesController(BoardPreferencesView bpv){
       this.bpv = bpv;
       xml = new XMLBoard();
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
                                   String color = new String();
                                   
                                   if(bpv.getTglbtnBlau().isSelected()){ 
                                       color = (color + " blue ");}
                                   
                                   if(bpv.getTglbtnGelb().isSelected()){
                                       color = (color + " yellow ");}
                                   
                                   if(bpv.getTglbtnGruen().isSelected()){
                                       color = (color + " green ");}
                                   
                                   if(bpv.getTglbtnRot().isSelected()){
                                       color = (color + " red ");}
                                
                                    xml.addRoot(bpv.getTxtName().getText().toString(), color);
                                      
                                for(int i = 0; i < bpv.getArrayindex(); i++){     
                                
                                    xml.addColumn(bpv.getTxtColumname()[i].getText().toString(), bpv.getWip()[i].getValue().toString());
                                 }
                                   
                                xml.createBoard(bpv.getTxtName().getText().toString());
                                
				}
        }
        
        
       else if(src == bpv.getBtnAbbrechen()){
            bpv.dispose();
        }
        
        
    }
}