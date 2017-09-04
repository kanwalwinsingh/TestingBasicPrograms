
public class FindMissingNumberInArray {

	public static void main(String[] args) {

		int n =8;
		int[] a = {1, 4, 5, 3, 7, 8, 6};
		 
        //Step 1
 
        int sumOfNnumbers = SumOfNumbers(n);
 
        //Step 2
 
        int sumOfElements = sumOfElement(a);
 
        //Step 3
 
        int missingNumber = sumOfNnumbers - sumOfElements;
 
        System.out.println("Missing Number is = "+missingNumber);

	}
	
	public static int SumOfNumbers(int n) {
int sum = (n*(n+1))/2;
return sum;
	}

	
	static int sumOfElement(int[] array){
		int sum = 0;
		for(int i=0;i<array.length-1;i++){
			sum = sum + array[i];
		}
		return sum;
	}
}
