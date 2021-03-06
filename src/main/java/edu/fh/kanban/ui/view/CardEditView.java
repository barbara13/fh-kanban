package edu.fh.kanban.ui.view;

import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import edu.fh.kanban.ui.controller.CardEditController;

/**
 *
 * @author Maxim
 *
 * In der Klasse CardEditView kann man die Werte in den JTextfield's verändern
 */
public class CardEditView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CardEditController cController = null;
    private int cId;
    private JTextField txtHeadline, txtEffort;
    private TextArea textDescription;
    private JButton btnCancel, btnSave;
    private JComboBox<String> comboBoxValue;

    //Konstruktor
    public CardEditView(BacklogView blv, String headline, int cardId, int effort, String value, String description) {
        super("EDIT: \"" + headline + "\"");
        cController = new CardEditController(this, blv);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(new Rectangle(0, 0, 700, 500));
        setLocationByPlatform(true);
        setResizable(false);

        int index = 0;
        if (value.equals("Standard")) {
            index = 0;
        } else if (value.equals("Expedite")) {
            index = 1;
        } else if (value.equals("Fixed Date")) {
            index = 2;
        } else if (value.equals("Intangible")) {
            index = 3;
        }

        //Werte werden initilisiert
        this.cId = cardId;
        txtHeadline = new JTextField(headline);
        txtEffort = new JTextField(Integer.toString(effort));
        textDescription = new TextArea(description);
        comboBoxValue = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[]{"Standard", "Expedite", "Fixed Date", "Intangible"}));
        comboBoxValue.setSelectedIndex(index);
    }

    //Methode aus der Klasse View initialsiert das Fenster und gibt getContentPane() zurück
    public JComponent getComponent() {
        //Das FormLayout aus jgoodies wird verwendet
        getContentPane().setLayout(new FormLayout(new ColumnSpec[]{
                FormFactory.UNRELATED_GAP_COLSPEC,
                ColumnSpec.decode("100px"),
                FormFactory.UNRELATED_GAP_COLSPEC,
                ColumnSpec.decode("100px"),
                FormFactory.UNRELATED_GAP_COLSPEC,
                ColumnSpec.decode("230px"),
                FormFactory.UNRELATED_GAP_COLSPEC,
                ColumnSpec.decode("100px"),
                FormFactory.UNRELATED_GAP_COLSPEC,
                ColumnSpec.decode("100px"),},
                    new RowSpec[]{
                FormFactory.UNRELATED_GAP_ROWSPEC,
                RowSpec.decode("20px"),
                FormFactory.UNRELATED_GAP_ROWSPEC,
                RowSpec.decode("20px"),
                FormFactory.UNRELATED_GAP_ROWSPEC,
                RowSpec.decode("fill:20dlu"),
                FormFactory.RELATED_GAP_ROWSPEC,
                RowSpec.decode("20px"),
                FormFactory.UNRELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"),
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,}));
        
        getContentPane().add(new JLabel("Head Line:"), "2, 2, right, default");
        getContentPane().add(txtHeadline, "4, 2, 3, 1, fill, default");

        getContentPane().add(new JLabel("Effort:"), "8, 2, right, center");
        
        txtEffort.addKeyListener(cController);
        getContentPane().add(txtEffort, "10, 2, default, top");

        getContentPane().add(new JLabel("Value:"), "8, 4, right, center");
        getContentPane().add(comboBoxValue, "10, 4, fill, default");

        getContentPane().add(new JLabel("Description:"), "2, 8, default, bottom");
        getContentPane().add(textDescription, "2, 10, 9, 1, fill, fill");

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(cController);
        getContentPane().add(btnCancel, "2, 13, fill, top");

        btnSave = new JButton("Save");
        btnSave.addActionListener(cController);
        getContentPane().add(btnSave, "4, 13, fill, top");

        setVisible(true);
        return (JComponent) getContentPane();
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getTxtHeadline() {
        return txtHeadline.getText().toString();
    }

    public String getTxtEffort() {
        return txtEffort.getText().toString();
    }

    public String getValue() {
        return comboBoxValue.getSelectedItem().toString();
    }

    public String getTextDescription() {
        return textDescription.getText().toString();
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnSave() {
        return btnSave;
    }
}
