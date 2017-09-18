package GeekForGeeks.Stacks;

import java.util.Stack;

public class InfixToPostFix {

		
		//A utility function to return prcedence of a given operator
		//higher returned value means higher precedence
		static int prec(char ch){
			switch(ch){
			case '+':
			case '-':
				return 1;
			case'*':
			case'/':
				return 2;
			case'^':
				return 3;
		}
		return -1;
	}
		
		//the main method that convert given infix expression to postfix
		static String infixToPostFix(String exp){
		String result = new String("");
		
		//initialize empty stack
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<exp.length(); ++i){
			char c = exp.charAt(i);
			
			//if the scanned charecter is an operand, add it to output
			if(Character.isLetter(c))
				result+=c;
			//if the scanned character is an '(', push it to the stack
			else if(c=='(')
				stack.push(c);
			
			//if the scanned character is an ')', pop and output from the stack
			//until an '(' is encountered
			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek()!='(')
					result+=stack.pop();
			if(!stack.isEmpty() && stack.peek()!='(')
				return "Invalid Expression";
			else
				stack.pop();
		}
			else{
				while(!stack.isEmpty() && prec(c)<=prec(stack.peek()))
					result+=stack.pop();
				stack.push(c);
			}
		}
	//pop all the operator from the stack
		while(!stack.isEmpty())
			result +=stack.pop();
		
		return result;
	}

		public static void main(String[] args) {
			String exp = "a+b*(c^d-e)^(f+g*h)-i";
			System.out.println(infixToPostFix(exp));
		}
}


