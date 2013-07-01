/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

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
    
    
    public XML(String xmlPath){
        try {
            
            docBuilderFactory = DocumentBuilderFactory.newInstance();             
            docBuilder = docBuilderFactory.newDocumentBuilder();      
            doc = docBuilder.parse (new File(xmlPath));
            
            // normalize text representation
            doc.getDocumentElement().normalize();
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
          
    private void loadXML(){

    }

    private void saveXML(){

    } 

}
