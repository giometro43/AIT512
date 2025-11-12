package ds.bag;
/**
 * Testing class for all of our bags and various types
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastil9@gmu.edu
 */
public class TestBags {

public static void testBag(Bag<String> bag) {
		
		System.out.println("Create an empty bag with capacity 5.");

		System.out.println("Bag is a singleton:" + bag.isSingleton());
		System.out.println("Bag is a empty:" + bag.isEmpty());
		System.out.println("Bag has a double:" + bag.hasDouble());

		System.out.println("Dynamic Capacity Bag - Task 2 - by Giovanni Castillo");

		System.out.println("Bag: " + bag.toString());

		System.out.println("add the item: SING: the movie tickets");
		bag.add("movie ticket(x2)");

		System.out.println("Bag is a singleton: " + bag.isSingleton());
		System.out.println("Bag is a empty:" + bag.isEmpty());
		System.out.println("Bag has a double:" + bag.hasDouble());
		System.out.println("Dynamic Capacity Bag - Task 2 - by Giovanni Castillo");

		System.out.println("Bag: " + bag.toString());
		System.out.println("add the items: hair tie, gray sweater, roscoes chicken, signal hill momento");
		bag.add("hair tie");
		bag.add("gray sweater");
		bag.add("roscoes chicken");
		bag.add("signal hill momento");
		bag.add("hair tie");

		System.out.println("Bag: " + bag.toString());

		try {
			System.out.println("add the sixth item. MONEYY");
			bag.add("961,600,000,000 Dollars");
			System.out.println("Bag: " + bag.toString());
		} catch (Exception e) {
			System.out.println("Error trying to add the sixth item: " + e.getMessage());
		}

		System.out.println("Bag is a singleton:" + bag.isSingleton());
		System.out.println("How many items start with b?");
		
		int count = 0;
		for (String item : bag) {
			if (item.charAt(0) == 'b')
				count++;
		}
		System.out.println("There are " + count + " items that start with B.");

	}

	public static void main(String[] args) {
		System.out.println("Dynamic Capacity Bag - Task 1 - by Giovanni Castillo");

		Bag<String> b1 = new FixedCapacityBag<>(5);
		Bag<String> b2 = new DynamicCapacityBag<>(5);
		Bag<String> b3 = new LinkedListBag<>();

		//testBag(b1);
		//testBag(b2);
		testBag(b3);
	}

}
