package src.com.ctc.c19;

import java.util.ArrayList;

/**
 * You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum.
 * @author Somu
 *
 */
public class q7 {
	/**
	 * This problem is solved by Kadane's Algo
	 * @param num
	 * @return
	 */
	public static ArrayList<Integer> maxSum(int[] num){
		int max_so_far = num[0];
		int local_max = num[0];
		ArrayList<Integer> max = new ArrayList<>();
		ArrayList<Integer> curr_max = new ArrayList<>();
		max.add(num[0]);
		curr_max.add(num[0]);
		for(int i = 1; i<num.length; i++){
			if(num[i] > local_max+num[i]){
				local_max = num[i];
				curr_max.removeAll(curr_max);
				curr_max.add(num[i]);
			}else{
				local_max += num[i];
				curr_max.add(num[i]);
			}
			if(max_so_far < local_max){
				max_so_far = local_max;
				max.removeAll(max);
				max.addAll(curr_max);
			}
		}
		return max;
	}
	
	//Driver
	public static void main(String[] args){
		int[] arr = {-1,-2,-3,-5,-6,-3};
		ArrayList<Integer> res  = maxSum(arr);
		for(int x : res){
			System.out.print(x+" ");
		}
	}

}
