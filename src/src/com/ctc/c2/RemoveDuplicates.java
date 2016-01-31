package src.com.ctc.c2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Cracking the Coding interview: Chap2: Q1
 * Remove duplicates from a Singly Linked List
 * Also do it without any additional buffer
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		// Create a Singly Linked List
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter elemts to a linked list '-1' to exit");
		int num = reader.nextInt();
		Node n = new Node(num);
		while(num != -1){
			num = reader.nextInt();
			n.appendValue(num);
		}
		System.out.println("The Linked List is : ");
		n.display();
		System.out.println("Removing duplicte nodes");
		removeDuplicates(n);
		//removeDuplicates_1(n);
		n.display();
	}
	
	public static void removeDuplicates(Node head){
		Node n = head;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(n.data);
		while(n.next != null){
			if(arr.contains(n.next.data)){
				n.next = n.next.next;
			}
			else{
				arr.add(n.next.data);
				n = n.next;
			}
			
		}
	}
	//In linear space
	public static void removeDuplicates_1(Node head){
		Node n = head;
		while(n.next != null){
			Node n2 = n;
			while(n2.next != null){
				if(n.data == n2.next.data){
					n2.next = n2.next.next;
				}
				n2 = n2.next;
			}
			n = n.next;
		}
	}
}
