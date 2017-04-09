package src.com.ctc6.DP;

public class Q1_ThreeSteps {
	public static int countWays(int n){
		if(n ==0 || n == 1) return n;
		int a = 0;
		int b = 1;
		int c = 1;
		for(int i=2; i<=n; i++){
			int d = a + b + c;
			a = b;
			b = c;
			c = d;
		}
		return c;
	}
	
	public static void main(String[] args){
		System.out.println("Number of Ways: "+countWays(5));
	}

}
