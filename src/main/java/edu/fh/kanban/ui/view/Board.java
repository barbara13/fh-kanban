/*
 * Created by JFormDesigner on Mon Jul 01 11:57:27 CEST 2013
 */

package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Frodo Beutlin
 */
public class Board extends JPanel implements View {
    public Board() {
        getComponents();
    }

    
    
private JLabel title;
private JTextField searchtext;
private JSeparator separator;
private JScrollPane scrollPane1;
private JTable table;
    
    public JComponent getComponent() {
 
        JPanel bp = new JPanel();
        title = new JLabel();
        searchtext = new JTextField();
        separator = new JSeparator();
        scrollPane1 = new JScrollPane();
        table = new JTable();

        bp.setLayout(new FormLayout(
            "2*(default, $lcgap), 250dlu, 80dlu, 4*($lcgap, default)",
            "3*(default, $lgap), default"));

       
        title.setText("Board - Wand?");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        bp.add(title, CC.xy(3, 3));
        bp.add(searchtext, CC.xy(6, 3));
        bp.add(separator, CC.xywh(1, 5, 7, 1));
        
        
       
        {
            scrollPane1.setViewportView(table);
        }
        bp.add(scrollPane1, CC.xywh(3, 7, 6, 1));
        //bp.add(table, CC.xywh(3, 7, 6, 1));
        
        return bp;
    }
    

}
