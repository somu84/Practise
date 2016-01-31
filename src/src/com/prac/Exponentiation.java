package src.com.prac;
/*
 * Exponentiation with recursion
 */
public class Exponentiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long result = expo(2,4);
		System.out.println(result);
	}
	public static long expo(int num, int pow){
		//If pow = 0 is the base case.
		if(pow == 0)
			return 1;
		return num * expo(num, pow -1);
	}
}
