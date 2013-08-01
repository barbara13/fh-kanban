package edu.fh.kanban.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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

public class ExportToCsv {
	
    private String path;
    private XMLBoard xml;
    private ArrayList<Column> listSubColumns = new ArrayList<Column>();
    private ArrayList<Column> listMainColumns = new ArrayList<Column>();
    private ArrayList<Board> listBoard = new ArrayList<Board>();
    private ArrayList<Card> listCards = new ArrayList<Card>();
    
    public ExportToCsv(String path){
        xml = new XMLBoard();
    	this.path = path;
    	
    	try {
			createCsv(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void createCsv(String filename) throws DocumentException, IOException { 
    	BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
       
        xml.loadXML(Kanban.xmlPath);
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();
        
        String[][] line = {{listBoard.get(0).getName(), "1", "2", "3", "4", "5", "6", "7", "8", "9"},
        				  {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}};
        
        for(int col = 0; col < 2; col++){
        	for(int row = 0; row < 10; row++){
        		writer.append(line[col][row]);
        	}
        	writer.append("\n");
        }
        writer.close();
    }
}
