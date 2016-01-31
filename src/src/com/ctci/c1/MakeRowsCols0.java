package src.com.ctci.c1;

import java.util.ArrayList;

/*
 * Cracking the Coding interview: Chap1: Q7
 * In a MxN matrix if any element is 0, make that entire 
 * row and column of the matrix 0.
 */
public class MakeRowsCols0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{8,1,2,3},
				   {4,5,6,7},
				   {8,9,0,11}};
		System.out.println("Original Matrix");
		display(arr);
		makeZero(arr);
	}
	
	private static void display(int[][]arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void makeZero(int[][]arr){
	
		ArrayList<Integer> rowList = new ArrayList<Integer>();
		ArrayList<Integer> colList = new ArrayList<Integer>();
		int rowL = arr.length;
		int colL = arr[0].length;
		for(int i=0; i<rowL; i++){
			for(int j=0; j<colL; j++){
				if(arr[i][j] == 0){
					rowList.add(i);
					colList.add(j);
				}
			}
		}
		for(int i=0; i<rowList.size(); i++){
			for(int j=0; j<colL; j++){
				arr[rowList.get(i)][j] = 0;
			}
		}
		for(int i=0; i<colList.size(); i++){
			for(int j=0; j<rowL; j++){
				arr[j][colList.get(i)] = 0;
			}
		}
		System.out.println();
		display(arr);
	}
}
