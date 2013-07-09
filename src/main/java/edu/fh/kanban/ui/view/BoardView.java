package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
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
 
    public BoardView() {
        //BoardController im Konstruktor
        c = new BoardController(this);
        getComponents();
    }

    


    
    public JButton[] getCards() {
        return cards;
    }

    public JLabel[] getColumns() {
        return columns;
    }

    public JLabel getTitle() {
        return title;
    }

    public JPanel getBpanel() {
        return bpanel;
    }

    public JTextField getSearchtext() {
        return searchtext;
    }

    

  
private JLabel title = new JLabel();
private JTextField searchtext;
private JSeparator separator;
private JScrollPane scrollPane;
private JPanel bpanel = new JPanel();
private JLabel label1;
private JButton b;
private JButton[] cards= new JButton[100];
private JLabel[] columns = new JLabel[100];



    public JComponent getComponent() {
 
        //bpanel = new JPanel();
        searchtext = new JTextField();
        separator = new JSeparator(); 
        scrollPane = new JScrollPane();
        label1 = new JLabel("New");

        
  //Layout
        bpanel.setLayout(new FormLayout(
            "2*(default, $lcgap), 250dlu, 80dlu, 4*($lcgap, default)",
            "5*(default, $lgap), default"));

        
 //Binden an Panel
        //title.setFont(new Font("Arial", Font.BOLD, 24));
        bpanel.add(title, CC.xy(3, 3));
        bpanel.add(searchtext, CC.xy(6, 3));
        bpanel.add(separator, CC.xywh(1, 5, 7, 1));
        
      
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
        
        return bpanel;
        
    }
}
