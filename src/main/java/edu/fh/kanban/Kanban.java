package edu.fh.kanban;

import edu.fh.kanban.dao.HTML;
import edu.fh.kanban.dao.Export;

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
import javax.swing.filechooser.FileFilter;
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

        JMenuItem board_preferences = new JMenuItem("New Board...");
        board_preferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BoardPreferencesView().getComponent();
            }
        });
        
        final JMenuItem html = new JMenuItem("Export to HTML...");
        html.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HTML().createHTML();
            }
        });
        
        //Klasse SaveAll
        final JMenuItem saveAs = new JMenuItem("Export to...");
        saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Export();
				
			}
		});
             
        final BacklogView backlogView = new BacklogView();
        BoardView boardView = new BoardView(backlogView);
        backlogView.setBv(boardView);
        
                
        JMenuItem card_preferences = new JMenuItem("New Card...");
        card_preferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CardCreateView(backlogView).getComponent();
            }
        });

        JMenuItem loadBoard = new JMenuItem("Load Board...");
        loadBoard.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                FileFilter filter = new FileNameExtensionFilter("XMLDatei", "xml");
                chooser = new JFileChooser();
                chooser.addChoosableFileFilter(filter);
                BoardView boardView = new BoardView(backlogView);
                backlogView.setBv(boardView);
                int x = chooser.showOpenDialog(null);

                if (x == JFileChooser.APPROVE_OPTION) {
                    xmlName = chooser.getSelectedFile().getName();
                    xmlPath = chooser.getSelectedFile().getPath();
                    xmlPath = xmlPath.replaceAll("\\\\", "\\\\\\\\");
                    //boardView.getComponent();
                    if (firstBoard == true) {
                        pane.addTab("Board: " + chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().lastIndexOf(46)), boardView.getComponent());
                        firstBoard = false;
                        html.setEnabled(true);
                        saveAs.setEnabled(true);
                      //  try{
                      //  for(int i = 0; backlogView.getAddcards()[i].getText().toString() != "0"; i++){
                      //  backlogView.getAddcards()[i].setEnabled(true);
                      //  }
                      //  }
                      //  catch(java.lang.NullPointerException exc){
                       //     return;
                       // }
                    } else if (firstBoard == false) {
                        pane.addTab("Board: " + chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().lastIndexOf(46)), boardView.getComponent());
                        pane.removeTabAt(1);
                        
                    }
                }

            }
        });

        JMenu file = new JMenu("File");
        file.add(board_preferences);
        file.add(card_preferences);
        file.add(loadBoard);
        file.add(html);
        file.add(saveAs);
        html.setEnabled(false);
        saveAs.setEnabled(false);

        JMenuBar menubar = new JMenuBar();
        menubar.add(file);


        pane = new JTabbedPane();
        pane.addTab("Backlog", backlogView.getComponent());
        //pane.addTab("Board", boardView.getComponent());

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
