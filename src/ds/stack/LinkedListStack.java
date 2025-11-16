package ds.stack;
import java.util.Iterator;
/*
Tasks:

Perform these tasks based on these videos, 
do not include elements from other videos. 
The program will be modified in future assignments. 
However, the TestStack must continue the previous homework file 
(testing also the pop method). 
Task 1: Implement the classes as desscribed in the video. 
In the package (ds.stack) define the class implementation 
LinkedListStack based on the video. You must add javadoc and inline comments to express the functionality in your own words.
Modify the class TestStacks to add a name for the stack and call the test for a linked list stack of strings and for one of integers.
Modify TestStacks class to print at the beginning of the test the message (where you replace my name with your name):
Linked List Stack - Task 1 - by Mihai Boicu
Test and debug your program
EXECUTION PDF: increase the size of the output area (maximize), add two screenshots of the execution showing the beggining and the end of the output.
ANSWERS PDF: Provide an example where a linked list stack must be used and explain why all the other  learned  data structures are not applicable (e.g., fixed capacity stack or  dynamic capacity bag). (paragraph answer)
 */


/**
 * A linked list stakc allowing adding and removing elements in an efficient LIFO manner
 * @param <Item> - a generic type for the things in the stack, an object
 * @author gcastillo 
 * @Version 1
 */
public class LinkedListStack<Item> implements Stack<Item> {
	
	/**
	 * Node class representing each element in the linked list stack
	 */
	private class Node {
		
	/**
	 * What is a node?:
	 * A node is a container that holds an item and a reference to the node below it in the stack.
	 * Each node contains:
	 * 1. An item of generic type Item, representing the data stored in the node
	 * 2. A reference to the node below it in the stack, allowing us to
	 * link nodes together to form the stack structure.
	 */
		Node belowNode; 
		/**
		 * The item stored at this node
		 */
		Item item;
	}
	/**
	 * teh top node in the stack of items.
	 */
	private Node topNode;
	
	/**
	 * the number of elements in the stack.
	 */
	private int numberOfElements;
	/**   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 *    |||||||||||||||||||||||||||||||
	 * Linked List Stack Explanation:
	 * this will be different from the other stacks by using the nodes to link the elements
	 * together instead of using an array.
	 * 
	 * this is so that we can link the elements together dynamically without worrying about capacity.
	 * 
	 * Example: if we have 3 elements and we push one more, 
	 * we can just create a new node and link it to the top.
	 * 
	 */
	
	/**
	 * Constructor: 
	 * Creates an empty stack of items.
	 * --------------------------------
	 * what is a constructor?: it is a special method that is called when an object is created.
	 * it initializes the object. then we can use the object in another class.
	 * 
	 * So when we create a new LinkedListStack, it will set the topNode to null and numberOfElements to 0.
	*/public LinkedListStack() {
		topNode = null;
		numberOfElements = 0;
	}
	
	/**
	 * Returns an iterator to traverse the stack from top to bottom.
	 * -------------------------------------------------------------
	 * LINE BY LINE:
	 * we return a new iterator object that implements the Iterator<Item> interface.
	 * currentNode is initialized to the topNode of the stack.
	 * 
	 * The iterator has two main methods:
	 * 1. hasNext(): checks if there are more elements in the stack by checking if currentNode is not null.
	 * 2. next(): retrieves the current item, moves to the node below, and returns the item.
	 * 
	 * This allows us to iterate through the stack from top to bottom.
	 * 
	 * ------------------------------------------------------------
	 * Simple example:
	 * If the stack has three items A (top), B, C (bottom):
	 * - Initially, currentNode points to A.
	 * - hasNext() returns true (currentNode is A).
	 * - next() returns A, moves currentNode to B.
	 * - hasNext() returns true (currentNode is B).
	 * - next() returns B, moves currentNode to C.
	 * - hasNext() returns true (currentNode is C).
	 * - next() returns C, moves currentNode to null.
	 * - hasNext() returns false (currentNode is null).
	 * -----------------------------------------------------------
	 */@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node currentNode = topNode;
			
			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public Item next() {
				Item item = currentNode.item;
				currentNode = currentNode.belowNode;
				return item;
			}
		};
	}
	 /**
	  * LINE BY LINE:
	  * Creates a new node (called itemNode) to hold the item being pushed onto the stack.
	  * Sets the belowNode of the new node to null initially.
	  * Assigns the item to the new node's item field.
	  * Increments the numberOfElements counter to reflect the addition of a new item.
	  * Checks if the stack is currently empty (topNode is null).
	  * If the stack is empty, sets topNode to the new node (itemNode).
	  * If the stack is not empty, links the new node to the current topNode by
	  * setting itemNode's belowNode to the current topNode, then updates topNode to
	  * itemNode, effectively placing the new node on top of the stack.
	  * ------------------------------------------------------------
	  * Simple Example:
	  * If the stack is empty and we push item A:
	  * - A new node (itemNode) is created for A.
	  * - topNode is null, so topNode is set to itemNode.
	  * Now the stack has one item: A (top).
	  * If we push item B onto the stack:
	  * - A new node (itemNode) is created for B.
	  * - topNode is not null (it points to A), so itemNode's below
	  * Node is set to the current topNode (A).
	  * - topNode is updated to itemNode (B).
	  * Now the stack has two items: B (top), A.
	  * -----------------------------------------------------------
	  */@Override
	public void push(Item item) {
		Node itemNode = new Node();
		itemNode.belowNode = null;
		itemNode.item = item;
		numberOfElements++;
		if(topNode == null) {
			topNode = itemNode;
		} else {
			itemNode.belowNode = topNode;
			topNode = itemNode;
		}
		
	}
	  /**
	   * LINE BY LINE:
	   * Checks if the stack is empty by verifying if topNode is null.
	   * If the stack is empty, throws a RuntimeException indicating that there are no items to pop.
	   * If the stack is not empty, retrieves the item from the topNode.
	   * Updates topNode to point to the node below the current topNode, effectively removing the
	   * top item from the stack.
	   * Returns the retrieved item.
	   * ------------------------------------------------------------
	   * Simple Example:
	   * If the stack has two items B (top), A:
	   * - topNode points to B.
	   * - The item from topNode (B) is retrieved.
	   * - topNode is updated to point to A (the node below B).
	   * - B is effectively removed from the stack.
	   * - The method returns B.
	   * Now the stack has one item: A (top).
	   * -----------------------------------------------------------
	   */
	@Override
	public Item pop() {
		if (topNode ==null) {
			throw new RuntimeException("No items to pop, stack is empty");
			}
		Item top = topNode.item;
		topNode = topNode.belowNode;
		return top;
		}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}
	/**
	 * Module:
	 * Assignment: 
	 * @author gcastillo
	 */
}


