package src.com.prac;
/*
 * Recursively check if a sentence is a palindrome
 */
public class PalindromeSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stn = "Evil olgve";
		System.out.println(stn+ " is a palindrome: "+isPalindrome(stn.toLowerCase()));
	}
	public static boolean isPalindrome(String stn){
		int len = stn.length() -1;
		if(len <= 1)
			return true;
		if(stn.charAt(0) == stn.charAt(len)){
			String newStn = stn.substring(1, len);
			return isPalindrome(newStn);
		}
			
		return false;
	}
}
