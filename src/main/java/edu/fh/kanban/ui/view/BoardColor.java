package edu.fh.kanban.ui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class BoardColor extends JComboBox<Object>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Icon[] COLOR_ICONS;
    public final String LABELS[] = {
        "BLUE","CYAN","GRAY","GREEN","MAGENTA","ORANGE","PINK","RED","YELLOW"
    };
    public final Color COLORS[] = {
        Color.BLUE,Color.CYAN,Color.GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW
    };
    public BoardColor(){
        super();
        //Load the COLOR_ICONS and create an array of indexes:
        COLOR_ICONS = new Icon[LABELS.length];
        final Integer[] INT_ARRAY = new Integer[LABELS.length];
        for (int i = 0; i < LABELS.length; i++) {
            INT_ARRAY[i] = new Integer(i);
            COLOR_ICONS[i] = new ColorIcon(COLORS[i], new Dimension(100, 20));
        }
        setModel(new DefaultComboBoxModel<Object>(INT_ARRAY));
        setRenderer(new ComboBoxRenderer());
    }
    class ComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ComboBoxRenderer() {setOpaque(true);}
        public Component getListCellRendererComponent(
                final JList<?> list, final Object value, final int index,
                final boolean isSelected, final boolean cellHasFocus) {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }
            //Set the icon and text:
            int selectedIndex = ((Integer)value).intValue();
            setIcon(COLOR_ICONS[selectedIndex]);
            setText(LABELS[selectedIndex]);
            return this;
        }
    }
    
    class ColorIcon implements Icon {
        final private Color color;
        final private Dimension size;
        public ColorIcon(final Color color, final Dimension size) {
            this.color = color;
            this.size = size;
        }
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            g.setColor(color);
            g.fillRect(x, y, getIconWidth(), getIconHeight());
        }
        public int getIconWidth() {return size.width;}
        public int getIconHeight() {return size.height;}
    }
}
