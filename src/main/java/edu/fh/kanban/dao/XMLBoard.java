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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Ronald
 */
public class XMLBoard extends XML {

    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    private String xmlPath;
    private XMLCard xmlCard = new XMLCard();
    private Element rootElement;
    private Element columnElement;
    private Element subColumnElement1;
    private Element subColumnElement2;
    private Element cardElement;
    private Element searchedElement = null;
    private NodeList boardList = null;
    private NodeList columnList = null;
    private NodeList cardList = null;
    private ArrayList<Board> listBoard = new ArrayList<Board>();
    private ArrayList<Column> listMainColumn = new ArrayList<Column>();
    private ArrayList<Column> listSubColumn = new ArrayList<Column>();
    private ArrayList<Card> listCard = new ArrayList<Card>();
    private XML_Pk pk;
    private int co_id;
    private Attr attr;
    private Attr attr1;
    private Attr attr2;
    private int wip;
    private boolean wipCheck = false;
    private int wipCount;
    private SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private boolean isCardOnBoard;

    public XMLBoard() {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Parsed eine XML Datei und speichert sie in dem HSP
     *
     * @param xmlPath
     */
    public void loadXML(String xmlPath) {
        try {
            this.xmlPath = xmlPath;

            doc = docBuilder.parse(new File(xmlPath));
            doc.getDocumentElement().normalize();

        } catch (SAXException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Liest das Board aus der geladenen XML Datei aus und gibt es zurÃ¼ck
     *
     * @return Board
     */
    public Board getBoard() {
        boardList = doc.getElementsByTagName("board");

        for (int i = 0; i < boardList.getLength(); i++) {
            listBoard.add(new Board(Kanban.tryParseInt(getString(boardList.item(i).getAttributes().getNamedItem("b_id").toString())), getString(boardList.item(i).getAttributes().getNamedItem("name").toString()), getString(boardList.item(i).getAttributes().getNamedItem("expedite").toString()), getString(boardList.item(i).getAttributes().getNamedItem("standart").toString()), getString(boardList.item(i).getAttributes().getNamedItem("fixedDate").toString()), getString(boardList.item(i).getAttributes().getNamedItem("intangible").toString())));
        }

        return listBoard.get(0);
    }

    /**
     * Liest das Board aus der geladenen XML Datei aus und gibt als es ArrayList
     * zurÃ¼ck
     *
     * @return ArrayList
     */
    public ArrayList<Board> readBoard() {
        listBoard.clear();
        boardList = doc.getElementsByTagName("board");

        for (int i = 0; i < boardList.getLength(); i++) {
            listBoard.add(new Board(Kanban.tryParseInt(getString(boardList.item(i).getAttributes().getNamedItem("b_id").toString())), getString(boardList.item(i).getAttributes().getNamedItem("name").toString()), getString(boardList.item(i).getAttributes().getNamedItem("expedite").toString()), getString(boardList.item(i).getAttributes().getNamedItem("standart").toString()), getString(boardList.item(i).getAttributes().getNamedItem("fixedDate").toString()), getString(boardList.item(i).getAttributes().getNamedItem("intangible").toString())));
        }

        return listBoard;
    }

    /**
     * Liest die Unterspalten do und done aus und gibt sie als ArrayList zurÃ¼ck
     *
     * @return ArrayList
     */
    public ArrayList<Column> readSubColumns() {
        listSubColumn.clear();
        columnList = doc.getElementsByTagName("column");

        for (int i = 0; i < columnList.getLength(); i++) {
            listSubColumn.add(new Column(Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())), Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("b_id").toString())), getString(columnList.item(i).getAttributes().getNamedItem("name").toString()), Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("wip").toString()))));
        }

        return listSubColumn;
    }

    /**
     * Liest die Hauptspalten aus und gibt sie als ArrayList zurÃ¼ck
     *
     * @return ArrayList
     */
    public ArrayList<Column> readMainColumns() {
        listMainColumn.clear();
        columnList = doc.getElementsByTagName("columns");

        for (int i = 0; i < columnList.getLength(); i++) {
            listMainColumn.add(new Column(Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())), Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("b_id").toString())), getString(columnList.item(i).getAttributes().getNamedItem("name").toString()), Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("wip").toString()))));
        }

        return listMainColumn;
    }

    /**
     * Liest die Karten aus der geladenen XML Datei aus und gibt sie als
     * ArrayList zurÃ¼ck
     *
     * @return ArrayList
     */
    public ArrayList<Card> readCards() {
        listCard.clear();
        cardList = doc.getElementsByTagName("card");

        for (int i = 0; i < cardList.getLength(); i++) {
            listCard.add(new Card(Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())), Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("co_id").toString())), getString(cardList.item(i).getAttributes().getNamedItem("name").toString()), getString(cardList.item(i).getAttributes().getNamedItem("description").toString()), Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("effort").toString())), getString(cardList.item(i).getAttributes().getNamedItem("value").toString()), getString(cardList.item(i).getAttributes().getNamedItem("blocker").toString()), getString(cardList.item(i).getAttributes().getNamedItem("blocker_tooltip").toString()), getString(cardList.item(i).getAttributes().getNamedItem("created").toString()), getString(cardList.item(i).getAttributes().getNamedItem("started").toString()), getString(cardList.item(i).getAttributes().getNamedItem("done").toString())));
        }
        return listCard;
    }

    /**
     * Liest die Karten einer bestimmten Spalte aus und gibt sie als ArrayList
     *
     * @param co_id
     * @return ArrayList
     */
    public ArrayList<Card> readCardsFromColumn(int co_id) {
        listCard.clear();

        cardList = doc.getElementsByTagName("card");
        columnList = doc.getElementsByTagName("column");

        for (int i = 0; i < cardList.getLength(); i++) {
            if (Kanban.tryParseInt(getString(cardList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                listCard.add(new Card(Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())), Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("co_id").toString())), getString(cardList.item(i).getAttributes().getNamedItem("name").toString()), getString(cardList.item(i).getAttributes().getNamedItem("description").toString()), Integer.parseInt(getString(cardList.item(i).getAttributes().getNamedItem("effort").toString())), getString(cardList.item(i).getAttributes().getNamedItem("value").toString()), getString(cardList.item(i).getAttributes().getNamedItem("blocker").toString()), getString(cardList.item(i).getAttributes().getNamedItem("blocker_tooltip").toString()), getString(cardList.item(i).getAttributes().getNamedItem("created").toString()), getString(cardList.item(i).getAttributes().getNamedItem("started").toString()), getString(cardList.item(i).getAttributes().getNamedItem("done").toString())));
            }
        }

        return listCard;
    }

    /**
     * Erstellt ein XML Board. Um die XML Datei zu erstellen muss anschlieÃŸend
     * die Mehtode createBoard aufgerufen werden.
     *
     * @param name
     * @param expedite
     * @param standart
     * @param fixedDate
     * @param intangible
     */
    public void addBoard(String name, String expedite, String standart, String fixedDate, String intangible) {
        pk = new XML_Pk();

        rootElement = doc.createElement("board");
        doc.appendChild(rootElement);

        //Attribut b_id hinzufÃ¼gen
        attr = doc.createAttribute("b_id");
        attr.setValue(String.valueOf(pk.getB_id()));
        rootElement.setAttributeNode(attr);

        //Attribut name hinzufÃ¼gen
        attr = doc.createAttribute("name");
        attr.setValue(name);
        rootElement.setAttributeNode(attr);

        //Attribut expedite hinzufÃ¼gen
        attr = doc.createAttribute("expedite");
        attr.setValue(expedite);
        rootElement.setAttributeNode(attr);

        //Attribut standart hinzufÃ¼gen
        attr = doc.createAttribute("standart");
        attr.setValue(standart);
        rootElement.setAttributeNode(attr);

        //Attribut fixedDate hinzufÃ¼gen
        attr = doc.createAttribute("fixedDate");
        attr.setValue(fixedDate);
        rootElement.setAttributeNode(attr);

        //Attribut intangible hinzufÃ¼gen
        attr = doc.createAttribute("intangible");
        attr.setValue(intangible);
        rootElement.setAttributeNode(attr);
    }

    /**
     * FÃ¼gt eine Hauptspalte zu dem geladenen Board hinzu.
     *
     * @param name
     * @param wip
     */
    public void addNewColumn(String name, String wip) {

        columnElement = doc.createElement("columns");
        subColumnElement1 = doc.createElement("column");
        subColumnElement2 = doc.createElement("column");

        rootElement.appendChild(columnElement);
        columnElement.appendChild(subColumnElement1);
        columnElement.appendChild(subColumnElement2);

        /*
         * Attribut co_id hinzufÃ¼gen
         */
        //Column
        attr = doc.createAttribute("co_id");
        attr.setValue(String.valueOf(pk.getCo_id()));
        pk.setCo_id();
        columnElement.setAttributeNode(attr);
        //SubColumn1
        attr1 = doc.createAttribute("co_id");
        attr1.setValue(String.valueOf(pk.getCo_id()));
        pk.setCo_id();
        subColumnElement1.setAttributeNode(attr1);
        //SubColumn2
        attr2 = doc.createAttribute("co_id");
        attr2.setValue(String.valueOf(pk.getCo_id()));
        pk.setCo_id();
        subColumnElement2.setAttributeNode(attr2);


        /*
         * Attribut b_id hinzufÃ¼gen
         */
        //Column
        attr = doc.createAttribute("b_id");
        attr.setValue(String.valueOf(pk.getB_id()));
        columnElement.setAttributeNode(attr);
        //SubColumn1
        attr1 = doc.createAttribute("b_id");
        attr1.setValue(String.valueOf(pk.getB_id()));
        subColumnElement1.setAttributeNode(attr1);
        //SubColumn2
        attr2 = doc.createAttribute("b_id");
        attr2.setValue(String.valueOf(pk.getB_id()));
        subColumnElement2.setAttributeNode(attr2);

        /*
         * Attribut name hinzufÃ¼gen
         */
        //Column
        attr = doc.createAttribute("name");
        attr.setValue(name);
        columnElement.setAttributeNode(attr);
        //SubColumn1
        attr1 = doc.createAttribute("name");
        attr1.setValue("Do");
        subColumnElement1.setAttributeNode(attr1);
        //SubColumn2
        attr2 = doc.createAttribute("name");
        attr2.setValue("Done");
        subColumnElement2.setAttributeNode(attr2);

        /*
         * Attribut wip hinzufÃ¼gen
         */
        //SubColumn
        attr = doc.createAttribute("wip");
        attr.setValue(wip);
        columnElement.setAttributeNode(attr);
        //SubColumn1
        attr1 = doc.createAttribute("wip");
        attr1.setValue(wip);
        subColumnElement1.setAttributeNode(attr1);
        //SubColumn2
        attr2 = doc.createAttribute("wip");
        attr2.setValue("100");
        subColumnElement2.setAttributeNode(attr2);

    }

    /**
     * FÃ¼gt eine Unterspalte zu dem geladen Board hinzu.
     *
     * @param name
     * @param wip
     */
    public void addColumn(String name, String wip) {
        columnElement = doc.createElement("column");
        rootElement.appendChild(columnElement);

        //Attribut co_id hinzufÃ¼gen
        attr = doc.createAttribute("co_id");
        attr.setValue(String.valueOf(pk.getCo_id()));
        columnElement.setAttributeNode(attr);

        //Attribut b_id hinzufÃ¼gen
        attr = doc.createAttribute("b_id");
        attr.setValue(String.valueOf(pk.getB_id()));
        columnElement.setAttributeNode(attr);

        //Attribut name hinzufÃ¼gen
        attr = doc.createAttribute("name");
        attr.setValue(name);
        columnElement.setAttributeNode(attr);

        //Attribut wip hinzufÃ¼gen
        attr = doc.createAttribute("wip");
        attr.setValue(wip);
        columnElement.setAttributeNode(attr);

        pk.setCo_id();
    }

    /**
     * FÃ¼gt eine Karte zu einer bestimmten Spalte hinzu
     *
     * @param card
     * @param co_id
     * @return
     */
    public Element addCard(Element card, String co_id) {
        Element newCardElement;
        newCardElement = doc.createElement("card");

        //Attribut ca_id hinzufÃ¼gen
        attr = doc.createAttribute("ca_id");
        attr.setValue(card.getAttribute("ca_id"));
        newCardElement.setAttributeNode(attr);

        //Attribut co_id hinzufÃ¼gen
        attr = doc.createAttribute("co_id");
        attr.setValue(card.getAttribute("co_id"));
        newCardElement.setAttributeNode(attr);

        //Attribut name hinzufÃ¼gen
        attr = doc.createAttribute("name");
        attr.setValue(card.getAttribute("name"));
        newCardElement.setAttributeNode(attr);

        //Attribut Description hinzufÃ¼gen
        attr = doc.createAttribute("description");
        attr.setValue(card.getAttribute("description"));
        newCardElement.setAttributeNode(attr);

        //Attribut Effort hinzufÃ¼gen
        attr = doc.createAttribute("effort");
        attr.setValue(card.getAttribute("effort"));
        newCardElement.setAttributeNode(attr);

        //Attribut Value hinzufÃ¼gen
        attr = doc.createAttribute("value");
        attr.setValue(card.getAttribute("value"));
        newCardElement.setAttributeNode(attr);

        //Attribut Blocker hinzufÃ¼gen
        attr = doc.createAttribute("blocker");
        attr.setValue(card.getAttribute("blocker"));
        newCardElement.setAttributeNode(attr);

        //Attribut Blocker_Tooltip hinzufÃ¼gen
        attr = doc.createAttribute("blocker_tooltip");
        attr.setValue(card.getAttribute("blocker_tooltip"));
        newCardElement.setAttributeNode(attr);

        //Attribut Created hinzufÃ¼gen
        attr = doc.createAttribute("created");
        attr.setValue(card.getAttribute("created"));
        newCardElement.setAttributeNode(attr);

        //Attribut Started hinzufÃ¼gen
        attr = doc.createAttribute("started");
        attr.setValue(card.getAttribute("created"));
        newCardElement.setAttributeNode(attr);

        //Attribut Started hinzufÃ¼gen
        attr = doc.createAttribute("done");
        attr.setValue(card.getAttribute(""));
        newCardElement.setAttributeNode(attr);

        return newCardElement;
    }

    /**
     * Durchsucht die Unterspalten nach einer bestimmter Column
     *
     * @param co_id
     * @return
     */
    public Element searchColumn(int co_id) {
        columnList = doc.getElementsByTagName("column");
        for (int i = 0; i < columnList.getLength(); i++) {
            //Wenn gesuchtes Element gefunden wurde
            if (Kanban.tryParseInt(this.getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                searchedElement = (Element) columnList.item(i);
                //Abbruch der Schleife wenn gesuchtes Element gelÃ¶scht wurde
                break;
            }
        }
        return searchedElement;
    }

    /**
     * Durchsucht die MainColumns nach einer bestimmter Column
     *
     * @param co_id
     * @return
     */
    public Element searchColumns(int co_id) {
        columnList = doc.getElementsByTagName("columns");
        for (int i = 0; i < columnList.getLength(); i++) {
            //Wenn gesuchtes Element gefunden wurde
            if (Kanban.tryParseInt(this.getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                searchedElement = (Element) columnList.item(i);
                //Abbruch der Schleife wenn gesuchtes Element gelÃ¶scht wurde
                break;
            }
        }
        return searchedElement;
    }

    /**
     * Durchsucht das Board nach einer Karte und gibt sie zurÃ¼ck
     *
     * @param ca_id
     * @return Element
     */
    public Element searchCard(int ca_id) {
        cardList = doc.getElementsByTagName("card");

        for (int i = 0; i < cardList.getLength(); i++) {
            //Wenn gesuchtes Element gefunden wurde
            if (Kanban.tryParseInt(this.getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())) == ca_id) {
                searchedElement = (Element) cardList.item(i);
                //Abbruch der Schleife wenn gesuchtes Element gelÃ¶scht wurde
                break;
            }
        }

        return searchedElement;
    }

    /**
     * Gibt die erste Spalte des Boards zurÃ¼ck
     *
     * @return Element
     */
    private Element getFirstColumn() {
        columnList = doc.getElementsByTagName("column");
        searchedElement = (Element) columnList.item(0);

        return searchedElement;
    }

    /**
     * FÃ¼gt eine Karte aus dem Backlog ins Board hinzu.
     *
     * @param ca_id
     */
    public void addCardToBoard(int ca_id) {
        columnElement = getFirstColumn();
        cardElement = xmlCard.searchCard(ca_id);

        //Wenn die gesuchte card und column gefunden wurde oder keine firstcard exisitiert
        if (cardElement != null && columnElement != null) {

            columnElement.appendChild(this.addCard(cardElement, columnElement.getAttribute("co_id")));
            this.editCard(ca_id, "co_id", columnElement.getAttribute("co_id"));
            editCard(ca_id, "started", sd.format(new Date()));

            updateXML(xmlPath);
        }
    }

    /**
     * Verschiebt eine Karte in die nÃ¤chste Spalte.
     *
     * @param ca_id
     */
    public void forwardCard(int ca_id) {
        boolean f = false;

        Element targetColumnElement;


        cardElement = searchCard(ca_id);

        this.co_id = Kanban.tryParseInt(cardElement.getAttribute("co_id"));

        columnList = doc.getElementsByTagName("column");

        /*
         * Es erst nach der Column gesucht in der sich die Card befindet, dann
         * wird f == true gesetzt damit die Schleife noch einmal durchlaufen
         * wird, dann befindet man sich in der Ziel Column
         */
        for (int i = 0; i < columnList.getLength(); i++) {
            //Wenn f == false ist
            if (f == false) {
                if (Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {

                    f = true;

                }
            } else {

                targetColumnElement = searchColumn(Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())));




                if (checkWip(Kanban.tryParseInt(targetColumnElement.getAttribute("co_id"))) == true) {

                    targetColumnElement.appendChild(this.addCard(cardElement, getString(targetColumnElement.getAttribute("co_id"))));
                    deleteCard(ca_id, this.co_id);
                    editCard(Kanban.tryParseInt(cardElement.getAttribute("ca_id")), "co_id", targetColumnElement.getAttribute("co_id"));

                    //Letztes Element der Liste
                    Element doneElement = (Element) columnList.item(columnList.getLength() - 1);

                    //ÃœberprÃ¼fen ob Done oder nicht
                    if (targetColumnElement == doneElement) {
                        editCard(Kanban.tryParseInt(cardElement.getAttribute("ca_id")), "done", sd.format(new Date()));
                    } else {
                        editCard(Kanban.tryParseInt(cardElement.getAttribute("ca_id")), "done", "");
                    }

                    updateXML(xmlPath);

                }
                break;
            }
        }
    }

    /**
     * Verschiebt eine Karte in die vorherige Do bzw. Next Spalte
     *
     * @param ca_id
     */
    public void prevCard(int ca_id) {
        boolean f = false;
        int count = 0;
        int maxCount;

        Element targetColumnElement;

        cardElement = searchCard(ca_id);

        this.co_id = Kanban.tryParseInt(cardElement.getAttribute("co_id"));

        columnElement = searchColumn(co_id);
        
        columnList = doc.getElementsByTagName("column");
        Element lastDone = (Element) columnList.item(columnList.getLength()-1);
        
        if (columnElement.getAttribute("name").equals("Done")){
            maxCount = 1;
        } else {
            maxCount = 2;
        }
        
        //Beim letzten Done
        if(lastDone.getAttribute("co_id").equals(columnElement.getAttribute("co_id"))){
            maxCount = 2;
        }

        columnList = doc.getElementsByTagName("column");


        for (int i = columnList.getLength() - 1; i >= 0; i--) {
            if (f == false) {
                if (Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                    f = true;
                }
            } else {
                count++;
            }

            targetColumnElement = searchColumn(Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())));
            if (targetColumnElement.getAttribute("name").equals("Next")) {
                count = 2;
            }

            if (count == maxCount) {
                targetColumnElement = searchColumn(Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())));

                cardElement.getAttribute("co_id");
                if (checkWip(Kanban.tryParseInt(targetColumnElement.getAttribute("co_id"))) == true) {
                    
                    deleteCard(ca_id, this.co_id);
                    targetColumnElement.appendChild(this.addCard(cardElement, getString(targetColumnElement.getAttribute("co_id"))));
                    editCard(Kanban.tryParseInt(cardElement.getAttribute("ca_id")), "co_id", targetColumnElement.getAttribute("co_id"));


                    updateXML(xmlPath);
                    break;
                }
            }
        }
    }

    /**
     * LÃ¶scht eine bestimmte Karte aus einer bestimmten Spalte aus dem Board
     *
     * @param ca_id
     * @param co_id
     */
    public void deleteCard(int ca_id, int co_id) {
        cardElement = searchCard(ca_id);
        columnElement = searchColumn(co_id);

        if (cardElement != null) {
            //Element aus der Datei lÃ¶schen
            columnElement.removeChild(cardElement);
            //XML Datei aktualisieren
            updateXML(xmlPath);
        }
    }

    /**
     * VerÃ¤ndert das Board. attr -> Attribut; value -> Wert der geÃ¤ndert werden
     * soll
     *
     * @param id
     * @param attr
     * @param value
     */
    public void editBoard(int id, String attr, String value) {
        boardList = doc.getElementsByTagName("board");

        for (int i = 0; i < boardList.getLength(); i++) {
            if (Kanban.tryParseInt(getString(boardList.item(i).getAttributes().getNamedItem("b_id").toString())) == id) {
                boardList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }

    /**
     * VerÃ¤ndert eine Spalte. attr -> Attribut; value -> Wert der geÃ¤ndert
     * werden soll
     *
     * @param id
     * @param attr
     * @param value
     */
    public void editColumn(int id, String attr, String value) {
        columnList = doc.getElementsByTagName("column");

        for (int i = 0; i < columnList.getLength(); i++) {
            if (Kanban.tryParseInt(getString(columnList.item(i).getAttributes().getNamedItem("co_id").toString())) == id) {
                columnList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }

    /**
     * VerÃ¤ndert eine karte. attr -> Attribut; value -> Wert der geÃ¤ndert werden
     * soll
     *
     * @param id
     * @param attr
     * @param value
     */
    public void editCard(int id, String attr, String value) {
        cardList = doc.getElementsByTagName("card");

        for (int i = 0; i < cardList.getLength(); i++) {
            if (Kanban.tryParseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())) == id) {
                cardList.item(i).getAttributes().getNamedItem(attr).setTextContent(value);
                updateXML(xmlPath);
                break;
            }
        }
    }

    /**
     * ÃœberprÃ¼ft eine Spalte ob sie noch Platz hat
     *
     * @param co_id
     * @return true -> frei; false -> belegt
     */
    private boolean checkWip(int co_id) {
        searchedElement = this.searchColumn(co_id);
        wip = Kanban.tryParseInt(searchedElement.getAttribute("wip"));

        NodeList cList = doc.getElementsByTagName("card");

        for (int i = 0; i < cList.getLength(); i++) {

            if (Kanban.tryParseInt(getString(cList.item(i).getAttributes().getNamedItem("co_id").toString())) == co_id) {
                wipCount++;
            }
        }
        if (wip <= wipCount) {
            wipCheck = false;
        } else {
            wipCheck = true;
        }

        return wipCheck;
    }

    /**
     * ÃœberprÃ¼ft ob eine bestimmte Karte auf dem Board bereits vorhanden ist.
     *
     * @param ca_id
     * @return false -> frei; true -> besetzt
     */
    public boolean checkCardAtBoard(int ca_id) {
        isCardOnBoard = false;
        cardList = doc.getElementsByTagName("card");

        for (int i = 0; i < cardList.getLength(); i++) {
            if (Kanban.tryParseInt(getString(cardList.item(i).getAttributes().getNamedItem("ca_id").toString())) == ca_id) {
                isCardOnBoard = true;
                break;
            }
        }

        return isCardOnBoard;
    }

    /**
     * Erstellt ein Board als XML Datei.
     *
     * @param xmlPath
     */
    public void createBoard(String xmlPath) {
        updateXML(xmlPath);
        pk.setB_id();
    }
}
