package src.com.ctc6.DP;

public class Q11_Coins {
	public static int countWays(int c, int[] coins){
		if(c == 0) return c;
		int[] T = new int[c+1];
		T[0] = 1;
		for(int n: coins){
			for(int i = 1; i<T.length; i++){
				if(i >= n) T[i] += T[i-n];
			}
		}
		return T[c];
	}
	
	public static void main(String[] args){
		int[] coins = {3,4, 6, 7, 9};
		System.out.println(countWays(15, coins));
	}

}
