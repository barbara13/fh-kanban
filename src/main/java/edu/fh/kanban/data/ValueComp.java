/**
 * 
 */
package edu.fh.kanban.data;

import java.util.Comparator;

/**
 * @author Ghost
 *
 */
public class ValueComp implements Comparator<Card> {

	@Override
	  public int compare(Card c1, Card c2) {
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
	    
	  }

}
