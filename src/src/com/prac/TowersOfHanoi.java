package src.com.prac;

//import java.util.Stack;

/* Recursive solution to the Towers of "Hanoi" Problem
 * 
 */
public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(64,"f","t","s");
	}
	public static void hanoi(int n, String first, String target, 
			String spare){
		//This is the base case if number of rings is 1.
		//Move that ring from first stack to the target stack.
		if(n == 1){
			System.out.println("move from "+first+ " to "+target);
			return;
		}
		//Else solve for n-1 rings
		else{
			hanoi(n-1, first, spare, target);
			hanoi(1, first, target, spare);
			hanoi(n-1, spare, target, first);
		}
	}
}
