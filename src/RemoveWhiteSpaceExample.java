
public class RemoveWhiteSpaceExample {

	public static void main(String[] args) {
		String str = "  Core Java jsp servlets             jdbc struts hibernate spring  ";
		
		String strWithoutSpace = str.replaceAll("\\s", "");
		System.out.println(strWithoutSpace);
		
		char[] strArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<strArray.length; i++){
			if((strArray[i]!=' ') && (strArray[i]!='\t')){
				sb.append(strArray[i]);
			}
		}
		System.out.println(sb);

	}

}
