import java.awt.List;

public class FindingAndRemovingLoopInLInkedList {

	
	static Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
	}
		
		//Function that detects loop in the list
		void detectAndRemoveLoop(Node node){
			
			//If list is empty pr has only one node without loop
			if(node==null || node.next ==null)
				return;
			
			Node slow =node, fast = node;
			
			//Move slow and fast 1 and 2 steps
			//ahead respectively
			slow = slow.next;
			fast = fast.next.next;
			
			// Search for loop using slow and fast pointers
			while(fast!=null && fast.next!=null){
				if(slow==fast){
					break;
				}
				slow = slow.next;
				fast = fast.next.next;
			}
			
			 /* If loop exists */
			if(slow == fast){
				slow = node;
				while(slow.next !=fast.next){
					slow = slow.next;
					fast = fast.next;
				}
				
				/* since fast->next is the looping point */
				fast.next = null;/* remove loop */
			}
			
		}
		
		void printlist(Node node){
			while(node!=null){
				System.out.println(node.data + " ");
				node = node.next;
			}
		}
	public static void main(String[] args) {
		FindingAndRemovingLoopInLInkedList linkedList = new FindingAndRemovingLoopInLInkedList();
		linkedList.head = new Node(50);
		linkedList.head.next = new Node(20);
		linkedList.head.next.next = new Node(15);
		linkedList.head.next.next.next = new Node(4);
		linkedList.head.next.next.next.next = new Node(10);
		
		// Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
		
        linkedList.detectAndRemoveLoop(head);
        System.out.println("Linked kist after removing loop");
        linkedList.printlist(head);

	}

}
