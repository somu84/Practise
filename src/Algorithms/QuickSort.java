package Algorithms;
/*
 * Implementation of QuickSort
 * Worst case running time will be when the array is already sorted or reverse sorted.'
 * The complexity will be O(n2)
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr= { 85, 64, 16, 18, 1, 88, 48, 63, 54, 83, 79, 50, 0, 55, 17, 99,
				69, 53, 65, 22, 93, 86, 9, 37, 56, 23, 21, 52, 78, 29, 14, 58, 35, 47, 68, 87, 3,
				34, 5, 74, 4, 45, 41, 49, 67, 89, 92, 60, 72, 20, 8, 15, 42, 71, 31, 36, 90, 84,
				70, 51, 28, 32, 81, 10, 82, 40, 57, 24, 25, 91, 44, 66, 30, 62, 94, 6, 7, 46, 43,
				38, 75, 11, 39, 80, 98, 27, 12, 76, 96, 2, 77, 19, 26, 59, 33, 73, 13, 61, 95, 97
				};
		
		quickSort(arr, 0, arr.length-1);
		disp(arr);

	}
	public static int partition(int[]arr, int p, int q){
		int x = arr[p]; 
		int i = p;
		for(int j = p+1; j<=q; j++){
			if(arr[j] <= x){
				i = i+1;
				swap(arr,i,j);
			}
		}
		swap(arr,p, i);
		return i;
	}
	public static void swap(int[]arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void quickSort(int[]arr, int p, int q){
		if(p<=q){
			int r = partition(arr, p, q);
			quickSort(arr,p, r-1);
			quickSort(arr,r+1, q);
		}
	}
	public static void disp(int[]arr){
		System.out.print(arr[0]);
		for(int i=1;i< arr.length; i++){
			System.out.print(", "+arr[i]);
		}
		System.out.println();
	}
}
