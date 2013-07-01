package edu.fh.kanban.ui.view;

import javax.swing.JFrame;

import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;

public class BoardPreferencesView extends JFrame implements View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtColumsname;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public BoardPreferencesView(){
		super("Board Preferences");
		setBounds(new Rectangle(0, 0, 700, 500));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("119px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("125px"),},
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
				RowSpec.decode("213px"),
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name: ");
		getContentPane().add(lblName, "2, 2, left, center");
		
		txtName = new JTextField();
		txtName.setText("");
		getContentPane().add(txtName, "4, 2, fill, top");
		txtName.setColumns(10);
		
		JLabel lblColors = DefaultComponentFactory.getInstance().createLabel("Colors: ");
		getContentPane().add(lblColors, "2, 4, fill, top");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 4, 11, 1, fill, center");
		
		JToggleButton tglbtnRot = new JToggleButton("Rot");
		
		buttonGroup.add(tglbtnRot);
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		JToggleButton tglbtnGelb = new JToggleButton("Gelb");
		buttonGroup.add(tglbtnGelb);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		JToggleButton tglbtnGruen = new JToggleButton("Gruen");
		buttonGroup.add(tglbtnGruen);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		JToggleButton tglbtnBlau = new JToggleButton("Blau");
		buttonGroup.add(tglbtnBlau);
		getContentPane().add(tglbtnBlau, "10, 6, fill, top");
		
		JLabel lblColums = DefaultComponentFactory.getInstance().createLabel("Colums: ");
		getContentPane().add(lblColums, "2, 8, fill, top");
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "4, 8, 11, 1, fill, center");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "2, 10, 13, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("94px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),},
			new RowSpec[] {
				RowSpec.decode("31px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblName_1 = DefaultComponentFactory.getInstance().createLabel("Name");
		panel.add(lblName_1, "2, 2, fill, center");
		
		txtColumsname = new JTextField();
		panel.add(txtColumsname, "4, 2, fill, center");
		txtColumsname.setText("");
		txtColumsname.setColumns(10);
		
		JLabel lblWip = DefaultComponentFactory.getInstance().createLabel("Wip");
		panel.add(lblWip, "6, 2, fill, center");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		panel.add(spinner, "8, 2, fill, center");
		
		JButton button = new JButton("+");
		panel.add(button, "10, 2, fill, top");
		
		JButton button_1 = new JButton("-");
		panel.add(button_1, "12, 2, fill, top");
		
		JButton btnSpeichern = new JButton("Speichern");
		getContentPane().add(btnSpeichern, "12, 12, fill, top");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		getContentPane().add(btnAbbrechen, "14, 12, fill, top");	
	}

	public JComponent getComponent() {
		return null;
	}
}