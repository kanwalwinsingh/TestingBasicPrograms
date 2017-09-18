package GeekForGeeks.Stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CalculateStockSpan {

	//  method to calculate stock span values
	    static void calculateSpan(int price[], int n, int S[])
	    {
        S[0] = 1;
         
        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++)
        {
            S[i] = 1; // Initialize span value
             
            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                S[i]++;
        }
    }
	    
	    
	    
	    //a linear time solution for stock span problem
	    //A stack based efficeient method to calculate stock span values
	    static void calculateSpanWithStack(int price[], int n, int S[]){
	    
	    	//Create a stack and push index of first element to it
	    	Stack<Integer> st = new Stack<>();
	    	st.push(0);
	    	
	    	//Span value of ofirst element is always 1
	    	S[0] = 1;
	    	
	    	//calculate span values for rest of the elements
	    	for(int i=1; i<n;i++){
	    		
	    		//pop elements from stack while stack is not empty and top of
	    		//stack is smaller than price[i]
	    		while(!st.empty()&& price[st.peek()]<= price[i])
	    			st.pop();
	    		
	    		//If stack becomes empty, then price[i] is greater than all elements
	    		//on left of it, i.e, price[0], price[1],..price[i-1]. Else price[i]
	    		//is greater than element after top of stack
	    		S[i] = (st.empty())?(i+1):(i-st.peek());
	    		
	    		//push this element to stack
	    		st.push(i);
	    	}
	    }
	    
	    
	    
		
		//A utility function to print element of array
		static void printArrray(int arr[]){
			System.out.println(Arrays.toString(arr));
		}
		
		
		//driver program to test above functions
		public static void main(String[] args){
			int price[] = {10,4,5,90,120,80};
			int n = price.length;
			int S[] = new int[n];
			
			
			//fill the span values in array S[]
			calculateSpanWithStack(price, n, S);
			
			//print the calculated span values
			printArrray(S);
		}
		
	}


