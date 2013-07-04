package edu.fh.kanban.ui.view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

import edu.fh.kanban.database.Board;
import edu.fh.kanban.database.Column;
import edu.fh.kanban.database.DatabaseManager;

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
	
	private int arrayindex=0;
	private JTextField[] txtColumname = new JTextField[10]; 
	private JSpinner[] wip = new JSpinner[10];
	private JButton[] btnMinus= new JButton[10];

	public BoardPreferencesView(){
		super("Board Einstellungen");
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
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		tglbtnGelb = new JToggleButton("Standard");
		tglbtnGelb.setOpaque(true);
		tglbtnGelb.setBackground(Color.YELLOW);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		tglbtnGruen = new JToggleButton("Fixed date");
		tglbtnGruen.setOpaque(true);
		tglbtnGruen.setBackground(Color.GREEN);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		tglbtnBlau = new JToggleButton("Intangible");
		tglbtnBlau.setOpaque(true);
		tglbtnBlau.setBackground(Color.BLUE);
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
	
		Erweiterung();
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().isEmpty() || (!tglbtnRot.isSelected() && !tglbtnGelb.isSelected() && !tglbtnGruen.isSelected() && !tglbtnBlau.isSelected())){
					if(txtName.getText().isEmpty()) txtName.setBackground(Color.RED);
					else txtName.setBackground(Color.WHITE);
					if(!tglbtnRot.isSelected() && !tglbtnGelb.isSelected() && !tglbtnGruen.isSelected() && !tglbtnBlau.isSelected())
						System.out.println("Mindestens eine Color MUSS selektiert sein!!!");
				}else{
					int b_ID;
					DatabaseManager.createConnection();
					Board b = new Board();
					Column c = new Column();
					b_ID = b.insertRowAndReturn(txtName.getText(), tglbtnRot.isSelected()? tglbtnRot.getBackground().toString():"null", tglbtnGelb.isSelected()? tglbtnGelb.getBackground().toString():"null", tglbtnGruen.isSelected()? tglbtnGruen.getBackground().toString():"null", tglbtnBlau.isSelected()? tglbtnBlau.getBackground().toString():"null");
					for(int i = 0; i < 10; i++){
						if(txtColumname[i] != null){
							c.insertRow(b_ID, txtColumname[i].getText(), Integer.parseInt(wip[i].getValue().toString()));
						}else break;
					}
					DatabaseManager.closeConnection();
				}
			}
		});
		
		getContentPane().add(btnSpeichern, "10, 12, fill, top");
			
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnAbbrechen, "12, 12, default, top");	
	}

	public JComponent getComponent() {
		return null;
	}
	
	private void Erweiterung(){
		if(arrayindex<10){
			txtColumname[arrayindex] = new JTextField();
			wip[arrayindex] = new JSpinner();
			btnMinus[arrayindex] = new JButton("-");
			arrayindex++;
			Aktualisierung();
		} else{
			JOptionPane.showMessageDialog(null, "Nicht mehr als 10 erlaubt!!!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);	//Fehlermeldung wenn mehr als 10 Rows gewählt wurden
		}
	}
	
	private void Loeschung(int i){
		txtColumname[i] = null;
		wip[i] = null;
		btnMinus[i] = null;
		arrayindex--;
		
		Aktualisierung();	
	}
	
	private void Aktualisierung(){
		for(int i = 0; i < 10; i++){
			if(txtColumname[i] == null){
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
		
		if(txtColumname[0] == null)
			Erweiterung();
		
		panel.removeAll();
		
		for(int i=0, k=2; i<10; i++, k+=2){
			if(txtColumname[i]!=null){
				
				panel.add(new JLabel("Name:"), "2, "+k+", fill, center");
				
				panel.add(txtColumname[i], "4, "+k+", fill, center");
				txtColumname[i].setColumns(10);
				
				panel.add(new JLabel("Wip:"), "6, "+k+", right, center");
				
				wip[i].setModel(new SpinnerNumberModel(1, 1, 10, 1));
				panel.add(wip[i], "8, "+k+", fill, center");
				
				JButton btnPlus = new JButton("+");
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Erweiterung();
					}
				});
				panel.add(btnPlus, "10, "+k+", fill, top");
				
				btnMinus[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0; i < 10; i++){
							if(e.getSource() == btnMinus[i] && btnMinus != null){
								Loeschung(i);
								break;
							}
						}
					}
				});
				panel.add(btnMinus[i], "12, "+k+", fill, top");
			}
		}
		panel.updateUI();
	}
}

