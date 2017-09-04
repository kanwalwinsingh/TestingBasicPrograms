import java.util.HashMap;

public class FindSumPairsInArray {

	static int getPairsCount(int n, int sum, int arr[]){
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<n; i++){
			if(!hm.containsKey(arr[i]))
				hm.put(arr[i], 0);
			
			hm.put(arr[i], hm.get(arr[i])+1);
		}
		int twice_count = 0;

	for(int i=0; i<n;i++){
		twice_count +=hm.get(sum-arr[i]);
		
		if(sum-arr[i] == arr[i])
			twice_count--;
	}
	return twice_count/2;
}
	
	public static void getPairsCountTwoLoops(int[] arr, int sum){
		int count=0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i]+arr[j]==sum)
					count++;
			}
		}
		System.out.println("Count of pair is %d"+count);
	}
	
	public static void main(String[] args) {
		int sum =6;
		int arr[] = new int[]{1, 5, 7, -1, 5};
		getPairsCountTwoLoops(arr,sum);
		System.out.println("Count of pairs is "+ getPairsCount(arr.length, sum, arr));
	}
}
