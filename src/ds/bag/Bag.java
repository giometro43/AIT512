/**
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastillo
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
	
	
	
	
	// 
	/**
	 * pretty much how many things are in the bag.2 things, size is 2 for the bag 
	 * @return
	 */
	public int size();
	
}
