package src.com.ctc.c5;

public class Q3 {
	public static void main(String[] args){
		int i = 31;
		int j = 14;
		bitSwap(i, j);
	}
	
	public static void bitSwap(int i, int j){
		int count = 0;
		for(int k = i^j; k != 0; k =k >>1){
			count += k & 1;
		}
		System.out.println("Number of Bit required for "+i+" to be "+j+" : "+count);
	}
}
