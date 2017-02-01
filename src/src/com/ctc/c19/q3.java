package src.com.ctc.c19;
//Write an algorithm which computes the number of trailing zeros in n factorial.
public class q3 {

	int countZeros(int n){
		if(n < 5)
			return 0;
		int count = 0;
		for(int i = 5; n/i > 0; i+=5){
			count++;
		}
		return count;
	}
}
