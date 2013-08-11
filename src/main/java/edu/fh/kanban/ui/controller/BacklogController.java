package edu.fh.kanban.ui.controller;

import edu.fh.kanban.dao.XMLCard;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardView;
import edu.fh.kanban.ui.view.BacklogCardView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author David, Malte, Lorenz, Maxim
 */
public class BacklogController extends Controller implements CaretListener {

    private BoardView bv;
    private BacklogView blv;
    private CardView cv;
    private XMLCard xml;
    private ArrayList<Card> listCard = new ArrayList<Card>();

    public BacklogController(BacklogView blv) {

        this.blv = blv;
    }

    public void setBv(BoardView bv) {
        this.bv = bv;
    }

    public void showCards() {
        xml = new XMLCard();
        listCard = xml.readCards();

        for (int i = 0, j = 1, k = 1; i < listCard.size(); i++, j += 2) {
            addCardToPanel(i, i, j, k);
            if (j == 7) {
                k += 2;
                j = -1;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        xml = new XMLCard();
        listCard = xml.readCards();
        String selecteItem = blv.getSort().getSelectedItem().toString();
        blv.getPanel().removeAll();

        if (selecteItem.equals("Card ID")) {
            int array[] = new int[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getCa_id();
            }

            array = sortByInt(array);

            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i] == listCard.get(n).getCa_id()) {
                        addCardToPanel(i, n, j, k);

                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
        } else if (selecteItem.equals("Headline")) {
            String array[] = new String[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getName();
            }
            array = sortByString(array);
            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i].equals(listCard.get(n).getName())) {
                        addCardToPanel(i, n, j, k);

                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
        } else if (selecteItem.equals("Effort")) {
            int array[] = new int[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getEffort();
            }

            array = sortByInt(array);

            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i] == listCard.get(n).getEffort()) {
                        addCardToPanel(i, n, j, k);

                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
        } else if (selecteItem.equals("Value")) {
            String array[] = new String[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getValue();
            }

            array = sortByString(array);

            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i].equals(listCard.get(n).getValue())) {
                        addCardToPanel(i, n, j, k);

                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
        } else if (selecteItem.equals("Creation time")) {
            String array[] = new String[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getCreatedDate();
            }

            array = sortByString(array);

            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i].equals(listCard.get(n).getCreatedDate())) {
                        addCardToPanel(i, n, j, k);
                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
        }
        blv.getPanel().updateUI();
    }

    private void addCardToPanel(int toCard, int fromCard, int column, int row) {
        JTextArea desc = new JTextArea(listCard.get(fromCard).getDescription());
        desc.setEditable(false);

        blv.getCards()[toCard] = new BacklogCardView();
        blv.getCards()[toCard].add(new JLabel(Integer.toString(listCard.get(fromCard).getCa_id())), "4, 2");
        blv.getCards()[toCard].add(new JLabel(listCard.get(fromCard).getName()), "8, 2");
        blv.getCards()[toCard].add(new JLabel(Integer.toString(listCard.get(fromCard).getEffort())), "4, 4");
        blv.getCards()[toCard].add(new JLabel(listCard.get(fromCard).getValue()), "8, 4");
        blv.getCards()[toCard].add(desc, "2, 10, 9, 1, fill, fill");
        blv.getCards()[toCard].add(new JLabel(listCard.get(fromCard).getCreatedDate()), "4, 12, 7, 1");
        blv.getCards()[toCard].setBorder(BorderFactory.createLineBorder(Color.black));

        blv.getShowcards()[fromCard] = new JButton("SHOW");
        blv.getCards()[toCard].add(blv.getShowcards()[fromCard], "10, 2");
        blv.getShowcards()[fromCard].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < blv.getCards().length; i++) {
                    if (e.getSource() == blv.getShowcards()[i]) {
                        cv = new CardView(listCard.get(i).getCa_id(), listCard, blv, bv);
                        cv.getComponent();
                        cv.getBtnBackward().setVisible(false);
                        cv.getBtnForward().setVisible(false);
                        cv.getTglbtnBlocker().setVisible(false);
                        cv.getBtnDeleteFromBoard().setVisible(false);
                        break;
                    }
                }
            }
        });

        blv.getPanel().add(blv.getCards()[toCard], column + ", " + row + ", 1, 1");
    }

    private int[] sortByInt(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = (i + 1); j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tausch = array[i];
                    array[i] = array[j];
                    array[j] = tausch;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            int j = (i + 1);
            if (j < array.length) {
                while (array[i] == array[j]) {
                    array[j] = -1;
                    j++;
                    if (j == array.length) {
                        break;
                    }
                }
                if (i != (j - 1)) {
                    for (int k = (i + 1); k < array.length; k++, j++) {
                        if (j < array.length) {
                            array[k] = array[j];
                        } else {
                            array[k] = -1;
                        }
                    }
                }
            }
        }
        return array;
    }

    private String[] sortByString(String array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = (i + 1); j < array.length; j++) {
                if (array[i].compareToIgnoreCase(array[j]) > 0) {
                    String tausch = array[i];
                    array[i] = array[j];
                    array[j] = tausch;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            int j = (i + 1);
            if (j < array.length) {
                while (array[i].equals(array[j])) {
                    array[j] = "-1";
                    j++;
                    if (j == array.length) {
                        break;
                    }
                }
                if (i != (j - 1)) {
                    for (int k = (i + 1); k < array.length; k++, j++) {
                        if (j < array.length) {
                            array[k] = array[j];
                        } else {
                            array[k] = "-1";
                        }
                    }
                }
            }
        }
        return array;
    }

    private String[] searchByString(String array[], String searchText) {
        for (int i = 0; i < array.length; i++) {
            if (searchText.regionMatches(true, 0, array[i], 0, searchText.length())) {
            } else {
                array[i] = "-1";
            }
        }

        for (int i = 1; i < array.length; i++) {
        	if (searchText.compareTo(array[i]) == 0) {
                String tausch = array[i];
                array[i] = array[0];
                array[0] = tausch;
            }
        }

        for (int i = 0; i < array.length; i++) {
            int j = (i + 1);
            if (j < array.length) {
                while (array[i].equals(array[j])) {
                    array[j] = "-1";
                    j++;
                    if (j == array.length) {
                        break;
                    }
                }
                if (i != (j - 1)) {
                    for (int k = (i + 1); k < array.length; k++, j++) {
                        if (j < array.length) {
                            array[k] = array[j];
                        } else {
                            array[k] = "-1";
                        }
                    }
                }
            }
        }
        return array;
    }

    public void caretUpdate(CaretEvent e) {

        String searchText = blv.getSearch().getText().trim();
        if (!searchText.isEmpty()) {
            blv.getPanel().removeAll();

            String array[] = new String[listCard.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listCard.get(i).getName();
            }

            array = searchByString(array, blv.getSearch().getText());

            for (int i = 0, j = 1, k = 1; i < array.length; i++) {
                for (int n = 0; n < listCard.size(); n++) {
                    if (array[i].equals(listCard.get(n).getName())) {
                        addCardToPanel(i, n, j, k);

                        if (j == 7) {
                            k += 2;
                            j = -1;
                        }
                        j += 2;
                    }
                }
            }
            blv.getPanel().updateUI();
        } else {
            blv.getSort().setSelectedIndex(1);
        }
    }
}
