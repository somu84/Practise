package src.com.ctc.c2;
/* Singly Linked List Implementation class
 * For the Chapter 2 of CTCI.
 * This class will be used for all questions
 */
public class Node {
	Node next = null;
	int data;

	public Node(int d){
		data = d;
	}
	//Add a node to the end of the Linked List
	public void appendValue(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	//Delete a node from a Linked List having a value d
	public Node deleteNode(Node head, int d){
		Node n = head;
		if(n.data == d){
			return head.next;
		}
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return null;
	}
	//Display a Linked List
	public void display(){
		Node n = this;
		while(n.next != null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
}
