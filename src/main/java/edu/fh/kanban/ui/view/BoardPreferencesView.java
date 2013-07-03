package edu.fh.kanban.ui.view;

import javax.swing.JFrame;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

/**
 * 
 * @author Babsi
 *
 */
public class BoardPreferencesView extends JFrame implements View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JScrollPane scrollPane;
	
	private int i=2;
	private JTextField txtColumname;

	public BoardPreferencesView(){
		super("Board Preferences");
		setBounds(new Rectangle(0, 0, 700, 500));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("44px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("119px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("125px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("31px"),
				RowSpec.decode("14px"),
				RowSpec.decode("31px"),
				RowSpec.decode("23px"),
				RowSpec.decode("31px"),
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("213px:grow"),
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name: ");
		getContentPane().add(lblName, "2, 2, left, center");
		
		txtName = new JTextField();
		txtName.setText("");
		getContentPane().add(txtName, "4, 2, fill, top");
		txtName.setColumns(10);
		
		JLabel lblColors = DefaultComponentFactory.getInstance().createLabel("Colors: ");
		getContentPane().add(lblColors, "2, 4, fill, top");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "4, 4, 11, 1, fill, center");
		
		JToggleButton tglbtnRot = new JToggleButton("Rot");
		
		buttonGroup.add(tglbtnRot);
		getContentPane().add(tglbtnRot, "4, 6, fill, top");
		
		JToggleButton tglbtnGelb = new JToggleButton("Gelb");
		buttonGroup.add(tglbtnGelb);
		getContentPane().add(tglbtnGelb, "6, 6, fill, top");
		
		JToggleButton tglbtnGruen = new JToggleButton("Gruen");
		buttonGroup.add(tglbtnGruen);
		getContentPane().add(tglbtnGruen, "8, 6, fill, top");
		
		JToggleButton tglbtnBlau = new JToggleButton("Blau");
		buttonGroup.add(tglbtnBlau);
		getContentPane().add(tglbtnBlau, "10, 6, fill, top");
		
		JLabel lblColums = DefaultComponentFactory.getInstance().createLabel("Colums: ");
		getContentPane().add(lblColums, "2, 8, fill, top");
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "4, 8, 11, 1, fill, center");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 10, 13, 1, fill, fill");
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
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
			new RowSpec[] {
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
		
		ColumsPanel();
		
		JButton btnSpeichern = new JButton("Speichern");
		getContentPane().add(btnSpeichern, "12, 12, fill, top");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		getContentPane().add(btnAbbrechen, "14, 12, fill, top");	
	}

	public JComponent getComponent() {
		return null;
	}
	
	private void ColumsPanel(){
		
		System.out.println("i = " + i);
		
		Erweiterung(i);
		i+=2;
		
//		for(int u=0; i<5; u++){
//			Erweiterung(getI());
//			setI();
//			panel.repaint();
//		}	
	}
	private void Erweiterung(int i){
		
//		JLabel lblName_1 = DefaultComponentFactory.getInstance().createLabel("Name:");
		panel.add(new JLabel("Name:"), "2, "+i+", fill, center");
		
		txtColumname = new JTextField();
		panel.add(txtColumname, "4, "+i+", fill, center");
		txtColumname.setColumns(10);
		
		JLabel lblWip = new JLabel("Wip:");
		panel.add(lblWip, "5, 2, 2, 1, right, center");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		panel.add(spinner, "8, "+i+", fill, center");
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getI() < 21){
					Erweiterung(getI());
					incI();
					panel.updateUI();
				}else System.out.println("I zu gross");
			}
		});
		panel.add(btnPlus, "10, "+i+", fill, top");
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(get)
			}
		});
		panel.add(btnMinus, "12, "+i+", fill, top");
			
	}
	
	private void Loeschung(){
		

		
	}
	
	public int getI(){
		return this.i;
	}
	public void incI(){
		this.i += 2;
	}
	public void decI(){
		this.i -= 2;
	}
}