import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

	static Set<String> s = new HashSet<>();
	static public void stringPermutation(String input){
		stringPermutation("",input);
	}
	private static void stringPermutation(String permutation, String input){
		if(input.length() == 0)
		{
			s.add(permutation);
			System.out.println(permutation);
		}else{
			for(int i=0;i<input.length();i++){
				stringPermutation(permutation+input.charAt(i),input.substring(0, i)+input.substring(i+1,input.length()) );
			}
		}
	}
	
	public static void main(String[] args) {
		String[] sArr = {"jsp", "jps","abc","cde"};
		stringPermutation("jsp");
		int count = 0;
		for(String s2: sArr){
			if(s.contains(s2))
				count++;
			
		}
		
		System.out.println("Possible combination of string array "+count);
	}
}
