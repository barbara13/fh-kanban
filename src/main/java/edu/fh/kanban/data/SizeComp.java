package edu.fh.kanban.data;

import java.util.Comparator;

/**
 * @author Ghost
 *
 */
public class SizeComp implements Comparator<Card>{

	@Override
	  public int compare(Card c1, Card c2) {
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
}