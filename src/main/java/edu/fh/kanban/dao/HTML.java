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
    private Element cardElement;
    private ArrayList <Element> columnElements = new ArrayList();
    private ArrayList <Element> rowElements = new ArrayList();
    private XMLBoard xml = new XMLBoard();
    
    
    
    private ArrayList <Element> tdElement = new ArrayList();
    private ArrayList <Element> trElement = new ArrayList();
    
    private ArrayList <Element> tdElementSkip = new ArrayList();
    private ArrayList <Element> trElementSkip = new ArrayList();
    
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
        
        htmlTag = doc.createElement("html");
        doc.appendChild(htmlTag);
        
        bodyTag = doc.createElement("body");
        htmlTag.appendChild(bodyTag);
        
        mainTableElement = createTable();
        bodyTag.appendChild(mainTableElement);
        
        loadXML();
             
        
        //Next Spalte
        trElementSkip.add(createTrElement(mainTableElement));
        //tdElement.add(createTdElement(trElement.get(0), listSubColumn.get(0).getName().toString()));
        tdElementSkip.add(createTdElement(trElementSkip.get(0), listSubColumn.get(0).getName().toString()));

        
        //Main Spalten
        for(int i = 0; i < listMainColumn.size(); i++){
            //tdElement.add(createTdElement(trElement.get(0), listMainColumn.get(i).getName().toString()));
            tdElementSkip.add(createTdElement(trElementSkip.get(0), listMainColumn.get(i).getName().toString()));
        }
        
        
        trElementSkip.add(createTrElement(mainTableElement));
        //Platzhalter für NextSpalte
        //tdElement.add(createTdElement(trElement.get(1), " "));
        tdElementSkip.add(createTdElement(trElementSkip.get(1), " "));
                
        //Untertabelle Do und Done
        for(int j = 0; j < listMainColumn.size(); j++){
            //System.out.println("tttt");
            //Untertabelle
            //tdElement.add(createTdElement(trElement.get(1), " "));
            tdElementSkip.add(createTdElement(trElementSkip.get(1), " "));
            
            subTableElement.add(createSubTable(tdElementSkip.get(tdElementSkip.size()-1)));
            
            trElementSkip.add(createTrElement(subTableElement.get(j)));
            //tdElement.add(createTdElement(trElement.get(trElement.size()-1), "Do"));
            tdElementSkip.add(createTdElement(trElementSkip.get(trElementSkip.size()-1), "Do"));
            //System.out.println(listMainColumn.get(j).getCo_id());
            
            //tdElement.add(createTdElement(trElement.get(trElement.size()-1), "Done"));   
            tdElementSkip.add(createTdElement(trElementSkip.get(trElementSkip.size()-1), "Done"));
        }
        
        
        
        //Done Spalte
        //tdElement.add(createTdElement(trElement.get(0), listSubColumn.get(listSubColumn.size()-1).getName().toString()));
        tdElement.add(createTdElement(trElementSkip.get(0), listSubColumn.get(listSubColumn.size()-1).getName().toString()));
        
        //Platzhalter
        //tdElement.add(createTdElement(trElement.get(trElement.size()-1), " "));
                   

        for(int l = 1; l < listSubColumn.size()-1; l++){

            listCard = xml.readCardsFromColumn(listSubColumn.get(l).getCo_id());
             
           
            
            for(int k = 0; k < listCard.size(); k++){
                trElement.add(createTrElement(subTableElement.get(l)));
                tdElement.add(createTdElement(trElement.get(k)));
                createCardElement(tdElement.get(k) ,listCard.get(k).getName());
                
            }
            
        }
        
        /*
        for(int k = 0; k < listCard.size(); k++){
            int id = listCard.get(k).getCo_id();
            System.out.println("CARD: "+ listCard.get(k).getCa_id());
            System.out.println("COLUMN: "+ listCard.get(k).getCo_id());
            
            
            
            if(tdElement.get(k).getCo_id() == id){
                System.out.println("ELEMENT: " +tdElement.get(k).getTdElement().getTextContent());
                trElement.add(createTrElement(mainTableElement));
            }        
                  
        }
        * */
        
        
        //System.out.println(Kanban.xmlName);

        this.updateXML(Kanban.xmlName.substring(0, Kanban.xmlName.lastIndexOf(46))+".html");
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
    
        private Element createTdElement(Element tr) {
        colElement = doc.createElement("td");
        tr.appendChild(colElement);
        
        return colElement;
    }
    
     private Element createCardElement(Element td, String name) {    
         cardElement = doc.createElement("input"); 
         td.appendChild(cardElement);
         
         attr = doc.createAttribute("type");
         attr.setValue("button");
         cardElement.setAttributeNode(attr);
         
         attr = doc.createAttribute("value");
         attr.setValue(name);
         cardElement.setAttributeNode(attr);
         
        return cardElement;
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
