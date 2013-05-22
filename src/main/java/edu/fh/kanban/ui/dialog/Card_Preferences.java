package edu.fh.kanban.ui.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Card_Preferences implements ActionListener{
	
	JTextField ticketID_textfield = new JTextField();
	JTextField aufwand_textfield = new JTextField();
	JTextField wert_textfield = new JTextField();
	JButton farb_button = new JButton("Farbe");
	
	public void actionPerformed(ActionEvent e) {
		FormLayout formLayout = new FormLayout("right:p, 2dlu, p:g, 2dlu, p, 2dlu, right:p, 2dlu, p:g",	//colums
											   "p, 1dlu, p, 5dlu, p, 2dlu, p , 2dlu, p, 2dlu");		//rows
        CellConstraints cc = new CellConstraints();
        formLayout.setColumnGroups(new int[][]{{1, 7}, {3, 9}});
        
        /*JPanel panel = new JPanel(formLayout);
        panel.add(new JLabel("Ticket ID:"), cc.xy(1, 1));
        panel.add(ticketID_textfield, cc.xy(3, 1));
        panel.add(farb_button, cc.xy(5, 1));
        panel.add(new JLabel("Aufwand"), cc.xy(7, 1));
        panel.add(aufwand_textfield, cc.xy(9, 1));
        panel.add(new JLabel("Wert"), cc.xy(7, 3));
        panel.add(wert_textfield, cc.xy(9, 3));*/
        
        
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
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
        //frame.add(b.getPanel(), BorderLayout.SOUTH);
        //frame.add(panel);
        frame.setTitle("Ticket Erzeugen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
	
}
