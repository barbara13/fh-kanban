package edu.fh.kanban.ui.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.ButtonBarBuilder2;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Card_Create implements ActionListener{
	
	JTextField ticketID_textfield = new JTextField();
	JTextField aufwand_textfield = new JTextField();
	JTextField wert_textfield = new JTextField();
	JTextArea beschreibung_text = new JTextArea();
	JButton state_button = new JButton("Status");
	JButton create, cancel;
	
	public void actionPerformed(ActionEvent e) {
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
        builder.add(farb_button, cc.xy(5, 1));
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
	}
	
}
