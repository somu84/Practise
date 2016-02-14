package Algorithms;

public class BST {

	private Integer data;
	public BST left = null;
	public BST right = null;
	public BST parent = null;
	private int height = -1;
	
	public BST(int d){
		data = d;
		height = 0;
	}
	public void insert(int d){
		BST end = new BST(d);
		BST n = this;
		insertTree(n, end);
	}
	public void updateHeight(BST n){
		if(n.left != null && n.right != null)
			n.height = max(n.left.height, n.right.height)+1;
		else if(n.left != null)
			n.height = n.left.height+1;
		else if(n.right != null)
			n.height = n.right.height+1;
		else
			n.height = 0;
	}
	
	public int getHeight(){
		return this.height;
	}
	private int max(int h1, int h2){
		if(h1 <= h2)
			return h2;
		return h1;
	}
	public void insertTree(BST n, BST end){
		if(n.data > end.data){
			if(n.left != null){
				insertTree(n.left, end);
			}
			else{
				n.left = end;
				end.parent = n;
			}
		}
		else{
			if(n.right != null){
				insertTree(n.right, end);
			}
			else{
				n.right = end;
				end.parent = n;
			}
		}
		//update height
		updateHeight(n);
	}
	public static BST search(BST n, int d){
		if(n==null)
			return null;
		if(n.left == null & n.right == null){
			if(d == n.data)
				return n;
			else return null;
		}
		if(n.data == d)
			return n;
		else if(n.data > d){
			return search(n.left, d);
		}
		else{
			return search(n.right, d);
		}
	}
	
	public static void disp(BST n){
		if(n == null){
			return;
		}
		if (n.left == null && n.right == null){
			System.out.print(n.data+" ");
		}
		else if(n.left != null && n.right != null){
			disp(n.left);
			System.out.print(n.data+" ");
			disp(n.right);
		}
		else if(n.left == null){
			System.out.print(n.data+" ");
			disp(n.right);
		}
		else if(n.right == null){
			disp(n.left);
			System.out.print(n.data+" ");
		}
	}
	public static void delete(BST n, int val){
		BST n1 = search(n, val);
		if(n1 == null)
			return;
		else if(n1.left == null && n1.right == null){
			n = n1.parent;
			if(n.data <= val)
				n.right = null;
			else
				n.left = null;
		}
		else if(n1.left != null && n1.right != null){
			n1.data = min(n1.right);
			delete(n1.right, n1.data);
		}
		else if(n1.left == null){
			n = n1.parent;
			if(n.data <=val){
				n.right = n1.right;
			}
			else
				n.left = n1.right;
		}
		else if(n1.right == null){
			n = n1.parent;
			if(n.data <=val){
				n.right = n1.left;
			}
			else
				n.left = n1.left;
		}
	}
	private static int min(BST n){
		if(n == null){
			return -1;
		}
		BST min = null;
		while(n != null){
			min = n;
			if(n.left == null){
				return min.data;
			}
			else{
				n = n.left;
			}
		}
		return min.data;
	}
	
	public static void main(String[] args) {
		int[] arr = { 85, 64, 88, 48, 63, 54, 83, 79, 50, 55, 99};
				
		BST n = new BST(arr[0]);
		for(int i =1; i< arr.length; i++){
			n.insert(arr[i]);
		}
		disp(n);
		System.out.println();
		//BST n1 = search(n, 10);
		delete(n, 50);
		disp(n);
		System.out.println();
		System.out.println(n.getHeight());
	}

}
