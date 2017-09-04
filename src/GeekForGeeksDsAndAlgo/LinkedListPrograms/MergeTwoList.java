package GeekForGeeksDsAndAlgo.LinkedListPrograms;

public class MergeTwoList {

	Node head;
	
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
		
	}
	
	private Node mergeUsingRecursion(Node list1, Node list2){
		if(list1==null) return list2;
		if(list2==null) return list1;
		if(list1.data<list2.data){
			list1.next = mergeUsingRecursion(list1.next, list2);
			return list1;
		}else{
			list2.next = mergeUsingRecursion(list1, list2.next);
			return list2;
		}
	}
	
	private void printList(Node node){
		while(node!=null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		MergeTwoList m = new MergeTwoList();
		Node n1 = new Node(1);
		m.head = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(5);
		n2.next = n3;
		Node n4 = new Node(7);
		n3.next = n4;
		System.out.println("Printing data of linked list 1");
		m.printList(m.head);
		
		
		MergeTwoList m2 = new MergeTwoList();
		Node n5 = new Node(3);
		m2.head = n5;
		Node n6 = new Node(4);
		n5.next = n6;
		Node n7 = new Node(6);
		n6.next = n7;
		Node n8 = new Node(8);
		n7.next = n8;
		System.out.println("Printing data of linked list 1");
		m.printList(m2.head);
		
		System.out.println("linked list after merging");
		m.printList(m.mergeUsingRecursion(m.head, m2.head));
		
		
		
	}

}
