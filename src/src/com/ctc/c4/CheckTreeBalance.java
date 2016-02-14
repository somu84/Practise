/*
 * CTCI: Chapter 4 Q1: Check if a Binary tree is balanced or not.
 * If the difference of depth between left and right sub-trees is more than 1.
 * Then the tree is not balanced.
 */
package src.com.ctc.c4;
import Algorithms.*;
public class CheckTreeBalance {

	public static void main(String[] args) {
		int[] arr = {8,9,6,7,5,4,3,1};
		
		BST n = new BST(arr[0]);
		for(int i =1; i< arr.length; i++){
			n.insert(arr[i]);
		}
		System.out.println(isBalanced(n));
	}
	public static boolean isBalanced(BST n){
		if(n == null)
			return true;
		else if(n.left != null && n.right != null){
			int left = n.left.getHeight();
			int right = n.right.getHeight();
			if(Math.abs(left - right)>1)
				return false;
			return true;
		}
		else if(n.left != null){
			if(n.left.getHeight()>1)
				return false;
			return true;
		}
		else{
			if(n.right.getHeight()>1)
				return false;
			return true;
		}
	}
}
