package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.controller.CardController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Color;

/**
 *
 * @author Maxim
 *
 * Die Klasse CardView zeigt die Karte an und bietet JButton's diese zu
 * verändern, zu löschen oder dem Board zuzuordnen
 */
public class CardView extends JFrame implements View {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CardController cController = null;
    private int cId, effort;
    private String description, headline, value, create, start, done;
    private JButton btnEdit, btnDelete, btnCancel;
//    private JButton btnAddCard, btnForward, btnBackward;
    private JToggleButton tglbtnBlocker = new JToggleButton("Blocker");;
    
   /* 
    public void getBoardCards(){
        XMLCard card = new XMLCard();
        listCard = card.readCards();
    }
    
    
    public void getCards(){RF
        XMLBoard board = new XMLBoard();
        listCard = board.readCards();
    }*/
    
    public CardView(int cId, ArrayList<Card> listCard, BacklogView blv, BoardView bv) {

        cController = new CardController(this, blv, bv);
        setBounds(new Rectangle(0, 0, 500, 300));
        setLocationByPlatform(true);
        setResizable(false);
        this.cId = cId;

        //Auslesen der cards
        for (int i = 0; i < listCard.size(); i++) {
            if (listCard.get(i).getCa_id() == cId) {
	            headline = listCard.get(i).getName();
	            effort = listCard.get(i).getEffort();
                value = listCard.get(i).getValue();
	            description = listCard.get(i).getDescription();
	            create = listCard.get(i).getCreatedDate();
	        	start = listCard.get(i).getStartedDate();
	        	done = listCard.get(i).getDoneDate();
	        	if(listCard.get(i).getBlocker().equals("true"))
	        		tglbtnBlocker.doClick();
	        	tglbtnBlocker.setToolTipText(listCard.get(i).getBlocker_tooltip());
	            break;
            }
        }
    }

    //Methode aus der Klasse View initialsiert das Fenster und gibt getContentPane() zurück
    public JComponent getComponent() {
        setTitle(headline);

        getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("50px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("50px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("107px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("107px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("50px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("50px"),},
        	new RowSpec[] {
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("79px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("23px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("23px"),
        		FormFactory.RELATED_GAP_ROWSPEC,
        		FormFactory.DEFAULT_ROWSPEC,}));

        getContentPane().add(new JLabel("CardID:"), "2, 2, right, top");
        getContentPane().add(new JLabel(Integer.toString(cId)), "4, 2, left, top");
        
        tglbtnBlocker.setForeground(Color.RED);
        tglbtnBlocker.setOpaque(true);
        tglbtnBlocker.setBackground(Color.RED);
        getContentPane().add(tglbtnBlocker, "6, 2, 1, 3");
        tglbtnBlocker.addActionListener(cController);
        
        getContentPane().add(new JLabel("Effort:"), "10, 2, right, top");
        getContentPane().add(new JLabel(Integer.toString(effort)), "12, 2, fill, top");
        getContentPane().add(new JLabel("Value:"), "10, 4, right, top");
        getContentPane().add(new JLabel(value), "12, 4, left, top");
        getContentPane().add(new JLabel("Description"), "2, 6, 3, 1, left, top");

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, "2, 8, 11, 1, fill, fill");
        scrollPane.setViewportView(new JLabel(description));

        getContentPane().add(new JLabel("Created"), "2, 10, 3, 1, center, top");
        getContentPane().add(new JLabel("Started"), "6, 10, center, top");
        getContentPane().add(new JLabel("Done"), "8, 10, center, top");

        getContentPane().add(new JLabel(create), "2, 12, 3, 1, fill, top");
        getContentPane().add(new JLabel(start), "6, 12, fill, top");
        getContentPane().add(new JLabel(done), "8, 12, fill, top");

        //If Karte bereits on Board soll der Button - btnAddCard.setvivible(false);
//        btnAddCard = new JButton("Add Card");
//        btnAddCard.addActionListener(cController);
//        
//        btnForward = new JButton("Forward");
//        btnForward.addActionListener(cController);
//        getContentPane().add(btnForward, "10, 12, 3, 1, fill, top");
//
//        btnBackward = new JButton("Back");
//        btnBackward.addActionListener(cController);
//        getContentPane().add(btnBackward, "10, 14, 3, 1, fill, top");
//        
//        getContentPane().add(btnAddCard, "10, 14, 3, 1, fill, top");
//        if (Kanban.xmlPath == null) {
//            btnAddCard.setEnabled(false);
//        } else {
//            btnAddCard.setEnabled(true);
//        }
                
        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(cController);
        getContentPane().add(btnEdit, "8, 14, fill, top");
        
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(cController);
        getContentPane().add(btnDelete, "6, 14, fill, top");

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(cController);
        getContentPane().add(btnCancel, "2, 14, 3, 1, fill, top");

        setVisible(true);
        return (JComponent) getContentPane();
    }
    
    public int getcId() {
        return cId;
    }

    public int getEffort() {
        return effort;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getHeadline() {
        return headline;
    }

    public JToggleButton getTglbtnBlocker() {
		return tglbtnBlocker;
	}

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }
}
