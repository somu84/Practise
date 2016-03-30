package src.com.ctc.c8;
//nth Fibonacci
public class Q1 {

	public static void main(String[] args) {
		
		int i = 0;
		System.out.println(fib(i));
	}
	public static int fib(int i){
		if(i <= 1)
			return i;
		return fib(i-1)+fib(i-2);
	}
}
