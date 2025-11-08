/**
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastillo
 */

/**FIXME: 
 * AIT 502 – Fixed Capacity Bag Assignment
 * 
 * Task 1:
 * Create package structure ds.bag.
 * Inside ds.bag, define the Bag interface, the FixedCapacityBag class, and the TestBags class.
 * Update all Javadoc and inline comments in your own words.
 * In TestBags, print: "Fixed Capacity Bag - Task 1 - by Giovanni Castillo".
 * Test and debug the program.
 * In the Answers PDF, identify a missing test and explain why it would be important to add.
 * 
 * Task 2:
 * Add a new method in the Bag interface: boolean isSingleton(), which returns true if the bag has exactly one element.
 * Implement this method in the FixedCapacityBag class.
 * Update TestBags to print: "Fixed Capacity Bag - Task 2 - by Giovanni Castillo".
 * In TestBags, call and print the result of isSingleton() in three places:
 *   1. Just after the bag is created
 *   2. After adding the first element
 *   3. After adding the next four elements
 * Print: "Bag is a singleton: true/false" after each call.
 * In the Answers PDF, include the code for isSingleton() and explain whether the test completely verifies the method.
 * 
 * Task 3:
 * Modify the toString() method in FixedCapacityBag to separate elements by a comma and space.
 * In TestBags, create a new method testFixedCapacityBag that receives five item names and performs similar testing.
 * Replace the call in main() with a call to the new method using different objects to add to the bag.
 * Print: "Fixed Capacity Bag - Task 3 - by Giovanni Castillo" at the start of the test.
 * Test and debug the program.
 * In the Answers PDF, include the modified toString() code and explain how to make it more user-friendly, including a code fragment for your idea.
 */

package ds.bag;
/*a bag is a data structure that collects items and allows us to use it
like a bag at the grocery store, as the name entails, it doesnt descriminate what goes
in it and it doesnt care if it gets filled or not*/



// what does the <item> part? 
public interface Bag<Item> extends Iterable<Item> {

	/**
	 * adds things to the bag, naturally as a bag would do.
	 * @param item
	 */
	public void add(Item item);

	
	
	/**
	 * checks if the bag is empty, almost like when you grab it at the store to see if 
	 * you can fill it
	 * @return
	 */
	public boolean isEmpty();
	
	
	/**
	 * TASK 2a: method defined in bag to check if is singleton  
	 * @return
	 */
	public boolean isSingleton();
	
	
	
	// 
	/**
	 * pretty much how many things are in the bag.2 things, size is 2 for the bag 
	 * @return
	 */
	public int size();
	
}
