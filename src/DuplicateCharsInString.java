import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {

	public static void main(String[] args) {
		DuplicateCharsInString duplicateCharsInString = new DuplicateCharsInString();
		duplicateCharsInString.findDuplicateChars("java2Novice");

	}
	
	public void findDuplicateChars(String str){
		Map<Character, Integer> dupMap = new HashMap<>();
		char[] chrs = str.toCharArray();
		for(Character ch:chrs){
			if(dupMap.containsKey(ch)){
				dupMap.put(ch, dupMap.get(ch)+1);
			}else{
				dupMap.put(ch, 1);
			}
		}
		Set<Character> keys = dupMap.keySet();
		for(Character ch:keys){
			if(dupMap.get(ch)>1){
				System.out.println(ch+"-------------->"+dupMap.get(ch));
			}
		}
	}

}
