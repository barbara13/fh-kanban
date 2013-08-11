package edu.fh.kanban.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.fh.kanban.ui.view.CardCreateView;
import edu.fh.kanban.ui.view.CardEditView;

/**
 * 
 * @author Maxim
 *
 */

public class CardTest {
	
	private CardCreateView ccreate = new CardCreateView(null);
	private CardEditView cedit = new CardEditView(null, null, 0, 0, "Expedite", null);

	@Test
	public void testHeadline(){
		ccreate.getComponent().setVisible(false);
		
		ccreate.setTxtHeadline("TestHeadline");
		assertEquals("Test change Headline", "TestHeadline", ccreate.getTxtHeadline());
	}
	
	@Test
	public void testEffort(){
		ccreate.getComponent().setVisible(false);
		
		ccreate.setTxtEffort("30");
		assertEquals("Test change Effort", "30", ccreate.getTxtEffort());
	}
	
	@Test
	public void testValue(){
		ccreate.getComponent().setVisible(false);
		
		ccreate.setValue("Standart");
		assertEquals("Test change Value", "Standart", ccreate.getValue());
	}
	
	@Test
	public void testDescription(){
		ccreate.getComponent().setVisible(false);
		
		ccreate.setTextDescription("Beschreibung der Karte");
		assertEquals("Test change Description", "Beschreibung der Karte", ccreate.getTextDescription());
	}
	
	@Test
	public void testId(){
		cedit.getComponent().setVisible(false);
		
		cedit.setCId(20);
		assertTrue("Test change Card ID", 20 == cedit.getCId());
	}
}
