/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Ronald
 */
public class WriteBoard {
    private TransformerFactory transformerFactory;
    private Transformer transformer;
    private DOMSource source;
    private StreamResult result;
    
    private DocumentBuilder docBuilder;
    private DocumentBuilderFactory docFactory;
    
    private int rootCount = 0;
    private Document doc;
    private Attr attr;
    
    private Element rootElement;
    private Element columnElement;
    private Element cardElement;
    
    public WriteBoard(){
        try {
            
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WriteBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createRoot(String name){
        //Wenn ein root Element 
        if(rootCount > 0){         
            try {
                transformerFactory = TransformerFactory.newInstance();
                transformer = transformerFactory.newTransformer();
                source = new DOMSource(doc);
                result = new StreamResult(new File(name));
                try {
                    transformer.transform(source, result);
                } catch (TransformerException ex) {
                    Logger.getLogger(WriteBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(WriteBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addRoot(String name, String color){  		
        //Wenn kein root existiert
        if(rootCount < 1){
            // root elements
            doc = docBuilder.newDocument();
            rootElement = doc.createElement("board");
            doc.appendChild(rootElement);

            //Attribut b_id hinzufügen
            attr = doc.createAttribute("b_id");
            attr.setValue("1");
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
        attr.setValue("1");
        columnElement.setAttributeNode(attr);
        
        //Attribut b_id hinzufügen
        attr = doc.createAttribute("b_id");
        attr.setValue("1");
        columnElement.setAttributeNode(attr);
        
        //Attribut name hinzufügen
        attr = doc.createAttribute("name");
        attr.setValue(name);
        columnElement.setAttributeNode(attr);
        
        //Attribut wip hinzufügen
        attr = doc.createAttribute("wip");
        attr.setValue(wip);
        columnElement.setAttributeNode(attr);
    }
    
    public void addCard(String name, String description, String effort, String value, String status){
        cardElement = doc.createElement("card");
        columnElement.appendChild(cardElement);
        
        //Attribut ca_id hinzufügen
        attr = doc.createAttribute("ca_id");
        attr.setValue("1");
        cardElement.setAttributeNode(attr);
        
        //Attribut co_id hinzufügen
        attr = doc.createAttribute("co_id");
        attr.setValue("1");
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
    }
    
}
