
package edu.fh.kanban.data;

import java.util.Comparator;

/**
 * @author Ghost
 *
 */
public class NameComp implements Comparator<Card>{

	@Override
	  public int compare(Card c1, Card c2) {
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

}
