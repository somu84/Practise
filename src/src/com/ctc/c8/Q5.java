package src.com.ctc.c8;

import java.util.ArrayList;

public class Q5 {

	public static void main(String[] args) {
		int i = 3;
		printPar(i);
	}
	/*
	 * Function which prepares the input parameters 
	 * for the recursive function.
	 */
	private static void printPar(int count){
		//Make sure to have a char array instead of String.
		//Since we are dealing with characters '(' & ')'.
		char[] str = new char[count * 2];
		printPar(count, count, str, 0);
	}
	/*
	 * The recursive function
	 */
	private static void printPar(int l, int r, char[] str, int count){
		//Take care of an invalid state
		if(l <0 || r < l)return;
		//Base case
		if(l == 0 && r == 0){
			System.out.println(str);
		}else{
			if(l > 0){
				//Try inserting a left parenthesis
				str[count] = '(';
				printPar(l-1, r, str, count+1);
			}
			if(r> l){
				//Try a right parenthesis
				str[count] = ')';
				printPar(l, r-1, str, count+1);
			}
		}
	}
}
