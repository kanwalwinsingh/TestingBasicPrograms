import java.util.HashSet;

import com.sun.xml.internal.fastinfoset.util.StringArray;

public class DuplicateInArray {

	public static void main(String[] args) {
		 String[] strArray = {"abc", "def", "mno", "xyz", "pqr", "xyz", "def"};
		 DuplicateUsingBruteForce(strArray);
		 DuplicateUsingHashSet(strArray);
	}

	
	private static void DuplicateUsingBruteForce(String[] array) {
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1; j<array.length;j++){
				if((array[i].equals(array[j]) )&& (i!=j)){
					System.out.println("Duplicate Element is : "+array[j]);
				}
			}
		}
		
	}
	
	
	private static void DuplicateUsingHashSet(String[] array) {
		HashSet<String> set = new HashSet<>();
		for(String arrayElement : array){
			if(!set.add(arrayElement)){
				System.out.println("Duplicate element is : "+arrayElement);
			}
		}
		
		
	}
}
