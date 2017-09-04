package GeekForGeeksDsAndAlgo.LinkedListPrograms;

public class AddingInSortedLinkedList {

	Node head;
	
	static class Node{
		
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	 void addInSortedList( int data){
		Node newNode = new Node(data);
		Node cuurNode = head;
		if(cuurNode==null){
			newNode.next = cuurNode;
			head = newNode;
		}
		else{
		Node prev = null;
		while(cuurNode!=null){
		if(cuurNode.data>data){
			break;
		}else{
			prev = cuurNode;
			cuurNode = cuurNode.next;
		}

		}
		prev.next = newNode;
		newNode.next = cuurNode;
		}
			
	}
	
	 
	 void deletePurticularNode(Node nodeToDelete){
		 Node temp = nodeToDelete.next;
		 nodeToDelete.data = temp.data;
		 nodeToDelete.next = temp.next;
		 temp = null;
		 
	 }
	static void printList(Node node){
		
		while(node!=null){
			System.out.println("The value of "+node.data);
			node = node.next;
		}
		
	}
	public static void main(String[] args) {

		AddingInSortedLinkedList linkList = new AddingInSortedLinkedList();
		linkList.head = null;
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(9);
		linkList.head = n1;
		n1.next  = n2;
		n2.next = n3;
		n3.next = n4;
		
		linkList.printList(linkList.head);
		
		linkList.addInSortedList(8);
		
		System.out.println("Printing after adding in sorted");
		linkList.printList(linkList.head);
		

	}

}
