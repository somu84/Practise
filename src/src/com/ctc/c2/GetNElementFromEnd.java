package src.com.ctc.c2;

public class GetNElementFromEnd {

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
		
		//System.out.printf("The 4th element from the end is: %d\n", 
		getNode_1(n, 3);//);
	}
	public static int getNode(Node head, int num){
		int count = 0;
		Node p = head;
		Node q = head;
		while(p.next != null){
			if(count != num){
				p=p.next;
				count +=1;
			}
			else{
				p=p.next;
				q=q.next;
			}
		}
		return q.data;
	}
	
	//Recursive solution
	static int i = 0;
	public static void getNode_1(Node head, int num){
		Node n = head;
		if(n.next == null)
			return;
		getNode_1(n.next, num);
		if(++i == num){
			System.out.println(n.data);
		}
	}
}
