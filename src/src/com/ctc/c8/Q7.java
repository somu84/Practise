package src.com.ctc.c8;

import java.util.Scanner;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) 
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 * @author Somu
 *
 */
public class Q7 {
	
	public static int makeChange(int n, int denom){
		int next_denom = 0;
		switch(denom){
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i=0; i*denom <= n; i++){
			ways = ways + makeChange(n-i*denom, next_denom);
		}
		return ways;
	}

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println(makeChange(in.nextInt(), 25));
	}
}
