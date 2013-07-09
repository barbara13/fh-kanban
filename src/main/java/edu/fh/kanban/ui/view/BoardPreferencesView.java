package edu.fh.kanban.ui.view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

import edu.fh.kanban.ui.controller.BoardPreferencesController;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner.DefaultEditor;

/**
 * + Preferences dialog for colors, name of board, columns(10), wips(10)
   + Validate on wip limits (10 Stück)
   + Edit dialog for card
   + Warn user if modifications have not been saved

 * @author Barbara
 *
 */
public class BoardPreferencesView extends JFrame implements View{	//Klasse BoardPreferencesView erbt von der JFrame
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JToggleButton tglbtnRot, tglbtnGruen, tglbtnGelb, tglbtnBlau; 
    
	private BoardPreferencesController c = null;
    private JButton btnSpeichern;
    private JButton btnAbbrechen;
 
    public JToggleButton getTglbtnRot() {		//Getter für die Farbe Rot "Expedite" wird erstellt
        return tglbtnRot;
    }

    public JToggleButton getTglbtnGruen() {		//Getter für die Farbe Grün "Fixed Date" wird erstellt
        return tglbtnGruen;
    }

    public JToggleButton getTglbtnGelb() {		//Getter für die Farbe  Gelb "Standard" wird erstellt
        return tglbtnGelb;
    }

    public JToggleButton getTglbtnBlau() {		//Getter für die Farbe Blau "Intangible" wird erstellt
        return tglbtnBlau;
    }

    public JButton getBtnSpeichern() {			//Getter für den JButton "Speichern" wird erstellt
        return btnSpeichern;
    }

    public JButton getBtnAbbrechen() {			//Getter für den JButton "Abbrechen" wird erstellt
        return btnAbbrechen;
    }
    
    public JTextField getTxtName() {			//Getter JTextField für den Namen des Boardes wird erstellt
        return txtName;
    }

    public JPanel getPanel(){					//Getter für das JPanel wird erstellt
    	return panel;
    }

    public BoardPreferencesView(){				//Konstruktor
                
		super("Board Einstellungen");
        c = new BoardPreferencesController(this); //Controller zum BoardPreferencesVontroller wird initialisiert
                        
		setBounds(new Rectangle(0, 0, 700, 500));
		setLocationByPlatform(true);
		setResizable(false);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("33px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("292px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		getContentPane().add(new JLabel("Name:"), "2, 2, fill, center");
		
		txtName = new JTextField();
		getContentPane().add(txtName, "4, 2, 11, 1, fill, top");
		txtName.setColumns(10);
		
		getContentPane().add(new JLabel("Color:"), "2, 4, fill, top");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 4, 11, 1, fill, Center");
		               
		tglbtnRot = new JToggleButton("Expedite");		//Button Rot "Expedite" wird initialisiert
        tglbtnRot.setOpaque(true);
		tglbtnRot.setBackground(Color.RED);
        tglbtnRot.addActionListener(c);
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		tglbtnGelb = new JToggleButton("Standard");		//Button Gelb "Standard" wird initialisiert
		tglbtnGelb.setOpaque(true);
		tglbtnGelb.setBackground(Color.YELLOW);
		tglbtnGelb.addActionListener(c);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		tglbtnGruen = new JToggleButton("Fixed date");	//Button Grün "Fixed Date" wird erstellt
		tglbtnGruen.setOpaque(true);
		tglbtnGruen.setBackground(Color.GREEN);
		tglbtnGruen.addActionListener(c);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		tglbtnBlau = new JToggleButton("Intangible");	//Butoon Blau "Intangible" wird initialisiert
		tglbtnBlau.setOpaque(true);
		tglbtnBlau.setBackground(Color.BLUE);
		tglbtnBlau.addActionListener(c);
		getContentPane().add(tglbtnBlau, "10, 6, fill, top");
                
		getContentPane().add(new JLabel("Colums:"), "2, 8, fill, top");
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "4, 8, 11, 1, fill, Center");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 10, 13, 1, fill, top");
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("119px"),
				ColumnSpec.decode("28px"),
				ColumnSpec.decode("22px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				ColumnSpec.decode("56px"),
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));		
	
		c.erweiterung();						//Methode aus Controller c.erweiterung wird aufgerufen

		btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(c);
		
		getContentPane().add(btnSpeichern, "10, 12, fill, top");
			
		btnAbbrechen = new JButton("Abbrechen");
        btnAbbrechen.addActionListener(c);
		
		getContentPane().add(btnAbbrechen, "12, 12, default, top");	
	}

	public JComponent getComponent() {
		return null;
	}
}

