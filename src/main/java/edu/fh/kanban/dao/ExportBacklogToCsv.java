package edu.fh.kanban.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import edu.fh.kanban.data.Card;

public class ExportBacklogToCsv {
	private XMLCard xml;
    private ArrayList<Card> card = new ArrayList<Card>();
    
    public ExportBacklogToCsv(String path){
        xml = new XMLCard();
        card = xml.readCards();
    	
    	try {
			createCsv(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void createCsv(String filename) throws DocumentException, IOException {
    	 FileWriter fw = new FileWriter(filename);
    	 PrintWriter writer = new PrintWriter(fw);
        
        writer.print("Backlog\n");
        writer.print("CardID;Headline;Effort;Value;Description;Created\n");
        
        for(int i = 0; i < card.size(); i++){
        	writer.print(card.get(i).getCa_id() + ";" + 
        				card.get(i).getName() + ";" + 
        				card.get(i).getEffort() + ";" + 
        				card.get(i).getValue() + ";" + 
        				card.get(i).getDescription() + ";" + 
        				card.get(i).getCreatedDate() + "\n");
        }
        writer.flush();
        fw.close();
        writer.close();
        }
    
}
