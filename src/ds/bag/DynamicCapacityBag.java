package ds.bag;

import java.util.Iterator;
/**
 * A bag with a dynamic capacity. the capacity (space) is modified based on the current number of elements (things)
 * ( So if the space was 5 things, then the item count is 6, the new space is 6)
 */
/**
 * Module: 1 Bags, Stacks and Queues
 * Assignment: A12-PA Dynamic Capacity Bag
 * @author gcastil9@gmu.edu
 */

/**
 * A12-PA Dynamic Capacity Bag
 * 
 * Task 1:
 * Implement the files as described in the last video with the following modifications.
 * In the package ds.bag define the class implementation DynamicCapacityBag as described in the video.
 * Modify the Javadoc and inline comments to express the functionality in your own words.
 * Modify TestBags class, delete the method testFixedCapacityBag() with no parameters, that is no longer used.
 * Modify TestBags class, add the method testDynamicCapacityBag() with 5 parameters, similar to testFixedCapacityBag with 5 parameters, 
 * but test a dynamic capacity bag starting with a bag with the capacity of 2.
 * Modify TestBags class, in the main call the tests for dynamic capacity bag.
 * Modify TestBags class to print at the beginning of the test the message:
 * Dynamic Capacity Bag - Task 1 - by Giovanni Castillo.
 * Test and debug your program.
 * EXECUTION PDF: add a screenshot of the execution.
 * ANSWERS PDF: Are we testing the dynamic nature of the new bag implementation? Justify in a short paragraph.
 * 
 * Task 2:
 * Default implementations for isEmpty and isSingleton.
 * Modify Bag interface and add a default implementation for isEmpty based on the size method.
 * Use the default keyword to indicate a default implementation in the interface.
 * Use size() to get the number of elements in the bag and compare it with zero, returning the result.
 * Modify Bag interface again to add a default implementation for isSingleton based on the size method.
 * Delete the implementations of isEmpty and isSingleton from both FixedCapacityBag and DynamicCapacityBag classes.
 * Modify TestBags class to update testDynamicCapacityBag() so it also tests isEmpty in the same places where isSingleton is tested.
 * Modify TestBags class to print at the beginning of the test the message:
 * Dynamic Capacity Bag - Task 2 - by Giovanni Castillo.
 * Test and debug your program.
 * EXECUTION PDF: add a screenshot of the execution.
 * ANSWERS PDF: Can we have a default implementation for the method size? Why or why not? (short paragraph)
 * 
 * Task 3:
 * Default implementation for hasDouble, a method to test if there is any element duplicated in the bag (appears twice or more times).
 * Modify Bag interface to add a default implementation for hasDouble.
 * Modify TestBags class to update testDynamicCapacityBag() so it also tests hasDouble in the same places where isSingleton is tested.
 * Add a new test case where the first and the third elements are the same.
 * Modify TestBags class to print at the beginning of the test the message:
 * Dynamic Capacity Bag - Task 3 - by Giovanni Castillo.
 * Test and debug your program.
 * EXECUTION PDF: add a screenshot of the execution.
 * ANSWERS PDF: Is the default implementation efficient? Why or why not? How can it be improved? (short paragraph)
 * 
 * 
::::::------::::::::::::::::::THE CHAMPS!
:::::-@@@@@@+:::::::::::::::::
::::::=+@@#=-:::::::::::::::::
:::::::-@@+:::::::::::::::::::
:::::::=@@*::=%%%#::::::::::::
:::::::-@@+::%@@@@+:::::::::::
:::::::-@@*:=@@*%@%:::::::::::
:::::::=@@*:#@@:*@@=::::::::::
:::::::-@@+-@@*::@@%:+%%-:::::
:::::-+*@@#%@@#**%@@*%@@-:::::
:::::-@@%%@@@@@@@@@@@%%%-:::::
::::::::::*@@-::::*@@-::::::::
:::::::-++@@@+=::=*@@%+=::::::
:::::::-@@@@@@*:-@@@@@@#::::::
::::::::-------::-------::::::
 */

public class DynamicCapacityBag<Item> implements Bag<Item> {

	
	/**
	 * The array of elements that is left in the bag, 
	 */
	private Item[] elements; // Item is the data type, elements is the array name
	
	
	
	/**
	 * the current num of elements that is left inside the bag
	 */
	private int numberOfElements;
	
	
	//Constructor that will receive the initial capacity as a parameter, this param will reflect the size of the array of elements when the bag is created
	
	/**
	 * Creates the bag with a specific initial capacity
	 * @param initialCapacity - the initial capacity of the bag.
	 */
	public DynamicCapacityBag(int initialCapacity) {
		elements = (Item[]) new Object [initialCapacity];
		numberOfElements = 0;
		
	}
	@Override
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

	@Override
	public void add(Item item) { 
		if(numberOfElements==elements.length) // we will look at the end off the bag (bag is full) if so, double capacity
			doubleCapacity();
		
		
		//since we have enough space to add the item (after doubling size) we can add to the current elements any new items and also increment the 
		// number of elements
		elements[numberOfElements++]= item;
		
		
	}
	
	
	/**
	 * Doubles the capacity of the current bag.
	 */
	@SuppressWarnings("unchecked")
	private void doubleCapacity() { // private method to create a new array of items, that has a size double the length of the original array
		//we will copy in this new array all of the elements in the previous array, we will use for loop
		//copying element by element using the for index
		
		//initialCapacity * 2; that is wrong since we are trying to increase the Item[] size
		
		Item[] newElements = (Item[]) new Object[elements.length*2]; // new array, will have the size double the length of the original
		
		
		//for loops go initialization, condition, update
		for (int i=0; i< elements.length; i++) { // index of zero, when index is greater than orig array, increment
			newElements[i] = elements[i]; // copy in this new array, all the elements in the previous array
		}
		elements = newElements; //at the end we update the elements field to keep the new array that was created.
		
		// SYNOPSIS: we create a new array, we make the size of the NEW array elements length times 2
		// we use a for loop to see that once the index is greater than the length of the original array, we copy the values of the old array onto the new
		// after that, we take this new array with the old items and double the size, and overwrite the old array with the new values. 
		
	}
	
	
	@Override
	public boolean isEmpty() {
		//compare the number of elements with zero, similar with fixed,
		return numberOfElements==0;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public int size() {
		//returns the number of elements
		return numberOfElements;
	}
	
	
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
	



}

