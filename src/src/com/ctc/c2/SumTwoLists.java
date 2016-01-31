package src.com.ctc.c2;
/*
 * Chapter 2 Q4
 */
class Node1 {
	Node1 next = null;
	int data;

	public Node1(int d){
		data = d;
	}
	//Add a node to the end of the Linked List
	public void appendValue(int d){
		Node1 end = new Node1(d);
		Node1 n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	//Delete a node from a Linked List having a value d
	public Node1 deleteNode(Node1 head, int d){
		Node1 n = head;
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
		Node1 n = this;
		while(n != null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
}
public class SumTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node1 n1 = new Node1(3);
		n1.appendValue(1);
		n1.appendValue(5);
		
		Node1 n2 = new Node1(5);
		n2.appendValue(9);
		n2.appendValue(2);
		
		n1.display();
		n2.display();
		
		sum(n1, n2);
	}
	
	public static void sum(Node1 n1, Node1 n2){
		int num1 = convert(n1);
		int num2 = convert(n2);
		
		System.out.println(num1);
		System.out.println(num2);
		
		Node1 n = convertToList(num1+num2);
		n.display();
	}
	
	public static int convert(Node1 n){
		int num = 0;
		int count = 0;
		while(n != null){
			num = num + (int)Math.pow(10, count) * n.data;
			count +=1;
			n = n.next;
		}
		return num;
	}
	
	public static Node1 convertToList(int num){
		int rest = num/10;
		double digit = (double)num/10 - rest;
		int number = (int)Math.ceil((digit * 10));
		Node1 n = new Node1(number);
		num = num/10;
		while(num > 0){
			rest = num/10;
			digit = (double)num/10 - rest;
			number = (int)(digit * 10);
			n.appendValue(number);
			num = num/10;
		}
		n.appendValue(0);
		return n;
	}
}
