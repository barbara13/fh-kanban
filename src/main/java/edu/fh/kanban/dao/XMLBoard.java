/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.database.Board;
import edu.fh.kanban.database.Card;
import edu.fh.kanban.database.Column;
import java.io.File;
import java.io.IOException;
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
    
    private int totalColumns;
    private int totalCards;
    
    private XML_Pk pk;
    
    private int b_id;
    private int co_id;
    
    private int rootCount = 0;
    private Attr attr;
    

    
    public XMLBoard(){
        try {             
            docBuilderFactory = DocumentBuilderFactory.newInstance();             
            docBuilder = docBuilderFactory.newDocumentBuilder();    
            
            //Column Elemente parsen
            //columnList = doc.getElementsByTagName("column");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
          
    public void loadXML(String xmlPath){
        this.xmlPath = xmlPath;
        
        String boardName;
        String boardColor;
        
        String columnName;
        String columnWip;
        
        String cardName;
        String cardDescription;
        String cardEffort;
        String cardValue;
        String cardStatus;
        
        try {
            doc = docBuilder.parse (new File(xmlPath));    
            doc.getDocumentElement().normalize();
                
                //Root Element parsen
                //boardList = doc.getDocumentElement().getElementsByTagName("board");
                boardList = doc.getElementsByTagName("board");
                
                boardName = getString(boardList.item(0).getAttributes().getNamedItem("name").toString());
                boardColor = getString(boardList.item(0).getAttributes().getNamedItem("color").toString());
                
                //Board in de Datenbank eintragen
                //b_id = b.insertRowAndReturn(boardName, boardColor);

                columnList = doc.getElementsByTagName("column");
                
                //Anzahl der Columns
                totalColumns = columnList.getLength();
                
                
                for(int i = 0; i < totalColumns ; i++){
                    cardNode = columnList.item(i);
                    
                    columnName = getString(columnList.item(i).getAttributes().getNamedItem("name").toString());
                    columnWip = getString(columnList.item(i).getAttributes().getNamedItem("wip").toString());
                    
                    //Column in die Datenbank eintragen
                    //co_id = co.insertRowAndReturn(b_id, columnName, Integer.parseInt(columnWip));
                    
                    if(cardNode.getNodeType() == Node.ELEMENT_NODE){
                        //Card Element
                        cardElement = (Element)cardNode;
                        //Card Elemente parsen
                        cardList = cardElement.getElementsByTagName("card");
                        //Anzahl der Cards
                        totalCards = cardList.getLength();
                        
                        for(int j = 0; j < totalCards ; j++){
                                    
                            cardName = getString(cardList.item(j).getAttributes().getNamedItem("name").toString());
                            cardDescription = getString(cardList.item(j).getAttributes().getNamedItem("description").toString());
                            cardEffort = getString(cardList.item(j).getAttributes().getNamedItem("effort").toString());
                            cardValue = getString(cardList.item(j).getAttributes().getNamedItem("value").toString());
                            cardStatus = getString(cardList.item(j).getAttributes().getNamedItem("status").toString());
       
                            //ca.insertRow(co_id, cardName, cardDescription, Integer.parseInt(cardEffort), Integer.parseInt(cardValue), cardStatus);
             
                        }
                    }//end of if clause
                }//end of for loop with s var
        } catch (SAXException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveXML(){
        
    }
    
    
    public void addRoot(String name, String color){  		
        //Wenn kein root existiert
        if(rootCount < 1){
            
            pk = new XML_Pk();
            
            // root elements
            doc = docBuilder.newDocument();
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
    
    public void addCardToColumn(int ca_id, int co_id){
        columnElement = this.searchColumn(co_id);
        cardElement = xmlCard.searchCard(ca_id);
        
        //Wenn die gesuchte card und column gefunden wurde
        if(cardElement != null && columnElement != null){ 
            
            columnElement.appendChild(this.addCard(cardElement, columnElement.getAttribute("co_id")));
            xmlCard.deleteCard(ca_id);
            
            this.updateXML(xmlPath);
         
        }
    }
    
    public void createBoard(String name){
        this.updateXML(name + ".xml");
        pk.setB_id();
    }


}
