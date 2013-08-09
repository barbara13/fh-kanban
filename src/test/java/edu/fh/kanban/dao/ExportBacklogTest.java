package edu.fh.kanban.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 
 * @author Maxim
 * Für CSV und PDF
 *
 */


public class ExportBacklogTest {
	
	@Test
	public void ExportBacklogTestPath(){
		String path = "Hier der Pfad";
		ExportBacklog expbacklog = new ExportBacklog();
		expbacklog.setPath(path);
		
		assertEquals("Test Pfad", path, expbacklog.getPath());
	}

}
