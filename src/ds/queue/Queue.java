package ds.queue;


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
}


