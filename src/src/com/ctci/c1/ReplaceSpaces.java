package src.com.ctci.c1;
/*
 * Cracking the Coding interview: Chap1: Q5
 * Replace all spaces in string by '%20'
 */
public class ReplaceSpaces {

	public static void main(String[] args) {
		String str = new String("Hello World my name is Slim Shady!");
		System.out.println(replaceSpace(str));
		return;
	}
	public static String replaceSpace(String str){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == ' '){
				sb.append("%20");
			}
			else{
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

}
