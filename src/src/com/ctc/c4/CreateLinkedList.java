/*
 * CTCI Chap 4 Q4 Given a binary search tree, 
 * design an algorithm which creates a linked list 
 * of all the nodes at each depth 
 * (i.e., if you have a tree with depth D, you’ll have D linked lists).
 */
package src.com.ctc.c4;
import java.util.LinkedList;
import java.util.List;

import src.com.algorithms.BST;

public class CreateLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,10,5,3,8,3,6,9,11};
		BST bT = new BST(arr[0]);
		for(int i=1; i<arr.length; i++){
			bT.insert(arr[i]);
		}
		
		List<Integer> l = createList(bT, 3);
		for (Integer h : l){
			System.out.print(h+", ");
		}
	}
	
	public static List<Integer>createList(BST bt, Integer h){
		List<Integer> l = new LinkedList<Integer>();
		traverseTree(bt, h, l);
		return l;
	}
	//This function will traverse the tree, while inserting all nodes
	//With height 'h' into the linked list.
	public static void traverseTree(BST bt, Integer h, List<Integer>l){
		if(bt == null) return;
		if(bt.getHeight() <h){
			return;
		}
		else if(bt.getHeight() == h){
			l.add(bt.getData());
			return;
		}
		else{
			traverseTree(bt.left, h, l);
			traverseTree(bt.right, h, l);
		}
	}
}
