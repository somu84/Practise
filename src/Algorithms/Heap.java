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
		int[] arr = {10,5,6,2,1,3,4,7,8,9};
		heapSort(arr);
		//build_max_heap(arr);
		//for(int i: arr){
		//	System.out.print(i+", ");
		//}
	}

}
