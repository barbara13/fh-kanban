package edu.fh.kanban.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
*
* @author Lorenz
*/

public class CSV {						//Kleiner Test
	
	public CSV() throws IOException{
	 //Note the "\\" used in the path of the file 
    //instead of "\", this is required to read 
    //the path in the String format.
    FileWriter fw = new FileWriter("/Users/Ghost/Documents/test2.csv");	// Ausgabepfad
    PrintWriter pw = new PrintWriter(fw);
    
    pw.println("Test");			//In Datei schreiben, erste Zeile
    
    pw.print("Test2");			//In Datei schreiben, zweite Zeile
  
    pw.flush();					//Flush the output to the file
    
    pw.close();					//Print Writer schließen
    
    fw.close();    				//File Writer schließen
	}
}
