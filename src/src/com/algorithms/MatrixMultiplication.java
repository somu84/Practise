package src.com.algorithms;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x = { { 1, 2 }, { 3, 4 } };
		int[][] y = { { 5, 6 }, { 7, 8 } };
		// int[][] z = matrix_mul(x,y);
		// disp(z);
	}

	public static void disp(int[][] z) {
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[i].length; j++) {
				System.out.print(z[i][j] + ",");
			}
			System.out.println();
		}
	}
	// Strassen Matrix Multiplication
	// public static int[][] matric_mul(int[][]m,int[][]n ){

	// }
}
