package edu.fh.kanban.domain;

import static org.junit.Assert.*;

import javax.swing.JToggleButton;

import org.junit.Test;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.ui.view.CardEditView;
import edu.fh.kanban.ui.view.CardView;

/**
 * 
 * @author Maxim
 *
 */

public class CardTest {
	
	private CardCreateView ccreate;
	private CardEditView cedit;
	private CardView cview;

	@Test
	public void testHeadline(){
		ccreate.setTxtHeadline("TestHeadline");
		assertEquals("Test change Headline", "TestHeadline", ccreate.getTxtHeadline());
	}
	
	@Test
	public void testEffort(){
		ccreate.setTxtEffort("30");
		assertEquals("Test change Effort", "30", ccreate.getTxtEffort());
	}
	
	@Test
	public void testValue(){
		ccreate.setValue("Standart");
		assertEquals("Test change Value", "Standart", ccreate.getValue());
	}
	
	@Test
	public void testDescription(){
		ccreate.setTextDescription("Beschreibung der Karte");
		assertEquals("Test change Description", "Beschreibung der Karte", ccreate.getTextDescription());
	}
	
	@Test
	public void testId(){
		cedit.setCId(20);
		assertEquals("Test change Card ID", "20", cedit.getCId());
	}
	
	@Test
	public void testBlocker(){
		JToggleButton blocker = cview.getTglbtnBlocker();
		blocker.doClick();
		assertTrue("is Blocker pressed", blocker.isSelected() == true);
	}
}
