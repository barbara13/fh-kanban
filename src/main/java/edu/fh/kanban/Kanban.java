
package edu.fh.kanban;

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

<<<<<<< HEAD
import edu.fh.kanban.ui.dialog.Card_Create;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.BoardPreferencesView;
=======
import edu.fh.kanban.ui.dialog.Board_Preferences;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.CardCreateView;
>>>>>>> f2e9b688e96817e9baec4e08a3ad41d03bc2d123
import edu.fh.kanban.ui.view.View;
//import edu.fh.kanban.ui.view.Board;

public class Kanban {

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
		
		JMenuItem board_preferences = new JMenuItem("Board Prenferences");
		board_preferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Board_Preferences().setVisible(true);
			}
		});
		
		JMenuItem card_preferences = new JMenuItem("New Card");
		card_preferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardCreateView newCard = new CardCreateView();
				newCard.getComponent();
				newCard.setVisible(true);
			}
		});
		
		JMenu file = new JMenu("File");
		file.add(board_preferences);
		file.add(card_preferences);
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(file);
		
		
		View backlogView = new BacklogView();
		View boardView = new BoardView();
                
                //View board = new Board();
		
		BoardView bv = new BoardView();
		
		bv.boardy();
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Backlog", backlogView.getComponent());
		//pane.addTab("Board", board.getComponent());
		
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
