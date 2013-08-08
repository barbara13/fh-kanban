package edu.fh.kanban.ui.view;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import edu.fh.kanban.ui.controller.BacklogController;

/**
 *
 * @author David, Lorenz, Maxim
 */
public class BacklogView extends JPanel implements View {

	/**
	  *
	  */
	private static final long serialVersionUID = 1L;
	
	private JTextField searchfield;
    private BacklogController c = null;
    private JPanel[] cards = new JPanel[100];
    private JButton[] showcards = new JButton[100], addcards = new JButton[100];
    private JLabel[] ids = new JLabel[100];
    private JComboBox<String> comboBox;
    private BoardView bv;

    public BacklogView(){
    	getComponent();
    }
    
    public  JComponent getComponent() {
    	c = new BacklogController(this, bv);

        setLayout(new FormLayout(new ColumnSpec[] {
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("default:grow"),
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("max(100dlu;default)"),
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

/*
        searchfield.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                try{
	                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	                    i--;
	                    i--;
	                }
                
                for(int j = 0; j < cards.length; j++){
                    
                if (searchfield.getText().toString().regionMatches(true, 0 + i, cards[j].getText().toString(), 0 + i, 1)) {
                    cards[j].setVisible(true);
                    i++;
                } else {
                    cards[j].setVisible(false);
                    i++;
                }
                if (searchfield.getText().toString().equals("")) {
                    
                    cards[j].setVisible(true);
                }
                }
                } catch(NullPointerException exc){
                   return;
                }
                
            }
        });*/
        
        searchfield = new JTextField();
        searchfield.setColumns(10);
        
        comboBox = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[]{"Creation time", "Headline", "Value", "Size"}));
        comboBox.addActionListener(c);
        
        add(searchfield, "8, 2, fill, default");
        add(comboBox, "8, 4, fill, default");
        add(new JLabel("Sort by:"), "6, 4, right, default");
        add(new JSeparator(), "2, 5, 7, 1");
        
        c.showCards();
        return this;
    }
    
    public void setBv(BoardView bv) {
        this.bv = bv;
    }
    
    public JPanel getPanel() {
        return this;
    }

    public JPanel[] getCards() {
        return cards;
    }

    public JLabel[] getIds() {
        return ids;
    }

    public JComboBox<String> getSort() {
        return comboBox;
    }

    public JTextField getSearch() {
        return searchfield;
    }

    public JButton[] getShowcards() {
        return showcards;
    }

    public JButton[] getAddcards() {
        return addcards;
    }
}
