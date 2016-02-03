package Algorithms;

public class Heap {
	public static void build_max_heap(int[] arr){
		int len = arr.length-1;
		for(int i=len; i>=0; i--){
			max_heapify(arr,i);
		}
	}
	public static void max_heapify(int[]arr, int i){
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		if(l<arr.length && arr[l]>arr[largest]){
			largest = l;
		}
		if(r<arr.length && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			swap(arr, i, largest);
			max_heapify(arr, largest);
		}
		
	}
	public static void swap(int[]arr, int i, int j){
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
	public static void heapSort(int[]arr){
		if(arr.length <=1){
			System.out.print(arr[0]);
			return;
		}
		build_max_heap(arr);
		int len = arr.length;
		swap(arr, 0,len-1);
		int[] newArr = new int[len-1];
		int max = arr[len-1];
		System.arraycopy(arr, 0, newArr, 0, newArr.length);
		max_heapify(newArr, 0);
		System.out.print(max+", ");
		heapSort(newArr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 85, 64, 16, 18, 1, 88, 48, 63, 54, 83, 79, 50, 0, 55, 17, 99,
				69, 53, 65, 22, 93, 86, 9, 37, 56, 23, 21, 52, 78, 29, 14, 58, 35, 47, 68, 87, 3,
				34, 5, 74, 4, 45, 41, 49, 67, 89, 92, 60, 72, 20, 8, 15, 42, 71, 31, 36, 90, 84,
				70, 51, 28, 32, 81, 10, 82, 40, 57, 24, 25, 91, 44, 66, 30, 62, 94, 6, 7, 46, 43,
				38, 75, 11, 39, 80, 98, 27, 12, 76, 96, 2, 77, 19, 26, 59, 33, 73, 13, 61, 95, 97
				};
		heapSort(arr);
	}

}
