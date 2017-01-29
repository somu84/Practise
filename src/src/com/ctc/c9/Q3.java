package src.com.ctc.c9;
import java.util.Scanner;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, 
 * give an O(log n) algorithm that finds an element in the array. 
 * You may assume that the array was originally sorted in increasing order.
 *	EXAMPLE:
 *	Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *	Output: 8 (the index of 5 in the array)
 * @author Somu
 *
 */
public class Q3 {

	public static int BinarySearch(int[] a, int n){
		int last = a.length -1;
		int first = 0;
		int mid = last /2;
		while(first <= last){
			if(a[mid] == n)
				return mid;
			if(a[first] <= a[mid]){
				if(n > a[mid]){
					first = mid+1;
				}
				else if(n >= a[first]){
					last = mid -1;
				}
				else{
					first = mid + 1;
				}
			}
			else if(n < a[mid])
				last = mid -1;
			else if(n <= a[last])
				first = mid + 1;
			else
				last = mid - 1;
			mid = (last - first)/2 + first;
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] arr = {15, 16, 19,20,25,1,3,4,5,7,10,14};
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(BinarySearch(arr, num));
	}
}
