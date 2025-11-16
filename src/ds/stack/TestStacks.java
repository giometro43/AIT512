package ds.stack;
/**
 * A stack is a collection of items. PANCAKES
 * LIFO - Last In First Out  ----PANCAKES! THINK OF HOW THEY GET PUT ON A PLATE AND ATE
 * 
Task 1: 
Implement the files as described in the last video with the following modifications:
Under ds package create sub-package stack 
In this package (stack) define the interface Stack, 
the class implementation FixedCapacityStack and the test class TestStacks.   
You must modify the javadoc and inline comments to express the functionality in your own words
In the class TestStacks, modify the method testPushItem() to add an empty line before any other message.
Modify TestStacks class to print at the beginning of the test the message (where you replace my name with your name):
Fixed Capacity Stack - Task 1 - by Mihai Boicu
Test and debug your program
EXECUTION PDF: increase the size of the output area (maximize), add two screenshots of the execution showing the 
beggining and the end of the output.
ANSWERS PDF: Provide an example where a fixed capacity stack must be used and one example where a fixed 
capacity bag must be used, explain why,  and explaining why the other structure will 
not be recommended in that situation. (paragraph answer) Task 2: Test pop method
In the class TestStacks, create a method testPopItem(), that will test the pop() method 
similar how testPushItem performs the test. Catch any error and print the error message. 
Print the operation, the poped item and the updated stack.
In the class TestStacks, update the method testStringStack(), 
to call four times the test pop item method after the elements were added.
Modify TestStacks class to print at the beginning of 
the test the message (where you replace my name with your name):
Fixed Capacity Stack - Task 2 - by Mihai Boicu
Test and debug your program
EXECUTION PDF: increase the size of the output area (maximize), 
add two screenshots of the execution showing the beggining and the end of the output.
ANSWERS PDF: What other methods are not tested? Which method  you will test next, why? How?
 * */
public class TestStacks {
	/**
	 * Module: 1 - Bags, Stacks and Queues
	 * Assignment: A21-PA1 Fixed Capacity Stack
	 * @author gcastillo
	 */
	
	
	
	
	/**
	 * Task 2d: Main method
	 * In  the class TestStacks,  modify the main method to perform the previous test, but calling the new testStack()
	 * 
	 * LINE BY LINE:
	 * Prints the header for the Fixed Capacity Stack test
	 * Creates a new Fixed Capacity Stack of Strings with a capacity of 3
	 * Calls the testStringStack method to perform tests on the stack
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*DEPRECIATED MAIN METHOD 
		/*
		 * Line by line:
		 * Prints the header for the Dynamic Capacity Stack test
		 * Creates a new Dynamic Capacity Stack of Strings with a capacity of 3
		 * Calls the testStack method to perform tests on the stack
		 * then prints the updated stack after all pops
		 * 
		 * next task 2e
		 * which is to add a new test for a stack of integers, 
		 * with the values 1,4,7,9,2,4,3,5 and popping 9 values.
		 * 
		 
		System.out.println(" Dynamic Capacity Stack - Task 2 - by Giovanni Castillo");
		
		
		DynamicCapacityStack<String> dcss = new DynamicCapacityStack<>(3);
		
		//test strings stack: instaed of calling push and pop individually, we call the testStack method
		
		testStack(dcss, new String[] {
				"first pancake (blueberry)",
				"second pancake (strawberry)",
				"third pancake (chocolate chip)",
				"fourth pancake (plain)",
				"fifth pancake (banana)" },4);
	
		//2.e. Add a new test for a stack of integers, with the values 1,4,7,9,2,4,3,5 and popping 9 values.
		
		
		
		DynamicCapacityStack<String> dcsi = new DynamicCapacityStack<>(3);
		testStack(dcsi, new String[] {
				"1",
				"4",
				"7",
				"9",
				"2",
				"4",
				"3",
				"5"},9);
		*/ 
			FixedCapacityStack<String> fcs = new FixedCapacityStack<>(3);
			testStringStack(fcs);
			DynamicCapacityStack<String> dcs = new DynamicCapacityStack<>(3);
			testStringStack(dcs);
		
	LinkedListStack<String> lls = new LinkedListStack<>();
	testStringStack(lls);
	
	}

	/**
	 * Test to push an item into the stack
	 * 
	 * 
	 * to test it we will need to recieve a stack and receive the items we need to push
	 * 
	 * we'll like to print everything on the screen so we can follow in the console what is happening
	 * 
	 * start by printing the operation
	 * 
	 * push item and push string of the item
	 * 
	 * a readable description of the item, then we try and call the push method for this item in the stack
	 * 
	 * we try because we may succeed or we may fail, if we fail we catch the exception and print the error message
	 * 
	 * then we print the updated stack by using right paranthesis, and the top will be an angled paranthesis
	 * we seperate the elements by a comma and a space
	 * 
	 * 
	 * 
	 * @param s - the stack in which the item is pushed
	 * @param item - the item pushed
	 */
