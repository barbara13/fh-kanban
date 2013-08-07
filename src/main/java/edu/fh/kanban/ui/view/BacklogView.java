<<<<<<< HEAD
package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

//import edu.fh.kanban.dao.XMLCard;
//import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.controller.BacklogController;
//import edu.fh.kanban.ui.controller.CardCreateController;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JScrollBar;
import javax.swing.JSeparator;
//import java.awt.event.KeyAdapter;
//import java.util.ArrayList;

/**
 *
 * @author David, Lorenz
 */
public class BacklogView extends JPanel implements View {

    /**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	
	private JTextField searchfield;
    private BacklogController c = null;
	private JPanel panel = new JPanel();
//    private JSeparator sep;
    private JPanel[] cards = new JPanel[100];
    private JButton[] showcards = new JButton[100];
    private JButton[] addcards = new JButton[100];
    private JLabel[] ids = new JLabel[100];
    private JComboBox comboBox;
//    private int i = 0;
    private BoardView bv;

    public void setBv(BoardView bv) {
        this.bv = bv;
    }

    public BacklogView() {
        getComponents();
    }
    
    public  JComponent getComponent() {
    	c = new BacklogController(this, bv);
       
    	/**
    	* @wbp.parser.entryPoint
    	*/
    	
        setLayout(new FormLayout(new ColumnSpec[]{
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
            new RowSpec[]{
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
        
        panel.setLayout(new FormLayout(new ColumnSpec[]{
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
                new RowSpec[]{
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
                FormFactory.RELATED_GAP_ROWSPEC,
                RowSpec.decode("max(16dlu;default)"),
                FormFactory.RELATED_GAP_ROWSPEC,}));

        searchfield = new JTextField();
//		searchfield.addKeyListener(c);
        add(searchfield, "6, 2, 3, 1, right, default");
        searchfield.setColumns(10);

/*
        searchfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
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

        add(new JLabel("Sort by"), "6, 4, right, default");

        comboBox = new JComboBox(new String[]{"Creation time", "Headline", "Value", "Size"});
        comboBox.addActionListener(c);

        add(comboBox, "8, 4, right, default");
        add(new JSeparator(), CC.xywh(1, 5, 10, 1));
        add(panel, CC.xywh(1, 7, 11, 17));
        
        c.showCards();
        return this;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel[] getCards() {
        return cards;
    }

    public JLabel[] getIds() {
        return ids;
    }

    public JComboBox getSort() {
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
=======
package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

//import edu.fh.kanban.dao.XMLCard;
//import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.controller.BacklogController;
//import edu.fh.kanban.ui.controller.CardCreateController;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JScrollBar;
import javax.swing.JSeparator;
//import java.awt.event.KeyAdapter;
//import java.util.ArrayList;

/**
 *
 * @author David, Lorenz
 */
public class BacklogView extends JPanel implements View {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField searchfield;
    private BacklogController c = null;
//    private JPanel panel = new JPanel();
//    private JSeparator sep;
    private JPanel[] cards = new JPanel[100];
    private JButton[] showcards = new JButton[100];
   // private JButton[] addcards = new JButton[100];
    private JLabel[] ids = new JLabel[100];
    private JComboBox comboBox;
//    private int i = 0;
    private BoardView bv;

    /**
     * @wbp.parser.entryPoint
     */
    public void setBv(BoardView bv) {
        this.bv = bv;
    }

    public BacklogView() {
        getComponents();
    }
    
    public  JComponent getComponent() {
    	c = new BacklogController(this, bv);
            
        setLayout(new FormLayout(new ColumnSpec[]{
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("max(120dlu;pref):grow"),//61
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("max(120dlu;pref):grow"),//121
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("max(120dlu;pref):grow"),//57
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("max(73dlu;pref):grow"),//73
            FormFactory.RELATED_GAP_COLSPEC,
            FormFactory.DEFAULT_COLSPEC,
            FormFactory.RELATED_GAP_COLSPEC,},
            new RowSpec[]{
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

        searchfield = new JTextField();
//		searchfield.addKeyListener(c);
        add(searchfield, "6, 2, 3, 1, right, default");
        searchfield.setColumns(10);

/*
        searchfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
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

        add(new JLabel("Sort by"), "6, 4, right, default");

        comboBox = new JComboBox(new String[]{"Creation time", "Headline", "Value", "Size"});
        comboBox.addActionListener(c);

        add(comboBox, "8, 4, right, default");
        add(new JSeparator(), CC.xywh(1, 5, 10, 1));
        
        c.showCards();
        
        return this;
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

    public JComboBox getSort() {
        return comboBox;
    }

    public JTextField getSearch() {
        return searchfield;
    }

    public JButton[] getShowcards() {
        return showcards;
    }

 //   public JButton[] getAddcards() {
 //       return addcards;
 //   }
    
    
}
>>>>>>> 73dbaa72101fd3dfce29ac7b93856c350a7224c7
