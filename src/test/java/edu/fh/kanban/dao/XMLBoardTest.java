/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Element;

/**
 *
 * @author Malte
 */
public class XMLBoardTest {
           
    private XMLBoard boardXml = new XMLBoard();  
    private XMLCard cardXml = new XMLCard();   
    private XML_Pk pkXml = new XML_Pk();
    public XMLBoardTest() {
    }
    /*
    public void createTestXml(XMLBoard boardXml){

        cardXml.addCard("card1", "Beschreibung", "5", "Standart", "false", "Text");
        pkXml.setCa_id();
        cardXml.createCard();
        
        boardXml.addBoard("BoardTest", "#FF0000", "#00FFFF", "#0000FF", "#800080");
        boardXml.addColumn("Next", "100");
        boardXml.addNewColumn("Column1", "2");
        boardXml.addColumn("Done", "100");
        
        boardXml.createBoard("BoardTest.xml");
        boardXml.loadXML("BoardTest.xml");
        

        boardXml.addCardToBoard(46);
        
        boardXml.createBoard("BoardText.xml");
        
        
        
    }
    */
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadXML method, of class XMLBoard.
     */
    @Test
    public void testLoadXML() {
        
        System.out.println("loadXML");
        
        XMLBoard instance = new XMLBoard();
        String xmlPath = "BoardTest.xml";
        instance.loadXML(xmlPath);
        
        assertEquals("BoardTest.xml", xmlPath);
    }

    /**
     * Test of getBoard method, of class XMLBoard.
     */
    @Test
    public void testGetBoard() {
        
        System.out.println("getBoard");
        
        XMLBoard instance = new XMLBoard();
        
        instance.loadXML("BoardTest.xml");
        
        Board expResult = new Board(999, "BoardTest", "#FF0000", "#00FFFF", "#0000FF", "#800080");
        Board result = instance.getBoard();

        assertTrue(expResult.getB_id() == result.getB_id());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getExpedite(), result.getExpedite());
        assertEquals(expResult.getFixedDate(), result.getFixedDate());
        assertEquals(expResult.getIntangible(), result.getIntangible());
        assertEquals(expResult.getStandart(), result.getStandart());

    }


    /**
     * Test of readSubColumns method, of class XMLBoard.
     */
    @Test
    public void testReadSubColumns() {
        System.out.println("readSubColumns");
        
        XMLBoard instance = new XMLBoard();
        instance.loadXML("BoardTest.xml");
        
        ArrayList <Column> expResult = new ArrayList();
        expResult.add(new Column(995, 999, "Next", 100));
        expResult.add(new Column(997, 999, "Do", 2));
        expResult.add(new Column(998, 999, "Done", 100));
        expResult.add(new Column(999, 999, "Done", 100));
        
        ArrayList <Column> result = instance.readSubColumns();
        
        for(int i = 0; i < expResult.size(); i++){
            assertTrue(expResult.get(i).getCo_id() == result.get(i).getCo_id());
            assertTrue(expResult.get(i).getB_id() == result.get(i).getB_id());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertTrue(expResult.get(i).getWip() == result.get(i).getWip());
        }
    }

    /**
     * Test of readMainColumns method, of class XMLBoard.
     */
    @Test
    public void testReadMainColumns() {
        System.out.println("readMainColumns");
        XMLBoard instance = new XMLBoard();
        instance.loadXML("BoardTest.xml");
        
        ArrayList <Column> expResult = new ArrayList();
        expResult.add(new Column(996, 999, "Column1", 2));
        
        ArrayList <Column> result = instance.readMainColumns();
        
        for(int i = 0; i < expResult.size(); i++){
            assertTrue(expResult.get(i).getCo_id() == result.get(i).getCo_id());
            assertTrue(expResult.get(i).getB_id() == result.get(i).getB_id());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertTrue(expResult.get(i).getWip() == result.get(i).getWip());
        }
    }

    /**
     * Test of readCards method, of class XMLBoard.
     */
    @Test
    public void testReadCards() {
        System.out.println("readCards");
        XMLBoard instance = new XMLBoard();
        instance.loadXML("BoardTest.xml");
        
        ArrayList <Card> expResult = new ArrayList();
        expResult.add(new Card(46, 995, "card1", "Beschreibung", 5, "Standart", "false", "Text", "08.08.2013 13:37:20", "08.08.2013 15:12:25", ""));
       
        ArrayList <Card> result = instance.readCards();
               
        for(int i = 0; i < expResult.size(); i++){
            assertTrue(expResult.get(i).getCo_id() == result.get(i).getCo_id());
            assertTrue(expResult.get(i).getCa_id() == result.get(i).getCa_id());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getDescription(), result.get(i).getDescription());
            assertTrue(expResult.get(i).getEffort() == result.get(i).getEffort());
            assertEquals(expResult.get(i).getValue(), result.get(i).getValue());
            assertEquals(expResult.get(i).getBlocker(), result.get(i).getBlocker());
            assertEquals(expResult.get(i).getBlocker_tooltip(), result.get(i).getBlocker_tooltip());
            assertEquals(expResult.get(i).getStartedDate(), result.get(i).getStartedDate());
            assertEquals(expResult.get(i).getCreatedDate(), result.get(i).getCreatedDate());
            assertEquals(expResult.get(i).getDoneDate(), result.get(i).getDoneDate());
        }
    }

    /**
     * Test of readCardsFromColumn method, of class XMLBoard.
     */
    @Test
    public void testReadCardsFromColumn() {
        System.out.println("readCardsFromColumn");
        int co_id = 995;
        XMLBoard instance = new XMLBoard();
        instance.loadXML("BoardTest.xml");
        
        ArrayList <Card> expResult = new ArrayList();
        expResult.add(new Card(46, 995, "card1", "Beschreibung", 5, "Standart", "false", "Text", "08.08.2013 13:37:20", "08.08.2013 15:12:25", ""));
        
        ArrayList <Card> result = instance.readCardsFromColumn(co_id);
               
        for(int i = 0; i < expResult.size(); i++){
            assertTrue(expResult.get(i).getCo_id() == result.get(i).getCo_id());
            assertTrue(expResult.get(i).getCa_id() == result.get(i).getCa_id());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getDescription(), result.get(i).getDescription());
            assertTrue(expResult.get(i).getEffort() == result.get(i).getEffort());
            assertEquals(expResult.get(i).getValue(), result.get(i).getValue());
            assertEquals(expResult.get(i).getBlocker(), result.get(i).getBlocker());
            assertEquals(expResult.get(i).getBlocker_tooltip(), result.get(i).getBlocker_tooltip());
            assertEquals(expResult.get(i).getStartedDate(), result.get(i).getStartedDate());
            assertEquals(expResult.get(i).getCreatedDate(), result.get(i).getCreatedDate());
            assertEquals(expResult.get(i).getDoneDate(), result.get(i).getDoneDate());
        }
    }


}
