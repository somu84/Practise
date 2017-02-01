package src.com.ctc.c19;
/**
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 * @author Somu
 *
 */
public class q4 {
	/**
	 * Remember the below equation to get the Max
	 * Let c = a - b. Let k = the most significant bit of c. 
	 * 			MAX =  a - k * c.
	 * @param a
	 * @param b
	 * @return
	 */
	int getMax(int a, int b){
		int c = a- b;
		//This is to get the MSB
		int k = (c>>31) & 0x1;
		int max = a-k*c;
		return max;
	}

}
