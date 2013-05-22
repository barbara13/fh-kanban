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
		
	JButton rot_Button = new JButton("rot");
	JButton gelb_Button = new JButton("gelb");
	JButton gruen_Button = new JButton("gruen");
	JButton blau_Button = new JButton("blau");
	JButton plus_Button = new JButton("+");
	JButton minus_Button = new JButton("-");
	
	JTextField texteingabe_Bordname = new JTextField();
	JTextField texteingabe_Colomsname = new JTextField();
	
	JSpinner auswahl = new JSpinner();
	
	public void actionPerformed(ActionEvent e){
		FormLayout formLayout = new FormLayout("p, 2dlu, 3cm, 2dlu, p, 2dlu, 1cm, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p,2dlu, p,2dlu, p ",  //Colums
											   "p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p");	//rows
        FormLayout fl = new FormLayout("center:2cm, 2dlu, center:2cm, 2dlu, center:2cm, 2dlu, center:2cm",
        								"p");
        
		CellConstraints cc = new CellConstraints();
		fl.setColumnGroups(new int[][]{{1, 3, 5, 7}, {}});
		
		DefaultFormBuilder bbutton = new DefaultFormBuilder(fl);
		bbutton.setDefaultDialogBorder();
		
		bbutton.add(rot_Button, cc.xy(1, 1));
		bbutton.add(gelb_Button, cc.xy(3, 1));
		bbutton.add(gruen_Button, cc.xy(5, 1));
		bbutton.add(blau_Button, cc.xy(7, 1));
                
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        builder.setDefaultDialogBorder();
                      
        builder.addLabel(" Bordname:", cc.xy(1, 1));
        builder.add(texteingabe_Bordname, cc.xy(3,1));//Textfeld Texteingabe	
        
        builder.addSeparator("Color", cc.xyw(1, 3, 11));
        
        builder.add(bbutton.getPanel(), cc.xyw(1, 7, 11));
        
        builder.addSeparator(" Colums", cc.xyw(1, 9, 11) );
        builder.addLabel("Name Colums:", cc.xy(1, 11));		//Label Name des Colums
        builder.add(texteingabe_Colomsname, cc.xy(3, 11));//Textfeld_Texteingabe
       	
        builder.addLabel("Wip", cc.xy(5, 11));
        builder.add(auswahl, cc.xy(7, 11));	//Erhöhen und senken der Wip
        
        builder.add(plus_Button, cc.xy(9, 11));		//Plus Button um weitere Colums zu wählen
        builder.add(minus_Button, cc.xy(11, 11));	//Minus Button um erstellte Buttons zu löschen
               
        builder.add(new JButton("Abbrechen"), cc.xy(5, 13));
        builder.add(new JButton("Speichern"), cc.xy(9, 13));
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
        frame.setTitle("Teamproject 2013 - Kanban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);    
	}
        }
	