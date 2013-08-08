package edu.fh.kanban.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JToggleButton;

import org.junit.Test;

import edu.fh.kanban.data.Card;
import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;

/**
 * 
 * @author Maxim
 *
 */

public class CardTest {
	
	private ArrayList<Card> listCards = new ArrayList<Card>();
	
	private CardCreateView ccreate = new CardCreateView(null);
	private CardEditView cedit = new CardEditView(null, null, 0, 0, "Expedite", null);
	private CardView cview = new CardView(0, listCards, null, null);

	@Test
	public void testHeadline(){
		ccreate.getComponent();
		
		ccreate.setTxtHeadline("TestHeadline");
		assertEquals("Test change Headline", "TestHeadline", ccreate.getTxtHeadline());
	}
	
	@Test
	public void testEffort(){
		ccreate.getComponent();
		
		ccreate.setTxtEffort("30");
		assertEquals("Test change Effort", "30", ccreate.getTxtEffort());
	}
	
	@Test
	public void testValue(){
		ccreate.getComponent();
		
		ccreate.setValue("Standart");
		assertEquals("Test change Value", "Standart", ccreate.getValue());
	}
	
	@Test
	public void testDescription(){
		ccreate.getComponent();
		
		ccreate.setTextDescription("Beschreibung der Karte");
		assertEquals("Test change Description", "Beschreibung der Karte", ccreate.getTextDescription());
	}
	
	@Test
	public void testId(){
		cedit.getComponent();
		
		cedit.setCId(20);
		assertTrue("Test change Card ID", 20 == cedit.getCId());
	}
	
	@Test
	public void testBlocker(){
		cview.getComponent();
		
		JToggleButton blocker = cview.getTglbtnBlocker();
		blocker.doClick();
		assertTrue("is Blocker pressed", blocker.isSelected() == true);
	}
}
