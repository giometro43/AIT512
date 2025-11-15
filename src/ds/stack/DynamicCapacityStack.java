package ds.stack;

/*
 * Tasks:

Perform these tasks based on these videos, do not include elements from other videos. 
The program will be modified in future assignments. However, the TestStack must continue the previous homework file (testing also the pop method).  
Task 1: Implement the files as described in the last video with the following modifications:
In this package (ds.stack) define the class implementation DynamicCapacityStack as described in the video. 
You must modify the javadoc and inline comments to express the functionality in your own words.
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
 * 
 * @param <Item>
 */
public class DynamicCapacityStack <Item> implements Stack<Item>{

	@Override
	public Iterator<Item> iterator() {
		return null;
	}

	@Override
	public void push(Item item) {
	}

	@Override
	public Item pop() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
	/**
	 * Module: 
	 * Assignment: 
	 * @author gcastillo
	 */
}