private static <Item> void testPushItem(Stack<String> s, String item) { //task 2 a
	
	System.out.println();
	System.out.println("Push item: " + item);
	try {
		s.push(item);
	} catch (Exception e) {
		System.out.println("Error trying to push item: " + e.getMessage());
		return;
	}
	
	System.out.println("Updated Stack: " + s.toString("[", ">", ", "));
}
	
	
/**
 * Test the Fixed Capacity Stack with Strings
 * 
 * LINE BY LINE:
 * Prints the header for the test
 * Creates a new Fixed Capacity Stack of Strings with a capacity of 5
 * Prints the empty stack
 * Pushes five pancake strings onto the stack using the testPushItem method
 * 
 * 
 * 
 * @param s - the stack to be tested.
 */

//2.c. In the class TestStacks, modify the method testStringStack() to be named testStack() 
	

/**
 * Task 2c: Test stack method
 * In the class TestStacks, modify the method testStringStack() to be named testStack()
 * and receive a stack, an array  of items to  be pushed and the number of items to be  popped after that.
 * 
 * LINE BY LINE:
 * Prints a separator line
 * Prints the empty stack
 * Pushes each item from the itemsToPush array onto 
 * the stack using testPushItem
 * Prints a newline for readability
 * Pops the specified number of items from the stack using testPopItem
 * then prints the updated stack after each pop
 * finally prints the updated stack after all pops
 * 
 * @param s - the stack to be tested
 * @param itemsToPush - array of items to be pushed onto the stack
 * @param numItemsToPop - number of items to pop from the stack
 */
public static void testStack(Stack<String> s, String[] itemsToPush, int numItemsToPop) {
	// add line to print name of stack being tested from main method:
	//Ex.LinkedListStack<String> lls = new LinkedListStack<>(); testStringStack(lls);
		
	
		System.out.println("-------------------------------");
		System.out.println("Empty Stack: " + s.toString("[", ">", ", "));
		for (String item : itemsToPush) {
			testPushItem(s, item);
		}
		System.out.println();
		for (int i = 0; i < numItemsToPop; i++) {
			testPopItem(s);
		}
		
	}
/*
private static void testStringStack(Stack<String> s) {
	System.out.println("Fixed Capacity Stack - Task 1 - by Giovanni Castillo");
	Stack<String> stack = new FixedCapacityStack<>(5);
	
	System.out.println("Empty Stack: " + s.toString("[", ">", ", "));
	
	testPushItem(s, "first pancake (blueberry)");
	testPushItem(s, "second pancake (strawberry)");
	testPushItem(s, "third pancake (chocolate chip)");
	testPushItem(s, "fourth pancake (plain)");
	testPushItem(s, "fifth pancake (banana)");
	System.out.println();
	System.out.print("Fixed Capacity Stack - Task 2 - by Giovanni Castillo");
	testPopItem(s);
	testPopItem(s);
	testPopItem(s);
	testPopItem(s);
	
	System.out.println();
	Stack<String> stack1 = new DynamicCapacityStack<>(5);
	System.out.println("Dynamic Capacity Stack - Task 1 - by Giovanni Castillo");
	
	System.out.println("Empty Stack: " + stack1.toString("[", ">", ", "));
	
	testPushItem(stack1, "first pancake (blueberry)");
	testPushItem(stack1, "second pancake (strawberry)");
	testPushItem(stack1, "third pancake (chocolate chip)");
	testPushItem(stack1, "fourth pancake (plain)");
	testPushItem(stack1, "fifth pancake (banana)");
	System.out.println();
	testPopItem(stack1);
	testPopItem(stack1);
	testPopItem(stack1);
	testPopItem(stack1);
} DEPRECIATED CODE*/

/**
 * LINE BY LINE:
 * Prints the header for the test named testStringStack
 * Creates a new Fixed Capacity Stack of Strings with a capacity of 5 ( named s )
 * Prints the empty stack with specific formatting ( [ , > , ,  )
 * Pushes four pancake strings onto the stack using the testPushItem method
 * -------------------------------------------------------------------------------
 * this is compared to the depreciated testStringStack in that:
 * 
 * it only pushes four items instead of five
 * it does not perform any pop operations,
 * it is focused solely on testing the push functionality
 * line count goes from 57 to 36
 * 
 * 
 * 
 * 
 * 
 * @param s - the stack to be tested. 
 */


public static void testStringStack(Stack<String> s) {
	System.out.println( "Empty Stack: " + s.toString("[", ">", ", "));
	testPushItem(s, "first pancake (blueberry)");
	testPushItem(s, "second pancake (strawberry)");
	testPushItem(s, "third pancake (chocolate chip)");
	testPushItem(s, "fourth pancake (plain)");
}



/**
 * Task 2: Test pop method
 * In the class TestStacks, create a method testPopItem(), 
 * that will test the pop() method
 * similar how testPushItem performs the test. 
 * 
 * Catch any error and print the error message.
 * Print the operation, 
 * the poped item and the updated stack.
 * @param s - the stack from which the item is popped
 * @return 
 *
 */
private static <Item> void testPopItem(Stack<String>s) { //task 2 b


	
	System.out.println();
	try {
	String popped = s.pop();
	System.out.println("Pop item: " + popped);
	}catch(Exception e) {
		System.out.println("Error trying to pop item: " + e.getMessage());
		return;
		
	} 
	System.out.println("Updated Stack: " + s.toString("[", ">", ", "));

	}
	
	




}
