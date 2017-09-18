package GeekForGeeksDsAndAlgo.LinkedListPrograms;

public class MergeSortLinkedList {

	Node head;
	
	static class Node{
		
		int val;
		Node next;
		public Node(int val){
			this.val = val;
		}
		
	}
	
	Node sortedMerge(Node a , Node b){
		Node result  = null;
		//base cases
		if(a==null)
			return b;
		if(b==null)
			return a;
		
		//pick either a or b, and recur
		if(a.val<=b.val){
			result = a;
			result.next = sortedMerge(a.next, b);
		}else{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}
	
	Node mergeSort(Node h){
		
		//Base case if head is null
		if(h==null || h.next == null){
			return h;
		}
		
		//get the middle of the list
		Node middle = getMiddle(h);
		Node nextOfMiddle = middle.next;
		
		//set the next of middle node to null
		middle.next = null;
		
		//Apply mergesort on left list
		Node left = mergeSort(h);
		
		//Apply mergesort on right list
		Node right = mergeSort(nextOfMiddle);
		
		//Merge the left and right list
		Node sortedList = sortedMerge(left, right);
		return sortedList;
		
	}
	
	//Utility function to get the middle of the linked list
	Node getMiddle(Node h) {

		// Base case
		if (h == null)
			return h;
		Node fastptr = h.next;
		Node slowptr = h;

		// Move fastptr by two slowptr by pne
		// finally slowptr will point to middle node
		while (fastptr != null) {

			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}

		return slowptr;

	}
	
	 void push(int new_data) 
	    {
	        /* allocate node */
	        Node new_node = new Node(new_data);
	 
	        /* link the old list off the new node */
	        new_node.next = head;
	 
	        /* move the head to point to the new node */
	        head = new_node;
	    }
	 
	    // Utility function to print the linked list
	    void printList(Node headref) 
	    {
	        while (headref != null) 
	        {
	            System.out.print(headref.val + " ");
	            headref = headref.next;
	        }
	    }
	public static void main(String[] args) {
		
		MergeSortLinkedList lList = new MergeSortLinkedList();
		lList.push(15);
		lList.push(10);
		lList.push(5);
		lList.push(20);
		lList.push(3);
		lList.push(2);
	}

}
