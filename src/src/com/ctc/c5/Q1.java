package src.com.ctc.c5;

public class Q1 {
	public static void main(String [] args)
	{
		//~ makes all bits 1
		int max = ~0;
		int n = 32;
		int m = 10;
		int i = 2;
		int j = 3;
		//1s through position j, then set 0's
		int left = max - ((1 << j) - 1); 
		//1s after the position i
		int right =  ((1 <<i) - 1);
		//1s with 0s between i and j
		int mask = left | right;
		System.out.println(Integer.toBinaryString((n & mask)|(m << i)));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(n));
		//System.out.println(a);
	}
}
