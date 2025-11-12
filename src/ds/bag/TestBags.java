package ds.bag;
/**
 * Testing class for all of our bags and various types
 * Module: A01 - Bags, Stacks and Queues
 * Assignment: A11-PA Fixed Capacity Bag
 * @author gcastil9@gmu.edu
 */
public class TestBags {

	
	
	/**
	 * Basic test of dynamic capacity bag
	 */
public static void testDynamicCapacityBag() {// TASK 1 A12-PA Dynamic Capacity Bag
		
		System.out.println("Create an empty bag with capacity 5.");
		
		Bag <String> bag = new DynamicCapacityBag<>(); // creating a fixed capacity bag before of 5, but now it uses the default from the DCB class.
		// capacity of 10 predefined

		System.out.println("Bag is a singleton:" + bag.isSingleton());// TASK 2C
		System.out.println("Bag is a empty:" + bag.isEmpty());// TASK 2C
		System.out.println("Bag has a double:" + bag.hasDouble());// TASK 3

		System.out.println("Dynamic Capacity Bag - Task 2 - by Giovanni Castillo");

		System.out.println("Bag: " + bag.toString());//print the bag 
		
		
		System.out.println("add the item: SING: the movie tickets");
		bag.add("movie ticket(x2)");
		
		System.out.println("Bag is a singleton: " + bag.isSingleton());// TASK 2C
		System.out.println("Bag is a empty:" + bag.isEmpty());// TASK 2C
		System.out.println("Bag has a double:" + bag.hasDouble());// TASK 3
		System.out.println("Dynamic Capacity Bag - Task 2 - by Giovanni Castillo");

		
		
		System.out.println("Bag: " + bag.toString());//print the bag
		System.out.println("add the items: hair tie, gray sweater, roscoes chicken, signal hill momento");
		// nostalgia from my past haha
		bag.add("hair tie");
		bag.add("gray sweater");
		bag.add("roscoes chicken");
		bag.add("signal hill momento");
		bag.add("hair tie"); // double test case

		System.out.println("Bag: " + bag.toString());
		System.out.println("Bag has a double:" + bag.hasDouble());// TASK 3
		System.out.println("Dynamic Capacity Bag - Task 3 - by Giovanni Castillo");


		System.out.println("add the sixth item. MONEYY");

		bag.add("961,600,000,000 Dollars");//new sixth item, DoD budget
		System.out.println("Bag: " + bag.toString());

		
		System.out.println("Bag is a singleton:" + bag.isSingleton());// TASK 2C
		System.out.println("How many items start with b?");
		int count = 0;
		for (String item: bag) {
			if (item.charAt(0)=='b') count++; //using the char at method to see the
		}
		System.out.println("There are "+count+" items that start with B.");
		
	}
	
	
/*⠀⠀⠀⠀⠀⠀⢀⣤⣤⣶⠶⠶⣶⣤⣤⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢀⣴⠾⠛⠉⠀⢠⣾⣴⡾⠛⠻⣷⣄⠀⠀⠀⠀⠀
⠀⠀⢶⣶⣶⣿⣁⠀⠀⠀⠀⢸⣿⠏⢀⣤⣶⣌⠻⣦⡀⠀⠀⠀
⠀⠀⣴⡟⠁⢉⣙⣿⣦⡀⠀⢸⡏⣴⠟⢡⣶⣿⣧⡹⣷⡀⠀⠀
⠀⣼⠏⢀⣾⠟⠛⠛⠻⣿⡆⠀⠀⢿⣄⠀⠙⠉⠹⣷⡸⣷⠀⠀
⢠⣿⠀⢸⡿⢿⠇⠀⠀⣾⠇⠀⣀⣈⠻⢷⣤⣤⣤⡾⠃⢹⣇⠀
⢸⣿⠀⢸⣧⣀⣀⣠⣾⢋⣴⢿⣿⡛⠻⣶⣤⣉⠁⠀⠀⠀⣿⠀
⠈⣿⠀⠀⠙⠛⠛⠋⠁⣼⣯⣀⣿⠿⠶⠟⠉⠛⢷⣄⠀⠀⣿⡇
⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡏⠉⠁⠀⠀⢀⣴⢶⣄⢻⡇⠀⢸⡇
⠀⢻⣇⠀⠀⠀⠀⠀⢠⡿⢀⣀⢠⣾⠷⣾⣧⡶⠿⠟⠁⠀⣾⡇
⠀⠈⣿⣧⡀⠀⠀⣠⣿⣷⠟⢻⣿⣷⡾⠛⠉⠀⠀⠀⠀⢀⣿⠀
⠀⠀⢹⣿⢻⣦⡀⠉⠛⠛⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀
⠀⠀⠀⠛⠀⠈⠻⠷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠟⠀⠀ ASCII drawing for my enjoyment*/
		
	
	/**
	 * Main methods performing all the tests.
	 * @param args - not used
	 */ 
	public static void main(String[] args) {
		System.out.println("Dynamic Capacity Bag - Task 1 - by Giovanni Castillo");
		//testFixedCapacityBag();

		testDynamicCapacityBag();//TASK 1 - A12-PA Dynamic Capacity Bag
	}

}
