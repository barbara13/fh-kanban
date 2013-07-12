/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.ParserDelegator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 *
 * @author Ronald
 */
public class HTML extends XML {

    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    private String htmlPath;
    
    private ArrayList<Board> listBoard = new ArrayList();
    private ArrayList<Column> listMainColumn = new ArrayList();
    private ArrayList<Column> listSubColumn = new ArrayList();
    private ArrayList<Card> listCard = new ArrayList();
    
    private Element htmlTag;
    private Element bodyTag;
    private Element tableElement;
    private Element mainTableElement;
    private Element subTableElement;
    private Element rowHeadElement;
    private Element rowElement;
    private Element colElement;
    private Element firstColumnElement;
    private Element lastColumnElement;
    private ArrayList<Element> columnElements = new ArrayList();
    private ArrayList<Element> rowElements = new ArrayList();
    private XMLBoard xml = new XMLBoard();
    
    
    private Element trElement;
    private Element tdElement;
    private Attr attr;

    public HTML() {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HTML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createHTML() {
        //loadXML();
        
        htmlTag = doc.createElement("html");
        doc.appendChild(htmlTag);
        
        bodyTag = doc.createElement("body");
        htmlTag.appendChild(bodyTag);
        
        mainTableElement = createTable();
        bodyTag.appendChild(mainTableElement);
        
        loadXML();
        
        
        for(int i = 0; i < 10; i++){
            trElement = createTrElement(mainTableElement);
            
            for(int j = 0; j < listMainColumn.size(); j++){
                tdElement = createTdElement(trElement, listMainColumn.get(j).getName());
            }
            
        }
        
        //listBoard.get(0)


        this.updateXML("HTMLTEST.html");
    }

    private void loadXML() {
        xml.loadXML("Test123.xml");

        listBoard = xml.readBoard();
        listMainColumn = xml.readMainColumns();
        listSubColumn = xml.readSubColumns();
        listCard = xml.readCards();

    }

    private Element createTable() {
        Element table;
        table = doc.createElement("table");
        
        attr = doc.createAttribute("border");
        attr.setValue("1");
        table.setAttributeNode(attr);
        
        return table;
    }

    private Element createSubTable(Element td) {

        subTableElement = createTable();
        subTableElement.appendChild(td);

        return subTableElement;
        //rowElement = doc.createElement("tr");
        //colElement = doc.createElement("th");
    }

    private Element createTrElement(Element table) {
        rowElement = doc.createElement("tr");
        table.appendChild(rowElement);

        return rowElement;
    }

    private Element createThElement(Element tr) {
        rowHeadElement = doc.createElement("th");
        tr.appendChild(rowHeadElement);

        return rowHeadElement;
    }

    private Element createTdElement(Element tr, String name) {
        colElement = doc.createElement("td");
        tr.appendChild(colElement);
        colElement.setTextContent(name);
        return colElement;
    }
}
