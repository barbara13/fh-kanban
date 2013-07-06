package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.fh.kanban.ui.controller.CardController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.text.html.StyleSheet;

import java.awt.Color;

/**
 * 
 * @author Maxim
 *
 */
public class CardView extends JFrame implements View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardController cController = null;
	
	private StyleSheet s = new StyleSheet();
	private int cId;
	private String c, effort, value, description, headline, create, start, done;
	private JButton btnAddCard, btnEdit, btnDelete, btnCancel;
	
	private Color color = s.stringToColor(c);

	public int getcID() {
		return cId;
	}

	public Color getColor() {
		return color;
	}

	public String getEffort() {
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

	public String getC() {
		return c;
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

	public CardView(final String headline){
		super(headline);
		cController = new CardController(this);
		setBounds(new Rectangle(0,0,455,300));
		setLocationByPlatform(true);
		getContentPane().setBackground(color);
		this.headline = headline;
		
		//Variablen init here--------------------------------------------------------------------------
	}
	
	private JComponent init(){
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
			new RowSpec[] {
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
		getContentPane().add(new JLabel(effort), "12, 2, fill, top");
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
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(cController);
		getContentPane().add(btnCancel, "2, 14, 3, 1, fill, top");

		//If Karte bereits on Board soll der Button - btnAddCard.setvivible(false);
		btnAddCard = new JButton("Add Card");
		btnAddCard.addActionListener(cController);
		getContentPane().add(btnAddCard, "10, 14, 3, 1, fill, top");
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(cController);
		getContentPane().add(btnEdit, "8, 14, fill, top");
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(cController);
		getContentPane().add(btnDelete, "6, 14, fill, top");
		
		setVisible(true);
		
		return (JComponent) getContentPane();
	}

	public JComponent getComponent() {
		return init();
	}
}
