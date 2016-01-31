package src.com.ctci.c1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Cracking the Coding interview: Chap1: Q1
 * Write a method to check if a string has duplicates or not.
 * Can you do it without any additional data structure.
 */
public class CheckDuplicates {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = reader.nextLine();
		reader.close();
		System.out.println(checkDuplicate_3(str));
	}
	/*Part 1: In linear time*/
	private static boolean checkDuplicate(String str){
		ArrayList<Character> ch = new ArrayList<Character>(str.length());
		for(int i=0; i< str.length(); i++){
			if(ch.contains(str.charAt(i))){
				return false;
			}
			else if(str.charAt(i) == ' '){
				continue;
			}
			else{
				ch.add(str.charAt(i));
			}
		}
		return true;
	}
	
	//Better Solution without using ArrayList or for very large String
	private static boolean checkDuplicate_2(String str){
		boolean[] char_set = new boolean[256];
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
	
	/* Another way is if we assume that the string is all lower case 'a' to 'z'
	 * We can use bitwise operation and check for duplicates using a single int.
	 */
	private static boolean checkDuplicate_3(String str){
		int checker = 0;
		for(int i=0; i< str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val))>0) return false;
			checker |= (1<<val);
		}
		return true;
	}
	
	/*In 0 space, but time complex is exponential O(n^2)*/
	private static boolean checkDuplicate_1(String str){
		for(int i = 0; i<str.length(); i++){
			for(int j=i+1; j<str.length(); j++){
				if(str.charAt(i) != ' ' || str.charAt(j) != ' '){
					if(str.charAt(i) == str.charAt(j)){
						return false;
					}
				}
			}
		}
		return true;
	}

}
