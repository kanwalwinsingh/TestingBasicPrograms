import java.util.ArrayList;
import java.util.List;

public class TestingGeneric {

	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		list1.add("Java");
		list1.add("is");
		list1.add("a");
		list1.add("Great");
		list1.add("Language");
		TestingRawList(list1); //can pass list of string in method that accept raw list.
		
		//TestingObjectGenericList(list1); //cannot pass list of string in method that accept list of object.
	}
	
	
	public static void TestingRawList(List newList) {
		System.out.println(newList);
		
	}
	
	
public static void TestingObjectGenericList(List<Object> newList) {
		
		System.out.println(newList);
		
	}
}
