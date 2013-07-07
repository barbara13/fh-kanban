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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
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
public class BoardPreferencesView extends JFrame implements View{
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JToggleButton tglbtnRot, tglbtnGruen, tglbtnGelb, tglbtnBlau; 
    
	private BoardPreferencesController c = null;
    private JButton btnSpeichern;
    private JButton btnAbbrechen;
	private int arrayindex=0;
	private JTextField[] txtColumname = new JTextField[10]; 
	private JSpinner[] wip = new JSpinner[10];
	private JButton[] btnMinus= new JButton[10];
 
    public JToggleButton getTglbtnRot() {
        return tglbtnRot;
    }

    public JToggleButton getTglbtnGruen() {
        return tglbtnGruen;
    }

    public JToggleButton getTglbtnGelb() {
        return tglbtnGelb;
    }

    public JToggleButton getTglbtnBlau() {
        return tglbtnBlau;
    }

    public JButton[] getBtnMinus() {
        return btnMinus;
    }

    public JButton getBtnSpeichern() {
        return btnSpeichern;
    }

    public JButton getBtnAbbrechen() {
        return btnAbbrechen;
    }
    
    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField[] getTxtColumname() {
        return txtColumname;
    }

    public JSpinner[] getWip() {
        return wip;
    }
    
    public void setArrayindex(int i){
    	this.arrayindex = i;
    }

    public int getArrayindex() {
        return arrayindex;
    }
    public JPanel getPanel(){
    	return panel;
    }

    public BoardPreferencesView(){
                
		super("Board Einstellungen");
        c = new BoardPreferencesController(this);
                        
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
		               
		tglbtnRot = new JToggleButton("Expedite");		
        tglbtnRot.setOpaque(true);
		tglbtnRot.setBackground(Color.RED);
        tglbtnRot.addActionListener(c);
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		tglbtnGelb = new JToggleButton("Standard");
		tglbtnGelb.setOpaque(true);
		tglbtnGelb.setBackground(Color.YELLOW);
		tglbtnGelb.addActionListener(c);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		tglbtnGruen = new JToggleButton("Fixed date");
		tglbtnGruen.setOpaque(true);
		tglbtnGruen.setBackground(Color.GREEN);
		tglbtnGruen.addActionListener(c);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		tglbtnBlau = new JToggleButton("Intangible");
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
		

//		txtColumname[arrayindex] = new JTextField();
//		wip[arrayindex] = new JSpinner();
//		((DefaultEditor) wip[arrayindex].getEditor()).getTextField().setEditable(false);
//		btnMinus[arrayindex] = new JButton("-");
//		arrayindex++;
		
	
		c.erweiterung();
		
		/*JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(c);	
			public void actionPerformed(ActionEvent e) {
				boolean panelfehler = false;
				
				for(int i=0; i<10; i++){
					if(txtColumname[i]!= null){
						if(txtColumname[i].getText().isEmpty()){
							txtColumname[i].setBackground(Color.RED);
							panelfehler = true;
						}
						else txtColumname[i].setBackground(Color.WHITE);	
					}else break;
				}
				
				if(txtName.getText().isEmpty() || (!tglbtnRot.isSelected() && !tglbtnGelb.isSelected() && !tglbtnGruen.isSelected() && !tglbtnBlau.isSelected())){
					if(txtName.getText().isEmpty()) txtName.setBackground(Color.RED);
					else txtName.setBackground(Color.WHITE);
					if(!tglbtnRot.isSelected() && !tglbtnGelb.isSelected() && !tglbtnGruen.isSelected() && !tglbtnBlau.isSelected())
						System.out.println("Mindestens eine Color MUSS selektiert sein!!!");
					
				}else if(panelfehler == false){
					dispose();
					//Änderung
				}
			}
		});*/

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

