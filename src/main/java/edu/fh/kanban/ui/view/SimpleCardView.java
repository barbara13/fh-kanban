/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class SimpleCardView extends JPanel implements View {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private JPanel panel = new JPanel();
     private JLabel idlabel = new JLabel("ID: ");    
    
    
    public SimpleCardView() {
    	getComponent();
    }
    
    
    public JPanel getComponent() { 
        setLayout(new FormLayout("4dlu, 15dlu, 4dlu, 50dlu, 4dlu, 50dlu", "4dlu, 15dlu, 4dlu, 50dlu, 4dlu, 15dlu")); 
        add(idlabel, CC.xy(2, 2));

        return this; 
    }



    public JPanel getPanel() {
        return this;
    }
}
