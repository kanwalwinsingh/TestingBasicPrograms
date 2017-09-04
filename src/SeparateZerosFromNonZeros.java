import java.util.Arrays;

public class SeparateZerosFromNonZeros {

	    static void moveZerosToEnd(int inputArray[])
	    {
	        //Initializing counter to 0
	 
	        int counter = 0;
	 
	        //Traversing inputArray from left to right
	 
	        for (int i = 0; i < inputArray.length; i++)
	        {
	            //If inputArray[i] is non-zero
	 
	            if(inputArray[i] != 0)
	            {
	                //Assigning inputArray[i] to inputArray[counter]
	 
	                inputArray[counter] = inputArray[i];
	 
	                //Incrementing the counter by 1
	 
	                counter++;
	            }
	        }
	 
	        //Assigning zero to remaining elements
	 
	        while (counter < inputArray.length)
	        {
	            inputArray[counter] = 0;
	 
	            counter++;
	        }
	 
	        System.out.println(Arrays.toString(inputArray));
	    }
	 
	    public static void main(String[] args)
	    {
	       // moveZerosToEnd(new int[] {12, 0, 7, 0, 8, 0, 3});
	 
	    	 int[] a = new int[10];
	    	 a[0] = 6;
	    	 System.out.println(Arrays.toString(a));
	         methodOne(a);
	  
	         System.out.print(a.length);
	         System.out.println(Arrays.toString(a));
	    }
	    
	    static void methodOne(int[] a)
	    {
	        int[] b = new int[5];
	 
	        a = b;
	        a[0] = 5;
	        System.out.print(a.length);
	        System.out.println(Arrays.toString(a));
	        System.out.print(b.length);
	    }
	
}
