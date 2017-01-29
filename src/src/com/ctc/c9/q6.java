package src.com.ctc.c9;

import java.util.Scanner;

/**
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it.
 * @author Somu
 *
 */
public class q6 {
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static Node search(int[][] arr, int num){
		for(int i = 0; i<arr.length; i++){
			if(num >= arr[i][0] && num <= arr[i][arr[0].length - 1]){
				return BinarySearch(arr, i, num);
			}
		}
		return null;
	}
	
	public static Node BinarySearch(int[][]arr, int i, int num){
		int first = 0;
		int last = arr[i].length -1;
		Node res = new Node(i,0);
		while(first <= last){
			int mid = (last - first)/2 + first;
			if(arr[i][mid] == num){
				res.y = mid;
				return res;
			}
			if(arr[i][mid] < num){
				first = mid + 1;
			}
			else{
				last = mid - 1;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		int[][] arr =  { { 1, 2,3 }, { 4, 5,6 },{7,8,9} };
		Scanner in = new Scanner(System.in);
		Node res = search(arr, in.nextInt());
		if(res == null){
			System.out.println("Not Found");
			return;
		}
		System.out.println("Found at Row: "+res.x+" and Column: "+res.y);
	}

}
