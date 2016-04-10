/*
 * Given an array of positive and negative ints. 
 * Write a method which will give the max sum of continuous indexes.
 * For Ex: : [-5, 0, -4, 1, 4, 3, -2, -1, 2, -3]
 * The max sum will be : 8 (1,4,3) 
 */

package src.com.prac;

public class MaxSubArray {
	public static void main(String[] args) {
		int[] arr = {-5, 0, -4, 1, 4, 3, -2, 2, -2};
		int maximum = 0;
		int prevMax = 0;
		maximum = MAX(arr[0], 0);
		prevMax = maximum;
		for(int i=1; i< arr.length; i++){
			prevMax = MAX(prevMax + arr[i], 0);
			maximum = MAX(prevMax, maximum);
		}
		System.out.println(maximum);
	}
	private static int MAX(int i, int j){
		if(i > j)
			return i;
		else
			return j;
	}
}
