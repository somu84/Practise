package src.com.ctc.c19;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 * @author Somu
 *
 */
public class q11 {
	/**
	 * Class to store the list of all pairs
	 * @author Somu
	 *
	 */
	static class Pair{
		int i;
		int j;
		Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	/**
	 * This function uses a hash to store the complements.
	 * Time complexity is O(n).
	 * @param arr
	 * @param num
	 * @return
	 */
	public static ArrayList<Pair> findPairs(int[] arr, int num){
		HashSet<Integer> comps = new HashSet<Integer>();
		ArrayList <Pair> res = new ArrayList<Pair>();
		for(int i=0; i<arr.length; i++){
			if(comps.contains(arr[i])){
				Pair newP = new Pair(num-arr[i], arr[i]);
				res.add(newP);
			}
			else{
				comps.add(num - arr[i]);
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] arr = {2,7,3,5,4,1,3,2,4,-1,9};
		ArrayList<Pair> res = findPairs(arr, 8);
		for(Pair p: res){
			System.out.println("<"+p.i+" , "+p.j+">");
		}
	}

}
