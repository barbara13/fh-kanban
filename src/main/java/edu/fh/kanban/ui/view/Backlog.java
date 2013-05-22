package edu.fh.kanban.ui.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Backlog implements ActionListener{
		
	JTextField suche = new JTextField();

	public void actionPerformed(ActionEvent e) {
	FormLayout formLayout = new FormLayout("right:p, 2dlu, p:g, 2dlu, p, 2dlu, right:p, 2dlu, p:g",	//colums
                                                "p, 1dlu, p, 5dlu, p, 2dlu, p , 2dlu, p, 2dlu");		//rows
        
        CellConstraints cc = new CellConstraints();
       
        
        
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
                
        
        builder.addLabel("Suche: ", cc.xy(7, 1));
        builder.add(suche, cc.xy(9, 1));
        builder.addSeparator("",cc.xyw(1, 5, 9));
        
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
        
        frame.setTitle("Backlog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
	
}