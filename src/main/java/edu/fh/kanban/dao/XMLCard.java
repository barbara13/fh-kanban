/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ronald
 */
public class XMLCard extends XML {
    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    
    private XML_Pk pk;
    
    private Element cardElement = null;
    private NodeList cardList = null;
    private Attr attr;
    
    public XMLCard() {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            
            try {
               doc = docBuilder.parse("cards.xml");
            } catch (SAXException ex) {
                Logger.getLogger(XMLCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XMLCard.class.getName()).log(Level.SEVERE, null, ex);
            }
            pk = new XML_Pk();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addCard(String name, String description, String effort, String value, String status){
        cardElement = doc.createElement("card");
        doc.getDocumentElement().appendChild(cardElement);
        
        //Attribut ca_id hinzufügen
        attr = doc.createAttribute("ca_id");
        attr.setValue(String.valueOf(pk.getCa_id()));
        cardElement.setAttributeNode(attr);
        
        //Attribut co_id hinzufügen
        attr = doc.createAttribute("co_id");
        attr.setValue("0");
        cardElement.setAttributeNode(attr);
        
        //Attribut name hinzufügen
        attr = doc.createAttribute("name");
        attr.setValue(name);
        cardElement.setAttributeNode(attr);
        
        //Attribut Description hinzufügen
        attr = doc.createAttribute("description");
        attr.setValue(description);
        cardElement.setAttributeNode(attr);
        
        //Attribut Effort hinzufügen
        attr = doc.createAttribute("effort");
        attr.setValue(effort);
        cardElement.setAttributeNode(attr);
        
        //Attribut Value hinzufügen
        attr = doc.createAttribute("value");
        attr.setValue(value);
        cardElement.setAttributeNode(attr);
        
        //Attribut Status hinzufügen
        attr = doc.createAttribute("status");
        attr.setValue(status);
        cardElement.setAttributeNode(attr);
        
        pk.setCa_id();
    }
    
    public void deleteCard(int ca_id){
        cardList = doc.getElementsByTagName("card");
        for(int i = 0; i < cardList.getLength(); i++){
            //if(cardList.item(i).getAttributes().getNamedItem("ca_id")){
                System.out.println("f");
            //}
        }
    }
    
    public void createCard(){
        this.createXML("cards.xml");
    }
}
