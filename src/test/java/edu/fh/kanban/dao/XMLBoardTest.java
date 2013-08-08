/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.dao;

import edu.fh.kanban.data.Board;
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
        
        //cardXml.deleteCard(pkXml.getCa_id()-1);

        
        
    }

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
        createTestXml(instance);
        String xmlPath = "BoardTest";
        instance.loadXML(xmlPath);
        
        assertEquals("BoardTest", xmlPath);
    }

    /**
     * Test of getBoard method, of class XMLBoard.
     */
    @Test
    public void testGetBoard() {
        
        System.out.println("getBoard");
        
        XMLBoard instance = new XMLBoard();
        createTestXml(instance);
        Board expResult = new Board(pkXml.getB_id(), "BoardTest", "#FF0000", "#00FFFF", "#0000FF", "#800080");
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
        createTestXml(instance);
        
        ArrayList expResult = null;
        
        ArrayList result = instance.readSubColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readMainColumns method, of class XMLBoard.
     */
    @Test
    public void testReadMainColumns() {
        System.out.println("readMainColumns");
        XMLBoard instance = new XMLBoard();
        ArrayList expResult = null;
        ArrayList result = instance.readMainColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readCards method, of class XMLBoard.
     */
    @Test
    public void testReadCards() {
        System.out.println("readCards");
        XMLBoard instance = new XMLBoard();
        ArrayList expResult = null;
        ArrayList result = instance.readCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readCardsFromColumn method, of class XMLBoard.
     */
    @Test
    public void testReadCardsFromColumn() {
        System.out.println("readCardsFromColumn");
        int co_id = 0;
        XMLBoard instance = new XMLBoard();
        ArrayList expResult = null;
        ArrayList result = instance.readCardsFromColumn(co_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBoard method, of class XMLBoard.
     */
    @Test
    public void testAddBoard() {
        System.out.println("addBoard");
        String name = "";
        String expedite = "";
        String standart = "";
        String fixedDate = "";
        String intangible = "";
        XMLBoard instance = new XMLBoard();
        instance.addBoard(name, expedite, standart, fixedDate, intangible);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewColumn method, of class XMLBoard.
     */
    @Test
    public void testAddNewColumn() {
        System.out.println("addNewColumn");
        String name = "";
        String wip = "";
        XMLBoard instance = new XMLBoard();
        instance.addNewColumn(name, wip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColumn method, of class XMLBoard.
     */
    @Test
    public void testAddColumn() {
        System.out.println("addColumn");
        String name = "";
        String wip = "";
        XMLBoard instance = new XMLBoard();
        instance.addColumn(name, wip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class XMLBoard.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Element card = null;
        String co_id = "";
        XMLBoard instance = new XMLBoard();
        Element expResult = null;
        Element result = instance.addCard(card, co_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchColumn method, of class XMLBoard.
     */
    @Test
    public void testSearchColumn() {
        System.out.println("searchColumn");
        int co_id = 0;
        XMLBoard instance = new XMLBoard();
        Element expResult = null;
        Element result = instance.searchColumn(co_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchColumns method, of class XMLBoard.
     */
    @Test
    public void testSearchColumns() {
        System.out.println("searchColumns");
        int co_id = 0;
        XMLBoard instance = new XMLBoard();
        Element expResult = null;
        Element result = instance.searchColumns(co_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCard method, of class XMLBoard.
     */
    @Test
    public void testSearchCard() {
        System.out.println("searchCard");
        int ca_id = 0;
        XMLBoard instance = new XMLBoard();
        Element expResult = null;
        Element result = instance.searchCard(ca_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCardToBoard method, of class XMLBoard.
     */
    @Test
    public void testAddCardToBoard() {
        System.out.println("addCardToBoard");
        int ca_id = 0;
        XMLBoard instance = new XMLBoard();
        instance.addCardToBoard(ca_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forwardCard method, of class XMLBoard.
     */
    @Test
    public void testForwardCard() {
        System.out.println("forwardCard");
        int ca_id = 0;
        XMLBoard instance = new XMLBoard();
        instance.forwardCard(ca_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prevCard method, of class XMLBoard.
     */
    @Test
    public void testPrevCard() {
        System.out.println("prevCard");
        int ca_id = 0;
        XMLBoard instance = new XMLBoard();
        instance.prevCard(ca_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCard method, of class XMLBoard.
     */
    @Test
    public void testDeleteCard() {
        System.out.println("deleteCard");
        int ca_id = 0;
        int co_id = 0;
        XMLBoard instance = new XMLBoard();
        instance.deleteCard(ca_id, co_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editBoard method, of class XMLBoard.
     */
    @Test
    public void testEditBoard() {
        System.out.println("editBoard");
        int id = 0;
        String attr = "";
        String value = "";
        XMLBoard instance = new XMLBoard();
        instance.editBoard(id, attr, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editColumn method, of class XMLBoard.
     */
    @Test
    public void testEditColumn() {
        System.out.println("editColumn");
        int id = 0;
        String attr = "";
        String value = "";
        XMLBoard instance = new XMLBoard();
        instance.editColumn(id, attr, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCard method, of class XMLBoard.
     */
    @Test
    public void testEditCard() {
        System.out.println("editCard");
        int id = 0;
        String attr = "";
        String value = "";
        XMLBoard instance = new XMLBoard();
        instance.editCard(id, attr, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewBoard method, of class XMLBoard.
     */
    @Test
    public void testCreateNewBoard() {
        System.out.println("createNewBoard");
        XMLBoard instance = new XMLBoard();
        instance.createNewBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCardAtBoard method, of class XMLBoard.
     */
    @Test
    public void testCheckCardAtBoard() {
        System.out.println("checkCardAtBoard");
        int ca_id = 0;
        XMLBoard instance = new XMLBoard();
        boolean expResult = false;
        boolean result = instance.checkCardAtBoard(ca_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBoard method, of class XMLBoard.
     */
    @Test
    public void testCreateBoard() {
        System.out.println("createBoard");
        String xmlPath = "";
        XMLBoard instance = new XMLBoard();
        instance.createBoard(xmlPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
