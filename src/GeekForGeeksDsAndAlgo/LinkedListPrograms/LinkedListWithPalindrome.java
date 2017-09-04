package GeekForGeeksDsAndAlgo.LinkedListPrograms;

public class LinkedListWithPalindrome {

	
	Node head;
	Node slow_ptr, fast_ptr,second_half;
	Node left;
	class Node{
		char data;
		Node next;
		public Node(char data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	public void push(char new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	void printList(Node ptr){
		while(ptr!=null){
			System.out.println(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.println("Null");
	}
	
	
	//function to check if given linked list is palindrome or not in iterative way
	boolean isPalindromeIterative(Node node){
		slow_ptr = head; 
		fast_ptr = head;
		Node prev_of_slow_ptr = node;
		Node midNode = null; //to handle odd size list;
		boolean res = true; // initalize result
		
		if(node!=null & node.next!=null){
			
			/*get the middle of the list. move slow_ptr by 1 and fast_ptr by 2, slow_ptr will
			 
			 * have the middle node*/
			while(fast_ptr!=null && fast_ptr.next!=null){
				fast_ptr  = fast_ptr.next.next;
				
				//we now link the prev of slow otr in case of odd linked list
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.next;
				
			}
			 /* fast_ptr would become NULL when there are even elements 
            in the list and not NULL for odd elements. We need to skip  
            the middle node for odd case and store it somewhere so that
            we can restore the original list */
			if(fast_ptr!=null){
				midNode = slow_ptr;
				slow_ptr = slow_ptr.next;
			}
			
			//now reverse the second half and compare it with first half
			
			second_half = slow_ptr;
			prev_of_slow_ptr.next = null;//null terminate first half;
			
			reverse(); //reverse the second half
			
			res = compareLists(head, second_half); //compare
			
			//construct the original list back
			reverse(); // reverse the second half again
			
			if(midNode!=null){
				//if there was a mid node (odd size case) which
				//was not part of either first half or second half
				
				prev_of_slow_ptr.next = midNode;
				midNode.next = second_half;
			}else{
				prev_of_slow_ptr.next = second_half;
			}
		}
			return res;

	}
	
	//function to reverse the linked list
	void reverse(){
		Node prev = null;
		Node current = second_half;
		Node next;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half = prev;
	}
	
	//function to check if two input list have same data
	boolean compareLists(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		
		while(temp1!=null && temp2!=null){
			if(temp1.data == temp2.data){
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else
				return false;
		}
		//both are empty 
		if(temp1==null && temp2==null)
			return true;
		
		//will reach here when one is null and other is not
		return false;
	}
	
	boolean isPalindromeRecursion(Node node){
		boolean result = isPalindromeRecursionUtil(node);
		return result;
	}
	
	boolean isPalindromeRecursionUtil(Node right){
		
		left = head;
		
		//stop recursion when right becomes null
		if(right == null)
			return true;
		//if sublist is nort palindrome then no need to check
		//for current left and right, return false
		boolean isp = isPalindromeRecursionUtil(right.next);
		if(isp == false)
			return false;
		
		//check values at current left and right
		boolean isp1 = (right.data == (left).data);
		
		//move left to next node
		left = left.next;
		return isp1;
		
	}
	
	public static void main(String[] args) {

		LinkedListWithPalindrome linkedList = new LinkedListWithPalindrome();
		char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
		String string = new String(str);
		for(int i=0;i<7;i++){
			linkedList.push(str[i]);
		}
			if(linkedList.isPalindromeRecursion(linkedList.head)!=false){
				System.out.println("Is palindrome");
				System.out.println("");
			}else{
				System.out.println("Not palindrome");
				System.out.println("");
			}

	}
	

}
