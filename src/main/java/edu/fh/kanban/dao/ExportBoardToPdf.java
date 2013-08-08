package edu.fh.kanban.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;

public class ExportBoardToPdf {
	
    private XMLBoard xml;
    private ArrayList<Column> listSubColumns = new ArrayList<Column>();
    private ArrayList<Column> listMainColumns = new ArrayList<Column>();
    private ArrayList<Board> listBoard = new ArrayList<Board>();
    private ArrayList<Card> listCards = new ArrayList<Card>();
    
    private PdfPTable table;
    
    public ExportBoardToPdf(String path){
        xml = new XMLBoard();
    	
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
       // PrintWriter pdfwriter = new PrintWriter(writer);
        
        
        xml.loadXML(Kanban.xmlPath);
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
        table = new PdfPTable(listSubColumns.size());
        
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont();
        
        cb.beginText();
        cb.setFontAndSize(bf, 12);
        cb.moveText(20, 815);
        cb.showText(listBoard.get(0).getName());
        int spalten = ((listSubColumns.size() - 2) / 2);
        
    	table.addCell("");
    	for(int i = 0; i < spalten; i++){
    		PdfPCell cell = new PdfPCell(new Paragraph(listMainColumns.get(i).getName().toString()));
    		cell.setColspan(2);
    		table.addCell(cell);
    	}
    	table.addCell("");
    	for(int i = 0; i < listSubColumns.size(); i++){
    		table.addCell(listSubColumns.get(i).getName().toString());
    	}
    	
        for(int k = 0; k < 10; k++){
        	for(int i = 0; i < listSubColumns.size(); i++){
                listCards = xml.readCardsFromColumn(listSubColumns.get(i).getCo_id());
	                if(k < listCards.size()){
	                	System.out.println(listCards.get(k).getCa_id() + "K= " + k);
	              	    table.addCell("CardID: " + Integer.toString(listCards.get(k).getCa_id()) + " Effort: " + Integer.toString(listCards.get(k).getEffort()) + " Value: " + listCards.get(k).getValue().toString() + " Description: " + listCards.get(k).getDescription().toString());
	                }else{
	                	table.addCell("");
	                }
              }
        }
        cb.endText();
        document.add(table);
        document.close();
    }
}
