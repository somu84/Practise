package src.com.ctc.c20;

import java.util.*;

/**
 * Given two words of equal length that are in a dictionary, 
 * write a method to transform one word into another word by changing only one letter at a time. 
 * The new word you get in each step must be in the dictionary.
 * @author Somu
 *
 */
public class q10 {
	/**
	 * This can be achieved by a modified BFS. Where we use a predecessor hash to strore the prev word.
	 * When we reach the end, we build the path, based on this predecessor hashmap.
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static LinkedList<String> transform(String start, String end, Set<String> dict){
		start = start.toUpperCase();
		end = end.toUpperCase();
		if(start.equals(end))
			return null;
		LinkedList<String> nextWord = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		//For printing the path, we need a predecessor word map.
		HashMap<String, String> prevWord = new HashMap<String, String>();
		
		nextWord.add(start);
		visited.add(start);
		while(!nextWord.isEmpty()){
			String w = nextWord.poll();
			for(String v: getOneEditWords(w)){
				if(v.equals(end)){
					//Build the result
					LinkedList <String> path = new LinkedList<String>();
					path.add(v);
					while(w != null){
						//Keep adding words at the beginning
						path.add(0, w);
						//Get the predecessor word
						w = prevWord.get(w);
					}
					return path;
				}
				if(dict.contains(v)){
					if(!visited.contains(v)){
						nextWord.add(v);
						visited.add(v);
						prevWord.put(v, w);
					}
				}
			}
		}
		return null;
	}
	
	public static Set<String> getOneEditWords(String word){
		Set<String> words = new TreeSet<String>();
		for(int i=0; i< word.length(); i++){
			char[] wordArr = word.toCharArray();
			
			for(char c='A'; c<='Z'; c++){
				if(c!= word.charAt(i)){
					wordArr[i] = c;
					words.add(new String(wordArr));
				}
			}
		}
		return words;
	}
	
	public static void main(String[] args){
		HashSet<String> dict = new HashSet<String>();
		dict.add("LAMP");
		dict.add("DAMP");
		dict.add("CAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
		dict.add("PMPO");
		dict.add("CORD");
		dict.add("DOOR");
		dict.add("COOL");
		dict.add("HILL");
		dict.add("STOP");
		dict.add("POMP");
		//dict.add("RAMP");
		
		LinkedList<String> path = transform("damp", "like", dict);
		for(String str: path){
			System.out.print(str+" ");
		}
		
		
		
	}

}
