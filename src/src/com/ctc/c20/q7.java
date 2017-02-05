package src.com.ctc.c20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class q7 {

	/**
	 * Trie class implementation
	 * @author Somu
	 *
	 */
	static class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}
	
	public static TrieNode root = new TrieNode();
	
	public static ArrayList<String> validPref = new ArrayList<String>();
	
	/**
	 * Modified the trie insert to push all valid prefixes in a seperate list
	 * @param word
	 */
	public static void insert(String word){
		TrieNode curr = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			if(node == null){
				node = new TrieNode();
				curr.children.put(ch, node);
			}
			//Add all valid Prefixes in a separate list
			else if(curr.endOfWord == true){
				if(!validPref.contains(word))
					validPref.add(word);
			}
			curr = node;
		}
		curr.endOfWord = true;
	}
	
	/**
	 * Custom comparator to sort the array based on string length
	 * @author Somu
	 *
	 */
	static class LengthComp implements Comparator<String>{

		@Override
		public int compare(String arg1, String arg2) {
			if(arg1.length() < arg2.length())
				return -11;
			else if(arg1.length() > arg2.length())
				return 1;
			else
				return 0;
		}
		
	}
	
	/**
	 * Main function to get the longest word.
	 * @param strList
	 * @return
	 */
	public static String getLongest(String [] strList){
		
		//Sort the array based on length
		LengthComp check = new LengthComp();
		Arrays.sort(strList, check);
		//Insert all the words into the Trie
		insertAll(strList);
		int max = 0;
		String maxWord = null;
		//Search the longest word
		for(String word:validPref){
			int curr = searchCompund(word);
			if(max < curr){
				max = curr;
				maxWord = new String(word);
			}
		}
		return maxWord;
	}
	
	/**
	 * Function that builds the Trie, based on the String array.
	 * @param strArr
	 * @return
	 */
	public static void insertAll (String[] strArr){
		for(String s: strArr){
			insert(s);
		}
	}
	
	/**
	 * Recursive function to check for compound strings
	 * @param str
	 * @param t
	 * @return
	 */
	public static int searchCompund(String str){ 
		TrieNode curr = root;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			TrieNode node = curr.children.get(ch);
			if(node == null){
				return -1;
			}
			if(node.endOfWord){
				//Search again from the beginning
				curr = root;
			}
			curr = node;
		}
		return str.length();
	}
	
	/**
	 * Driver method
	 * @param args
	 */
	public static void main(String[] args){
		String[] arr = {"cat", "cats", "catsdogcats", "catxdogcatsrat", "dog", "dogcatsdog", "ratcatdogcat", "hippopotamuses", "rat", "ratcat", "ratcatdog" };
		String str = getLongest(arr);
		if(str!= null){
			System.out.println(str);
		}
		else
			System.out.println("None");
					
		
	}
}
