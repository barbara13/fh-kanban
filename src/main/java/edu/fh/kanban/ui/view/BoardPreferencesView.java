package edu.fh.kanban.ui.view;

import javax.swing.JFrame;

import java.awt.Rectangle;
import edu.fh.kanban.ui.controller.BoardPreferencesController;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * + Preferences dialog for colors, name of board, columns(10), wips(10) +
 * Validate on wip limits (10 Stück) + Edit dialog for card + Warn user if
 * modifications have not been saved
 *
 * @author Barbara
 *
 */
public class BoardPreferencesView extends JFrame implements View {	//Klasse BoardPreferencesView erbt von der JFrame

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel tglbtnRot, tglbtnGruen, tglbtnGelb, tglbtnBlau;
    private BoardPreferencesController c = null;
    private JButton btnSpeichern;
    private JButton btnAbbrechen;
    private BoardColor comboBoxStandart, comboBoxFixedDate, comboBoxExpedite, comboBoxIntangible;
   
    public JButton getBtnSpeichern() {			//Getter für den JButton "Speichern" wird erstellt
        return btnSpeichern;
    }

    public JButton getBtnAbbrechen() {			//Getter für den JButton "Abbrechen" wird erstellt
        return btnAbbrechen;
    }

    public JTextField getTxtName() {			//Getter JTextField für den Namen des Boardes wird erstellt
        return txtName;
    }

    public JPanel getPanel() {					//Getter für das JPanel wird erstellt
        return panel;
    }

    public BoardPreferencesView() {				//Konstruktor

        super("Board Einstellungen");
        c = new BoardPreferencesController(this); //Controller zum BoardPreferencesVontroller wird initialisiert

        setBounds(new Rectangle(0, 0, 700, 500));
        setLocationByPlatform(true);
        setResizable(false);
        
       // getComponent();// 
    }
    
    public JComponent getComponent() {
    	
        getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
        		FormFactory.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("97px"),
        		FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
        		ColumnSpec.decode("99px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("97px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("97px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("99px"),
        		FormFactory.UNRELATED_GAP_COLSPEC,
        		ColumnSpec.decode("138px"),},
        	new RowSpec[] {
        		FormFactory.RELATED_GAP_ROWSPEC,
        		RowSpec.decode("20px"),
        		FormFactory.RELATED_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.LINE_GAP_ROWSPEC,
        		RowSpec.decode("23px"),
        		RowSpec.decode("20px"),
        		FormFactory.PARAGRAPH_GAP_ROWSPEC,
        		RowSpec.decode("14px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("292px"),
        		FormFactory.UNRELATED_GAP_ROWSPEC,
        		RowSpec.decode("23px"),}));

        JLabel label = new JLabel("Name:");
        getContentPane().add(label, "2, 2, fill, center");

        txtName = new JTextField();
        getContentPane().add(txtName, "4, 2, 9, 1, fill, top");
        txtName.setColumns(10);

        JLabel label_1 = new JLabel("Color:");
        getContentPane().add(label_1, "2, 4, fill, top");

        JSeparator separator = new JSeparator();
        getContentPane().add(separator, "4, 4, 9, 1, fill, center");

        getContentPane().add(new JLabel("Standard"), "4, 6, center, fill");
        getContentPane().add(new JLabel("Expedite"), "6, 6, center, fill");
        getContentPane().add(new JLabel("Fixed date"), "10, 6, center, fill");
        getContentPane().add(new JLabel("Intangible"), "8, 6, center, fill");
        
        comboBoxStandart = new BoardColor();
        comboBoxStandart.setSelectedIndex(8);
        getContentPane().add(comboBoxStandart, "4, 7, fill, top");
        
        comboBoxFixedDate = new BoardColor();
        comboBoxFixedDate.setSelectedIndex(3);
        getContentPane().add(comboBoxFixedDate, "6, 7, fill, top");
        
        comboBoxExpedite = new BoardColor();
        comboBoxExpedite.setSelectedIndex(7);
        getContentPane().add(comboBoxExpedite, "8, 7, fill, top");
        
        comboBoxIntangible = new BoardColor();
        comboBoxIntangible.setSelectedIndex(0);
        getContentPane().add(comboBoxIntangible, "10, 7, fill, top");

        JLabel label_2 = new JLabel("Colums:");
        getContentPane().add(label_2, "2, 9, fill, top");

        JSeparator separator_1 = new JSeparator();
        getContentPane().add(separator_1, "4, 9, 9, 1, fill, bottom");

        scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, "2, 11, 11, 1, fill, top");

        panel = new JPanel();
        scrollPane.setColumnHeaderView(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[]{
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("44px"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("119px"),
            ColumnSpec.decode("28px"),
            ColumnSpec.decode("22px"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("44px"),
            ColumnSpec.decode("56px"),
            ColumnSpec.decode("69px"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("69px"),},
                new RowSpec[]{
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("23px"),}));

        c.erweiterung();						//Methode aus Controller c.erweiterung wird aufgerufen

        btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(c);

        getContentPane().add(btnSpeichern, "10, 13, fill, top");

        btnAbbrechen = new JButton("Abbrechen");
        btnAbbrechen.addActionListener(c);

        getContentPane().add(btnAbbrechen, "12, 13, left, top");

        setVisible(true);
        return (JComponent) getContentPane();
    }
}
