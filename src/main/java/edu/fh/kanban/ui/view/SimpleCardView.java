/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author David
 */
public class SimpleCardView extends JPanel implements View {

     private JPanel panel = new JPanel();
     private JLabel idlabel = new JLabel("ID: ");    
    
    
    public SimpleCardView() {
        getComponents();
    }
    
    
    public JPanel getComponent() { 
        panel.setLayout(new FormLayout("4dlu, 15dlu, 4dlu, 50dlu, 4dlu, 50dlu", "4dlu, 15dlu, 4dlu, 50dlu, 4dlu, 15dlu")); 
        panel.add(idlabel, CC.xy(2, 2));

        return panel; 
    }



    public JPanel getPanel() {
        return panel;
    }
}
