package edu.fh.kanban.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Card_Preferences implements ActionListener{
	
	JTextField ticketID_textfield = new JTextField();
	JTextField aufwand_textfield = new JTextField();
	JTextField wert_textfield = new JTextField();
	JTextArea beschreibung_text = new JTextArea();
	JButton farb_button = new JButton("Farbe");
	JButton create, cancel;
	
	public void actionPerformed(ActionEvent e) {
		FormLayout formLayout = new FormLayout("right:p, 2dlu, 5cm, 2cm, p, 4.8cm, right:p, 2dlu, 2cm",	//colums
											   "p, 1dlu, p, 5dlu, p, 2dlu, p:g, 2dlu, p");							//rows
        CellConstraints cc = new CellConstraints();
        //formLayout.setColumnGroups(new int[][]{{1, 7}, {3, 9}});
        
        ButtonBarBuilder2 buttonbuilder = ButtonBarBuilder2.createLeftToRightBuilder();
        buttonbuilder.addButton(new JButton[]{create = new JButton("create"), cancel = new JButton("cancel")});
        
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
                
        builder.addLabel("Name:", cc.xy(1, 1));
        builder.add(ticketID_textfield, cc.xy(3, 1));
        builder.add(farb_button, cc.xy(5, 1));
        builder.addLabel("Aufwand", cc.xy(7, 1));
        builder.add(aufwand_textfield, cc.xy(9, 1));
        builder.addLabel("Wert", cc.xy(7, 3));
        builder.add(wert_textfield, cc.xy(9, 3));
        builder.addSeparator("Beschreibung", cc.xyw(1, 5, 9));
        builder.add(beschreibung_text, cc.xyw(1, 7, 9));
        
        builder.add(buttonbuilder.getPanel(), cc.xyw(6, 9, 4));
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
        //frame.add(buttonbuilder.getPanel(), BorderLayout.SOUTH);
        frame.setTitle("Ticket Erzeugen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
	
}
