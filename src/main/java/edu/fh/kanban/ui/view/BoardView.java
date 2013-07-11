package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import edu.fh.kanban.Kanban;
import edu.fh.kanban.ui.controller.BoardController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.*;


public class BoardView extends JPanel implements View {
  
//BoardController definieren    
 private BoardController c = null;  
 private Kanban kn;
 
    public BoardView() {
        //BoardController im Konstruktor
        c = new BoardController(this);
        kn = new Kanban();
        getComponents();
    }

    


    
    public JButton[] getCards() {
        return cards;
    }

    public JLabel[] getColumns() {
        return columns;
    }

    public JPanel getBpanel() {
        return bpanel;
    }

    public JTextField getSearchtext() {
        return searchtext;
    }

private JPanel bpanel;
private JTextField searchtext;
private JSeparator separator;
private JScrollPane scrollPane;
private JButton[] cards= new JButton[100];
private JLabel[] columns = new JLabel[100];
private boolean firstBoard = true;



    public JComponent getComponent() {
 
        bpanel = new JPanel();
        searchtext = new JTextField();
        separator = new JSeparator(); 
        scrollPane = new JScrollPane();
        //label1 = new JLabel("New");

        
  //Layout
        bpanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(120dlu;pref)"),//61
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(120dlu;pref)"),//121
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(120dlu;pref):grow"),//57
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(73dlu;pref)"),//73
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
                                FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
                                FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
                                FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
                                FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

        
 //Binden an Panel
        //title.setFont(new Font("Arial", Font.BOLD, 24));
        bpanel.add(searchtext, CC.xy(8, 2));
        bpanel.add(separator, CC.xywh(1, 5, 10, 1));
        
      
        //bpanel.add(label1, CC.xy(3, 7));
       /* 
        searchtext.addKeyListener(new KeyListener(){    
            
            @Override
            public void keyTyped(KeyEvent e) {
		}
            
            @Override
            public void keyPressed(KeyEvent e) {          
            }

            @Override
            public void keyReleased(KeyEvent e) {
                 if(searchtext.getText().toString().regionMatches(true, 0, card1.getText().toString(),0 , 1)){
                    card1.setVisible(true);
                }		
                else
                {
                    card1.setVisible(false);
                }
                
                if(searchtext.getText().toString().equals(""))
                {
                    card1.setVisible(true);
                }
		}      
        });
        */
        
        
        c.paintBoard(Kanban.xmlPath);
        return bpanel;
       
    }
}
