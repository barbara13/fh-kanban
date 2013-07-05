/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ronald
 */
public class XML_Pk extends XML {
    
    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;

    
    public XML_Pk() {
        try {
            
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File("Pks.xml"));
            doc.getDocumentElement().normalize();
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML_Pk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML_Pk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML_Pk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Liest die aktuelle b_id aus Pks.xml
     * @return int b_id
     */
    public int getB_id() {
        return Integer.parseInt(this.getString(doc.getElementsByTagName("board").item(0).getAttributes().getNamedItem("b_id").toString()));
    }
    
    /**
     * Liest die aktuelle co_id aus Pks.xml
     * @return int co_id
     */
    public int getCo_id() {
        return Integer.parseInt(this.getString(doc.getElementsByTagName("column").item(0).getAttributes().getNamedItem("co_id").toString()));
    }
    
    /**
     * Liest die aktuelle ca_id aus Pks.xml
     * @return int ca_id
     */
    public int getCa_id() {
        return Integer.parseInt(this.getString(doc.getElementsByTagName("card").item(0).getAttributes().getNamedItem("ca_id").toString()));
    }
    
    /**
     * Zählt die b_id um eins hoch
     */
    public void setB_id() { 
        doc.getElementsByTagName("board").item(0).getAttributes().getNamedItem("b_id").setTextContent(String.valueOf(this.getB_id() + 1));
        this.createXML("Pks.xml");
    }
    
    /**
     * Zählt die co_id um eins hoch
     */
    public void setCo_id() {
        doc.getElementsByTagName("column").item(0).getAttributes().getNamedItem("co_id").setTextContent(String.valueOf(this.getCo_id() + 1));
        this.createXML("Pks.xml");
    }
    
    /**
     * Zählt die ca_id um eins hoch
     */
    public void setCa_id() {
        doc.getElementsByTagName("card").item(0).getAttributes().getNamedItem("ca_id").setTextContent(String.valueOf(this.getCa_id() + 1));
        this.createXML("Pks.xml");
    }
    
    public void loadXML(String xmlPath) {
    }
}
