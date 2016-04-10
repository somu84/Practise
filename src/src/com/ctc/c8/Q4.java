package src.com.ctc.c8;
/*
 * Write a program to print all permutations of a string.
 */
import java.util.ArrayList;

public class Q4 {

	public static void main(String[] args){
		ArrayList<String> per = getPermutation("abc");
		for(String word: per){
			System.out.println(word);
		}
	}

	public static ArrayList<String> getPermutation(String s){
		ArrayList<String> permutations = new ArrayList<String>();
		if(s == null)
			return null;
		if(s.length() == 0){
			permutations.add("");
			return permutations;
		}
		//Get the first char
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPermutation(remainder);
		for(String word: words){
			for(int j=0; j<=word.length(); j++){
				permutations.add(insertChar(word, first, j));
			}
		}
		return permutations;
	}
	
	private static String insertChar(String word, char f, int i){
		String first = word.substring(0, i);
		String last = word.substring(i);
		return first+f+last;
	}
}
