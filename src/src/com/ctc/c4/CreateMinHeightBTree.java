/*
 * CTCI Chap 4 Q3: Write an algorithm which creates a binary tree with min height
 * from a sorted array.
 */
package src.com.ctc.c4;

import Algorithms.BST;

public class CreateMinHeightBTree {
	private Integer data;
	public CreateMinHeightBTree left = null;
	public CreateMinHeightBTree right = null;
	public CreateMinHeightBTree parent = null;
	private int height = -1;
	
	public CreateMinHeightBTree(int d){
		data = d;
		height = 0;
	}
	
	public void insert(int d){
		CreateMinHeightBTree end = new CreateMinHeightBTree(d);
		CreateMinHeightBTree n = this;
		insertTree(n, end);
	}
	/*
	 * This algorithm, takes the height of the left sub-tree
	 * and the right sub-tree and whichever is the min, recurses 
	 * on that node.
	 */
	public void insertTree(CreateMinHeightBTree n, CreateMinHeightBTree end){
		if(n.left == null && n.right == null){
			end.parent = n;
			n.left = end;
		}
		else{
			int h1 = getHeight(n.left);
			int h2 = getHeight(n.right);
			if(h1 == -1){
				end.parent =n;
				n.left = end;
			}
			else if(h2 == -1){
				end.parent = n;
				n.right = end;
			}
			else if(h1<=h2){
				insertTree(n.left, end);
			}
			else{
				insertTree(n.right, end);
			}
		}
		updateHeight(n);
	}
	public void updateHeight(CreateMinHeightBTree n){
		if(n.left != null && n.right != null)
			n.height = max(n.left.height, n.right.height)+1;
		else if(n.left != null)
			n.height = n.left.height+1;
		else if(n.right != null)
			n.height = n.right.height+1;
		else
			n.height = 0;
	}
	
	public static int getHeight(CreateMinHeightBTree n){
		if(n == null)
			return -1;
		else
			return n.height;
	}
	private int max(int h1, int h2){
		if(h1 <= h2)
			return h2;
		return h1;
	}

	public static void main(String[] args) {
		int[] arr = {2,4,5,6,7,8,9,10,11,12};
		CreateMinHeightBTree n = new CreateMinHeightBTree(arr[0]);
		for(int i=1; i<arr.length; i++){
			n.insert(arr[i]);
		}
		System.out.println(getHeight(n));
	}

}
