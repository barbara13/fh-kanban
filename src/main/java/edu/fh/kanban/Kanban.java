package edu.fh.kanban;

import edu.fh.kanban.dao.ExportBacklog;
import edu.fh.kanban.dao.ExportBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardPreferencesView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardCreateView;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Kanban {

    private static JFileChooser chooser;
    private static JTabbedPane pane;
    private static boolean firstBoard = true;
    public static String xmlPath = null;
    public static String xmlName = null;
    
    public JTabbedPane getPane() {
        return pane;
    }

    public JFileChooser getChooser() {
        return chooser;
    }
    static Logger LOGGER = Logger.getLogger(Kanban.class.getName());

    /**
     * @param args
     */
    public static void main(String[] args) {
    	
        LOGGER.info("Starting kanban app.");
        LOGGER.info("Setting look and feel.");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Creating UI components.");
        
        final BacklogView backlogView = new BacklogView();

        JMenuItem board_preferences = new JMenuItem("New Board...");
        board_preferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BoardPreferencesView().getComponent();
            }
        });
        
        JMenuItem card_preferences = new JMenuItem("New Card...");
        card_preferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CardCreateView(backlogView).getComponent();
            }
        });
        
        JMenuItem exportBacklog = new JMenuItem("Export Backlog to...");
        exportBacklog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExportBacklog();
			}
		}); 
        
        final JMenuItem exportBoard = new JMenuItem("Export Board to...");
        exportBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExportBoard();
				
			}
		});

        JMenuItem loadBoard = new JMenuItem("Load Board...");
        loadBoard.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser();
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("XMLDatei", "xml"));
                
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    xmlName = chooser.getSelectedFile().getName();
                    xmlPath = chooser.getSelectedFile().getPath();
                    xmlPath = xmlPath.replaceAll("\\\\", "\\\\\\\\");
                    BoardView boardView = new BoardView(backlogView);
                    
                    if (firstBoard == true) {
                        JScrollPane scrollpane = new JScrollPane();
                        scrollpane.setViewportView(boardView);
                        pane.addTab("Board: " + chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().lastIndexOf(46)), scrollpane);
                        firstBoard = false;
                        exportBoard.setEnabled(true);
                    } else if (firstBoard == false) {
                        JScrollPane scrollpane = new JScrollPane();
                        scrollpane.setViewportView(boardView);
                        pane.addTab("Board: " + chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().lastIndexOf(46)), scrollpane);
                        pane.removeTabAt(1);
                    }
                }
            }
        });

        JMenu file = new JMenu("File");
        file.add(board_preferences);
        file.add(card_preferences);
        file.add(loadBoard);
        file.add(exportBacklog);
        file.add(exportBoard);
        exportBoard.setEnabled(false);

        JMenuBar menubar = new JMenuBar();
        menubar.add(file);

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewportView(backlogView);
        
        pane = new JTabbedPane();
        pane.addTab("Backlog", scrollpane);

        JFrame frame = new JFrame();
        frame.setJMenuBar(menubar);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Teamproject 2013 - Kanban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationByPlatform(true);
        frame.add(pane);
        frame.setVisible(true);
    }

    public static Integer tryParseInt(String text) {
        try {
            return new Integer(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
