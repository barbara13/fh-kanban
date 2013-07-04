package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
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

	public CardView(){
		
		//Datenbank Tupel der Karte Laden und in Variablen Speichern
		super("HeadLine");	//Headline aus der DB laden
		getContentPane().setBackground(Color.YELLOW);	//Farbe aus der DB laden
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("47px"),
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
		
		getContentPane().add(new JLabel("CardID:"), "2, 2, right, top");
		
		JLabel lblCidfromdb = DefaultComponentFactory.getInstance().createLabel("cIDfromDB");
		getContentPane().add(lblCidfromdb, "4, 2, fill, top");
		
		JLabel lblAufwand = DefaultComponentFactory.getInstance().createLabel("Aufwand:");
		getContentPane().add(lblAufwand, "8, 2, right, top");
		
		JLabel lblAfromdb = DefaultComponentFactory.getInstance().createLabel("AfromDB");
		getContentPane().add(lblAfromdb, "10, 2, fill, top");
		
		JLabel lblWert = DefaultComponentFactory.getInstance().createLabel("Wert:");
		getContentPane().add(lblWert, "8, 4, right, top");
		
		JLabel lblWfromdb = DefaultComponentFactory.getInstance().createLabel("WfromDB");
		getContentPane().add(lblWfromdb, "10, 4, left, top");
		
		JLabel lblBeschreibung = DefaultComponentFactory.getInstance().createLabel("Beschreibung:");
		getContentPane().add(lblBeschreibung, "2, 6, 3, 1, left, top");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 8, 9, 1, fill, fill");
		
		JLabel lblBfromdb = DefaultComponentFactory.getInstance().createLabel("");
		scrollPane.setViewportView(lblBfromdb);
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "4, 10, default, top");
		
		JButton btnAddCard = new JButton("Add Card");
		getContentPane().add(btnAddCard, "6, 10, default, top");
		
		init();
	}
	
	private void init(){
		
	}

	public JComponent getComponent() {
		return (JComponent) getContentPane();
	}

}
