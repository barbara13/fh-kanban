package edu.fh.kanban.ui.view;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import edu.fh.kanban.ui.controller.CardCreateController;

/**
 * 
 * @author Maxim
 *
 *Die Klasse CardCreateView erstellt ein Fenster der Größe 700x500 mit JTextfield's die der Benutzer
 *ausfüllen MUSS die JTextArea KANN der Benutzer ausfüllen
 *Die Werte der JTextfield's werden über die Getter Methoden an den Controller übergeben
 */
public class CardCreateView extends JFrame implements View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardCreateController cController = null;	//Controller zur View
	
	private JTextField txtHeadline, txtEffort, txtValue;
	private TextArea textDescription;
	private JButton btnCancel, btnCreate;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private JToggleButton tglbtnRed, tglbtnYellow, tglbtnGreen, tglbtnBlue;
	
	public JTextField getTxtHeadline() {
		return txtHeadline;
	}

	public JTextField getTxtEffort() {
		return txtEffort;
	}

	public JTextField getTxtValue() {
		return txtValue;
	}

	public TextArea getTextDescription() {
		return textDescription;
	}
	
	public JButton getBtnCreate() {
		return btnCreate;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

    public JToggleButton getTglbtnRed() {
        return tglbtnRed;
    }

    public JToggleButton getTglbtnYellow() {
        return tglbtnYellow;
    }

    public JToggleButton getTglbtnGreen() {
        return tglbtnGreen;
    }

    public JToggleButton getTglbtnBlue() {
        return tglbtnBlue;
    }
	
    //Konstrukor
	public CardCreateView(){
		super("Create New Card");
		cController = new CardCreateController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 700, 500));
		setLocationByPlatform(true);
		setResizable(false);
	}

	//Methode aus der Klasse View initialsiert das Fenster und gibt getContentPane() zurück
	public JComponent getComponent() {
		//Das FormLayout aus jgoodies wird verwendet
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				//Spalten werden initialisiert
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("48px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("54px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("10px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				ColumnSpec.decode("80px"),
				ColumnSpec.decode("47px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("104px"),},
			new RowSpec[] {
				//Zeilen werden initialisiert
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("38px"),
				RowSpec.decode("14px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("210px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		getContentPane().add(new JLabel("Head Line:"), "1, 2, 3, 1, right, default");
		
		txtHeadline = new JTextField();
		getContentPane().add(txtHeadline, "4, 2, 7, 1, fill, default");
		txtHeadline.setColumns(10);
		
		getContentPane().add(new JLabel("effort:"), "16, 2, right, center");
		
		txtEffort = new JTextField();
		txtEffort.addKeyListener(cController);
		getContentPane().add(txtEffort, "18, 2, default, top");
		txtEffort.setColumns(10);
		
		getContentPane().add(new JLabel("Value:"), "16, 4, right, center");
		
		txtValue = new JTextField();
		txtValue.addKeyListener(cController);
		getContentPane().add(txtValue, "18, 4, default, top");
		txtValue.setColumns(10);
		
		getContentPane().add(new JLabel("Color:"), "2, 6, left, top");

		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 6, 15, 1");
                
		tglbtnRed = new JToggleButton("Expedite");
		tglbtnRed.setOpaque(true);
		tglbtnRed.setBackground(Color.RED);
        tglbtnRed.addActionListener(cController);
		buttonGroup.add(tglbtnRed);
		getContentPane().add(tglbtnRed, "4, 8, 5, 1, fill, top");
		
		tglbtnYellow = new JToggleButton("Standard");
		tglbtnYellow.setOpaque(true);
		tglbtnYellow.setBackground(Color.YELLOW);
        tglbtnYellow.addActionListener(cController);
		tglbtnYellow.doClick();
		buttonGroup.add(tglbtnYellow);
		getContentPane().add(tglbtnYellow, "10, 8, fill, top");
		
		tglbtnGreen = new JToggleButton("Fixed Date");
		tglbtnGreen.setOpaque(true);
		tglbtnGreen.setBackground(Color.GREEN);
        tglbtnGreen.addActionListener(cController);
		buttonGroup.add(tglbtnGreen);
		getContentPane().add(tglbtnGreen, "12, 8, fill, top");
		
		tglbtnBlue = new JToggleButton("Intangible");
		tglbtnBlue.setOpaque(true);
		tglbtnBlue.setBackground(Color.BLUE);
        tglbtnBlue.addActionListener(cController);
		buttonGroup.add(tglbtnBlue);
		getContentPane().add(tglbtnBlue, "14, 8, fill, top");
		
		getContentPane().add(new JLabel("Description:"), "2, 10, 5, 1, left, top");
		
		textDescription = new TextArea();
		getContentPane().add(textDescription, "2, 12, 17, 1, fill, fill");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(cController);
		getContentPane().add(btnCancel, "2, 14, 5, 1, fill, top");
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(cController);
		getContentPane().add(btnCreate, "8, 14, 4, 1, fill, top");
		
		setVisible(true);
		return (JComponent) getContentPane();
	}
}