package ds.stack;

import java.util.Iterator;

/**
 * a fixed size stack has the specified maximum capacity
 * when full new elements cannot be added ( plate can only hold 5 hotcakes)
 * it will throw a error if a push is called ( 6 throws error)
 * @version 1 
 * @param <Item>
 */
public class FixedCapacityStack <Item> implements Stack<Item>{

	/**
	 * Module: 1 - Bags, Stacks and Queues
	 * Assignment: A21-PA1 Fixed Capacity Stack
	 * @author gcastil9@gmu.edu */

	
	
	
	/**
	 * Goes bottom up, last in first out
	 * 
	 */
	@Override
	public Iterator<Item> iterator() {
		
		// we will generate the iterator as a class
		return new Iterator<Item>() {
			int index=0;// goes through all elements of bag

		
			// is there a next element? There is a next element if the index of the next element is less than the number of elements
			// example: if there are 3 elements, index 0,1,2 are valid, 3 is. if the stack is empty the index is zero, the num of elements is 0 then return 
			// false. works since index starts at 0 and the num of elements starts at 1
			@Override
			public boolean hasNext() {
				return index	<	numberOfElements;//check if the index is not yet arriving at the number of elements
			}

			
			//we need to check if the stack has next element then we return the element at the index position then we incrememnt the index to go to the next
			// element. if there are no more elements, we throw a runtime exception error.
			
			// laymens terms example: if there are 3 pancakes, index 0,1,2 are valid, 3 is not. 
			//if the stack is empty the index is zero, the num of elements is 0 then return
			// if index is 1 and num of elements is 3, we have next element, return element at index 1, then increment index to 2
			
			@Override
			public Item next() {
				//checks if there are more elements to iterate over

				// if our index is not yet arriving at the num of elements, its less than
				// it will return the elements in our bag 1 by 1
				
				if (hasNext()) return elements[index++]; //  if we have next element, we return the element as a current index
				// and increment the index ( add to it, to go to the next element ) 
				// if no next element, throw runtime exception 
				throw new RuntimeException(" No more Elements in the stack LOL...");
				
			}
		};
		
		
		
	}

	@Override
	public void push(Item item) {
		// TODO Auto-generated method stub
		
		/**
		 * First we need to check if the stack is full, if full then we cannot add.
		 * 
		 * so if the number of elements is equal to the capacity of the stack ( the length of the array)
		 * 
		 * that means the stack is full, we throw a runtime exception error
		 * 
		 * if not, that means we have space to add a new element
		 * then we add the item at the index of number of elements
		 * 
		 * we put on the next position which is the elements[numberOfElements]
		 * we put the items that we recieved and we increment the number of elements by one
		 * because we occupied one more position in the stack so we do numberOfElements++
		 * 
		 * this way we add a new item to the stack
		 * 
		 * 
		 */
		if (numberOfElements == elements.length) {
			throw new RuntimeException(" Stack is full, cannot push more items");
		}
		else if (numberOfElements < elements.length)
		{ elements[numberOfElements++] = item; // add the item at the current number of elements index, then increment the number of elements
		}
	}
	
	/**
	 * To take an element off the stack, we need to check if the stack is empty first
	 * 
	 * 
	 * if the stack is empty, we cannot pop any items, we throw a runtime exception error
	 * 
	 * if not empty, we decrement the number of elements first, since we are removing one
	 * then we get the top item which is at the index of numberOfElements
	 * 
	 * we remove the reference to the popped item for garbage collection (garbage collection is when the system cleans up memory that is no longer used)
	 * 
	 * finally we return the popped item
	 * 
	 * Laymens terms line by line:
	 * check if stack is empty, if empty throw error
	 * decrement number of elements since we are removing one
	 * get the top item at the index of numberOfElements
	 * remove reference to popped item for garbage collection
	 * return the popped item
	 */
	@Override
	public Item pop() {
		if (numberOfElements == 0) {
			throw new RuntimeException(" Stack is empty, cannot pop any items");
		}
		numberOfElements--;
		Item top = elements[numberOfElements]; 
		elements[numberOfElements] = null; // remove reference for garbage collection, we dont delete things in java
		// when something is no longer referenced, the garbage collector will auto get rid of the particular structure
		// to get rid of something, that structure must not be used somewhere else
		return top; 
		
		
	}
	
	
	/**
	 * returns the current size of the stack,
	 * the number of elements currently in the stack.
	 * 
	 * @return size of the stack. similar with the bag size method
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}
/**
*the array of elements stored in a stack  ( pancake 1 2 3 etc)
* DEFINITION OF ARRAY TYPE, DATA TYPE then ARRAY NAME.
*/
private final Item[] elements;	
	
/**
 * 
 * the current number of elements stored in a stack
 *  AKA the size of the stack
 * 
 * if there are 3 pancakes, number is 3, after array defined
 */
private int numberOfElements;
	
/**
 * 
 * CONSTRUCTOR
 * creates an empty stack with the given capacity
 * 
 * so we say 4, only 4 fit. defining the size of the plate
 * 
 * @param capacity - max capacity of the stack
 */
@SuppressWarnings("unchecked") 
// to create a stack, we create a new array of objects
// we cast the array of objects to the array of items
public FixedCapacityStack(int capacity) {
	elements = (Item[]) new Object [capacity];
	numberOfElements = 0;
}




}

