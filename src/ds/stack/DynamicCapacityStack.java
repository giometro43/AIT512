package ds.stack;

/*
 * Tasks:

Perform these tasks based on these videos, do not include elements from other videos. 
The program will be modified in future assignments. However, the TestStack must continue the previous homework file (testing also the pop method).  

Task 1: Implement the files as described in the last video with the following modifications:

Modify the class TestStacks as described in the video, to call the  test for a dynamic capacity stack.
Modify TestStacks class to print at the beginning of the test the message (where you replace my name with your name):
Dynamic Capacity Stack - Task 1 - by Mihai Boicu
Test and debug your program
EXECUTION PDF: increase the size of the output area (maximize), add two screenshots of the execution showing the beginning and the end of the output.
ANSWERS PDF: Provide an example where a dynamic capacity stack must be used and explain why all the other  
learned  data structures are not applicable (e.g., fixed capacity stack or  dynamic capacity bag). (paragraph answer)
Task 2: Generalize Test Stacks
2.a. In the class TestStacks, modify the method testPushItem() to work for a generic type Item 
Solution: 2a solution
2.b. In the class TestStacks, modify the method testPopItem() to work for a generic type Item 
Solution: 2b solution
2.c. In the class TestStacks, modify the method testStringStack() to be named testStack() 
and receive a stack, an array  of items to  be pushed and the number of items to be  popped after that.
Solution: 2c solution
2.d. In  the class TestStacks,  modify the main method to perform the previous test, but calling the new testStack()
Solution: 2d solution
2.e. Add a new test for a stack of integers, with the values 1,4,7,9,2,4,3,5 and popping 9 values.
Solution: 2e solution
2.f. Modify TestStacks class to print at the beginning of the test the message (where you replace my name with your name):
Dynamic Capacity Stack - Task 2 - by Mihai Boicu
Test and debug your program

 */

import java.util.Iterator;
/**
 * A stack with dynamic capacity. the capacity is increased based on THE CURRENT NUMBER OF ELEMENTS
 * it may increase or decrease as needed.
 * 
 * Ex. Decrease: if we have 16 elements and we pop 9 elements, we are left with 7 elements. --> we can decrease the capacity to 8
 * Ex. Increase: if we have 8 elements and we push one more element, we need to increase the capacity to 16
 * 
 * @version 1
 * @param <Item> - the type of elements stored in the stack, generic type called Item
 */
public class DynamicCapacityStack <Item> implements Stack<Item>{
	
	/**
	 * array to store stack elements. Example: pancakes
	 */
	private Item[] elements; 
	/**
	 * number of elements in the stack, Example: number of pancakes in the stack
	 */
	private int numberOfElements; 
	
