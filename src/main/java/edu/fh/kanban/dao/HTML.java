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
    //private Element subTableElement;
    private Element rowHeadElement;
    private Element rowElement;
    private Element colElement;
    private Element firstColumnElement;
    private Element lastColumnElement;
    private ArrayList <Element> columnElements = new ArrayList();
    private ArrayList <Element> rowElements = new ArrayList();
    private XMLBoard xml = new XMLBoard();
    
    
    private ArrayList <Element> trElement = new ArrayList();
    private ArrayList <Td> tdElement = new ArrayList();
    
    private Element[] tr;
    private Element[][] td;
    private int td_i = 0;
    
    private ArrayList <Element> subTableElement = new ArrayList();
    private ArrayList <Element> tdSubElement = new ArrayList();
    private ArrayList <Element> trSubElement = new ArrayList();
    
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
        
        //tr = new Element[listSubColumn.size()+2];
        //td = new Element[(listMainColumn.size()+2)*3 + listCard.size()][(listMainColumn.size()+2)*3 + listCard.size()];
        
        
        //Next Spalte
        trElement.add(createTrElement(mainTableElement));
        //tdElement.add(createTdElement(trElement.get(0), listSubColumn.get(0).getName().toString()));
        tdElement.add(new Td(createTdElement(trElement.get(0), listSubColumn.get(0).getName().toString()),listSubColumn.get(0).getCo_id()));

        
        //Main Spalten
        for(int i = 0; i < listMainColumn.size(); i++){
            //tdElement.add(createTdElement(trElement.get(0), listMainColumn.get(i).getName().toString()));
            tdElement.add(new Td(createTdElement(trElement.get(0), listMainColumn.get(i).getName().toString()), listMainColumn.get(i).getCo_id()));
        }
        
        
        trElement.add(createTrElement(mainTableElement));
        //Platzhalter für NextSpalte
        //tdElement.add(createTdElement(trElement.get(1), " "));
        tdElement.add(new Td(createTdElement(trElement.get(1), " "), 0));
                
        //Untertabelle Do und Done
        for(int j = 0; j < listMainColumn.size(); j++){
            //System.out.println("tttt");
            //Untertabelle
            //tdElement.add(createTdElement(trElement.get(1), " "));
            tdElement.add(new Td(createTdElement(trElement.get(1), " "), 0));
            subTableElement.add(createSubTable(tdElement.get(tdElement.size()-1).getTdElement()));
            trElement.add(createTrElement(subTableElement.get(j)));
            //tdElement.add(createTdElement(trElement.get(trElement.size()-1), "Do"));
            tdElement.add(new Td(createTdElement(trElement.get(trElement.size()-1), "Do"),listMainColumn.get(j).getCo_id()+1));
            //System.out.println(listMainColumn.get(j).getCo_id());
            
            //tdElement.add(createTdElement(trElement.get(trElement.size()-1), "Done"));   
            tdElement.add(new Td(createTdElement(trElement.get(trElement.size()-1), "Done"),listMainColumn.get(j).getCo_id()+2));
        }
        
        
        
        //Done Spalte
        //tdElement.add(createTdElement(trElement.get(0), listSubColumn.get(listSubColumn.size()-1).getName().toString()));
        tdElement.add(new Td(createTdElement(trElement.get(0), listSubColumn.get(listSubColumn.size()-1).getName().toString()),0));
        
        //Platzhalter
        //tdElement.add(createTdElement(trElement.get(trElement.size()-1), " "));
            
        for(int k = 0; k < listCard.size(); k++){
            int id = listCard.get(k).getCo_id();
            
            if(tdElement.get(k).getCo_id() == id){
                System.out.println("ELEMENT: " +tdElement.get(k).getTdElement().getTextContent());
                trElement.add(createTrElement(mainTableElement));
            }        
                  
        }
            
        
        //listBoard.get(0)


        this.updateXML("HTMLTEST.html");
    }

    private void loadXML() {
        xml.loadXML(Kanban.xmlPath);

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
        Element table;
        table = createTable();
        td.appendChild(table);

        return table;
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
    
    
    class Td{
        private Element tdElement;
        private int co_id;

        public Td(Element tdElement, int co_id) {
            this.tdElement = tdElement;
            this.co_id = co_id;
        }

        public Element getTdElement() {
            return tdElement;
        }

        public int getCo_id() {
            return co_id;
        }
        
        
    }
}
