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
import org.w3c.dom.Element;

public class Kanban {

	static Logger LOGGER = Logger.getLogger(Kanban.class.getName());
		/**
		 * @param args
		 */
        public static void main(String[] args) {    
    
            XMLBoard board = new XMLBoard();
            XMLCard card = new XMLCard();
            
            /*
            card.addCard("Card", "fff", "2", "3", "Fixed");
            card.addCard("Card2", "fff", "2", "3", "Fixed");
            card.addCard("Card3", "fff", "2", "3", "Fixed");
            */
            
            /*
            board.addBoard("test2", "d");
            board.addNewColumn("test", "d");
            board.addNewColumn("Hallo", "3");
            board.createBoard("board5.xml");
            */
            
            board.loadXML("board5.xml");
            //board.addCardToBoard(46);
            //board.addCardToBoard(42);
            //board.forwardCard(43);
            
            //board.createNewBoard();
            //Element el = board.searchCard(29);
            //System.out.println(el.g));
            //board.forwardCard(29);
            //ArrayList list = board.readBoard();
            
            
            //board.forwardCard(22);
            //board.addBoard("test", "Red");
            //board.addNewColumn("Penis", "2");
            //board.addColumn("ddd", "f");
            //board.createBoard();
                    
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
