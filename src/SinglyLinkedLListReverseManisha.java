
public class SinglyLinkedLListReverseManisha<A> {

	private Node<A> a;
	private Node<A> front;
	 
	static class Node<A>{
		Node<A> next;
		A a;
		public Node(Node<A> next, A a) {
			this.next = next;
			this.a = a;
		}
		
	}
	
	
	public void rev(){
		Node pp = a;
		Node c = null;
		rev1(pp,c);
	}
	
	public void rev1(Node<A> pp, Node<A> c){
		Node<A> b;
		Node<A> f;

		if (pp == null)
			return;

		b = c;
		f = pp;
		a = f;
		rev1(pp = pp.next, c = f);
		f.next = b;
	}
	public void add(A aa) {

		if (a == null) {
			a = new Node<>(null, aa);
			front = a;
		} else {
			Node v = new Node<>(null, aa);
			front.next = v;
			front = v;
		}
	}
	public static void main(String[] args) {
		SinglyLinkedLListReverseManisha<String> aiLinkedList = new SinglyLinkedLListReverseManisha();
		aiLinkedList.add("aa");
		aiLinkedList.add("bb");
		aiLinkedList.add("cc");
		aiLinkedList.rev();
		System.out.println(aiLinkedList.a.a + "==" + aiLinkedList.a.next.a + ", kk = " + aiLinkedList.a.next.next.a);
		
	}

}
