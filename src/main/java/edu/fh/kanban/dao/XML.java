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
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Ronald
 */
public class XML {
    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder; 
    private Document doc;
    
    private NodeList boardList = null;
    private Node cardNode = null;
    private Element cardElement = null;
    private NodeList columnList = null;
    private NodeList cardList = null;
    private int totalColumns;
    private int totalCards;
    
    private Board b;
    private Column co;
    private Card ca;
    
    
    public XML(String xmlPath){
        try {             
            docBuilderFactory = DocumentBuilderFactory.newInstance();             
            docBuilder = docBuilderFactory.newDocumentBuilder();      
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
          
    private void parseXML(){
            doc.getDocumentElement().normalize();
            
            boardList = doc.getDocumentElement().getElementsByTagName("board");
            
            columnList = doc.getElementsByTagName("column");
            totalColumns = columnList.getLength();

            for(int i = 0; i < totalColumns ; i++){
                cardNode = columnList.item(i);

                if(cardNode.getNodeType() == Node.ELEMENT_NODE){
                    cardElement = (Element)cardNode;
                    cardList = cardElement.getElementsByTagName("card");
                    totalCards = cardList.getLength();
                    
                    for(int j = 0; j < totalCards ; j++){
                        System.out.println(cardList.item(j).getAttributes().getNamedItem("name"));
                    }
                }//end of if clause
            }//end of for loop with s var
    }

    public void loadXML(String xmlPath){
        try {
            doc = docBuilder.parse (new File(xmlPath));
            parseXML();
            
            b = new Board();
            co = new Column();
            ca = new Card();
            
            
            
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void saveXML(){

    } 

}
