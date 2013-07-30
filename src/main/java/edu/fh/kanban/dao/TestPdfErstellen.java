package edu.fh.kanban.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import edu.fh.kanban.ui.view.BoardView;

public class TestPdfErstellen {
	
	    private String path;
	    private XMLBoard xml;
	    private ArrayList<Column> listSubColumns = new ArrayList<Column>();
	    private ArrayList<Column> listMainColumns = new ArrayList<Column>();
	    private ArrayList<Board> listBoard = new ArrayList<Board>();
	    private ArrayList<Card> listCards = new ArrayList<Card>();
	    
	    public TestPdfErstellen(String path){
	        xml = new XMLBoard();
	    	this.path = path;
	    	
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
	        
	        int i = 0;
	        xml.loadXML(Kanban.xmlPath);
	        listBoard = xml.readBoard();
	        listMainColumns = xml.readMainColumns();
	        listSubColumns = xml.readSubColumns();
	        
	        document.open();

	        PdfContentByte cb = writer.getDirectContent();
	        BaseFont bf = BaseFont.createFont();
	        
	        cb.beginText();
	        cb.setFontAndSize(bf, 12);
	        cb.moveText(20, 800);
	        cb.showText(listBoard.get(i).getName());
	        
	        cb.moveText(0, -12);
//	        cb.setCharacterSpacing(2);
//	        cb.setWordSpacing(12);
//	        cb.showText("Erst recht auch jeden kleineren.");
	        cb.endText();

	        document.close();

	    }

//	    private void setImage(PdfContentByte cb, String imgPath, float scalePercent) throws MalformedURLException, IOException, DocumentException {
//	        Image img = Image.getInstance(imgPath);
//	        img.scalePercent(scalePercent);
//	        img.setAbsolutePosition(cb.getXTLM(), cb.getYTLM());
//	        cb.addImage(img);
//	    }

//	    private void printMeasures(){
//	        System.out.println("A4-Ma\u00DFe: " + PageSize.A4.getWidth() + "pt x "
//	                + PageSize.A4.getHeight() + "pt - "
//	                + (PageSize.A4.getWidth() * 0.3527) + "mm x "
//	                + (PageSize.A4.getHeight() * 0.3527) + "mm");
//	    } 

}
