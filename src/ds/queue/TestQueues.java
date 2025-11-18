package ds.queue;


public class TestQueues {
	/**
	 * Module:
	 * Assignment: 
	 * @author gcastillo
	 */
	
	public static void main(String[] args) {
		System.out.println("Fixed Capacity Queue - Task 1 - Giovanni Castillo");//task 1
		
		Queue<String> fcq3 = new FixedCapacityQueue <String> (3);
		String fcq3Name = "FixedCapacityQueue of size 3";
		printQueue (fcq3, fcq3Name);
		
		testEnqueueItem(fcq3, fcq3Name, "my first item");
		testEnqueueItem(fcq3, fcq3Name, "my second item");
		testEnqueueItem(fcq3, fcq3Name, "my third item");
		testEnqueueItem(fcq3, fcq3Name, "my fourth item");
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testEnqueueItem(fcq3, fcq3Name, "my fourth item");
		testEnqueueItem(fcq3, fcq3Name, "my fifth item");
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		
		System.out.println("\n\n\n\n\n\n\n"); //spacing between tasks
		testWithStrings(); // task 2a
		
		
		System.out.println("\n\n\n\n\n\n\n"); //spacing between tasks
		testWithIntegers(); // task 2b
	}
	
	
	/**
	 * Prints the details of the given Queue, including its elements, size, and whether it is empty.
	 * 
	 * @param <Item> - Generic type parameter for the Queue
	 * @param queue - The Queue instance to be tested
	 * @param name - The name of the Queue implementation
	 */
	private static <Item> void printQueue(Queue <Item> queue, String name) {
		System.out.println ("Queue " + name );
		System.out.println("  -elements: " + queue.toString("<< ", " <<", ", "));
		System.out.println("  -size: " + queue.size());
		System.out.println("  -isEmpty: " + queue.isEmpty());
	}
	
	/**
	 * Tests the enqueue and dequeue operations on the given Queue.
	 * 
	 * @param <Item> - Generic type parameter for the Queue
	 * @param queue - The Queue instance to be tested
	 * @param name - The name of the Queue implementation
	 * @param item - The item to be enqueued
	 */
	private static <Item> void testEnqueueItem(Queue <Item> queue, String name, Item item) {
		System.out.println("Testing enqueue and dequeue on " + name);
		System.out.println("  -queue = "+ name);
		System.out.println("  -item = " + item);
		
		try { 
			queue.enqueue(item);
			System.out.println("  -add successful");
		}catch (Exception e) {
			System.out.println("  -runtime exception: " + e.getMessage());
		}
		printQueue(queue, name);
		
	}
	
	public static <Item>void testDequeueItem(Queue<Item> queue, String name) {
		System.out.println("Dequeue (remove and return) the next item from the queue");
		System.out.println("  -queue = "+ name);
		
		try { 
			Item item = queue.dequeue();
			System.out.println("  -dequeue successful");
			System.out.println("  -item = " + item.toString());
		}catch (Exception e) {
			System.out.println("  -runtime exception: " + e.getMessage());
		}
		printQueue(queue, name);
		
	}
	/**
	 * In the class TestQueues, create a method testWithStrings(), 
	 * and move all the current content of the main method in this method. 
	 * Call this method in the main method.
	 * In the class TestQueues, create a method testWithIntegers(), 
	 * and create a similar test with the string test,  but using Integers. 
	 * Call the method in the main method.
	 * Modify TestQueues class to print at the beginning of the test the message 
	 * (where you replace my name with your name):
	 *  Fixed Capacity Queue - Task 2 - by Mihai Boicu
	 */
	public static void testWithStrings () {
		System.out.println("Fixed Capacity Queue - Task 2 - Giovanni Castillo");//task 2
		
		Queue<String> fcq3 = new FixedCapacityQueue <String> (3);
		String fcq3Name = "FixedCapacityQueue of size 3";
		printQueue (fcq3, fcq3Name);
		
		testEnqueueItem(fcq3, fcq3Name, "my first item");
		testEnqueueItem(fcq3, fcq3Name, "my second item");
		testEnqueueItem(fcq3, fcq3Name, "my third item");
		testEnqueueItem(fcq3, fcq3Name, "my fourth item");
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testEnqueueItem(fcq3, fcq3Name, "my fourth item");
		testEnqueueItem(fcq3, fcq3Name, "my fifth item");
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
	
	
	}
	/**
	 * In the class TestQueues, create a method testWithIntegers(), 
	 * and create a similar test with the string test,  but using Integers. 
	 * Call the method in the main method.
	 */
	public static void testWithIntegers () {
		System.out.println("Fixed Capacity Queue - Task 2 - Giovanni Castillo");//task 2
		
		Queue<Integer> fcq3 = new FixedCapacityQueue <Integer> (3);
		String fcq3Name = "FixedCapacityQueue of size 3";
		printQueue (fcq3, fcq3Name);
		
		testEnqueueItem(fcq3, fcq3Name, 1);
		testEnqueueItem(fcq3, fcq3Name, 2);
		testEnqueueItem(fcq3, fcq3Name, 3);
		testEnqueueItem(fcq3, fcq3Name, 4);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testEnqueueItem(fcq3, fcq3Name, 4);
		testEnqueueItem(fcq3, fcq3Name, 5 );
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		testDequeueItem(fcq3, fcq3Name);
		
				
	}
	
	}