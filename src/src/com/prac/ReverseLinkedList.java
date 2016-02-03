package src.com.prac;
import src.com.ctc.c2.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(11);
		n.appendValue(5);
		n.appendValue(8);
		n.appendValue(10);
		n.appendValue(9);
		n.appendValue(3);
		n.appendValue(1);
		n.display();
		Node n2 = reverse(n, null);
		n2.display();
	}
	public static Node reverse(Node head, Node prev){
		if(head.next == null){
			head.next = prev;
			return head;
		}
		Node n = head.next;
		head.next = prev;
		return reverse(n, head);
	}
}
