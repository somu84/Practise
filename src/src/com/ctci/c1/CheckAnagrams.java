package src.com.ctci.c1;

import java.util.HashMap;
import java.util.Map;

/*
 * Cracking the Coding interview: Chap1: Q4
 * Write a method to check if two strings are anagrams.
 */
public class CheckAnagrams {

	public static void main(String[] args) {
		String str1 = new String("abad");
		String str2 = new String("aabd");
		System.out.printf("%s is an anagram of %s: %s\n", str1, str2, checkAnagram(str1, str2));
	}
	
	public static boolean checkAnagram(String str1, String str2)
	{
		if(str1.length() != str2.length()) return false;
		
		HashMap<Character, Integer> wordCount1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> wordCount2 = new HashMap<Character, Integer>();
		wordCount1 = getWordCount(str1);
		wordCount2 = getWordCount(str2);
		return wordCount1.equals(wordCount2);
	}
	
	public static HashMap<Character, Integer> getWordCount(String str){
		HashMap<Character, Integer> wc = new HashMap<Character, Integer>();
		for(int i= 0; i<str.length(); i++){
			int count = 0;
			if(wc.get(str.charAt(i)) == null)
				count = 0;
			else
				count = (int)wc.get(str.charAt(i));
			count +=1;
			wc.put(str.charAt(i), count);
		}
		return wc;
	}
}
