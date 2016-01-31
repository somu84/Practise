package src.com.ctc.c2;
/*
 * Chapter 2 Q3
 */
public class DeleteMidNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(4);
		n.appendValue(5);
		n.appendValue(8);
		n.appendValue(10);
		n.appendValue(9);
		n.appendValue(3);
		n.appendValue(1);
		n.display();
		deleteMid(n);
		n.display();
	}
	public static void deleteMid(Node head){
		if(head == null || head.next == null){
			return;
		}
		Node n = head;
		Node p = head;
		Node q = head;
		while(p.next != null){
			p = p.next.next;
			n = q;
			q = q.next;
		}
		n.next = q.next;
	}
}
