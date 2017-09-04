
public class FindingTheMissingNumber {

	
	static int getMissingNoUsingTotal(int[] array, int n){
		int i, total;
		total = (n+1)*(n+2)/2;
		for(int k:array){
			total = total-k;
		}
		return total;
	}
	

	public static void main(String[] args) {
		int arr[] = {1,2,4,5,6};
		int miss =getMissingNoUsingTotal(arr, arr.length);
		System.out.println("Missing no is : "+miss);

	}

}
