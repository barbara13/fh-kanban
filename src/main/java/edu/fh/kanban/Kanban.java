
/*<<<<<<< HEAD
package edu.fh.kanban;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.View;

public class Kanban {

	static Logger LOGGER = Logger.getLogger(Kanban.class.getName());
	
	/**
	 * @param args
	 */

/*
	public static void main(String[] args) {
		LOGGER.info("Starting kanban app.");
		
		LOGGER.info("Setting look and feel.");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		LOGGER.info("Creating UI components.");
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(new JMenu("File"));
		
		View backlogView = new BacklogView();
		View boardView = new BoardView();
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Backlog", backlogView.getComponent());
		pane.addTab("Boad", boardView.getComponent());
		
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

=======*/
package edu.fh.kanban;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import edu.fh.kanban.ui.dialog.Board_Preferences;
import edu.fh.kanban.ui.view.BacklogView;
import edu.fh.kanban.ui.view.BoardView;
import edu.fh.kanban.ui.view.View;

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
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem board_preferences = new JMenuItem("Board Prenferences");
		file.add(board_preferences);
		board_preferences.addActionListener(new Board_Preferences());
		JMenuItem card_preferences = new JMenuItem("Card Preferences");
		file.add(card_preferences);
		
		
		
		
		
		View backlogView = new BacklogView();
		View boardView = new BoardView();
		
		BoardView bv = new BoardView();
		
		bv.boardy();
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Backlog", backlogView.getComponent());
		pane.addTab("Boad", boardView.getComponent());
		
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
//>>>>>>> 54f3450e2ac8600e56ebaf1ce39262460486c810
