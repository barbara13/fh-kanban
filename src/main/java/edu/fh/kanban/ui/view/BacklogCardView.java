package edu.fh.kanban.ui.view;

import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JSeparator;

/**
 *
 * @author David, Maxim
 */
public class BacklogCardView extends JPanel implements View {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BacklogCardView() {
        getComponent();
    }

    public JPanel getComponent() {
        setLayout(new FormLayout(new ColumnSpec[]{
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("min(50dlu;default)"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("default:grow"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("default:grow"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("default:grow"),
            FormFactory.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("50dlu"),
            FormFactory.RELATED_GAP_COLSPEC,
            FormFactory.DEFAULT_COLSPEC,},
                new RowSpec[]{
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("fill:default"),
            FormFactory.RELATED_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.RELATED_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("fill:default"),
            FormFactory.RELATED_GAP_ROWSPEC,
            RowSpec.decode("default:grow"),
            FormFactory.RELATED_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.RELATED_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,}));

        add(new JLabel("ID:"), "2, 2, right, default");
        add(new JLabel("HeadLine:"), "6, 2, right, default");
        add(new JLabel("Effort:"), "2, 4, right, default");
        add(new JLabel("Value:"), "6, 4, right, default");
        add(new JSeparator(), "2, 6, 10, 1");
        add(new JLabel("Created at:"), "2, 12");

        return this;
    }
}
