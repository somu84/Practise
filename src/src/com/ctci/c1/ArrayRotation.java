package src.com.ctci.c1;
/*
 * Cracking the Coding interview: Chap1: Q6
 * Rotate a NxN matrix by 90 degress clockwise in place
 */

public class ArrayRotation {

	public static void main(String[] args) {
		/*int[][] arr = {{0,1,2,3},
					   {4,5,6,7},
					   {8,9,10,11},
					   {12,13,14,15}};
		*/			   
		//int[][]arr = {{0,1},{2,3}};
		/*int[][] arr = {{0,1,2},
				   	   {4,5,6},
				       {8,9,10}};
				       */
		int[][] arr = {{0,1,2,3,4},
				       {5,6,7,8,9},
				       {10,11,12,13,14},
				       {15,16,17,18,19},
				       {20,21,22,23,24}};
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		rotate90(arr);
	}
	
	public static void rotate90(int[][]a){
		int n = a.length;
		int n1 = (int)Math.ceil((double)n/2);
		int temp = 0;
		System.out.println();
		for(int i=0; i<n/2; i++){
			for(int j=0; j<n1; j++){
				temp = a[i][j];
				a[i][j] = a[(n-1-j)][i];
				a[(n-1-j)][i] = a[n-1-i][n-1-j];
				a[n-1-i][n-1-j] = a[j][n-1-i];
				a[j][n-1-i] = temp;
			}
		}
		for(int k=0; k<n; k++){
			for(int m=0; m<n; m++){
				System.out.print(a[k][m]+ " ");
			}
			System.out.println();
		}
	}

}

