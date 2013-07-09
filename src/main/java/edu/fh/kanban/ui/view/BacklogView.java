package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import edu.fh.kanban.ui.controller.BacklogController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;




public class BacklogView implements View{
	private JTextField Searchfield;
        private BacklogController c = new BacklogController(this);
        private JPanel panel;
        private JSeparator sep;
        private JButton[] cards= new JButton[100];
        private JLabel[] ids = new JLabel[100];
        private JComboBox comboBox;
        
        
	@Override
	public JComponent getComponent() {
                
            
            
                c = new BacklogController(this);
		panel = new JPanel();
		panel.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		Searchfield = new JTextField();
		Searchfield.setText("");
		panel.add(Searchfield, "6, 2, 3, 1, right, default");
		Searchfield.setColumns(10);
                
                

		               
            /*    Searchfield.addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent e) {
                   
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if(Searchfield.getText().toString().regionMatches(true, 0, button.getText().toString() , 0, 1)){
                        button.setVisible(true);
                    }
                    else {
                        button.setVisible(false);
                    }
                
                if(Searchfield.getText().toString().equals(""))
                {
                    button.setVisible(true);
                }
                }
                
                 
            
        });*/
                                
		JLabel lblSortBy = new JLabel("Sort by");
		panel.add(lblSortBy, "6, 4, right, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Creation time", "Headline", "Value", "Size"}));
		comboBox.setToolTipText("");
		panel.add(comboBox, "8, 4, right, default");
		
                sep = new JSeparator();
                panel.add(sep, CC.xywh(1, 5, 10, 1));
                
		//JScrollBar scrollBar = new JScrollBar();
		//panel.add(scrollBar, "10, 2, 1, 13");
                
                c.showCards();
		return panel;
	}

    
    public JPanel getPanel() {
        return panel;
    }

    public JButton[] getCards() {
        return cards;
    }
    
    public JLabel[] getIds(){
        return ids;
    }
    
    public JComboBox getSearch(){
    	return comboBox;
    }

	

}
