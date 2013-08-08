package edu.fh.kanban.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import edu.fh.kanban.data.Card;

public class ExportBacklogToPdf {
	private XMLCard xml;
    private ArrayList<Card> card = new ArrayList<Card>();
    private PdfPTable table;
    
    public ExportBacklogToPdf(String path){
    	xml = new XMLCard();
        card = xml.readCards();
    	
    	try {
			createPdf(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void createPdf(String filename) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        table = new PdfPTable(6);
        
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont();
        
        cb.beginText();
        cb.setFontAndSize(bf, 12);
        cb.moveText(20, 815);
        cb.showText("Backlog");
        
        table.addCell("CardID");
        table.addCell("Headline");
        table.addCell("Effort");
        table.addCell("Value");
        table.addCell("Description");
        table.addCell("Created");
    	
        for(int i = 0; i < card.size(); i++){
        	table.addCell(Integer.toString(card.get(i).getCa_id()));
            table.addCell(card.get(i).getName());
            table.addCell(Integer.toString(card.get(i).getEffort()));
            table.addCell(card.get(i).getValue());
            table.addCell(card.get(i).getDescription());
            table.addCell(card.get(i).getCreatedDate());
        }
        cb.endText();

        document.add(table);
        document.close();
    }
}

