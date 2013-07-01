package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class BacklogView implements View{
	private JTextField txtSuche;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][grow]", "[]"));
		
		txtSuche = new JTextField();
		txtSuche.setText("Suche");
		panel.add(txtSuche, "cell 11 0,growx");
		txtSuche.setColumns(10);
		return panel;
	}

	

}
