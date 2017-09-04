
public class ReversingLinkedListIterJava2Blog {

	private Node head;
	
	private static class Node{
		private int value;
		private Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public void addToLast(Node node){
		if(head == null){
			head = node;
			
		}else{
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = node;
		}
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	
	//reverse linked list using this function
	public static Node reverseLinkedListIteration(Node currentNode){
		
		//for first node, previousNode will be null
		Node previousNode = null;
		Node nextNode;
		while(currentNode!= null){
			nextNode = currentNode.next;
			currentNode.next =previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}
	
	public static Node reverseLinkedListRecursion(Node node){
		if(node==null || node.next == null){
			return node;
		}
		Node remaining = reverseLinkedListRecursion(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}
	
	public static void main(String[] args) {
		ReversingLinkedListIterJava2Blog lList = new ReversingLinkedListIterJava2Blog();
		Node head = new Node(5);
		lList.addToLast(head);
		lList.addToLast(new Node(6));
		lList.addToLast(new Node(7));
		lList.addToLast(new Node(1));
		lList.addToLast(new Node(2));
		
		lList.printList(head);
		
		Node reverseHead = lList.reverseLinkedListRecursion(head);
		System.out.println("After reversing ");
		lList.printList(reverseHead);
	}
}
