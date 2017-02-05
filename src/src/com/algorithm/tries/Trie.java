package src.com.algorithm.tries;

import java.util.HashMap;
import java.util.Map;



/**
 * This is a generalized implementation of Tries.
 * Instead of using an array of characters. Here we are using a hashmap.
 * This allows us, to support unicode characters along with letters.
 * @author somu
 *
 */

public class Trie{
	
	private class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
		
		public boolean getEndOfWord(){
			return endOfWord;
		}
	}
	
	public final TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	
	/**
	 * Recursive insert
	 */
	public void insertR(String word){
		insertRecurse(root, word, 0);
	}
	
	/**
	 * Recurse function
	 * @param curr
	 * @param word
	 * @param index
	 */
	private void insertRecurse(TrieNode curr, String word, int index){
		//Base case
		if(index == word.length()){
			curr.endOfWord = true;
			return;
		}
		
		char ch = word.charAt(index);
		TrieNode node = curr.children.get(ch);
		//If node is null create a new node
		if(node == null){
			node = new TrieNode();
			curr.children.put(ch, node);
		}
		insertRecurse(node,word, index+1);
	}
	
	/**
	 * Iterative implementation of insert
	 * @param word
	 */
	public void insertIt(String word){
		TrieNode curr = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			if(node == null){
				node = new TrieNode();
				curr.children.put(ch, node);
			}
			curr = node;
		}
		curr.endOfWord = true;
	}
	
	/**
	 * Iterative search for a word
	 * @param word
	 * @return
	 */
	public boolean searchIt(String word){
		TrieNode curr = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			if(node == null)
				return false;
			curr = node;
		}
		if(curr.endOfWord)
			return true;
		return false;
	}
	
	/**
	 * Recursive search for a word
	 * @param word
	 * @return
	 */
	public boolean searchR(String word){
		return searchRec(root, word, 0);
	}
	
	/**
	 * Recursive function
	 * @param curr
	 * @param word
	 * @param index
	 * @return
	 */
	private boolean searchRec(TrieNode curr, String word, int index){
		if(index == word.length())
			return curr.endOfWord;
		char ch = word.charAt(index);
		TrieNode node = curr.children.get(ch);
		if(node == null)
			return false;
		return searchRec(node, word, index+1);
	}
	
	public void delete(String word){
		deleteWord(root, word, 0);
	}
	
	private boolean deleteWord(TrieNode curr, String word, int index) {
		if(index == word.length()){
			if(!curr.endOfWord)
				return false;
			curr.endOfWord = false;
			return curr.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = curr.children.get(ch);
		if(node == null)
			return false;
		boolean shouldDelete = deleteWord(node, word, index+1);
		if(shouldDelete){
			curr.children.remove(ch);
			//return true if no mappings are left
			return curr.children.size() == 0;
		}
		
		return false;
	}

	
}