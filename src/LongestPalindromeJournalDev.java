
public class LongestPalindromeJournalDev {

	public static void main(String[] args) {
		System.out.println(longestPalindromeString("1234"));
		System.out.println(longestPalindromeString("12321"));
		System.out.println(longestPalindromeString("9912321456"));
		System.out.println(longestPalindromeString("9912333321456"));
		System.out.println(longestPalindromeString("12145445499"));
		System.out.println(longestPalindromeString("1223213"));
		System.out.println(longestPalindromeString("abb"));

	}
	
	static public String intermediatePalindrome(String s, int left, int right){
		if(left>right)
			return null;
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}

	public static String longestPalindromeString(String s){
		if(s==null) return null;
		String longest = s.substring(0,1);
		for(int i = 0; i<s.length()-1;i++){
			String palindrome = intermediatePalindrome(s, i, i);
			if(palindrome.length()>longest.length()){
				longest = palindrome;
			}
			palindrome = intermediatePalindrome(s, i, i+1);
			if(palindrome.length()>longest.length()){
				longest = palindrome;
			}
		}
		return longest;
	}
}
