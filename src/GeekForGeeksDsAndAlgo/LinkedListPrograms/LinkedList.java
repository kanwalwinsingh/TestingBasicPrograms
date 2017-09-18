package GeekForGeeksDsAndAlgo.LinkedListPrograms;

import java.util.HashSet;

import sun.util.resources.cldr.ur.CurrencyNames_ur;

public class LinkedList {

	
	public LinkedList() {
	}

	Node head;
	
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}	
	}
	
	public void printList(){
		Node n =head;
		while(n!=null){
			System.out.println(n.data+ " ");
			n = n.next;
		}
	}
	
	public void addAtFirst(int newData){
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
	
	
	public void addAfter(int after, int newData){
		Node newNode = new Node(newData);
		
		Node n = head;
		while(n!=null){
		if(n.data==after){
			newNode.next = n.next;
			n.next = newNode;
		}
		n = n.next;
		}
	}
	
	public void addAtLast(int newData){
	Node newNode = new Node(newData);
	if(head==null){
		head = newNode;
	}
	else{
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = newNode;
	}
			
	}
	
	public void deleteNode(int key){
		Node temp = head;
		Node prev = null;
		if(temp!=null && temp.data==key){
			temp = temp.next;
		}
		else{
			while(temp.next!=null && temp.data!=key){
				prev =temp;
				temp = temp.next;
			}
			if(temp==null) return;
			prev.next = temp.next;
		}
	}
	
	public void deleteNodeAtGivenPosition(int position){
		Node temp = head;
		Node prev = null;
		if(temp == null) return;
		if(position==0){
			temp = temp.next;
		}
		else{
			for(int i=0; i<position-1 && temp!=null;i++){
				temp = temp.next;
			}
			if(temp==null||temp.next==null){
				return;
			}
			Node next = temp.next.next;
			temp.next = next;
		}
	}
	
	public int getCountIterative(Node node){
		Node temp = node;
		int count = 0;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int getCountRecur(Node node){
		if(node==null)
			return 0;
		
		return 1+ getCountRecur(node.next);
	}
	

	public boolean searchIteration(Node head, int x){
		Node current = head;
		while(current!=null){
			if(current.data == x){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	public boolean searchRecursion(Node head, int x){
		if(head==null){
			return false;
		}
		if(head.data==x){
			return true;
		}
		return searchRecursion(head.next, x);
	}
	
	/* Function to swap nodes xa nad y in linked list by changing links*/
	public void swapNodes(int x, int y){
		
		//Nothing to do if x and y are same
		if(x==y) return;

		//Search for x (keep track of prevX and currX)
		Node prevX = null, currX =head;
		while(currX!=null && currX.data!=x)
		{
			prevX = currX;
			currX = currX.next;
		}
		
		//Search for y (keep track of prevY and currY)
		Node prevY = null, currY =head;
		while(currY!=null && currY.data!=y){
			prevY = currY;
			currY = currY.next;
		}
		
		  // If either x or y is not present, nothing to do
		if(currX==null || currY == null)
			return;
		
		//if x is not head of linked list
		if(prevX!=null){
			prevX.next = currY;
		}else{
			head = currY;
		}
		
		//if y is not head of linked list
		if(prevY!=null){
			prevY.next = currX;
		}else{
			head =currX;
		}
		
		//Swap next Pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		
	}
	
	public static int getNthNode(int index, Node node){
		if(node== null)
			return 0;
		int counter = 0;
		while(node!=null){
			if(counter==index)
				return node.data;
			counter++;
			node = node.next;
		}
		return 0;
	
	}
	
	static void  printMiddle(Node node){
		Node slow_ptr = node;
		Node fast_ptr =node;
		if(node!=null){
			while(fast_ptr!=null && fast_ptr.next!=null){
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is["+slow_ptr.data+"]\n");
		}
	}
	
	//function to get the nth node form the last of a linked list
	static void printNthFromLastUsingLength(Node node,int n){
		int len = 0;
		Node temp = node;
		
		//1)count the number of nodes in linked list
		while(temp!=null){
			temp = temp.next;
			len++;
		}
		
		//check if value of n is not more than length of linked list
		if(len<n)
			return;
		
		temp = node;
		
		//2) get the (len -n+1) node form the beginig
		for(int i=1;i<len-n+1;i++)
			temp =temp.next;
		System.out.println(temp.data);
	}
	
	
	static void printNthFromLastMAintaningTwoPointers(Node node, int n ){
		Node main_ptr = node;
		Node ref_ptr =  node;
		
		int count = 0;
		if(node!=null){
			while(count<n){
				if(ref_ptr == null){
					System.out.println(n+" is greater than th no "+ " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}
			while(ref_ptr!=null){
				main_ptr = main_ptr.next;
				ref_ptr = ref_ptr.next;
			}
			System.out.println("Node no. "+n+" from last is "+main_ptr.data);
		}
	}
	
	public static void deleteList(Node node){
	node = null;
	}
	
	public static int getCountForSpecificData(Node node, int x){
		
		Node temp = node;
		if(temp == null)
			return 0;
		int count = 0;
				while(temp!=null){
					if(temp.data == x){
						count++;
					}
					temp = temp.next;
				}
				return count;
	}
	
	private static Node reverseUsingIteration(Node node){
		Node prev = null;
		Node current = node;
		Node pointer = null;
		while(current!=null){
			pointer = current.next;
			current.next = prev;
			prev= current;
			current = pointer;
		}
		node =prev;
		return node;
	}
	
	private Node reverseLinkListUsingRecursion(Node curr, Node prev){
		
		//if last node mark it null
		if(curr.next==null){
			head = curr;
			
			//update next with prev
			curr.next = prev;
			return null;
		}
		
		//savecurr.next for recursive call
		Node next1 = curr.next;
		
		//and update next
		curr.next = prev;
		reverseLinkListUsingRecursion(next1, curr);
		return head;
	}
	
	private int detectLoop(Node node){
		Node slowPtr = node;
		Node fastPtr = node;
		
		while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr){
				System.out.println("Found loop");
				return 1;
			}
			
		}
		return 0;
	}
	
	//function to print reverse of linked list
	void printReverse(Node node){
		if(node == null)
			return;
		
		//print list of head node
		printReverse(node.next);
		
		//after everything is printed
		System.out.println(node.data+ " ");
	}
	
	void removeDuplicatesInSortedList(){
		Node current = head;
		
		//pointer to store the next pointer of a node to be deleted;
		Node next_next;
		
		//do nothing if the list is empty
		if(head==null)
			return;
		
		//traverse list till the last node node
		while(current.next!=null){
			
			//compare current node with next node
			if(current.data == current.next.data){
				current.next = current.next.next;
			}else{
				current = current.next;
			}
		}
		
	}
	
	static void removeDuplicateInUnsortedListUsingHashing(Node node){
		HashSet<Integer> hashSet = new HashSet<>();
		
		//pick element one by one
		Node current = node;
		Node prev = null;
		while(current!=null){
			int currentvalue = current.data;
			
			//if current value is seen before 
			if(hashSet.contains(currentvalue)){
				prev.next = current.next;
			}else{
				hashSet.add(currentvalue);
				prev = current;
			}
			current = current.next;
				
			
		}
	}
	
	void pairwiseSwapIterativeWay(){
		Node temp = head;
		
		//traverse only till there are atleast 2 nodes left
		while(temp!=null && temp.next!=null){
			//swap thedata
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data =k;
			temp = temp.next.next;
		}
	}
	
	//recursive function to pairwise swap elements of a linked list
	void pairWiseSwapRecursive(Node node){
		
		//there must be at least two nodes in the list
		if(node!=null && node.next!=null){
			
			int k = node.data;
			node.data = node.next.data;
			node.next.data =k;
			
			pairWiseSwapRecursive(node.next.next);
			
		}
	}
	
	void moveToFront(){
		
		//if linked list is empty or it contains only
		//one node then simply return;
		if(head==null||head.next==null)
			return;
		
		//initialize second last and last pointer;
		Node secLast = null;
		Node last = head;
		
		while(last.next!=null){
			secLast = last;
			last = last.next;
		}
		secLast.next = null;
		last.next = head;
		head = last;
	}
	
	void deleteAlternativeIterative() {
		if (head == null)
			return;

		Node prev = head;
		Node current = head.next;
		while (prev != null && current != null) {

			// change next link of previous node
			prev.next = current.next;

			// free node
			current = null;

			// update previous and current
			prev = prev.next;
			if (prev != null) {
				current = prev.next;
			}

		}
	}
	
	void deleteAlternativeRecursive(Node head) {
		if (head == null) {
			return;
		}
		Node node = head.next;
		if (node == null) {
			return;
		}

		head.next = node.next;

		deleteAlternativeRecursive(head.next);

	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fivth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);
		list.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fivth;
		fivth.next = sixth;
		sixth.next = seventh;
		
		
		System.out.println("Printing complete linked list----------");
		list.printList();

		System.out.println("Printing complete linked list after deleting alternative Recursive----------");
		list.deleteAlternativeRecursive(list.head);
		list.printList();
	
/*		System.out.println("Count using iteration----------");
		System.out.println(list.getCountIterative(list.head));
		
		 System.out.println("Count of 3 in linked list is: " +getCountForSpecificData(list.head, 7) ); 
		 
		System.out.println("Count using recursion----------");
		System.out.println(list.getCountRecur(list.head));
		
		list.head = list.reverseUsingIteration(list.head);
		System.out.println("Printing After reverse linked list----------");
		list.printList();
	
	System.out.println("Printing complete linked list after making last as first----------");
		list.moveToFront();
		list.printList();
		
		System.out.println("Printing complete linked list after swap----------");
		list.pairwiseSwapIterativeWay();
		list.printList();
		
		System.out.println("Detect loop in linked list----------");
		list.detectLoop(list.head);
		
		list.head = list.reverseLinkListUsingRecursion(list.head, null);
		System.out.println("Printing After reverse linked list----------");
		list.printList();
		
		System.out.println("Printing complete linked list after swap----------");
		list.pairWiseSwapRecursive(list.head);
		list.printList();
		
		System.out.println("Printing complete linked list----------");
		list.printList();
		
		System.out.println("Printing  linked list After removing duplicates----------");
		list.removeDuplicatesInSortedList();
		list.printList();
		
		System.out.println("Printing  linked list After removing duplicates----------");
		list.removeDuplicateInUnsortedListUsingHashing(list.head);
		list.printList();
		
		System.out.println("Printing nth from last using length of linked list------------");
		list.printNthFromLastUsingLength(list.head, 3);
		
		System.out.println("value of nth node is----------");
		System.out.println(list.getNthNode(9, list.head));
		
		System.out.println("Printing nth from last using two pointers of linked list------------");
		list.printNthFromLastMAintaningTwoPointers(list.head, 3); 
		
		list.printMiddle(list.head);
		
		System.out.println("Printing searching using iterative way list----------");
		System.out.println(list.searchRecursion(list.head, 5));
		
		list.swapNodes(7, 1);
	    System.out.println("\n Linked list after calling swapNodes() ");
	    list.printList();
	    
	    		System.out.println("Printing complete linked list after deleting alternative Iterative----------");
		list.deleteAlternativeIterative();
		list.printList();
	    
		System.out.println("Insert After----------");
		list.addAfter(2, 5);
		list.printList();
		
		System.out.println("Insert starting----------");
		list.addAtFirst(6);
		list.printList();
		
		System.out.println("Insert ending----------");
		list.addAtLast(9);
		list.printList();
		
//		System.out.println("deleting a purticular Node----------");
//		list.deleteNode(3);
//		list.printList();


		System.out.println("Printing reverse of linked list----------");
		list.printReverse(list.head);
		
		System.out.println("deleting a purticular position----------");
		list.deleteNodeAtGivenPosition(4);
		list.printList();*/
	}
	
	
}
