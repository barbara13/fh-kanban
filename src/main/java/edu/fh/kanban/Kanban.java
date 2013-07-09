//Test für Malte
package edu.fh.kanban;

import edu.fh.kanban.dao.XMLBoard;
import edu.fh.kanban.dao.XMLCard;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import edu.fh.kanban.ui.controller.BoardController;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardPreferencesView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.ui.view.CardView;
import edu.fh.kanban.ui.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Kanban {

	static Logger LOGGER = Logger.getLogger(Kanban.class.getName());
		/**
		 * @param args
		 */
        public static void main(String[] args) {
            //Verbindung mit der Datenbank aufbauen
            //DatabaseManager.createConnection();
            

            
            //card.deleteCard(19);
            
            XMLBoard board = new XMLBoard();
            board.loadXML("TestBoardfdf.xml");
            //board.forwardCard(ca_id);
            
            
            
            //board.loadXML("Board2.xml");
            //board.addCardToColumn(25, 17);
            //ArrayList  listColumn = board.readXML("Board2.xml");
            //terator it = listColumn.iterator();
            //System.out.println("ID: "+listColumn.get());
            
                    
                    
            
		LOGGER.info("Starting kanban app.");
		LOGGER.info("Setting look and feel.");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		LOGGER.info("Creating UI components.");
		
		JMenuItem board_preferences = new JMenuItem("Board Prenferences");
		board_preferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BoardPreferencesView().setVisible(true);
			}
		});
		
		JMenuItem card_preferences = new JMenuItem("New Card");
		card_preferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardCreateView().getComponent();
			}
		});
                
                JMenuItem loadBoard = new JMenuItem("Load Board");
                loadBoard.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                               FileFilter filter = new FileNameExtensionFilter("XMLDatei", "xml");
                               JFileChooser chooser = new JFileChooser();
                               chooser.addChoosableFileFilter(filter);
                               
                                  int x = chooser.showOpenDialog(null);
        
                                if(x == JFileChooser.APPROVE_OPTION)
                                {  
                                    //chooser.getSelectedFile().getName();
                                    BoardView boardView = new BoardView();
                                    BoardController bc = new BoardController(boardView);
                                    bc.createBoard(chooser.getSelectedFile().getName());
                                    
                                }
                            
			}
                });
		
		JMenu file = new JMenu("File");
		file.add(board_preferences);
		file.add(card_preferences);
                file.add(loadBoard);
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(file);
		
		View backlogView = new BacklogView();
		View boardView = new BoardView();
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Backlog", backlogView.getComponent());
		pane.addTab("Board", boardView.getComponent());
                                
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
        
        
}
