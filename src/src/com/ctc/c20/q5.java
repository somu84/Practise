package src.com.ctc.c20;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You have a large text file containing words. Given any two words, 
 * find the shortest distance (in terms of number of words) between them in the file. 
 * Can you make the searching operation in O(1) time?
 * @author Somu
 *
 */
public class q5 {
	
	
	static int shortest(String[] words, String w1, String w2){
		HashMap<String, ArrayList<Integer>> wordLoc = new HashMap<String, ArrayList<Integer>>();
		int i = 0;
		//Build the hashmap with location of all words
		for(String word : words){
			if(wordLoc.containsKey(word)){
				ArrayList<Integer> loc = wordLoc.get(word);
				loc.add(i);
				wordLoc.put(word, loc);
			}
			else{
				ArrayList<Integer> loc = new ArrayList<Integer>();
				loc.add(i);
				wordLoc.put(word, loc);
			}
			i++;
		}
		//Get the location list of Words
		ArrayList<Integer> loc1 = wordLoc.get(w1);
		ArrayList<Integer> loc2 = wordLoc.get(w2);
		int overMin = 0;
		int currMin = 0;
		for(int l1: loc1){
			currMin = getMinDiff(l1, loc2);
			if(overMin > currMin)
				overMin = currMin;
		}
		return overMin;
	}
	
	/**
	 * This funtion returns the min distance based on 1 location in the other array
	 * @param i
	 * @param arr
	 * @return
	 */
	public static int getMinDiff(int i, ArrayList<Integer> arr){
		int low = 0;
		int hi = arr.size() -1;
		int min = Math.abs(arr.get(hi/2) - i);
		while(low <= hi){
			int mid = low + (hi - low)/2;
			int dh = Math.abs(arr.get(mid+1) - i);
			int dm = Math.abs(arr.get(mid) - i);
			if(dm < dh ){
				hi = mid - 1;
			}
			else{
				low = mid+1;
			}
			if(min > dm){
				min = dm;
			}
		}
		return min;
	}
}
