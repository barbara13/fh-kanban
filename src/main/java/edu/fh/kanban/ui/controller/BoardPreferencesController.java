/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.ui.view.BoardPreferencesView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Barbara
 */
public class BoardPreferencesController extends Controller{
    private Object src;
    private BoardPreferencesView bpv;
    private XMLBoard xml;
    
    public BoardPreferencesController(BoardPreferencesView bpv){
       this.bpv = bpv;
       xml = new XMLBoard();
    }  
    
    public void actionPerformed(ActionEvent e) {
        src = e.getSource();
        
        if(src == bpv.getBtnSpeichern()){         
	       	boolean panelfehler = false;
			for(int i=0; i<10; i++){                          
				if(bpv.getTxtColumname()[i]!= null){
					if(bpv.getTxtColumname()[i].getText().isEmpty()){
						bpv.getTxtColumname()[i].setBackground(Color.RED);
						panelfehler = true;
					}else bpv.getTxtColumname()[i].setBackground(Color.WHITE);	
				}else break;
			}
					
			if(bpv.getTxtName().getText().isEmpty() || (!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())){
				if(bpv.getTxtName().getText().isEmpty()) bpv.getTxtName().setBackground(Color.RED);
				else bpv.getTxtName().setBackground(Color.WHITE);
				if(!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())	
	              System.out.println("Mindestens eine Color MUSS selektiert sein!!!");	
			}else if(panelfehler == false){
				String color = new String();
				   
				if(bpv.getTglbtnBlau().isSelected()) color = (color + " blue ");
				if(bpv.getTglbtnGelb().isSelected()) color = (color + " yellow ");
				if(bpv.getTglbtnGruen().isSelected())  color = (color + " green ");
				if(bpv.getTglbtnRot().isSelected())  color = (color + " red ");
				
				xml.addRoot(bpv.getTxtName().getText().toString(), color);
				      
			   for(int i = 0; i < bpv.getArrayindex(); i++){
				   xml.addColumn(bpv.getTxtColumname()[i].getText().toString(), bpv.getWip()[i].getValue().toString());
			   }
			   xml.createBoard(bpv.getTxtName().getText().toString());          
			}
        }else if(src == bpv.getBtnAbbrechen()){
            bpv.dispose();
        }
    }
    
    public void erweiterung(){
		if(bpv.getArrayindex() < 10){
			bpv.getTxtColumname()[bpv.getArrayindex()] = new JTextField();
			bpv.getWip()[bpv.getArrayindex()] = new JSpinner();
			((DefaultEditor) bpv.getWip()[bpv.getArrayindex()].getEditor()).getTextField().setEditable(false);
			bpv.getBtnMinus()[bpv.getArrayindex()] = new JButton("-");
			bpv.setArrayindex(bpv.getArrayindex() + 1);
			aktualisierung();
		} else{
			JOptionPane.showMessageDialog(null, "Nicht mehr als 10 erlaubt!!!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);	//Fehlermeldung wenn mehr als 10 Rows gewählt wurden
		}
	}
	
	private void Loeschung(int i){
		bpv.getTxtColumname()[i] = null;
		bpv.getWip()[i] = null;
		bpv.getBtnMinus()[i] = null;
		bpv.setArrayindex(bpv.getArrayindex() - 1);
		
		aktualisierung();	
	}
	
	private void aktualisierung(){
		for(int i = 0; i < 10; i++){
			if(bpv.getTxtColumname()[i] == null){
				for(int k = (i+1); k < 10; k++){
					if(bpv.getTxtColumname() != null){
						bpv.getTxtColumname()[i] = bpv.getTxtColumname()[k];
						bpv.getTxtColumname()[k] = null;
						bpv.getWip()[i] = bpv.getWip()[k];
						bpv.getWip()[k] = null;
						bpv.getBtnMinus()[i] = bpv.getBtnMinus()[k];
						bpv.getBtnMinus()[k] = null;
						break;
					}
				}
			}
		}
		if(bpv.getTxtColumname()[0] == null)
			erweiterung();
		
		bpv.getPanel().removeAll();
		
		for(int i=0, k=2; i<10; i++, k+=2){
			if(bpv.getTxtColumname()[i]!=null){
				
				bpv.getPanel().add(new JLabel("Name:"), "2, "+k+", fill, center");
				
				bpv.getPanel().add(bpv.getTxtColumname()[i], "4, "+k+", fill, center");
				bpv.getTxtColumname()[i].setColumns(10);
				
				bpv.getPanel().add(new JLabel("Wip:"), "6, "+k+", right, center");
				
				bpv.getWip()[i].setModel(new SpinnerNumberModel(1, 1, 10, 1));
				bpv.getPanel().add(bpv.getWip()[i], "8, "+k+", fill, center");
				
				JButton btnPlus = new JButton("+");
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						erweiterung();
					}
				});
				bpv.getPanel().add(btnPlus, "10, "+k+", fill, top");
				
				bpv.getBtnMinus()[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0; i < 10; i++){
							if(e.getSource() == bpv.getBtnMinus()[i] && bpv.getBtnMinus() != null){
								Loeschung(i);
								break;
							}
						}
					}
				});
				bpv.getPanel().add(bpv.getBtnMinus()[i], "12, "+k+", fill, top");
			}
		}
		bpv.getPanel().updateUI();
	}
}