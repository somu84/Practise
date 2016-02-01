package Algorithms;
/*
 * An array inversion is given in an Array of N integers.
 * suppose there are two indexes i,j where i<j. The values
 * A[i]>A[j].
 * So each such pair of (i,j) is counted as 1 inversion.
 * For Ex: Array:1,3,5,2,4,6 will have 3 inversions: (3,2),(5,2),(5,4)
 * We use merge sort to complete this in O(nLogn) time.
 */
public class ArrayInversions {
	public static int count = 0;
	public static void main(String[] args) {
		int[] arr = {1,3,5,2,4,6};
		int[]res = countInversion(arr);
		System.out.println("Total Inversions: "+count);
	}
	
	public static int[] countInversion(int[] arr){
		if(arr.length<=1)
			return arr;
		int[] arrL = new int[arr.length/2];
		int[] arrR = new int[arr.length - arr.length/2];
		System.arraycopy(arr, 0, arrL, 0, arrL.length);
		System.arraycopy(arr, arrL.length, arrR, 0, arrR.length);
		int[] arr1 = countInversion(arrL);
		int[] arr2 = countInversion(arrR);
		//CountSplit
		return countSplit(arr1, arr2);
	}
	public static int[] countSplit(int[]arr1, int[] arr2){
		int i = arr1.length;
    	int j = arr2.length;
    	int l=0;
    	int m=0;
    	int[]res = new int[i+j];
    	for(int k=0; k<(i+j); k++){
    		if( m==j || (l<i && arr1[l]<arr2[m])){
    			res[k] = arr1[l];
    			l++;
    		}
    		else {
    			res[k] = arr2[m];
    			count = count+arr1.length-l;
    			m++;
    		}
    	}
    	return res;
	}
}
