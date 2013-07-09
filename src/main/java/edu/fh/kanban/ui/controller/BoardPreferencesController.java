package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.ui.view.BoardPreferencesView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import org.junit.Test;

/**
 *
 * @author Barbara
 * 
 * Die Klasse BoardPreferencesontroller ist der Controller zur Klasse BoardPreferencesView
 */

public class BoardPreferencesController extends Controller{		

	private int arrayindex=0;
	private JTextField[] txtColumname = new JTextField[10]; 
	private JSpinner[] wip = new JSpinner[10];
	private JButton[] btnMinus= new JButton[10];
	
    private Object src;
    private BoardPreferencesView bpv;
    private XMLBoard xml;
    private String color;
    
    public int getArrayindex() {
		return arrayindex;
	}

	public BoardPreferencesController(BoardPreferencesView bpv){
       this.bpv = bpv;
       xml = new XMLBoard();
    }  
    
    public void actionPerformed(ActionEvent e) {
        src = e.getSource();
        
        if(src == bpv.getBtnSpeichern()){
                xml.loadXML(bpv.getTxtName().getText().toString() + ".xml");
	       	boolean panelfehler = false;
			for(int i=0; i<10; i++){                          
				if(txtColumname[i]!= null){
					if(txtColumname[i].getText().isEmpty()){	//Abfrage wenn nichts eingetragen wurde (Name) wird das Textfeld Rot makiert
						txtColumname[i].setBackground(Color.RED);
						panelfehler = true;
					}else txtColumname[i].setBackground(Color.WHITE); //Ansonsten bleibt das textfeld weiß
				}else break;
			}
					
			if(bpv.getTxtName().getText().isEmpty() || (!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())){
				if(bpv.getTxtName().getText().isEmpty()) bpv.getTxtName().setBackground(Color.RED);
				else bpv.getTxtName().setBackground(Color.WHITE);
				if(!bpv.getTglbtnRot().isSelected() && !bpv.getTglbtnGelb().isSelected() && !bpv.getTglbtnGruen().isSelected() && !bpv.getTglbtnBlau().isSelected())	
	              System.out.println("Mindestens eine Color MUSS selektiert sein!!!");	
			}else if(panelfehler == false){
				color = new String();
				 
				//Abfrage, welcher "Farb"Button gedrückt wurde
				if(bpv.getTglbtnBlau().isSelected()) color = (color + "blue ");
				if(bpv.getTglbtnGelb().isSelected()) color = (color + "yellow ");
				if(bpv.getTglbtnGruen().isSelected())  color = (color + "green ");
				if(bpv.getTglbtnRot().isSelected())  color = (color + "red ");
				
				//Übergabe, was im Board gespeichert wird und das Fenster wird geschlossen
				xml.addBoard(bpv.getTxtName().getText().toString(), color);	
				xml.addColumn("Next", "50");
			   for(int i = 0; i < arrayindex; i++){
				   xml.addColumn(txtColumname[i].getText().toString(), wip[i].getValue().toString());
			   }
                                xml.addColumn("Done", "9999");
			   xml.createBoard();
                           bpv.dispose(); 
			}
        }else if(src == bpv.getBtnAbbrechen()){	//Wenn Abbrechen Button gedrückt wurde, schließe das fenster
            bpv.dispose();
        }
    }
    
    public void erweiterung(){
		if(arrayindex < 10){									//Ist getArrayindex kleiner als 10? Wenn ja
																//erstelle weitere Tupel
			txtColumname[arrayindex] = new JTextField();
			wip[arrayindex] = new JSpinner();
			((JSpinner.DefaultEditor) wip[arrayindex].getEditor()).getTextField().setEditable(false);	//MANUELLE EINGABE IM JSPINNER AUSSCHALTEN
			btnMinus[arrayindex] = new JButton("-");	//JButons werden einzeln initialisiert, damit man weiß, welcher Button genau gedrückt wird
			arrayindex++;
			aktualisierung();											//Private Methode "aktualisierung" wird aufgerufen
		} else{
			JOptionPane.showMessageDialog(null, "Nicht mehr als 10 erlaubt!!!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);	//Fehlermeldung wenn mehr als 10 Rows gewählt wurden
		}
	}
	
	private void loeschung(int i){						//Private Methode "Loeschung" löscht den i-ten Tupel aus dem Array
		txtColumname[i] = null;	
		wip[i] = null;
		btnMinus[i] = null;
		arrayindex--;									//Subtrahiert um eine Stelle die Laufvariable im Array
		
		aktualisierung();								//Private Methode wird aufgerufen
	}
	
	private void aktualisierung(){						//Konstruktor für die aktualisierung wird erstellt
		for(int i = 0; i < 10; i++){					//Es wird überprüft ob i<10, damit es nicht mehr als 10 Tupel gibt			
			if(txtColumname[i] == null){				//Sortiert das Array aufsteigend
				for(int k = (i+1); k < 10; k++){
					if(txtColumname != null){
						txtColumname[i] = txtColumname[k];
						txtColumname[k] = null;
						wip[i] = wip[k];
						wip[k] = null;
						btnMinus[i] = btnMinus[k];
						btnMinus[k] = null;
						break;
					}
				}
			}
		}
		if(txtColumname[0] == null) 					//Überprüfung ist an der ersten Stelle des Arrays ein Eintrag vorhanden, sollte kein eintrag vorhanden sein, wird die Methode erweiterung aufgerufen
			erweiterung();
		
		bpv.getPanel().removeAll();						//kompletter Inhalt des Panels wird entfernt
		
		for(int i=0, k=2; i<10; i++, k+=2){				//Das Panel wird neu aufgebaut
			if(txtColumname[i]!=null){
				
				bpv.getPanel().add(new JLabel("Name:"), "2, "+k+", fill, center");
				
				bpv.getPanel().add(txtColumname[i], "4, "+k+", fill, center");
				txtColumname[i].setColumns(10);
				
				bpv.getPanel().add(new JLabel("Wip:"), "6, "+k+", right, center");
				
				wip[i].setModel(new SpinnerNumberModel(1, 1, 10, 1));
				bpv.getPanel().add(wip[i], "8, "+k+", fill, center");
				
				JButton btnPlus = new JButton("+");
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						erweiterung();											//Methode erweiterung() wird aufgerufen sobald der JButton "+" gedrückt wurde
					}
				});
				bpv.getPanel().add(btnPlus, "10, "+k+", fill, top");
				
				btnMinus[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0; i < 10; i++){								//In der For-Schleife wird geschaut welcher der höchstens 10 "-" -Buttons gedrückt wurde
							if(e.getSource() == btnMinus[i] && btnMinus != null){
								loeschung(i);									//Methode loeschung ruft für die i-te Stelle auf
								break;
							}
						}
					}
				});
				bpv.getPanel().add(btnMinus[i], "12, "+k+", fill, top");
			}
		}
		bpv.getPanel().updateUI();		//JPanel wird aktualisiert
	}
}