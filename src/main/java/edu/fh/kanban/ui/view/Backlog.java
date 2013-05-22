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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Backlog implements ActionListener{

	public void actionPerformed(ActionEvent e) {
	
	}
   
        public JComponent getComponent() {
  
            JPanel bl = new JPanel();
            JTextField suche = new JTextField();
            JLabel label_suche = new JLabel();
            JSeparator separator = new JSeparator();
            
            label_suche.setText("Suche: ");
            
            
        FormLayout formLayout = new FormLayout("right:p, 2dlu, p:g, 2dlu, p, 2dlu, right:p, 2dlu, p:g",	//colums
                                                "p, 1dlu, p, 5dlu, p, 2dlu, p , 2dlu, p, 2dlu");		//rows
        bl.setLayout(formLayout);
        
        CellConstraints cc = new CellConstraints();
       
        
        
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
                
       
       bl.add(label_suche, cc.xy(7, 1));
       bl.add(suche, cc.xy(9, 1));
       bl.add(separator, cc.xyw(1, 5, 9));
        
        
        return bl;
	}	
}