/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Ronald
 */
public class XMLBoard extends XML{
    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder; 
   // private Document doc;
    
    private String xmlPath;
    private XMLCard xmlCard = new XMLCard();
    
    private Element rootElement;
    private Element columnElement;
    private Element cardElement;
    private Element searchedElement;
    
    private Node cardNode = null;
    
    private NodeList boardList = null;
    private NodeList columnList = null;
    private NodeList cardList = null;
    
    private ArrayList <Board> listBoard = new ArrayList();
    private ArrayList <Column> listColumn = new ArrayList();
    private ArrayList <Card> listCard= new ArrayList();
    
    private  Iterator it = listColumn.iterator();
    
    
    private int totalColumns;
    private int totalCards;
    
    private XML_Pk pk;
    
    private int b_id;
    private int co_id;
    
    private int rootCount = 0;
    private Attr attr;
    

    
    public XMLBoard(){


    }
    
  
          
    public void loadXML(String xmlPath) {
        try {
            
            docBuilderFactory = DocumentBuilderFactory.newInstance();             
            docBuilder = docBuilderFactory.newDocumentBuilder();
            this.xmlPath = xmlPath;
            doc = docBuilder.parse(xmlPath);
            
        } catch (SAXException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList readBoard(){
        listBoard.clear();
        boardList = doc.getElementsByTagName("board");
        
        for(int i = 0; i < boardList.getLength() ; i++){
             listBoard.add(new Board(Integer.parseInt(getString(boardList.item(i).getAttributes().getNamedItem("b_id").toString())),getString(boardList.item(i).getAttributes().getNamedItem("name").toString()), getString(boardList.item(i).getAttributes().getNamedItem("color").toString())));
        }
        
        return listBoard;
    }
    
    public ArrayList readColumns(){     
        listColumn.clear();
        columnList = doc.getElementsByTagName("column");
        
        for(int i = 0; i < columnList.getLength() ; i++){
            listColumn.add(new Column(Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())),Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("b_id").toString())), getString(columnList.item(i).getAttributes().getNamedItem("name").toString()), Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("wip").toString()))));       
        }
        
        return listColumn;
    }
    
    public ArrayList readCards(){     
        listCard.clear();
        cardList = doc.getElementsByTagName("card");
        
        for(int i = 0; i < cardList.getLength() ; i++){
            listCard.add(new Card(Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("co_id").toString())),getString(cardList.item(i).getAttributes().getNamedItem("name").toString()),getString(cardList.item(i).getAttributes().getNamedItem("description").toString()),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("effort").toString())),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("value").toString())),getString(cardList.item(i).getAttributes().getNamedItem("status").toString())));
         }
        return listCard;
    }    

    
    public void addBoard(String name, String color){  		
        //Wenn kein root existiert
        if(rootCount < 1){
            
            pk = new XML_Pk();
            
            // root elements
            //doc = docBuilder.newDocument();
            rootElement = doc.createElement("board");
            doc.appendChild(rootElement);

            //Attribut b_id hinzufügen
            attr = doc.createAttribute("b_id");
            attr.setValue(String.valueOf(pk.getB_id()));
            rootElement.setAttributeNode(attr);

            //Attribut name hinzufügen
            attr = doc.createAttribute("name");
            attr.setValue(name);
            rootElement.setAttributeNode(attr);

            //Attribut color hinzufügen
            attr = doc.createAttribute("color");
            attr.setValue(color);
            rootElement.setAttributeNode(attr);    
            
            rootCount++;
            
        }


    }
    
    public void addColumn(String name, String wip){
        columnElement = doc.createElement("column");
        rootElement.appendChild(columnElement);
        
        //Attribut co_id hinzufügen
        attr = doc.createAttribute("co_id");
        attr.setValue(String.valueOf(pk.getCo_id()));
        columnElement.setAttributeNode(attr);
        
        //Attribut b_id hinzufügen
        attr = doc.createAttribute("b_id");
        attr.setValue(String.valueOf(pk.getB_id()));
        columnElement.setAttributeNode(attr);
        
        //Attribut name hinzufügen
        attr = doc.createAttribute("name");
        attr.setValue(name);
        columnElement.setAttributeNode(attr);
        
        //Attribut wip hinzufügen
        attr = doc.createAttribute("wip");
        attr.setValue(wip);
        columnElement.setAttributeNode(attr);
        
        pk.setCo_id();
    }
    
    public Element addCard(Element card, String co_id){
        Element newCardElement;
        newCardElement = doc.createElement("card");
        
        //Attribut ca_id hinzufügen
        attr = doc.createAttribute("ca_id");
        attr.setValue(card.getAttribute("ca_id"));
        newCardElement.setAttributeNode(attr);

        //Attribut co_id hinzufügen
        attr = doc.createAttribute("co_id");
        attr.setValue(co_id);
        newCardElement.setAttributeNode(attr);

        //Attribut name hinzufügen
        attr = doc.createAttribute("name");
        attr.setValue(card.getAttribute("name"));
        newCardElement.setAttributeNode(attr);

        //Attribut Description hinzufügen
        attr = doc.createAttribute("description");
        attr.setValue(card.getAttribute("description"));
        newCardElement.setAttributeNode(attr);

        //Attribut Effort hinzufügen
        attr = doc.createAttribute("effort");
        attr.setValue(card.getAttribute("effort"));
        newCardElement.setAttributeNode(attr);

        //Attribut Value hinzufügen
        attr = doc.createAttribute("value");
        attr.setValue(card.getAttribute("value"));
        newCardElement.setAttributeNode(attr);

        //Attribut Status hinzufügen
        attr = doc.createAttribute("status");
        attr.setValue(card.getAttribute("status"));
        newCardElement.setAttributeNode(attr);
        
        return newCardElement;
    }
    
    

    
    public Element searchColumn(int co_id){
        columnList = doc.getElementsByTagName("column");
        for (int i = 0; i < columnList.getLength(); i++) {
            //Wenn gesuchtes Element gefunden wurde
            if (Integer.parseInt(this.getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                searchedElement = (Element) columnList.item(i);
                //Abbruch der Schleife wenn gesuchtes Element gelöscht wurde
                break;
            }  
    }
        return searchedElement;
    }
    
    public Element searchCard(int ca_id) {
        cardList = doc.getElementsByTagName("card");
        for (int i = 0; i < cardList.getLength(); i++) {
            //Wenn gesuchtes Element gefunden wurde
            if (Integer.parseInt(this.getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())) == ca_id) {
                searchedElement = (Element) cardList.item(i);
                //Abbruch der Schleife wenn gesuchtes Element gelöscht wurde
                break;
            }
        }

        return searchedElement;
    }
    
    private Element getFirstColumn(){
        columnList = doc.getElementsByTagName("column");
        searchedElement = (Element) columnList.item(0);
        
        return searchedElement;
    }
    
    public void addCardToBoard(int ca_id){
        columnElement = getFirstColumn();
        cardElement = xmlCard.searchCard(ca_id);
        
        //Wenn die gesuchte card und column gefunden wurde
        if(cardElement != null && columnElement != null){ 
            
            columnElement.appendChild(this.addCard(cardElement, columnElement.getAttribute("co_id")));
            xmlCard.deleteCard(ca_id);
            
            this.updateXML(xmlPath);
         
        }
    }
    
    public void forwardCard(int ca_id){
        boolean f = false;
        Element newColumnElement;
        
        cardElement = searchCard(ca_id);
        co_id = Integer.parseInt(cardElement.getAttribute("co_id"));
        
        
        columnElement = searchColumn(co_id);
        columnList = doc.getElementsByTagName("column");
        
        for(int i = 0; i < columnList.getLength(); i++){
            //Wenn f == false ist
            
            if(f == false){ 
                if(Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id){
                    //f = true setzen damit im nächsten durchlauf der else Fall eintritt
                    f = true;
                }
            } else{
                //addCard(cardElement, columnList.item(i).getAttributes().getNamedItem("co_id").toString());
                newColumnElement = searchColumn(Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())));
                
                newColumnElement.appendChild(this.addCard(cardElement, columnElement.getAttribute("co_id")));
                deleteCard(ca_id);
                updateXML(xmlPath);
                break;
            }
   
        }
        
        
    }
    
    public void prevCard(int ca_id){
        
    }
    
       
    public void deleteCard(int ca_id) {
        cardElement = searchCard(ca_id);
        if (cardElement != null) {
            //Element aus der Datei löschen
            columnElement.removeChild(cardElement);
            //XML Datei aktualisieren
            updateXML(xmlPath);
        }
    }
    
       
    public void editBoard(int id, String attr, String value){
        boardList = doc.getElementsByTagName("board");
        
        for(int i = 0; i < boardList.getLength(); i++){
            if(Integer.parseInt(getString(boardList.item(i).getAttributes().getNamedItem("b_id").toString())) == id){
                boardList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }
    
        
    public void editColumn(int id, String attr, String value){
        columnList = doc.getElementsByTagName("column");
        
        for(int i = 0; i < columnList.getLength(); i++){
            if(Integer.parseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == id){
                columnList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }
    
    public void editCard(int id, String attr, String value){
        cardList = doc.getElementsByTagName("card");
        
        for(int i = 0; i < cardList.getLength(); i++){
            if(Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())) == id){
                cardList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }    
    
    public void createBoard(){
        this.updateXML(xmlPath);
        pk.setB_id();
    }


}
