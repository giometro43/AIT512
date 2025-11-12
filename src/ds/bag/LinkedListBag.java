package ds.bag;

import java.util.Iterator;

/**
 * Module: 1 Bags, Stacks and Queues
 * Assignment: A13-PA Linked List Bag
 * @author gcastil9@gmu.edu
 */

/**
 * Rather than limit the size like fixed,
 * Or double the capacity after copying a previous array into a new one,
 * 
 * Create an efficent way to add new elements to a new bag
 * 
 * we will start by creating the nodes that will contain the value for that element
 * and also a link for the next element
 * 
 * 
 * this will be crucial to understand in not only programming in this course but in general
 */

/*
 * think of cyber systems that rely on this concept!
 * 
 * web browsers for back/forward navigation, 
 * operating systems for managing processes and memory, (CRITICAL)!!!!
 * and media players for playlist management. 
 * 
 */
public class LinkedListBag<Item> implements Bag<Item> {

	/**
	 * A node in the list
	 */
	private class Node {
		
		/**
		 * the next node, following after this node, null if none
		 */
		
		
		Node nextNode;
		
		// the item stored at this node
		Item item;
	}
	
	
	/**
	 * the start node in the lsit of items
	 */
	public Node startNode;
	
	/**
	 *  the end node in the list of items 
	 */
	
	public Node endNode;
	
	
	
	/**
	 * the number of elements in the list
	 */
	private int numberOfElements; // create a field for the elements 
	
	
	
	
	
	/**
	 * creates an empty list of items
	 */
	public LinkedListBag() {
		startNode =null; //the default when an object has no value. (NULL)
		endNode =null;
		numberOfElements =0;
	
	}
	
	
	
	@Override
	public Iterator<Item> iterator() {
			
		return new Iterator<Item>() {

			
			private Node currentNode=startNode;
			
			@Override
			public boolean hasNext() {
				
				return currentNode!=null;
			}

			@Override
			public Item next() {
				Item item = currentNode.item;
				currentNode=currentNode.nextNode;
				return item;
			}
			
		};
	}

	@Override
	public void add(Item item) {
		// TODO Auto-generated method stub

	/**
	 * We will create a new node, for each item we want to add
	 * 
	 * an item node that in which we want to store the new item
	 * 
	 * so we will put in the nextNode for the item, since there will be nothing after it (NULL)
	 * 
	 * also we need to put the item field of the itemNode. the item that we want to add
	 * 
	 * BREAKDOWN:
	 * create new node
	 * create item node field
	 * then increment the number of elements
	 * 
	 *  
	 * 
	 * 
	 */
		Node itemNode = new Node();
		itemNode.nextNode = null;
		itemNode.item = item;
		numberOfElements++;
		
		
		/*add this node at the end of the bag, not the beginning.
		 * 
		 * 
		 * wa want to add this node at the end of the bag, two cases, if the list is empty we need to intialize the list
		 * this will be the first element that we put in the list
		 * 
		 * 
		 * 
		 * 
		 * 
		 * so we must check if the list is empty ( if the start node is null), if that is the case then the item node
		 * be the start and the end of the list.
		 * 
		 * 
		 * if it is Not empty then we only need to add it as the last element in the list
		 * we just look at the previous end node, now the next node is the itemNode we created
		 * 
		 * 
		 * 
		 * 
		 * BREAKDOWN
		 * think of the linked list being like a horizontal bag
		 * and we cannot leave things on the left of the bag since it starts there
		 * so we move it to the very right even if its the first item. so that we can 
		 * make room for the other items if they come. 
		 * 
		 * IF, the the start node is null, that means the bag is empty.
		 * since the bag is empty there is nothing in the start or end node values
		 * we add the itemNode into start AND end node.
		 * 
		 * 
		 * ELSE: if the start node has a value, we know that same value is in the end node,
		 * 
		 * if its not empty, then we need to add the item as the last element of the list
		 * 
		 * 
		*/
		if(startNode ==null) {
			startNode=itemNode;
			endNode=itemNode;
		}else {
			endNode.nextNode = itemNode; //now we linked this previous list to this item node
			
			// the new end node will bne the item node
			endNode = itemNode;
		}
		
		
		
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
	//
		return startNode == null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}
	
	public String toString() {
		return toString ("[", "]" , ", " );
	}
	
	

}

/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*+=====+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%=::=++***++=-:=%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=.-*#*=-----=+**+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%::*%+::+#%%%#+--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-.*%=.+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.=%*.=@@@@@+=========%@@@@@@@@@+-====%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.=%+.+@@@@@*********-.=%@@@@@*::+**-.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::##::%@@@@=--=-=##*%*:.+@@#:.+%#*%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*.-##-:+%@@@%%*::##:-*%*::-.=##=.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#::*%*-:--==--=*##::.-*%+=#%=::.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+::=****+****+##:-%=.-#%+::#+.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+--------.:##:-@@#-.::*@@+.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%@@:-##:-@@@@#*@@@@+.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::##.:@@@@@@@@@@+.+%=.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%*#%==%#-=@@@@@@@@@@*-*%+-#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@%***#@@#***%@##@@@##@@@#*#*%@%***#@#*###@@@@#***@@#*#*#@@@**#*%%*@@@*@@#***%@*@%*@@@*@#*#*#%*##*@#***%@#%%*%@@#%@%***#@@@@@@@
@@@@@@#:*##+%==##*:#==@@@:=@@@:=*+#*:*#*+@-:***@@%:+##+:%-:***@@%.+*+%=.-%%.#==##+#@.%+.-#@ %--*+##.+**%--#*.%-=#.-*@:*#:*#*+@@@@@@@
@@@@@@=:@@@@%.#@@@:+==@@@:=@@@:=**%--@#*-*=-**#@@#.@@@@.*=-**#@@%.+**@=-#-=:*.#@*+-%.%=-#-=.%--**##:***@--+-=@-=#:%-=:*=-@%*-*@@@@@@
@@@@@@@+=+==@#=++=+@+-++%=-++#-=*+#%==++-%+-***@@@*=++=+@=+@@@@@%-+*+%==@@=:%#-++==%:%+=@@=:%==*+##:+*+%=+@==@=+#-@@+:#@==++-#@@@@@@
@@@@@@@@@%@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@**@@@*%@@#%%***#@@@@@%***#@@#***@@#*%@@%*%%***#@##@@@*%****#%*@##@@%#@@***#@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@==-+@#.:+@.**:##+:%@@*:*%#+%-=#%*:%=.:@%:.**.##:+=-@@#.##*.*%+.@::=@*:%:+##+%@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@*.#*.##:%==:**:@@@.*@@=-@@@@#.#@@@:*==*--#:**.*++%=-@@#.%@%.%@*:@:**---*.@@*==@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@%-*##+-#-@@*:**-++=*@@@@+=+==@#=++=+@+=@=+@-#*-@@@@#==+=+@@%-%@*-@-*@%-=@*=++=*@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

