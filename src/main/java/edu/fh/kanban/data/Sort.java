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

public abstract class Sort implements Comparator<Card>{
		
	public static List<Card> addIntoList(ArrayList <Card>slist){
		
		List<Card> card = new ArrayList<Card>();
		
		if(slist!=null){
			
			Iterator<Card> lit = slist.iterator();
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
	
		 
	public static List<Card> sortByValue(ArrayList<Card> slist){
		
		Comparator<Card> comp = new ValueComp();
		List<Card> card = addIntoList(slist); //Help list
		Collections.sort(card,comp);		
	
		return card;		
	}
	
	public static List<Card> sortByHeadline(ArrayList<Card> slist){
		
		Comparator<Card> comp = new NameComp();
		List<Card> card = addIntoList(slist);
		Collections.sort(card,comp);
		
		return card;		
	}
	
	public static List<Card> sortBySize(ArrayList<Card> slist){
	
		Comparator<Card> comp = new SizeComp();	
		List<Card> card = addIntoList(slist);
		Collections.sort(card,comp);
	
		return card;	
	}
	
	/*public int sizecomp(Card c1, Card c2) {
		    int x=0;
			if (Integer.parseInt(c1.getValue()) == Integer.parseInt(c2.getValue())) {
		      x= 0;										
		    }
			else if (Integer.parseInt(c1.getValue()) < Integer.parseInt(c2.getValue())) {		
		      x= -1;									
		    }
			else if (Integer.parseInt(c2.getValue()) > Integer.parseInt(c2.getValue())) {
		      x= 1;										
		    }
		    return x;
			}
	
	public int namecomp(Card c1, Card c2) {
		    if (c1.getName() == null && c2.getName() == null) {
		      return 0;							
		    }
		    if (c1.getName() == null) {
		      return 1;							
		    }
		    if (c2.getName() == null) {
		      return -1;						
		    }
		    return c1.getName().compareTo(c2.getName());
		  }
	

		  public int valuecomp(Card c1, Card c2) {
		    int x=0;
			if (c1.getEffort() == c2.getEffort()) {
		      x= 0;									
		    }
			else if (c1.getEffort() < c2.getEffort()) {
		      x= -1;									
		    }
			else if (c2.getEffort() > c2.getEffort()) {
		      x= 1;										
		    }
		    return x;
		    
		  }*/
	}

