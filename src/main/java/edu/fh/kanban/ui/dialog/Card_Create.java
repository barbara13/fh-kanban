package edu.fh.kanban.ui.dialog;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class Card_Create extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCardId;
	private JTextField txtAufwand;
	private JTextField txtWert;
	private TextArea textArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public Card_Create(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 700, 500));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("48px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("54px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("10px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				ColumnSpec.decode("80px"),
				ColumnSpec.decode("47px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("104px"),},
			new RowSpec[] {
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("38px"),
				RowSpec.decode("14px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("210px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JLabel lblCardId = new JLabel("Card ID:");
		getContentPane().add(lblCardId, "2, 2, 3, 1, right, center");
		
		txtCardId = new JTextField();
		getContentPane().add(txtCardId, "6, 2, 5, 1, left, top");
		txtCardId.setColumns(10);
		
		JLabel lblAufwand = new JLabel("Aufwand:");
		getContentPane().add(lblAufwand, "16, 2, left, center");
		
		txtAufwand = new JTextField();
		getContentPane().add(txtAufwand, "18, 2, left, top");
		txtAufwand.setColumns(10);
		
		JLabel lblWert = new JLabel("Wert:");
		getContentPane().add(lblWert, "16, 4, right, center");
		
		txtWert = new JTextField();
		getContentPane().add(txtWert, "18, 4, left, top");
		txtWert.setColumns(10);
		
		JLabel lblColor = DefaultComponentFactory.getInstance().createLabel("Color:");
		getContentPane().add(lblColor, "2, 6, right, top");
		
		JToggleButton tglbtnRot = new JToggleButton("Rot");
		buttonGroup.add(tglbtnRot);
		getContentPane().add(tglbtnRot, "4, 8, 5, 1, fill, top");
		
		JToggleButton tglbtnGelb = new JToggleButton("Gelb");
		buttonGroup.add(tglbtnGelb);
		getContentPane().add(tglbtnGelb, "10, 8, fill, top");
		
		JToggleButton tglbtnGruen = new JToggleButton("Gruen");
		buttonGroup.add(tglbtnGruen);
		getContentPane().add(tglbtnGruen, "12, 8, fill, top");
		
		JToggleButton tglbtnBlau = new JToggleButton("Blau");
		buttonGroup.add(tglbtnBlau);
		getContentPane().add(tglbtnBlau, "14, 8, fill, top");
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		getContentPane().add(lblBeschreibung, "2, 10, 5, 1, left, top");
		
		textArea = new TextArea();
		getContentPane().add(textArea, "2, 12, 17, 1, fill, fill");
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "2, 14, 5, 1, fill, top");
		
		JButton btnCreate = new JButton("Create");
		getContentPane().add(btnCreate, "8, 14, 3, 1, fill, top");
	}
}