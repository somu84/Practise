package src.com.prac;
/*
 * Exponentiation with recursion
 */
public class Exponentiation {

	public static void main(String[] args) {
		
		long result = expo2(2,20);
		System.out.println(result);
	}
	public static long expo(int num, int pow){
		//If pow = 0 is the base case.
		if(pow == 0)
			return 1;
		return num * expo(num, pow -1);
	}
	
	//This is a much more efficient algorithm as it has O(log n)
	//Running time.
	public static long expo2(int num, int pow){
		if(pow ==0)
			return 1;
		if(pow%2 == 0)
			return expo2((num*num), pow/2);
		else
			return num*(expo2(num, pow-1));
	}
}
