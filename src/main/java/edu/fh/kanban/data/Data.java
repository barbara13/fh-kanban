/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fh.kanban.data;

import edu.fh.kanban.dao.XMLBoard;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Data {
    private XMLBoard board;
    private int id = 0;
    
    private ArrayList <Board> listBoard;
    private ArrayList <Column> listColumn;
    private ArrayList <Card> listCard;
    
    public ArrayList<Column> getListColumn() {
		return listColumn;
	}

	public ArrayList<Card> getListCard() {
		return listCard;
	}

	public Data(XMLBoard b){
        board = b;
    }
    
    public int getData(String type, String attr, String value){
        
        if(type.equals("board")){
            listBoard = board.readBoard();
            
            for(int i = 0; i < listBoard.size(); i++){
                if(attr.equals("b_id")){
                    if(listBoard.get(i).getB_id() == Integer.parseInt(value)){
                        id = listBoard.get(i).getB_id();
                    }
                } else if(attr.equals("name")){
                    if(listBoard.get(i).getName().equals(value)){
                        //id 
                    }
                } else if(attr.equals("color")){
                    
                }
            }
        } else if(type.equals("column")){
            listColumn = board.readSubColumns();
        } else if(type.equals("card")){   
            listCard = board.readCards();
        }
        return id;
    }
}
