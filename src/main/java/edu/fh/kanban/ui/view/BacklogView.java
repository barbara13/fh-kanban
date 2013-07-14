package edu.fh.kanban.ui.view;

import com.jgoodies.forms.factories.CC;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.controller.BacklogController;
import edu.fh.kanban.ui.controller.CardCreateController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

/**
 *
 * @author David, Lorenz
 */
public class BacklogView extends JPanel implements View {

    private JTextField searchfield;
    private BacklogController c;
    private JPanel panel = new JPanel();
    private JSeparator sep;
    private JButton[] cards = new JButton[100];
    private JLabel[] ids = new JLabel[100];
    private JComboBox comboBox;
    private int i = 0;
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
            FormFactory.RELATED_GAP_ROWSPEC,}));

        searchfield = new JTextField();
        searchfield.setText("");
//		searchfield.addKeyListener(c);
        panel.add(searchfield, "6, 2, 3, 1, right, default");
        searchfield.setColumns(10);


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
        });

        JLabel lblSortBy = new JLabel("Sort by");
        panel.add(lblSortBy, "6, 4, right, default");

        comboBox = new JComboBox();
        comboBox.addActionListener(c);
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Creation time", "Headline", "Value", "Size"}));
        comboBox.setToolTipText("");
        panel.add(comboBox, "8, 4, right, default");
        sep = new JSeparator();
        panel.add(sep, CC.xywh(1, 5, 10, 1));
        
        c.showCards();
        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton[] getCards() {
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
}
