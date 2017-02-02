package src.com.ctc.c19;

import java.util.HashMap;

/**
 * Design a method to find the frequency of occurrences of any given word in a book.
 * @author Somu
 *
 */
public class q8 {

	/**
	 * Simply build a hashmap with the count of all words.
	 * @param book
	 * @return
	 */
	public static HashMap<String, Integer> buildMap(String []book){
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();	
		for(String word:book){
				if(wordCount.containsKey(word)){
					wordCount.put(word, wordCount.get(word)+1);
				}
				else{
					wordCount.put(word,1);
				}
			}
		return wordCount;
	}
	
	/**
	 * Return the count from the hash, for an input word.
	 * @param wordCount
	 * @param word
	 * @return
	 */
	public static int getFrequency(HashMap<String, Integer> wordCount, String word){
		int count = wordCount.get(word);
		return count;
	}
}
