package src.com.prac;
/*
 * Just practice to implement a Binary Search algorithm
 * recursively.
 */
public class BinarySearch {

	public static void main(String[] args) {
		// This is the initialized array
        int [] arr = {1,2,4,5,6,10,20,22,24,57};
        int n = 1;
        search(arr, n);
	}
	
	public static void search(int []arr, int n){
		int len = arr.length - 1;
		//Call Binary Search
		binarySearch(arr, n, 0, len);
	}
	
	public static void binarySearch(int[] arr, int n, int start, int end){
		if(start > end || start<0 || end <0){
			System.out.println("Not Found");
			return;
		}
		int len = (end-start)/2;
		if(n<arr[start+len]){
			binarySearch(arr, n, start, start+len-1);
		}
		else if(n>arr[start+len]){
			binarySearch(arr, n, start+len+1, end);
		}
		else{
			System.out.println(n+" found in the array, at index "+(start+len));
			return;
		}
	}
}
