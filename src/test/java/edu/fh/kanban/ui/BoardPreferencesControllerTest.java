package edu.fh.kanban.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.fh.kanban.ui.controller.BoardPreferencesController;
import edu.fh.kanban.ui.view.BoardPreferencesView;

public class BoardPreferencesControllerTest {

	@Test
	//Test ob BoardPreferencesController "bpc" nur einmal aufgerufen wird
	public void testErweiterung() {
		BoardPreferencesView bpv = new BoardPreferencesView();
		BoardPreferencesController bpc = new BoardPreferencesController(bpv);
		bpc.erweiterung(); //Aufruf der Methode erweiterung aus der Klasse BoardPreferencesController, es wird erwartet, dass sich die Variable Arrayindex um 1 erhöht
		//Überprüfung, ob Arrayindex um 1 erhöht hat
		assertTrue("ungleich!!", 1==bpc.getArrayindex());
	}
}
