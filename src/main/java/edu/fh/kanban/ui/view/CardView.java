package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.text.html.StyleSheet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private StyleSheet s = new StyleSheet();
	
	private int cID = 0001;
	private String color, effort, value, description;
	private String headline;
	
	private Color c = s.stringToColor(color);
	
	public CardView(final String headline){
		super(headline);
		setBounds(new Rectangle(0,0,455,300));
		setLocationByPlatform(true);
		getContentPane().setBackground(c);
		this.headline = headline;
		//Variablen init
	}
	
	private JComponent init(){
		
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("51px"),
				ColumnSpec.decode("6dlu"),
				ColumnSpec.decode("101px"),
				ColumnSpec.decode("6dlu"),
				ColumnSpec.decode("95px"),
				ColumnSpec.decode("6dlu"),
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
				RowSpec.decode("119px"),
				RowSpec.decode("31px"),
				RowSpec.decode("23px"),}));
		
		getContentPane().add(new JLabel("CardID:"), "2, 2, right, top");
		getContentPane().add(new JLabel(Integer.toString(cID)), "4, 2, 3, 1, left, top");
		getContentPane().add(new JLabel("Effort:"), "10, 2, left, top");
		getContentPane().add(new JLabel(effort), "12, 2, fill, top");
		getContentPane().add(new JLabel("Value:"), "10, 4, right, top");
		getContentPane().add(new JLabel(value), "12, 4, left, top");
		getContentPane().add(new JLabel("Description"), "2, 6, 3, 1, left, top");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 8, 11, 1, fill, fill");
		
		scrollPane.setViewportView(new JLabel(description));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnCancel, "2, 10, 3, 1, fill, top");
		
		JButton btnAddCard = new JButton("Add Card");
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Karte soll in den Board rein
			}
		});
		getContentPane().add(btnAddCard, "10, 10, 3, 1, fill, top");
		//If Karte bereits on Board soll der Button - btnAddCard.setvivible(false);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardEditView(headline, Integer.toString(cID), effort, value, description, c).getComponent();
				dispose();
			}
		});
		getContentPane().add(btnEdit, "8, 10, fill, top");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Karte Löoschen
			}
		});
		getContentPane().add(btnDelete, "6, 10, fill, top");
		
		setVisible(true);
		
		return (JComponent) getContentPane();
	}

	public JComponent getComponent() {
		return init();
	}
}
