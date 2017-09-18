
public class IntersectionOftwosortedLinkedList {

	Node head;
	
	private class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		
	}
	
	public Node getIntersectionNode(Node headA, Node headB){
		Node left = headA;
		Node right = headB;
		IntersectionOftwosortedLinkedList l3 = new IntersectionOftwosortedLinkedList();
		l3.head = null;
		while(left!=null && right!=null){
		if(left.data<right.data){
			left = left.next;
		}else if(left.data>right.data){
			right=right.next;
		}else{
			
			l3.push(left.data);
			left= left.next;
			right = right.next;
		}
		}
		return l3.head;
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	static boolean areIdenticalIterative(Node headA, Node headB) {
		Node a = headA, b = headB;
		while (a != null && b != null) {
			if (a.data != b.data)
				return false;

			a = a.next;
			b = b.next;
		}
		return (a == null && b == null);

	}
	
	static boolean areIdenticalRecursive(Node a, Node b){
		
		//if both list are empty
		if(a==null && b==null)
			return true;
		
		if(a!=null && b!=null)
			return (a.data==b.data) && areIdenticalRecursive(a.next, b.next);
		
		return false;
	}
	 
	public void printList(Node node){{
		while(node!=null){
			System.out.println("->"+node.data);
			node = node.next;
		}
	}
		
	}
	public static void main(String[] args) {

		IntersectionOftwosortedLinkedList l1 = new IntersectionOftwosortedLinkedList();
		IntersectionOftwosortedLinkedList l2 = new IntersectionOftwosortedLinkedList();
		l1.push(6);
		l1.push(5);
		l1.push(4);
		l1.push(3);
		l1.push(2);
		l1.push(1);
		l1.printList(l1.head);
		
		
		l2.push(9);
		l2.push(8);
		l2.push(7);
		l2.push(6);
		l2.push(5);
		l2.push(4);
		l2.printList(l2.head);
		
		System.out.println("The two result are identical "+areIdenticalIterative(l1.head, l1.head));
		
		System.out.println("The two result are identical "+areIdenticalRecursive(l1.head, l2.head));
		
	/*	IntersectionOftwosortedLinkedList l3  = new IntersectionOftwosortedLinkedList();
		l3.head = l1.getIntersectionNode(l1.head, l2.head);
		System.out.println("--->");
		l3.printList(l3.head);*/
		
		
		
	}

}
