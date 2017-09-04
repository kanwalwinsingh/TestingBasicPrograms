
public class FindingLoopInLinkedList {

	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	
	public void push(int new_data){
		Node new_node = new Node(new_data);
		if(head==null)
			head = new_node;
		new_node.next = head;
		head = new_node;
	}
	
	int detectLoop(){
		Node slow_p = head, fast_p = head;
		while(slow_p!=null && fast_p!=null && fast_p.next!= null){
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if(slow_p == fast_p){
				System.out.println("Found loop");
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		FindingLoopInLinkedList linkedList =  new FindingLoopInLinkedList();
		linkedList.push(20);
		linkedList.push(4);
		linkedList.push(15);
		linkedList.push(10);
		
		linkedList.head.next.next.next.next = linkedList.head;
		
		linkedList.detectLoop();
		


	}
	

}
