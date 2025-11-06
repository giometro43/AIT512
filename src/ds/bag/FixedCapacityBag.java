package ds.bag;

import java.util.Iterator;
/**
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastillo
 */


/**
 * As the name entails, the class is for the use of defined size of a bag
 * so if the bag is 4 size, only 4 things in there and absolutely no more
 * @param <Item>
 * 
 * Friday Midnight may be okay
 * 
 * Submit 2 files, all code into zip, then word doc with screenshot and answers with 
 * a couple of sentances, then screenshots need to have one name on the screen
 * 
 * 
 * Dont overthink it, 1 pdf including the answers and the screenshots. 
 * 
 * Module 1 until Sunday night 11/9, then module 2 until 11/14
 * 
 * Go to zoom: 
 */
public class FixedCapacityBag<Item> implements Bag<Item> {

	/**
	 * The array of elements that is left in the bag, 
	 */
	private Item[] elements;
	
	/**
	 * the current num of elements that is left inside the bag
	 */
	private int numberOfElements;
	
	/**
	 * makes an empty bag with the given size
	 * @param capacity - the max size of the bag (Capacity is 4, only 4 things)
	 */
	public FixedCapacityBag(int capacity) {
		elements = (Item[]) new Object[capacity];
		numberOfElements = 0;
	}
	
	
	
	
	@Override
	/**
	 * this is the counter to go through all the items in the bag
	 */
	public Iterator<Item> iterator() {
		// we will generate the iterator as a class
		return new Iterator<Item>() {
			int index=0;
		}
	}

	@Override
	/**
	 * bc the bag is fixed in size, we need to check that the bag is not full
	 * it checks if the number of elements equals the same  
	 */
	public void add(Item item) {
		if (numberOfElements == elements.length)
			throw new RuntimeException("Bag is full");
		elements[numberOfElements]=item;
		numberOfElements++;
	}

	@Override
	
	/**
	 * This will return if the number of elements is zero.
	 */
	public boolean isEmpty() {
		
		return numberOfElements==0;
	}

	/**
	 * Just will return the number of elements.
	 */
	@Override
	public int size() {
		return numberOfElements;
	}
	
	
	
}
