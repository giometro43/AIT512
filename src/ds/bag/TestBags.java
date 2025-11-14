package ds.bag;
/**
 * Testing class for all of our bags and various types
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastil9@gmu.edu
 */
public class TestBags {

	/*Modify TestBags class, 
	 * modify the main method, 
	 * adding at the end a call for each type of implemention in 
	 * each one element appears 3 times (on positions one, three and six), 
	 * another 2 times (on positions two and four) 
	 * and the last one once (on position five).*/
	
public static void testBag(Bag<String> bag) {
		
		System.out.println("Create an empty bag with capacity 5.");

		System.out.println("Bag is a singleton:" + bag.isSingleton());
		System.out.println("Bag is a empty:" + bag.isEmpty());
		System.out.println("Max frequency:" + bag.maxFreq());// task 2 , fcb
		System.out.println("Bag has a double:" + bag.hasDouble());

		System.out.println("Linked List Bag - Task 1 - by Giovanni Castillo");

		System.out.println("Bag: " + bag.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("add the item: SING: the movie tickets");
		bag.add("movie ticket(x2)");

		System.out.println("Bag is a singleton: " + bag.isSingleton());
		System.out.println("Bag is a empty:" + bag.isEmpty());
		System.out.println("Max frequency:" + bag.maxFreq());// task 2 , fcb
		
		System.out.println("Max times most frequent item is called:" + bag.isEmpty());
		System.out.println("Bag has a double:" + bag.hasDouble());
		System.out.println("Dynamic Capacity Bag - Task 2 - by Giovanni Castillo");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Bag: " + bag.toString());
		System.out.println("add the items: hair tie, gray sweater, roscoes chicken, signal hill momento");
		bag.add("hair tie");
		bag.add("gray sweater");
		bag.add("roscoes chicken");
		bag.add("signal hill momento");
		bag.add("hair tie");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Bag: " + bag.toString());
		
		try {
			System.out.println("add the sixth item. MONEYY");
			bag.add("961,600,000,000 Dollars");
			System.out.println("Bag: " + bag.toString());
		} catch (Exception e) {
			System.out.println("Error trying to add the sixth item: " + e.getMessage());
		}
		System.out.println("Max frequency:" + bag.maxFreq());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Bag is a singleton:" + bag.isSingleton());
		System.out.println("How many items start with b?");
		
		int count = 0;
		for (String item : bag) {
			if (item.charAt(0) == 'b')
				count++;
		}
		System.out.println("There are " + count + " items that start with B.");
		
		
		System.out.println("linked list Bag - Task 2 - by Giovanni Castillo");

	}

	
	private static void addPattern(Bag<String> bag, String thrice, String twice, String once) {
		bag.add(thrice); // 1
		bag.add(twice);  // 2
		bag.add(thrice); // 3
		bag.add(twice);  // 4
		bag.add(once);   // 5
		bag.add(thrice); // 6
	}
	private static void runPatternTest(String title, Bag<String> bag) {
		System.out.println(title);
		addPattern(bag, "alpha", "beta", "gamma");
		System.out.println("Bag: " + bag.toString());
		System.out.println("Max frequency:" + bag.maxFreq());
		System.out.println("Bag has a double:" + bag.hasDouble());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public static void main(String[] args) {
		System.out.println("Linked List  Bag - Task 1 - by Giovanni Castillo");
		System.out.println("");
		Bag<String> b1 = new FixedCapacityBag<>(5);
		Bag<String> b2 = new DynamicCapacityBag<>(5);
		Bag<String> b3 = new LinkedListBag<>();

		//testBag(b1);
		//testBag(b2);
		System.out.println("Title: LinkedListBag");
		System.out.println("");
		testBag(b3);
		
		System.out.println("-----------------------------------------------------------------------------");
		// Implements task 2: run the 3/2/1 pattern for each type of implementation
		System.out.println("Pattern tests (3x/2x/1x) - all bag types");
		runPatternTest("FixedCapacityBag pattern", new FixedCapacityBag<>(6));
		runPatternTest("DynamicCapacityBag pattern", new DynamicCapacityBag<>(3));
		runPatternTest("LinkedListBag pattern", new LinkedListBag<>());
		
	}

}
