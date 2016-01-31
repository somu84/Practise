package src.com.prac;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number :");
	    int num = reader.nextInt();
		reader.close();
		
		//Call the function to calculate the factorial
		callFact(num);
		callFactRecursion(num);
	}
	
	private static void callFact(int num){
		int fact = 1;
		for(int i = 1; i<= num; i++){
			fact = i * fact; 
		}
		System.out.printf("Factorial of %d : %d", num, fact);
	}
	private static void callFactRecursion(int num){
		int fact = callRecusion(num);
		System.out.printf("\nFactorial of %d : %d", num, fact);
	}
	private static int callRecusion(int num){
		if(num == 1)
			return 1;
		return num * callRecusion(num-1);
	}
}
