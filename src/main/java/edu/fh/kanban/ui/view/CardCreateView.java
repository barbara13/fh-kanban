package edu.fh.kanban.ui.view;

import java.awt.TextArea;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import edu.fh.kanban.ui.controller.CardCreateController;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Maxim
 *
 * Die Klasse CardCreateView erstellt ein Fenster der Größe 700x500 mit
 * JTextfield's die der Benutzer ausfüllen MUSS die JTextArea KANN der Benutzer
 * ausfüllen Die Werte der JTextfield's werden über die Getter Methoden an den
 * Controller übergeben
 */
public class CardCreateView extends JFrame implements View {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CardCreateController cController = null; // Controller zur View
    // private BacklogView bv;
    private JTextField txtHeadline, txtEffort;
    private TextArea textDescription;
    private JButton btnCancel, btnCreate;
    private JComboBox<String> comboBoxValue;

    // Konstrukor
    public CardCreateView(BacklogView bv) {
        super("Create New Card");

        cController = new CardCreateController(this, bv);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(new Rectangle(0, 0, 700, 500));
        setLocationByPlatform(true);
        setResizable(false);
    }

    // Methode aus der Klasse View initialsiert das Fenster und gibt
    // getContentPane() zurück
    public JComponent getComponent() {
        // Das FormLayout aus jgoodies wird verwendet
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

        txtHeadline = new JTextField();
        getContentPane().add(txtHeadline, "4, 2, 3, 1, fill, default");

        getContentPane().add(new JLabel("Effort:"), "8, 2, right, center");

        txtEffort = new JTextField();
        txtEffort.addKeyListener(cController);
        getContentPane().add(txtEffort, "10, 2, default, top");

        getContentPane().add(new JLabel("Value:"), "8, 4, right, center");

        comboBoxValue = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[]{"Standard", "Expedite", "Fixed Date", "Intangible"}));
        getContentPane().add(comboBoxValue, "10, 4, fill, default");

        getContentPane().add(new JLabel("Description:"), "2, 8, default, bottom");

        textDescription = new TextArea();
        getContentPane().add(textDescription, "2, 10, 9, 1, fill, fill");

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(cController);
        getContentPane().add(btnCancel, "2, 13, fill, top");

        btnCreate = new JButton("Create");
        btnCreate.addActionListener(cController);
        getContentPane().add(btnCreate, "4, 13, fill, top");

        setVisible(true);
        return (JComponent) getContentPane();
    }

    public String getTxtHeadline() {
        return txtHeadline.getText().toString();
    }

    public void setTxtHeadline(String headline) {
        txtHeadline.setText(headline);
    }

    public String getTxtEffort() {
        return txtEffort.getText().toString();
    }

    public void setTxtEffort(String effort) {
        txtEffort.setText(effort);
    }

    public String getValue() {
        return comboBoxValue.getSelectedItem().toString();
    }

    public void setValue(String value) {
        comboBoxValue.addItem(value);
        comboBoxValue.setSelectedItem(value);
    }

    public String getTextDescription() {
        return textDescription.getText().toString();
    }

    public void setTextDescription(String description) {
        textDescription.setText(description);
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }
}