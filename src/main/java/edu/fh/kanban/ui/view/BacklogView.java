package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class BacklogView implements View{
	private JTextField Searchfield;
        private JButton button;

	/**
	 * @author Lorenz
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getComponent() {
                button = new JButton("Karte1");
		JPanel panel = new JPanel();
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(62dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(121dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(57dlu;pref):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(73dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(54dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(44dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(48dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(73dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		Searchfield = new JTextField();
		Searchfield.setText("");
		panel.add(Searchfield, "6, 2, 3, 1, right, default");
		Searchfield.setColumns(10);
		
                 panel.add(button, "2, 8");
                Searchfield.addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent e) {
                   
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if(Searchfield.getText().toString().regionMatches(true, 1, button.getText().toString() , 1, 1)){
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
                
                 
            
        });
                
		JLabel lblSortBy = new JLabel("Sort by");
		panel.add(lblSortBy, "6, 4, right, default");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Creation time", "Headline", "Value", "Size"}));
		comboBox.setToolTipText("");
		panel.add(comboBox, "8, 4, right, default");
		
               
                
		JScrollBar scrollBar = new JScrollBar();
		panel.add(scrollBar, "10, 2, 1, 13");
                
                
		return panel;
	}

	

}
