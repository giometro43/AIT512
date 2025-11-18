package ds.queue;

import java.util.Iterator;

/**
 * Using a FIFO setup, which makes it so that we can get one person in one person out
 * 
 * 
 * Think of the DMV. Everyones favorite government office.
 * One person walks in, and they are seen first. the next person in comes after them
 * 
 * 
 * Fixed Queue:
 * We will see first come first serve ONLY 4 PEOPLE TODAY. If more then 4 people come in, we will
 * not be seeing them today
 * 
 * 
 * Dynamic Queue: 
 * 
 * We are seeing 4 people at the moment, but if more arrive then we can see them as well. 

 * 
 *
 * Linked List Queue:
 * Each person that comes in is assigned a number, corresponding to themeselves and the number
 * in front of them. We have 4 people in line. Person 4 has a ticket pointing to person 3,
 * etc. If a fifth person comes in they will be the new bottom of the Queue and be assigned that Node
 * We can accomidate new walk ins besides the 4. 
 * 
 * 
 * @param <Item>
 */
public interface Queue<Item> extends Iterable<Item> {
	/**
	 * Module:
	 * Assignment: 
	 * @author gcastillo
	 */
	
	
	/**
	 * Example : When a call center gets a new customer on the line, they add them to the end of the queue
	 * so that is what enqueue does. It adds an item to the end of the queue.
	 *------------------------------------------------------------------------------------------------ 
	 * Add an item at the end of the queue
	 * 
	 * @param item - item thte Item to be added
	 */
	public void enqueue (Item item);
	
	/**Example : when a call center finishes with a customer, they take the next customer in line
	 * so that is what dequeue does. It removes the next item in line and returns it. 
	 * 
	 * What does returning mean? : When you call a function/method, you can have it give you something back
	 * . So when you dequeue, you are asking the queue to give you back the next item in line
	 * -------------------------------------------------------------------------------------------------
	 * Remove and return the item from the beginning of the queue
	 * 
	 * @return - the next item in the queue (from the beginning 
	 */
	public Item dequeue();
	
	/**
	 * the number of elements in the queue is named the size of the queue
	 * 
	 * @return the size of the queue
	 */
	public int size();
	
	/**
	 * Check if the queue is empty (no elements in the queue)
	 * 
	 * @return true if the queue is empty, false otherwise.
	 */
	default boolean isEmpty() {
		return size() == 0;
	}
	
	default public String toString(String start, String end, String separator) {
		
		String result  = start;
		boolean needSeparator = false;
		for (Item item : this) {
			if (needSeparator) {
				result += separator;
			}
			result += item.toString();
			needSeparator = true;
		}
		 result += end;
		 return result;
		
	}
}


