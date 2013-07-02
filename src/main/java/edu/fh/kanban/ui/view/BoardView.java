package edu.fh.kanban.ui.view;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import javax.swing.table.*;


public class BoardView extends JPanel implements View {
    public BoardView() {
        getComponents();
    }

//Setter
public void setTitle(JLabel title) {
        this.title = title;
    }

public void setTable(JTable table) {
        this.table = table;
    }    
    


//
private JLabel title;
private JTextField searchtext;
private JSeparator separator;
private JScrollPane scrollPane;
private JTable table;
public static TableModel tableModel;
    
    public JComponent getComponent() {
 
        JPanel bpanel = new JPanel();
        title = new JLabel();
        searchtext = new JTextField();
        separator = new JSeparator();
        
        scrollPane = new JScrollPane(table);
        table = new JTable();
        
        tableModel = new DefaultTableModel(
            new Object [][] {
                    {"Next"}
            },
            new String [] {
                "Next"
            } ) {
            
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class
            };
            
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
  
  
  //Layout
        bpanel.setLayout(new FormLayout(
            "2*(default, $lcgap), 250dlu, 80dlu, 4*($lcgap, default)",
            "5*(default, $lgap), default"));

  
 //Table
       table.setModel(tableModel);
       //table.setFillsViewportHeight(true);
       scrollPane.setViewportView(table);       
        
 //Binden an Panel       
        title.setText("Board - Name");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        bpanel.add(title, CC.xy(3, 3));
        bpanel.add(searchtext, CC.xy(6, 3));
        bpanel.add(separator, CC.xywh(1, 5, 7, 1));

        bpanel.add(table, CC.xywh(3, 7, 7, 1));
        
        return bpanel;
    }


    

}
