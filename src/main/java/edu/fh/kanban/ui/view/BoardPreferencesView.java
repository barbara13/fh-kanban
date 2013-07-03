
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
import com.jgoodies.forms.factories.DefaultComponentFactory;

import edu.fh.kanban.database.Board;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * + Preferences dialog for colors, name of board, columns(10), wips(10)
   + Validate on wip limits (10 Stück)
   + Edit dialog for card
   + Warn user if modifications have not been saved

 * @author Babsi
 *
 */
public class BoardPreferencesView extends JFrame implements View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	private int i=2;
	private JTextField txtColumname;

	public BoardPreferencesView(){
		super("Board Einstellungen");
		setBounds(new Rectangle(0, 0, 700, 500));
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
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(21dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("31px"),
				RowSpec.decode("14px"),
				RowSpec.decode("31px"),
				RowSpec.decode("23px"),
				RowSpec.decode("31px"),
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("238px"),
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name: ");
		getContentPane().add(lblName, "2, 2, left, center");
		
		txtName = new JTextField();
		txtName.setText("");
		getContentPane().add(txtName, "4, 2, left, top");
		txtName.setColumns(10);
		
		JLabel lblColors = DefaultComponentFactory.getInstance().createLabel("Colors: ");
		getContentPane().add(lblColors, "2, 4, fill, top");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 4, 9, 1, fill, center");
		
		JToggleButton tglbtnRot = new JToggleButton("Expedite");		//Button Rot
		//tglbtnRot.setContentAreaFilled(false);
		tglbtnRot.setOpaque(true);
		tglbtnRot.setBackground(Color.RED);
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		JToggleButton tglbtnGelb = new JToggleButton("Standard");		//Button Gelb
		//tglbtnGelb.setContentAreaFilled(false);
		tglbtnGelb.setOpaque(true);
		tglbtnGelb.setBackground(Color.YELLOW);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		JToggleButton tglbtnGruen = new JToggleButton("Fixed date");	//Button Grün
		//tglbtnGruen.setContentAreaFilled(false);
		tglbtnGruen.setOpaque(true);
		tglbtnGruen.setBackground(Color.GREEN);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		JToggleButton tglbtnBlau = new JToggleButton("Intangible");		//Button Blau
		//tglbtnBlau.setContentAreaFilled(false);
		tglbtnBlau.setOpaque(true);
		tglbtnBlau.setBackground(Color.BLUE);
		getContentPane().add(tglbtnBlau, "10, 6, default, top");
		
		JLabel lblColums = DefaultComponentFactory.getInstance().createLabel("Colums: ");
		getContentPane().add(lblColums, "2, 8, fill, top");
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "4, 8, 9, 1, fill, center");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 10, 13, 1, fill, fill");
		
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
	
		ColumsPanel();
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				//new Board().insertRow(String.na, color);
				
			}
		});
		
		getContentPane().add(btnSpeichern, "10, 12, fill, top");
			
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnAbbrechen, "12, 12, fill, top");	
	}

	public JComponent getComponent() {
		return null;
	}
	
	private void ColumsPanel(){
		Erweiterung(i);
		i+=2;
	}
	private void Erweiterung(int i){
		
		panel.add(new JLabel("Name:"), "2, "+i+", fill, center");
		
		txtColumname = new JTextField();
		panel.add(txtColumname, "4, "+i+", fill, center");
		txtColumname.setColumns(10);
		
		panel.add(new JLabel("Wip:"), "6, "+i+", right, center");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		panel.add(spinner, "8, "+i+", fill, center");
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getI() < 21){
					Erweiterung(getI());
					incI();
					panel.updateUI();
				}else System.out.println("I zu gross");
			}
		});
		panel.add(btnPlus, "10, "+i+", fill, top");
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loeschung();
				//panel.rem
				//panel.updateUI();	
			}
		});
		panel.add(btnMinus, "12, "+i+", fill, top");
		Aktualisierung();	
	}
	
	private void Loeschung(){
	//Funktion	
		
		
		
		Aktualisierung();
	}
	
	private void Aktualisierung(){
	
		
	}
	
	public int getI(){
		return this.i;
	}
	public void incI(){
		this.i += 2;
	}
	public void decI(){
		this.i -= 2;
	}
}