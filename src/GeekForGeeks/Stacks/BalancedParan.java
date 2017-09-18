package GeekForGeeks.Stacks;

import sun.applet.Main;

public class BalancedParan {

	static class stack 
	{
		int top = -1;
		char[] items = new char[100];
		
		void push(char x){
			if(top == 99){
				System.out.println("stack full");
			}else{
				items[++top] = x;
			}
		}
		
		char pop(){
			if(top == -1){
				System.out.println("Underflow error");
				return '\0';
			}else{
				char element = items[top];
				top--;
				return element;
			}
		}
		
		boolean isEmpty(){
			return (top == -1)?true:false;
		}
	}
	
	static boolean isMatchingPair(char character1, char character2)
	{
		if(character1 == '(' &&  character2 == ')')
			return true;
		else if (character1 == '{' &&  character2 == '}')
			return true;
		else if(character1 == '[' &&  character2 == ']')
			return true;
		else 
			return false;
	}
	
	//return true if expression has balanced parenthesis
	static boolean areParenthesisBalanced(char exp[]){
		
		//declare an empty character stack
		stack st = new stack();
		
		//travers the given expression to check matching parenthesis
		for(int i=0;i<exp.length;i++){
			
			//if the exp[i] is a starting
			//parenthesis then pushing it
			if(exp[i] == '{' || exp[i]=='(' || exp[i] == '[')
				st.push(exp[i]);
			
			/*if exp[i] is an extending parenthesis then pop from stack and check if the popped
			 * parenthesis is matching pair */
			if(exp[i] == '}' || exp[i]==')' || exp[i] == ']'){
				
				//if we see an ending parenthesis without
				//a pair the return false
				if(st.isEmpty())
				{
					return false;
							
				}
				/*Pop the top element from stack, if it is not a pair parenthesis of character then
				 * there is a mismatch. this happens for expression like {(})
				 */
				else if(!isMatchingPair(st.pop(), exp[i]))
				{
					return false;
				}
			}
		}
		if(st.isEmpty())
			return true;
		else{
			return false;
		}
	}
	
		public static void main(String[] args) {
			char exp[] = {'{','(',')',']','[','}'};
			if(areParenthesisBalanced(exp))
				System.out.println("Balanced ");
			else
				System.out.println("Not Balanced ");
		}
}
