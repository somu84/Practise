package src.com.algorithms;

/*
 * Merge sort implementation. The complexity is O(nlog(n))
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 85, 64, 16, 18, 1, 88, 48, 63, 54, 83, 79, 50, 0, 55, 17, 99, 69, 53, 65, 22, 93, 86, 9, 37, 56,
				23, 21, 52, 78, 29, 14, 58, 35, 47, 68, 87, 3, 34, 5, 74, 4, 45, 41, 49, 67, 89, 92, 60, 72, 20, 8, 15,
				42, 71, 31, 36, 90, 84, 70, 51, 28, 32, 81, 10, 82, 40, 57, 24, 25, 91, 44, 66, 30, 62, 94, 6, 7, 46,
				43, 38, 75, 11, 39, 80, 98, 27, 12, 76, 96, 2, 77, 19, 26, 59, 33, 73, 13, 61, 95, 97 };
		//sort(arr);
		
		int[]arr1 = {5, 3, 10, 2};
		mergeSort(arr);
		for(int a: arr){
			System.out.print(a+" ,");
		}
	}

	static int count = 0;

	public static void sort(int[] arr) {
		// Call merge sort
		int len = arr.length;
		int[] res = mergeSort(arr, len);
		for (int i : res) {
			System.out.print(i + ",");
		}
		System.out.println();
		System.out.println("Input of length: " + arr.length);
		System.out.println("Number of function calls: " + count);
	}

	// Merge Sort Algorithm
	public static int[] mergeSort(int[] arr, int end) {
		count++;
		if (end <= 1) {
			return arr;
		}
		int[] arr1 = new int[end / 2];
		int[] arr2 = new int[end - arr1.length];
		// Split the array in half
		System.arraycopy(arr, 0, arr1, 0, arr1.length);
		System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
		// Call mergeSort recursively
		int[] arr3 = mergeSort(arr1, arr1.length);
		int[] arr4 = mergeSort(arr2, arr2.length);
		return merge(arr3, arr4);
	}

	// Function to merge the sub arrays
	public static int[] merge(int[] arr1, int[] arr2) {
		int i = arr1.length;
		int j = arr2.length;
		int l = 0;
		int m = 0;
		int[] res = new int[i + j];
		for (int k = 0; k < (i + j); k++) {
			if (m == j || (l < i && arr1[l] < arr2[m])) {
				res[k] = arr1[l];
				l++;
			} else {
				res[k] = arr2[m];
				m++;
			}
		}
		return res;
	}
	
	public static void mergeSort(int[]arr){
		mergeSort(arr, 0, arr.length-1);
		return;
	}
	
	public static void mergeSort(int[]arr, int l, int r){
		if(l >= r) return;
		int m = (r+l)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m+1, r);
		merge(arr, l, r);
	}
	
	public static void merge(int[]arr, int l, int r){
		int m = (r+l)/2;
		int[]a1 = new int[m-l+1];
		int[]a2 = new int[r-m];
		int[]temp = new int[r-l+1];
		System.arraycopy(arr, l, a1, 0, m-l+1);
		System.arraycopy(arr, m+1, a2, 0, r-m);
		int i1= 0, i2 = 0, i= 0;
		while(i1 < a1.length && i2 < a2.length){
			if(a1[i1] < a2[i2]){
				temp[i] = a1[i1];
				i1++;
				i++;
			}else{
				temp[i] = a2[i2];
				i2++;
				i++;
			}
		}
		if(i < temp.length){
			if(i1 < a1.length){
				copyArr(temp, a1, i, i1);
			}else{
				copyArr(temp, a2, i, i2);
			}
		}
		System.arraycopy(temp, 0, arr, l, temp.length);
	}
	
	public static void copyArr(int[]arr, int[]a, int i, int i1){
		while(i1 < a.length){
			arr[i] = a[i1];
			i++;
			i1++;
		}
	}
}
