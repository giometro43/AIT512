package ds.bag;
/**
 * Testing class for all of our bags and various types
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastillo
 */
public class TestBags {
	/**
	 * Basic test of a fixed capacity bag
	 */
	public static void testFixedCapacityBag() {
		System.out.println("Create an empty bag with capacity 5.");
		FixedCapacityBag<String> bag = new FixedCapacityBag<>(5); // creating a fixed capacity bag
		//capacity of 5
		System.out.println("Bag: " + bag.toString());//print the bag 
		System.out.println("add the item: movie ticket");
		bag.add("SING: the movie (x2)");
		System.out.println("Bag: " + bag.toString());//print the bag
		System.out.println("add the items: movie ticket, valentines bear, sour patch kids, yogurtland ");
		//nostalgia from first date :  AHH
		bag.add("White teddy bear holding heart. ");
		bag.add("mason jar with sour patch kids");
		bag.add("Tart flavor with strawberry popping boba");
		System.out.println("Bag: " + bag.toString());
	}
	/**
	 * Main methods performing all the tests.
	 * @param args - not used
	 */
	public static void main(String[] args) {
		testFixedCapacityBag();
	}

}
