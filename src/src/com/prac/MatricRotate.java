/*
 * You are given a 2D matrix, a, of dimension MxN and a positive integer R. 
 * You have to rotate the matrix R times and print the resultant matrix. 
 * Rotation should be in anti-clockwise direction.
 * Sample Input:
 * 4 4 1
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * Sample Output:
 * 2 3 4 8
 * 1 7 11 12
 * 5 6 10 16
 * 9 13 14 15
 */
package src.com.prac;

import java.util.Scanner;

public class MatricRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String p = reader.nextLine();
		String[]a = p.split(" ");
		int row = Integer.parseInt(a[0]);
		int col = Integer.parseInt(a[1]);
		int rot = Integer.parseInt(a[2]);
		if(min(row,col)%2 != 0)
			return;
		int[][]arr = new int[row][col];
		int[][]b = new int[row][col];
		for(int i=0; i< row; i++){
			String r = reader.nextLine();
			String[]g = r.split(" ");
			for(int j=0; j<g.length; j++){
				arr[i][j] = Integer.parseInt(g[j]);
			}
		}
		reader.close();
		disp(arr);
		System.out.println();
		for(int num = 1; num<=rot; num++){
			b = rotate(arr);
			arr = b;
		}
		disp(b);
	}
	
	private static int min(int row, int col) {
		if(row <= col)
			return row;
		return col;
	}
	private static int max(int row, int col) {
		if(row <= col)
			return col;
		return row;
	}
	public static int[][] rotate(int[][]a){
		
		int n = a.length -1;
		int k = a[0].length -1;
		int[][]b = new int[a.length][a[0].length];
		if(n>=k)
			b = rot(a, n, k);
		else
			b = rot(a,n,k);
		return b;
	}
	public static int[][]rot(int[][]a, int n, int k){
		int[][]b = new int[a.length][a[0].length];
		for(int i=0; i<a.length/2; i++){
			for(int j=i; j<=max((k-i), (n-i)); j++){
				if(j<(n-i) && j<(k-i)){
					//Rows
					b[i][j] = a[i][j+1];
					b[(n-i)][j+1] = a[n-i][j];
					//Columns
					b[j+1][i] = a[j][i];
					b[j][k-i] = a[j+1][k-i];
				}
				else if((n-i)<=j && j<(k-i)){
					b[i][j] = a[i][j+1];
					b[(n-i)][j+1] = a[n-i][j];
				}
				else if((n-i)>j && j>=(k-i)){
					b[j+1][i]= a[j][i];
					b[j][k-i] = a[j+1][k-i];
				}
			}
		}
		return b;
	}
	
	public static void disp(int[][]b){
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[0].length; j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

}
