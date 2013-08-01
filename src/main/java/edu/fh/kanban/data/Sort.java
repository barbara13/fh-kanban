package edu.fh.kanban.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;

/**
 * @author Ghost
 *
 */

public class Sort{
	
	public static List<Card> addIntoList(ArrayList <Card>listCard){
		
		List<Card> card = new ArrayList<Card>();
		
		if(listCard!=null){
			
			Iterator<Card> lit = listCard.iterator();
			while(lit.hasNext()){
				Card c = lit.next();
				
				card.add(new Card(c.getCa_id(),c.getCo_id(),c.getName(),c.getDescription(),c.getEffort(),c.getValue(),c.getBlocker(),
							c.getBlocker_tooltip(),c.getCreatedDate(),c.getStartedDate(),c.getDoneDate()));
			}
			
		}else{
			
			System.out.println("keine Karten vorhanden!");
		}
		return card;
	}
	
		 
	public static List<Card> sortByValue(ArrayList<Card> listCard){
		
		Comparator<Card> comp = new ValueComp();
		List<Card> card = addIntoList(listCard); //Help list
		Collections.sort(card,comp);
		
		return card;
		
	}
	
	public static List<Card> sortByHeadline(ArrayList<Card> listCard){
		
		Comparator<Card> comp = new NameComp();
		List<Card> card = addIntoList(listCard);
		Collections.sort(card,comp);
		
		return card;
		
	}
	
	public static List<Card> sortBySize(ArrayList<Card> listCard){
	
		Comparator<Card> comp = new SizeComp();	
		List<Card> card = addIntoList(listCard);
		Collections.sort(card,comp);
	
		return card;
	
	
}
	

}
