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

//Setter
public void setTitle(JLabel title) {
        this.title = title;
    }

    public JButton getCard1() {
        return card1;
    }


  
private JLabel title;
private JTextField searchtext;
private JSeparator separator;
private JScrollPane scrollPane;
private JPanel bpanel;
private JButton card1;
private JLabel label1;
private JButton b;



    public JComponent getComponent() {
 
        bpanel = new JPanel();
        title = new JLabel();
        searchtext = new JTextField();
        separator = new JSeparator(); 
        scrollPane = new JScrollPane();
        label1 = new JLabel("New");
        card1 = new JButton("Karte 1");
        
//Dem Button einen ActionListener zuweisen        
        card1.addActionListener(c);
        
  //Layout
        bpanel.setLayout(new FormLayout(
            "2*(default, $lcgap), 250dlu, 80dlu, 4*($lcgap, default)",
            "5*(default, $lgap), default"));

        
 //Binden an Panel       
        title.setText("Board - Name");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        bpanel.add(title, CC.xy(3, 3));
        bpanel.add(searchtext, CC.xy(6, 3));
        bpanel.add(separator, CC.xywh(1, 5, 7, 1));
        
        card1.setBackground(Color.red);
        card1.setForeground(Color.red);
        bpanel.add(card1, CC.xy(3, 9));
        bpanel.add(label1, CC.xy(3, 7));
        
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
              
        
        return bpanel;
        
    }
}
