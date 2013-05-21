package edu.fh.kanban.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import nu.xom.jaxen.function.RoundFunction;

import com.jgoodies.forms.builder.ButtonBarBuilder2;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Board_Preferences implements ActionListener{

	public void actionPerformed(ActionEvent e){
		FormLayout formLayout = new FormLayout("p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p,2dlu, p,2dlu, p ",  //Colums
											   "p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p");	//rows
        CellConstraints cc = new CellConstraints();
        
        /*JPanel panel = new JPanel(formLayout);
        panel.add(new JLabel(" Bordname:"), cc.xy(1, 1));
        panel.add(new JTextField(), cc.xy(3, 1));
        panel.add(new JLabel(" Colors "), cc.xy(1,3));
        panel.add(new JSeparator(SwingConstants.VERTICAL), cc.xy(3, 3));
        
        panel.add(new JLabel(" rot"), cc.xy(1, 5));
        panel.add(new JLabel(" gelb"), cc.xy(3, 5));
        panel.add(new JLabel(" grün"), cc.xy(5, 5));
        panel.add(new JLabel(" blau"), cc.xy(7, 5));
        //ROT GELB GRÜN BLAU 
        panel.add(new JLabel(" Colums"), cc.xy(1, 7));
        panel.add(new JSeparator(SwingConstants.VERTICAL), cc.xy(3, 7));
        panel.add(new JLabel(" Name"), cc.xy(1, 11));
        panel.add(new JTextField(), cc.xy(3, 11));
        panel.add(new JLabel(" Wip"), cc.xy(5, 9));
        //Wip erhöhen senken
        //Round button +
        //Round Button -
        panel.add(new JButton(" Abbrechen"), cc.xy(5, 13));
        panel.add(new JButton(" Speichern"), cc.xy(9, 13));
        

        /*JButton jb = new JButton("+");
        jb.setBorder(new LineBorder(Color.blue, 10, true));
        panel.add(jb, cc.xy(1, 1));*/
        
        
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
        ButtonBarBuilder2 b = ButtonBarBuilder2.createLeftToRightBuilder();
        b.addButton(new JButton("Speichern"));
        b.addButton(new JButton("Abbrehen"));
        b.addButton(new JButton("Hilfe"));
                
        builder.addLabel(" Bordname:", cc.xy(1, 1));
        builder.add(new JTextField(), cc.xy(3, 1));
        
        builder.addSeparator("Color", cc.xyw(1, 3, 4));
        
        builder.addLabel("rot", cc.xy(1, 5));
        builder.addLabel("gelb", cc.xy(3, 5));
        builder.addLabel("gruen", cc.xy(5, 5));
        builder.addLabel("blau", cc.xy(7, 5));
        
        //FARBEN BUTTON
        //ROT GELB GRÜN BLAU
        
        builder.addSeparator(" Colums", cc.xyw(1, 9, 11) );
        builder.addLabel("Name Colums:", cc.xy(1, 11));
        builder.add(new JTextField(), cc.xy(3, 11));
        builder.addLabel("Wip", cc.xy(5, 11));
        //Button hoch und runterschalten
        //BUTTON +
        //Button -
        
       // JButton jb = new JButton("+");
       // jb.setBorder(new LineBorder(Color.blue, 10, true));
        
        //builder.append(jb);
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
        //frame.add(panel);
        frame.setTitle("Teamproject 2013 - Kanban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}

}
