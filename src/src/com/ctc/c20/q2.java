package src.com.ctc.c20;
/**
 * Write a method to shuffle a deck of cards. 
 * It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely.
 * @author Somu
 *
 */
public class q2 {
	/**
	 * This problem is solved by Knuth Shuffle
	 * @param deck
	 */
	public static void shuffle(int[] deck){
		for(int i = 0; i<deck.length; i++){
			int shuff = rand52(i);
			//swap(deck[shuff], deck[i]);
			int temp = deck[shuff];
			deck[shuff] = deck[i];
			deck[i] = temp;
		}
	}
	
	/**
	 * Just a RNG
	 * @param start
	 * @return
	 */
	public static int rand52(int start){
		int range = 52 - start;
		return (int)(Math.random()*range)+start;
		
	}
	
	/**
	 * Driver
	 * @param args
	 */
	public static void main(String[] args){
		int[] deck = new int[52];
		for(int i=1; i<=52; i++){
			deck[i-1] = i;
		}
		shuffle(deck);
		for(int i:deck){
			System.out.print(i+" ");
		}
	
	}
}
