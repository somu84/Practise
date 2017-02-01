package src.com.ctc.c19;
/*
 * Write a function to swap a number in place without temporary variables.
 */
public class q1 {
	
	void swap(int a, int b){
		a = a + b;
		b = a -b;
		a = a - b;
	}

	//Optimized using XOR
	void swap_opt(int a, int b){
		a = a ^b;
		b = a^b;
		a = a^b;
	}
}
