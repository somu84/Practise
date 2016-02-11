package Algorithms;

public class BST {

	private Integer data;
	public BST left = null;
	public BST right = null;
	public BST parent = null;
	
	public BST(int d){
		data = d;
	}
	//public BST(){
	//	data = 0;
	//}
	public void insert(int d){
		BST end = new BST(d);
		BST n = this;
		insertTree(n, end);
	}
	public void insertTree(BST n, BST end){
		if(n.data > end.data){
			if(n.left != null){
				n = n.left;
				insertTree(n, end);
			}
			else{
				n.left = end;
				end.parent = n;
			}
		}
		else{
			if(n.right != null){
				n = n.right;
				insertTree(n, end);
			}
			else{
				n.right = end;
				end.parent = n;
			}
		}
	}
	public static boolean search(BST n, int d){
		if(n.left == null & n.right == null){
			if(d == n.data)
				return true;
			else return false;
		}
		if(n.data == d)
			return true;
		else if(n.data > d){
			return search(n.left, d);
		}
		else{
			return search(n.right, d);
		}
	}
	public static void disp(BST n){		
		if(n == null)
			return;
		if(n.parent == null){
			disp(n.left);
			System.out.print(n.data+" ");
			disp(n.right);
			return;
		}
		if(n.left == null && n.right == null){
			System.out.print(n.data+ " ");
			return;
		}
		else if(n.left == null){
			System.out.print(n.data+" ");
			n = n.right;
			disp(n);
			n = n.parent;
			n.right = null;
			return;
		}
		else{
			disp(n.left);
			n.left = null;
			disp(n);
			return;
		}
	}
	public static void main(String[] args) {
		int[] arr = { 85, 64, 16, 18, 1, 88, 48, 63, 54, 83, 79, 50, 0, 55, 17, 99,
				69, 53, 65, 22, 93, 86, 9, 37, 56, 23, 21, 52, 78, 29, 14, 58, 35, 47, 68, 87, 3,
				34, 5, 74, 4, 45, 41, 49, 67, 89, 92, 60, 72, 20, 8, 15, 42, 71, 31, 36, 90, 84,
				70, 51, 28, 32, 81, 10, 82, 40, 57, 24, 25, 91, 44, 66, 30, 62, 94, 6, 7, 46, 43,
				38, 75, 11, 39, 80, 98, 27, 12, 76, 96, 2, 77, 19, 26, 59, 33, 73, 13, 61, 95, 97
				};
				
		BST n = new BST(arr[0]);
		for(int i =1; i< arr.length; i++){
			n.insert(arr[i]);
		}
		//disp(n);
		//System.out.println();
		System.out.println(search(n, 0));
	}

}
