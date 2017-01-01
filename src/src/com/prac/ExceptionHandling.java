package src.com.prac;
import java.util.*;
/**
 * @author somes
 *
 */
public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner i = new Scanner(System.in);
		System.out.println("Enter first number:");
		int n1 = i.nextInt();
		System.out.println("Enter second number:");
		int n2 = i.nextInt();
		i.close();
		try{
			double div = (double)n1 / n2;
			System.out.println(div);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
