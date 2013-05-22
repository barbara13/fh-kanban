package edu.fh.kanban.ui.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Board_Preferences implements ActionListener{

	public void actionPerformed(ActionEvent e){
		FormLayout formLayout = new FormLayout("p, 2dlu, 3cm, 2dlu, p, 2dlu, 1cm, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p,2dlu, p,2dlu, p ",  //Colums
											   "p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p");	//rows
        FormLayout fl = new FormLayout("center:2cm, 2dlu, center:2cm, 2dlu, center:2cm, 2dlu, center:2cm", "p");
		CellConstraints cc = new CellConstraints();
		fl.setColumnGroups(new int[][]{{1, 3, 5, 7}, {}});
		
		DefaultFormBuilder bbutton = new DefaultFormBuilder(fl);
		bbutton.setDefaultDialogBorder();
		
		bbutton.add(new JButton("rot"), cc.xy(1, 1));
		bbutton.add(new JButton("gelb"), cc.xy(3, 1));
		bbutton.add(new JButton("gruen"), cc.xy(5, 1));
		bbutton.add(new JButton("blau"), cc.xy(7, 1));
                
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
                      
        builder.addLabel(" Bordname:", cc.xy(1, 1));
        builder.add(new JTextField(), cc.xy(3, 1));
        
        builder.addSeparator("Color", cc.xyw(1, 3, 11));
        
        builder.add(bbutton.getPanel(), cc.xyw(1, 7, 11));
        
        builder.addSeparator(" Colums", cc.xyw(1, 9, 11) );
        builder.addLabel("Name Colums:", cc.xy(1, 11));
        builder.add(new JTextField(), cc.xy(3, 11));
        builder.addLabel("Wip", cc.xy(5, 11));
        builder.add(new JSpinner(), cc.xy(7, 11));
        //BUTTON +
        //Button -
        
       // JButton jb = new JButton("+");
       // jb.setBorder(new LineBorder(Color.blue, 10, true));
               
        builder.add(new JButton("Abbrechen"), cc.xy(5, 13));
        builder.add(new JButton("Speichern"), cc.xy(9, 13));
        
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
