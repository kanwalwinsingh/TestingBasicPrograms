package GeekForGeeks.Stacks;

import java.util.Stack;

public class ReversingStackUsingRecursion {

	//using stack class for stack implementation
	static Stack<Character> st = new Stack<>();
	
	//below is a recursion function that insers amn elemnt at the bottom of stack
	static void insert_at_bottom(char x){
		if(st.empty())
			st.push(x);
		else{
			/*
			 * All items are held in fuction call stack until we
			 * reach end of the stack. when the stack becomes empty,
			 * the st.size() becomes 0, the above if part is excuted and the item is inserted at the bottom
			 * 
			 */
			char a = st.peek();
			st.pop();
			insert_at_bottom(x);
			
			//push all the items held in fuction call stack
			//once the item is inserted at the bottom
			st.push(a);
		}
	}
	
	//below is the fuction that reverses the given stack using insert_at+the+bottom
	static void reverse(){
		
		if(st.size()>0){
			//hold all items in function call stack until we reach end of the stack
			char x = st.peek();
			st.pop();
			reverse();
			/*
			 * Insert all the items held in fuction call stack
			 * one by one from the bottom to to[. every item is
			 * inserted at the bottom
			 * 
			 */
			insert_at_bottom(x);
		}
	}
	
	public static void main(String[] args) {


		//push element into the stack
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');
		
		System.out.println("Original stack");
		System.out.println(st);
		
		//function to reverse the stack
		reverse();
		
		System.out.println("Reversed stack");
		
		System.out.println(st);

	}
	

}
