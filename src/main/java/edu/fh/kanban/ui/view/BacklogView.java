package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

public class BacklogView implements View{
	private JTextField txtSuche_1;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(62dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(121dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(90dlu;pref):grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		txtSuche_1 = new JTextField();
		txtSuche_1.setText("Suche");
		panel.add(txtSuche_1, "5, 3, fill, default");
		txtSuche_1.setColumns(10);
		return panel;
	}

	

}
