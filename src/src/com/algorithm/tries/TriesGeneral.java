package src.com.algorithm.tries;

import java.util.HashMap;

/**
 * This is a generalized implementation of Tries.
 * Instead of using an array of characters. Here we are using a hashmap.
 * This allows us, to support unicode characters along with letters.
 * @author somu
 *
 */

public class TriesGeneral {
	HashMap<Character, TriesGeneral> children;
	boolean endOfWord;
	//This parameter will help us identify number of words that match a prefix.
	int size = 0;
	
	/**
	 * Function to add a string in a Trie.
	 * @param s
	 */
	public void add(String s){
		add(s, 0);
	}
	
	/**
	 * This is the recursive function.
	 * @param s
	 * @param index
	 */
	private void add(String s, int index){
		this.size++;
		if(index == s.length()){
			endOfWord = true;
			return;
		}
		char curr = s.charAt(index);
		TriesGeneral node = this.children.get(curr);
		if(node == null){
			node = new TriesGeneral();
			this.children.put(curr, node);
		}
		node.add(s, index+1);
	}
	
	/**
	 * This recursive function gives the number of valid words in our tire, 
	 * that have the same prefix as the input parameter 's'.
	 * @param s
	 * @param index
	 * @return
	 */
	public int findCount(String s, int index){
		if(index == s.length()){
			return this.size;
		}
		TriesGeneral node = this.children.get(s.charAt(index));
		if(node == null) return 0;
		return node.findCount(s, index+1);
	}
	
}
