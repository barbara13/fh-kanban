/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author Ronald
 */
public class XML {

    protected TransformerFactory transformerFactory;
    protected Transformer transformer;
    protected DOMSource source;
    protected StreamResult result;
    protected Document doc;

    /**
     * Extrahiert den Wert eines ausgelesen Attribut aus und gibt diesen zurÃ¼ck
     * @param s
     * @return Sting
     */
    protected String getString(String s) {
        int s1 = s.indexOf("=\"") + 2;
        int s2 = s.length() - 1;

        return s.substring(s1, s2);
    }


    /**
     * Aktualisiert die XML Datei.
     * @param name 
     */
    protected void updateXML(String name) {
        try {        
            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            source = new DOMSource(doc);
            result = new StreamResult(new File(name));
          
                
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
