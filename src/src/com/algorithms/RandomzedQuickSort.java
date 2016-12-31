package src.com.algorithms;

import java.util.Random;

/*
 * This is a randomized Quick sort algorithm. Where the running time is independant of the 
 * order of the input array.
 * The running time will always be O(nlogn).
 * In fact the worst case running time will be dependent on the random number geneator.
 */
public class RandomzedQuickSort {

	public static void main(String[] args) {
		/*
		 * int[] arr= { 85, 64, 16, 18, 1, 88, 48, 63, 54, 83, 79, 50, 0, 55,
		 * 17, 99, 69, 53, 65, 22, 93, 86, 9, 37, 56, 23, 21, 52, 78, 29, 14,
		 * 58, 35, 47, 68, 87, 3, 34, 5, 74, 4, 45, 41, 49, 67, 89, 92, 60, 72,
		 * 20, 8, 15, 42, 71, 31, 36, 90, 84, 70, 51, 28, 32, 81, 10, 82, 40,
		 * 57, 24, 25, 91, 44, 66, 30, 62, 94, 6, 7, 46, 43, 38, 75, 11, 39, 80,
		 * 98, 27, 12, 76, 96, 2, 77, 19, 26, 59, 33, 73, 13, 61, 95, 97 };
		 */
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
				53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
				79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99 };

		quickSortRandom(arr, 0, arr.length - 1);
		disp(arr);

	}

	public static int partitionRandom(int[] arr, int p, int q) {
		// Before doing anything, swap p with a random index
		Random rand = new Random();
		int l = rand.nextInt((q - p) + 1) + p;
		swap(arr, p, l);
		int x = arr[p];
		int i = p;
		for (int j = p + 1; j <= q; j++) {
			if (arr[j] <= x) {
				i = i + 1;
				swap(arr, i, j);
			}
		}
		swap(arr, p, i);
		return i;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSortRandom(int[] arr, int p, int q) {
		if (p <= q) {
			int r = partitionRandom(arr, p, q);
			quickSortRandom(arr, p, r - 1);
			quickSortRandom(arr, r + 1, q);
		}
	}

	public static void disp(int[] arr) {
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.print(", " + arr[i]);
		}
		System.out.println();
	}

}
