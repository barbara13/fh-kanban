/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.data.Card;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
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
    private String xmlPath = "cards.xml";
    
    private XML_Pk pk;
    private Element cardElement = null;
    private Element searchedElement = null;
    private Element rootElement = null;
    private NodeList rootList = null;
    private NodeList cardList = null;
    private Attr attr;
    
    private ArrayList <Card> listCard= new ArrayList();
   
    private SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private String dateString; 
    private Date date;
    
    public XMLCard() {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();

            try {
                //XML Datei laden
                doc = docBuilder.parse(xmlPath);
                //Root Element
                rootElement = (Element) doc.getElementsByTagName("cards").item(0);

                cardList = doc.getElementsByTagName("card");

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

    public void addCard(String name, String description, String effort, String value, String blocker, String blocker_tooltip) {
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

        //Attribut Blocker hinzufügen
        attr = doc.createAttribute("blocker");
        attr.setValue(blocker);
        cardElement.setAttributeNode(attr);
        
        //Attribut Blocker_Tooltip hinzufügen
        attr = doc.createAttribute("blocker_tooltip");
        attr.setValue(blocker_tooltip);
        cardElement.setAttributeNode(attr);
        
        //Attribut Created hinzufügen
        attr = doc.createAttribute("created");
        attr.setValue(sd.format(new Date()));
        cardElement.setAttributeNode(attr);
        
        //Attribut Started hinzufügen
        attr = doc.createAttribute("started");
        attr.setValue("");
        cardElement.setAttributeNode(attr);
        
        //Attribut Done hinzufügen
        attr = doc.createAttribute("done");
        attr.setValue("");
        cardElement.setAttributeNode(attr);



        pk.setCa_id();
        updateXML(xmlPath);
    }

    public Element searchCard(int ca_id) {
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

    public void deleteCard(int ca_id) {
        cardElement = searchCard(ca_id);
        if (cardElement != null) {
            //Element aus der Datei löschen
            rootElement.removeChild(cardElement);
            //XML Datei aktualisieren
            updateXML(xmlPath);
        }
    }

    public void createCard() {
        this.updateXML(xmlPath);
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
    
        
    public ArrayList readCards(){     
        listCard.clear();
        cardList = doc.getElementsByTagName("card");
        
        for(int i = 0; i < cardList.getLength() ; i++){
            listCard.add(new Card(Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("co_id").toString())),getString(cardList.item(i).getAttributes().getNamedItem("name").toString()),getString(cardList.item(i).getAttributes().getNamedItem("description").toString()),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("effort").toString())),Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("value").toString())),getString(cardList.item(i).getAttributes().getNamedItem("blocker").toString()), getString(cardList.item(i).getAttributes().getNamedItem("blocker_tooltip").toString()), getString(cardList.item(i).getAttributes().getNamedItem("created").toString()), getString(cardList.item(i).getAttributes().getNamedItem("started").toString()), getString(cardList.item(i).getAttributes().getNamedItem("done").toString())));
         }
        return listCard;
    }
}
