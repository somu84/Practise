//To print all the possible of a string
package src.com.prac;

import java.util.ArrayList;

public class AllStringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("abc");
		String str2 = new String("abc");
		if(str == str2){
			System.out.println("True");
			
		}
		combinations(str);
	}
	
	private static void combinations(String str){
		int length = str.length();
		StringBuffer output = new StringBuffer(length);
		combine(str, length, output, 0);
	}
	
	private static void combine(String str, int length, StringBuffer output, int allowedStart){
		if(allowedStart == length){
			return;
		}
		else{
			for(int i=allowedStart; i< length; i++){
				output.append(str.charAt(i));
				System.out.println(output.toString());
				combine(str, length, output, i+1);
				output.deleteCharAt(output.length() - 1);
			}
		}
	}

}
