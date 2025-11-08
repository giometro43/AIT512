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
			int index=0;// goes through all elements of bag

			// implements (right clicks the interface Iterator) all the methods from
			// Iterator
			@Override
			public boolean hasNext() {
				return index<numberOfElements;//check if the index is not yet arriving at the number of elements
			}

			@Override
			public Item next() {
				//checks if there are more elements to iterate over

				// if our index is not yet arriving at the num of elements, its less than
				// it will return the elements in our bag 1 by 1
				
				if (hasNext()) return elements[index++]; //  if we have next element, we return the element as a current index
				// and increment the index ( add to it, to go to the next element ) 
				// if no next element, throw runtime exception 
				throw new RuntimeException(" No more Elements lol...");
				
			}
		};
	}

	
	/*
	
	OVERWRITTEN SINCE WE MADE DEFAULT IN THE BAG INTERFACE!!

	//method to display the elements, the two string method. to generate the nice format
	@Override
	public String toString() {
		System.out.println("Fixed Capacity Bag - Task 3 - by Giovanni Castillo");
		String result = "["; // to break the elements
		
		String seperator =""; // required because without it, formatting will be off and
		// it will make it so that we leave a space after the ending break of the bag.
		 
		String comma = ","; //task 3
		//takes all the elements from the bag, 
		for (int i = 0; i < numberOfElements; i++) {// first element on position zero,
			// will go to the number of elements, go element by element
			//then add to the result the current element.
			result += seperator + elements[i].toString()+ ""; // string representation of the element
			if(i < numberOfElements - 1 ) result += comma; // TASK 3
			
			seperator = " ";
		}
			// at the end we close with another break.
			result+= "]"; // at the end we break it again
			return result;
			
			
			
		}
	
	OVERWRITTEN SINCE WE MADE DEFAULT IN THE BAG INTERFACE
	*/
	public String toString() {
		return toString ("[", "]", ",");
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
	
	
	/**
	 * TASK 2b: checks if is singleton, return true. 
	 */
	public boolean isSingleton() {
		
		// checks and returns true if it has 1 element exact. 
		System.out.println("Capacity Bag - Task 2 - by Giovanni Castillo");

		return numberOfElements ==1;
		
	}
	
	
}
