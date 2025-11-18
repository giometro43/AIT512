package ds.queue;

import java.util.Iterator;

/**
 * Using a FIFO setup, which makes it so that we can get one person in one person out
 * 
 * @param <Item> - Generic type parameter for the Queue
 */
public class FixedCapacityQueue<Item> implements Queue<Item> {
	
	
	/**
	 * Line by line:
	 * 1. Declare an array of Items called elements to hold the queue elements.
	 * 2. Declare an integer numberOfElements to track the number of elements in the
	 * queue.
	 * 3. Declare an integer startIndex to track the index of the front of the
	 * queue.
	 * 4. Declare an integer endIndex to track the index of the end of the
	 * queue.
	 * ----------------------------------------------------------------------------*/
	
	private final Item[] elements;
	
	private int numberOfElements;
	
	private int startIndex;
	
	private int endIndex;
	
	
	/**
	 * Constructor that initializes the FixedCapacityQueue with a specified capacity.
	 * @param capacity - the maximum number of elements the queue can hold
	 * ------------------------------------------------------------------------------
	 *Line by line:
	 * 1. Create a new array of Items with the specified capacity and assign it to
	 * the elements array.
	 * 2. Initialize numberOfElements to 0, indicating that the queue is initially
	 * empty.
	 * 3. Initialize startIndex to 0, indicating the front of the queue.
	 * 4. Initialize endIndex to 0, indicating the end of the queue	 */
	public FixedCapacityQueue(int capacity) {
		elements = (Item[]) new Object[capacity];
		numberOfElements = 0;
		startIndex = -1;
		endIndex = -1;
	}
	
	
	
	/**
	 * Example : When a call center gets a new customer on the line, they add them to the end of the queue
	 * so that is what enqueue does. It adds an item to the end of the queue.
	 *------------------------------------------------------------------------------------------------ 
	 * Add an item at the end of the queue
	 * 
	 * @param item - the Item to be added,
	 * -----------------------------------------------------------------------------------------------
	 * Line by Line:
	 * 1. Check if the queue is full by comparing numberOfElements with the length
	 * of the elements array. If they are equal, throw a RuntimeException
	 * indicating that the queue is full.
	 * 2. If the queue is empty (numberOfElements is 0), set
	 * startIndex and endIndex to 0.
	 * 3. If the queue is not empty, increment endIndex by 1.
	 * 4. If endIndex reaches the length of the elements array, wrap it around to 0
	 * (circular behavior).
	 * 5. Assign the new item to the elements array at the position indicated by
	 * endIndex.
	 * 6. Increment numberOfElements to reflect the addition of the new item.*/
	@Override
	public void enqueue(Item item) {
		System.out.println();//task 1
		// TODO Auto-generated method stub
		if (numberOfElements == elements.length) {
			throw new RuntimeException("Queue is full");
		}
		if (numberOfElements == 0) {
			startIndex = 0;
			endIndex = 0;
		} else {
			endIndex++;
			if ( endIndex == elements.length) {
				endIndex = 0;
			}
			
		}
		elements[endIndex] = item;
		numberOfElements++;
		
	}
	/**Dequeue Method that removes and returns the item from the beginning of the queue.
	 * @return - the next item in the queue (from the beginning
	 * 
	 * -----------------------------------------------------------------------------------------------
	 * Line by Line:
	 * 1. Check if the queue is empty by verifying if numberOfElements is
	 * 0. If it is, throw a RuntimeException indicating that the queue is empty.
	 * 2. Store the item at the position indicated by startIndex in a variable
	 * called item.
	 * 3. Set the position in the elements array at startIndex to null to help
	 * with garbage collection.
	 * 4. Decrement numberOfElements to reflect the removal of the item.
	 * 5. If the queue is now empty (numberOfElements is 0),
	 * set startIndex and endIndex to -1.
	 * 6. If the queue is not empty, increment startIndex by 1.
	 * 7. If startIndex reaches the length of the elements array, wrap it around
	 * to 0 (circular behavior).
	 * 8. Return the stored item.*/
	@Override
	public Item dequeue() {
		
		// TODO Auto-generated method stub
		System.out.println();//task 1
		if (numberOfElements == 0) {
			throw new RuntimeException ("Queue is empty");
		}
		Item item = elements[startIndex];
		elements[startIndex] = null; 
		numberOfElements--;
		if (numberOfElements == 0) {
			startIndex = -1;
			endIndex = -1;
		} else {
			startIndex++;
			if (startIndex == elements.length)
				startIndex = 0;
		}
		return item;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}
	
	
	/**
	 *  Iterator for the FixedCapacityQueue that iterates over the elements in the queue.
	 *  
	 * @return - an Iterator for the FixedCapacityQueue
	 * 
	 * -----------------------------------------------------------------------------------------------
	 * Line by Line:
	 * 1. Create and return a new Iterator<Item> instance.
	 * 2. Declare an integer variable nextItem initialized to startIndex to track
	 * the next item to be returned.
	 * 3. Implement the hasNext() method to check if there are more items in
	 * the queue by verifying if nextItem is not -1.
	 * 4. Implement the next() method to return the next item in the queue:
	 *   a. If nextItem is -1, throw a RuntimeException indicating that there
	 *   are no more items in the queue.
	 *   b. Store the item at the position indicated by nextItem in a variable
	 *   called item.
	 *   c. If nextItem is equal to endIndex, set nextItem to -1 
	 *   to indicate that there are no more items.
	 *   d. If nextItem is not equal to endIndex, increment nextItem by 1.
	 *   If nextItem reaches the length of the elements array, wrap it around
	 *   to 0 (circular behavior).
	 *   e. Return the stored item.
	 *   
	 */
	public Iterator <Item> iterator() {
		return new Iterator<Item>() {
			int nextItem = startIndex;
			@Override
			public boolean hasNext() {
				return nextItem != - 1;
			}
			@Override
			public Item next() {
				if (nextItem == -1) {
					throw new RuntimeException ("No more items in the queue");
				}
				Item item = elements [nextItem];
				if (nextItem == endIndex) {
					nextItem =-1;
				} else {
					nextItem++;
					if (nextItem == elements.length)
						nextItem = 0;
				}
				return item;
			}
		};
	}
	/**
	 * Module: 1 - Queues
	 * Assignment: A21-PA2 Fixed Capacity Queue
	 * @author gcastillo
	 */

/**
 * tasks:
Perform these tasks based on these videos, do not include elements from other videos. 
The program will be modified in future assignments. 
Task 1: Implement the files as described in the last video with the following modifications:
In the class TestQueues, modify the method testEnqueueItem() and testDequeueItem() 
to add an empty line before any other message.
Modify TestQueues class to print at the beginning of the test the message 
(where you replace my name with your name):
Fixed Capacity Queue - Task 1 - by Mihai Boicu

Test and debug your program
EXECUTION PDF: increase the size of the output area (maximize), 
add two screenshots of the execution showing the beggining and the end of the output.
ANSWERS PDF: Provide an example where a fixed capacity queue must be used, 
explain why and why a fixed capacity bag or stack cannot (or is not recommended to) be used, 
explain why (paragraph answer)
Task 2: Test with Integers
In the class TestQueues, create a method testWithStrings(), 
and move all the current content of the main method in this method. Call this method in the main method.
In the class TestQueues, create a method testWithIntegers(), and create a similar test with the string test,  but using Integers. Call the method in the main method.
Modify TestQueues class to print at the beginning of the test the message (where you replace my name with your name):
Fixed Capacity Queue - Task 2 - by Mihai Boicu
 */
	

	
}


