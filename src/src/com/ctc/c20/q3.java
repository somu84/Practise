package src.com.ctc.c20;

/**
 * Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen.
 * @author Somu
 *
 */
public class q3 {
	
	public static int rand(int low, int high){
		return low+(int)(Math.random()*(high - low +1));
	}
	
	/**
	 * We clone the array, to not garble the input array.
	 * @param arr
	 * @param m
	 * @return
	 */
	public static int[] pickRandom(int[] arr, int m){
		int[] subset = new int[m];
		int[] temp = arr.clone();
		for(int i = 0; i<m; i++){
			int j = rand(i, temp.length - 1);
			subset[i] = temp[j];
			//This step ensures the value picked doesn't get picked again.
			temp[j] = temp[i];
		}
		return subset;
		
	}

}
