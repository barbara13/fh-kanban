package edu.fh.kanban.ui.dialog;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JSeparator;

public class Card_Create extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCardId;
	private JTextField txtAufwand;
	private JTextField txtWert;
	
	public Card_Create(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 700, 500));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("119px"),
				ColumnSpec.decode("328px"),
				ColumnSpec.decode("47px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("94px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("294px"),
				RowSpec.decode("31px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblCardId = new JLabel("Card ID:");
		getContentPane().add(lblCardId, "2, 2, right, center");
		
		txtCardId = new JTextField();
		getContentPane().add(txtCardId, "4, 2, fill, top");
		txtCardId.setColumns(10);
		
		JLabel lblAufwand = new JLabel("Aufwand:");
		getContentPane().add(lblAufwand, "6, 2, right, center");
		
		txtAufwand = new JTextField();
		getContentPane().add(txtAufwand, "8, 2, fill, top");
		txtAufwand.setColumns(10);
		
		JLabel lblWert = new JLabel("Wert:");
		getContentPane().add(lblWert, "6, 4, right, center");
		
		txtWert = new JTextField();
		getContentPane().add(txtWert, "8, 4, fill, top");
		txtWert.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung");
		getContentPane().add(lblBeschreibung, "2, 6, right, top");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 6, 5, 1, fill, center");
		
		TextArea textArea = new TextArea();
		getContentPane().add(textArea, "2, 8, 7, 1, fill, fill");
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "2, 10, fill, top");
		
		JButton btnCreate = new JButton("Create");
		getContentPane().add(btnCreate, "4, 10, left, top");
	}
}


/*public Window(){

JTextField ticketID_textfield = new JTextField();
JTextField aufwand_textfield = new JTextField();
JTextField wert_textfield = new JTextField();
JTextArea beschreibung_text = new JTextArea();
JButton state_button = new JButton("Status");
JButton create, cancel;

FormLayout formLayout = new FormLayout("right:p, 2dlu, 5cm, p:g, p, p:g, p",		//colums
										"p, 1dlu, p, 5dlu, p, 2dlu, p:g, 2dlu, p");	//rows
FormLayout aufwandwert = new FormLayout("right:p, 2dlu, 2cm", "p, 2dlu, p");
CellConstraints cc = new CellConstraints();

DefaultFormBuilder aufwandwert_builder = new DefaultFormBuilder(aufwandwert);
aufwandwert_builder.setDefaultDialogBorder();

aufwandwert_builder.addLabel("Aufwand:", cc.xy(1, 1));
aufwandwert_builder.add(aufwand_textfield, cc.xy(3, 1));
aufwandwert_builder.addLabel("Wert:", cc.xy(1, 3));
aufwandwert_builder.add(wert_textfield, cc.xy(3, 3));

ButtonBarBuilder2 buttonbuilder = ButtonBarBuilder2.createLeftToRightBuilder();
buttonbuilder.addButton(new JButton[]{create = new JButton("create"), cancel = new JButton("cancel")});

DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
builder.setDefaultDialogBorder();

builder.addLabel("Name:", cc.xy(1, 1));
builder.add(ticketID_textfield, cc.xy(3, 1));
//builder.add(farb_button, cc.xy(5, 1));
builder.add(aufwandwert_builder.getPanel(), cc.xy(7, 1));
builder.addSeparator("Beschreibung", cc.xyw(1, 5, 7));
builder.add(beschreibung_text, cc.xyw(1, 7, 7));

builder.add(buttonbuilder.getPanel(), cc.xyw(1, 9, 7));

JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());
frame.add(builder.getPanel(), BorderLayout.CENTER);
frame.setTitle("Ticket Erzeugen");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(700, 500);
frame.setLocationByPlatform(true);
frame.setVisible(true);
}*/



