package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import edu.fh.kanban.Kanban;

import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.controller.CardController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

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
    private int cId;
    int effort, value;
    private String description, headline, create, start, done, status;
    private JButton btnAddCard, btnEdit, btnDelete, btnCancel;
    private ArrayList<Card> listCard = new ArrayList();

    public int getcId() {
        return cId;
    }

    public int getEffort() {
        return effort;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getHeadline() {
        return headline;
    }

    public String getStatus() {
        return status;
    }

    public JButton getBtnAddCard() {
        return btnAddCard;
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

    public CardView(int cId) {

        cController = new CardController(this);
        setBounds(new Rectangle(0, 0, 455, 300));
        setLocationByPlatform(true);
        setResizable(false);

        this.cId = cId;
        XMLCard card = new XMLCard();
        listCard = card.readCards();

        //Auslesen der cards
        for (int i = 0; i < listCard.size(); i++) {
            if (listCard.get(i).getCa_id() == cId) {
                headline = listCard.get(i).getName();
                effort = listCard.get(i).getEffort();
                value = listCard.get(i).getValue();
                description = listCard.get(i).getDescription();
                status = listCard.get(i).getStatus();
                create = listCard.get(i).getCreatedDate();
//        		start = listCard.get(i).getStartDate()
//        		done = listCard.get(i).getDoneDate()
                break;
            }
        }
    }

    //Methode aus der Klasse View initialsiert das Fenster und gibt getContentPane() zurück
    public JComponent getComponent() {
        setTitle(headline);

        //Je nach status wird der Hintergrund des Fensters gesetzt
        if (status.equals("Expedite")) {
            getContentPane().setBackground(Color.RED);
        } else if (status.equals("Standard")) {
            getContentPane().setBackground(Color.YELLOW);
        } else if (status.equals("Fixed Date")) {
            getContentPane().setBackground(Color.GREEN);
        } else if (status.equals("Intangible")) {
            getContentPane().setBackground(Color.BLUE);
        }

        getContentPane().setLayout(new FormLayout(new ColumnSpec[]{
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("44px"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("55px"),
            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
            ColumnSpec.decode("101px"),
            FormFactory.UNRELATED_GAP_COLSPEC,
            ColumnSpec.decode("101px"),
            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
            ColumnSpec.decode("32px"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("62px"),},
                new RowSpec[]{
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("14px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("14px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("14px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("79px"),
            FormFactory.UNRELATED_GAP_ROWSPEC,
            RowSpec.decode("14px"),
            FormFactory.LINE_GAP_ROWSPEC,
            RowSpec.decode("14px"),
            RowSpec.decode("27px"),
            RowSpec.decode("23px"),}));

        getContentPane().add(new JLabel("CardID:"), "2, 2, right, top");
        getContentPane().add(new JLabel(Integer.toString(cId)), "4, 2, left, top");
        getContentPane().add(new JLabel("Effort:"), "10, 2, left, top");
        getContentPane().add(new JLabel(Integer.toString(effort)), "12, 2, fill, top");
        getContentPane().add(new JLabel("Value:"), "10, 4, right, top");
        getContentPane().add(new JLabel(Integer.toString(value)), "12, 4, left, top");
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

        btnAddCard = new JButton("Add Card");
        btnAddCard.addActionListener(cController);
        getContentPane().add(btnAddCard, "10, 14, 3, 1, fill, top");
        if (Kanban.xmlPath == null) {
            btnAddCard.setEnabled(false);
        } else {
            btnAddCard.setEnabled(true);
        }

        //If Karte bereits on Board soll der Button - btnAddCard.setvivible(false);

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
}