	/**
	 * Creates a stack with a designated initial size
	 * ------------------------------------------------------
	 * @param initalCapacity - the starting size of the stack
	 */
	@SuppressWarnings("unchecked")
	public DynamicCapacityStack(int initalCapacity) {
		elements = (Item []) new Object [initalCapacity]; //the array to store the stack elements. Originally of type Object, casted to Item[]
		numberOfElements =0;
	}
	/**
	 * Creates a stack with a default initial size of 10
	 * ------------------------------------------------------
	 * 	LINE BY LINE:
	 * creates a stack with initial capacity of 10 by using this.
	 * 
	 *  the this keyword refers to the current object instance within a class.
	 */
	public DynamicCapacityStack() {
		this(10);
	}
	/**
	 * Doubles the capacity of the stack when needed.
	 * ------------------------------------------------------
	 * AKA:
	 * when the stack is full, we need to create a new array with double the size. (newElements)
	 * we copy all the elements from the old array to the new array (elements to newElements)
	 * we update the reference of elements to point to the new array (newElements)
	 * 
	 * 
	 */
	private void doubleCapacity() {
		Item [] newElements = (Item []) new Object [elements.length * 2]; 
		for (int i =0; i< numberOfElements; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	/**
	 * Halves the capacity of the stack when needed.
	 * ------------------------------------------------------
	 * LINE BY LINE:
	 * if the stack is more than half full then we can't half the capacity
	 * because we may lose elements.
	 * 
	 * 
	 * 
	 * when the stack (elements array)
	 * is one half full, we need to create a new array with half the size. (newElements)
	 * we copy all the elements from the old array to the new array (elements to newElements)
	 * we update the reference of elements to point to the new array (newElements)
	 * 
	 * 
	 * if the stack is less than half full then we can half the capacity
	 * because we will still have enough space for all elements.
	 * 
	 */
	private void halfCapacity() {
		if  ( numberOfElements >= elements.length /2) {
			throw new RuntimeException(" Stack is more than half full " );
		}
		@SuppressWarnings("unchecked")
		Item [] newElements = (Item []) new Object [elements.length / 2]; 
		for (int i =0; i< numberOfElements; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	/**
	 * Returns an iterator to traverse the stack from top to bottom.
	 * ------------------------------------------------------
	 * LINE BY LINE:
	 * Returns an iterator to traverse the stack from top to bottom. 
	 * ( a class that implements the iterator interface from Stack<Item>)
	 * 
	 * 
	 * The iterator is implemented as an anonymous inner class 
	 * that maintains an index to track the current position in the stack. 
	 * The hasNext() method checks if there are more elements to iterate over 
	 * by comparing the index with the number of elements in the stack.
	 * The next() method returns the next element in the stack if available; 
	 * otherwise, it throws a RuntimeException indicating that there are no more elements.
	 * -----------------------------------------------------
	 *
	 */
	@Override
/*
public Iterator<Item> iterator() {
		
		return new Iterator<Item>() {
			int index=0;

		
	
			@Override
			public boolean hasNext() {
				return index	<	numberOfElements;
			}

			
			
			@Override
			public Item next() {
				
				
				if (hasNext()) return elements[index++];
				throw new RuntimeException(" No more Elements in the stack LOL...");
				
			}
		};
	}
	
	
	Needs to be updated to the new version of the iterator since we updated the interface ( LLS.java)

*/
	
	/**
	 * Returns an iterator to traverse the stack from top to bottom.
	 * LINE BY LINE:
	 * 
	 * Returns an iterator to traverse the stack from top to bottom.
	 * ( a class that implements the iterator interface from Stack<Item>)
	 * 
	 * The iterator is implemented as an anonymous inner class called Iterator<Item>
	 * that maintains an index to track the current position in the stack defined as index
	 * The hasNext() method checks if there are more elements to iterate over
	 * by comparing the index with the number of elements in the stack ( numberOfElements).
	 * The next() method returns the next element in the stack if available; ( hasNext() )
	 * otherwise, it throws a RuntimeException indicating that there are no more elements.
	 * -----------------------------------------------------*/
	public Iterator<Item> iterator(){
		return new Iterator <Item>() {
			int index =numberOfElements-1;
			
			@Override
			public boolean hasNext() {
				return index >=0;
			}
			
			@Override
			public Item next() {
				if (hasNext())
					return elements[index--];
				throw new RuntimeException ("No more elements in the stack");
			}
		};
	}
	/**
	 * Adds an item to the top of the stack.
	 * ------------------------------------------------------
	 * LINE BY LINE:
	 * If the stack is full (numberOfElements equals the length of the elements array), 
	 * it calls doubleCapacity() to increase the stack's capacity.
	 * 
	 * Then, it adds the new item to the top of the stack (elements[numberOfElements]) 
	 * and increments the numberOfElements counter.
	 */
	@Override
	public void push(Item item) {
		if (numberOfElements == elements.length) {
			doubleCapacity();
		}
		elements[numberOfElements++] = item;
	}

	
	/**
	 * Removes and returns the item from the top of the stack.
	 * ------------------------------------------------------
	 * LINE BY LINE:
	 * If the stack is empty (numberOfElements is 0), it throws a RuntimeException indicating that
	 * there are no items to pop.
	 * 
	 * Otherwise, it decrements the numberOfElements counter, ( --numberOfElements )
	 *  retrieves the top item from the stack, 
	 * by accessing elements[numberOfElements], 
	 * 
	 * and sets the corresponding position in the elements array to null for garbage collection.
	 * 
	 * if after popping the item, 
	 * the numberOfElements is greater than 0 and equal to one-fourth of the length of the elements array,
	 * it calls halfCapacity() to reduce the stack's capacity.
	 * then returns the popped item.
	 * ----------------------------------------------------- 
	 */
	@Override
	public Item pop() {
		if (numberOfElements ==0) {
			throw new RuntimeException(" Stack is empty, cannot pop ");
		}
		Item top = elements[--numberOfElements];
		elements[numberOfElements] = null; // garbage collection
		if (numberOfElements >0 && numberOfElements == elements.length /4) {
			halfCapacity();
		}
		return top;
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	/**
	 * Module: 1 - Bags, Queues, and Stacks
	 * Assignment: A22-PA1 Dynamic Capacity Stack
	 * @author gcastillo
	 */
}


