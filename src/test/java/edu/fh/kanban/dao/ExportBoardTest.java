package edu.fh.kanban.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 
 * @author Barbara
 * Für PDF, CSV und HTML
 *
 */

public class ExportBoardTest {
	
	@Test
    public void testExportBoardPath(){
		String path = "Hier der Pfad";
    	ExportBoard expBoard = new ExportBoard();
    	expBoard.setPath(path);
    	
    	assertEquals("Test Pfad", path, expBoard.getPath());	
    }
}
