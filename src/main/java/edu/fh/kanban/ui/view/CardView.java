package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.fh.kanban.database.Card;
import edu.fh.kanban.database.DatabaseManager;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
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
	
	private int cID;
	private String color, effort, value, description;
	
	public CardView(String headline){
		super(headline);
		
		DatabaseManager.createConnection();
		Card c = new Card();
		cID = c.getId(headline);
		c.get
		
		setBounds(new Rectangle(0,0,455,300));
		setLocationByPlatform(true);
		getContentPane().setBackground(Color.YELLOW);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("51px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("32px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70px"),},
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
		
		JLabel label = new JLabel("CardID:");
		getContentPane().add(label, "2, 2, right, top");
		JLabel label_1 = new JLabel(cID);
		getContentPane().add(label_1, "4, 2, 3, 1, fill, top");
		JLabel label_2 = new JLabel("Effort:");
		getContentPane().add(label_2, "10, 2, left, top");
		JLabel label_3 = new JLabel(effort);
		getContentPane().add(label_3, "12, 2, fill, top");
		JLabel label_4 = new JLabel("Value:");
		getContentPane().add(label_4, "10, 4, right, top");
		JLabel label_5 = new JLabel(value);
		getContentPane().add(label_5, "12, 4, left, top");
		JLabel label_6 = new JLabel("Description");
		getContentPane().add(label_6, "2, 6, 3, 1, left, top");
		
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
		getContentPane().add(btnAddCard, "8, 10, fill, top");
		
		init();
		
		JButton btnEdit = new JButton("Edit");
		getContentPane().add(btnEdit, "6, 10, fill, top");
	}
	
	private JComponent init(){
		
		return (JComponent) getContentPane();
		
	}

	public JComponent getComponent() {
		return init();
	}
}
