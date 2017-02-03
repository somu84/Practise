package src.com.ctc.c19;
/**
 * implement rand7() using rand5()
 * @author Somu
 *
 */
public class q10 {
	/**
	 * In order to generate a random number between 1 and 7, we just need to uniformly generate a 
	 * larger range than we are looking for and then repeatedly sample until we get a number 
	 * that is good for us. 
	 * We will generate a base 5 number with two places with two calls to the RNG.
	 * @return
	 */
	public static int rand7(){
		while(true){
			int num = 5 * (rand5() -1) + (rand5() -1);
			if(num < 21)
				return (num %7 + 1);
		}
	}
	
	/**
	 * Just a RNG for 5 numbers
	 * @return
	 */
	public static int rand5(){
		int range = 5;
		return (int)(Math.random()*5)+1;
	}
	
	/**
	 * Driver
	 */
	public static void main(String[] args){
		int i = 0;
		while(i < 10){
			System.out.println(rand7());
			i++;
		}
	}
}
