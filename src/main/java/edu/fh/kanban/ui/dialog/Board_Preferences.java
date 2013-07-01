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
	
	private JButton abbrechen, speichern;
	private JFrame JFrame_BoardPreferences;
		
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
		FormLayout formLayout1 = new FormLayout("p, 2dlu, 3cm, 2dlu, p, 2dlu, 1cm, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p ,2dlu, p ",  //Colums
											   "p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p");	//rows
        FormLayout formLayout2 = new FormLayout("center:2cm, 2dlu, center:2cm, 2dlu, center:2cm, 2dlu, center:2cm",
        										"p");
        FormLayout formLayout3 = new FormLayout("p, 2dlu, 3cm, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p, 2dlu, p ,2dlu, p ",
        										"p");
        
		CellConstraints cc = new CellConstraints();
		formLayout2.setColumnGroups(new int[][]{{1, 3, 5, 7}, {}});
		
		DefaultFormBuilder bbutton = new DefaultFormBuilder(formLayout2); //Neues Register für Farben
		bbutton.setDefaultDialogBorder();
		
		bbutton.add(rot_Button, cc.xy(1, 1));
		bbutton.add(gelb_Button, cc.xy(3, 1));
		bbutton.add(gruen_Button, cc.xy(5, 1));
		bbutton.add(blau_Button, cc.xy(7, 1));
                
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout1);
        builder.setDefaultDialogBorder();
                      
        builder.addLabel(" Bordname:", cc.xy(1, 1));
        builder.add(texteingabe_Bordname, cc.xy(3,1));		//Textfeld Texteingabe	
        
        builder.addSeparator(" Color", cc.xyw(1, 3, 11));
        
        builder.add(bbutton.getPanel(), cc.xyw(1, 7, 11));
        
        builder.addSeparator(" Colums", cc.xyw(1, 9, 11) );
        
        //formLayout3.setColumnGroups(new int[][]{{1,3,5,7,9,11},{}});
        
        DefaultFormBuilder bbbutton = new DefaultFormBuilder(formLayout3);	//AB HIER
        bbbutton.setDefaultDialogBorder();
        
        bbbutton.addLabel(" Name Colums:", cc.xy(1, 1));	//Label Name des Colums
        bbbutton.add(texteingabe_Colomsname, cc.xy(3, 1));  //Textfeld_Texteingabe
       	
        bbbutton.addLabel("Wip", cc.xy(5, 1));
        bbbutton.add(auswahl, cc.xy(7, 1));					//Erhöhen und senken der Wip
        
        bbbutton.add(plus_Button, cc.xy(9, 1));				//Plus Button um weitere Colums zu wählen
        bbbutton.add(minus_Button, cc.xy(11, 1));			//Minus Button um erstellte Buttons zu löschen //BIS HIER SEPERAT
               
        builder.add(new JButton("Abbrechen"), cc.xy(5, 13));
        builder.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(new ActionEvent e){
        		JFrame_BoardPreferences.dispose();
        		}
        }
        builder.add(new JButton("Speichern"), cc.xy(9, 13));
        builder.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(new ActionEvent e){
        		JFrame_BoardPreferences.dispose();
        	}
        }
        
        builder.add(bbbutton.getPanel(), cc.xyw(1,11, 11));
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(builder.getPanel(), BorderLayout.CENTER);
       
        frame.setTitle("Board_Preferences erstellen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
        }
	