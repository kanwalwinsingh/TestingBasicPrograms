import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CommonElementINArray {

	public static void main(String[] args) {
		  String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
		  
	        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
	        
	        retainCommonElementUsingIterativeWay(s1, s2);
	        retainCommonElementUsingSetRetainMethod(s1, s2);

	}
	
	public static void retainCommonElementUsingIterativeWay(String[] array1, String[] array2) {
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<array1.length-1; i++){
			for(int j=0;j<array2.length-1; j++){
				if(array1[i].equals(array2[j])){
					set.add(array1[i]);
				}
			}
		}
		System.out.println(set);
	}

	
	public static void  retainCommonElementUsingSetRetainMethod(String[] array1, String[] array2) {
		HashSet<String> set1 = new HashSet<>(Arrays.asList(array1));
		HashSet<String> set2 = new HashSet<>(Arrays.asList(array2));
		set1.retainAll(set2);
		System.out.println(set1);
	}
}
