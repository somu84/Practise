package src.com.ctc.c3;
/*
 * Chap 3 Q5
 */
public class QueueWithStacks {
	
	private Stacks s1;
	private Stacks s2;
	
	public QueueWithStacks(int s){
		s1 = new Stacks(s);
		s2 = new Stacks(s);
	}
	
	public void push(int i){
		s1.push(i);
	}
	public Integer take(){
		Integer d = null;
		if(s1.getTop() == 1){
			d = s1.pop();
		}
		else{
			int top = s1.getTop();
			for(int i=top; i>1; i--){
				s2.push(s1.pop());
			}
			d = s1.pop();
			for(int i=s2.getTop(); i>0; i--){
				s1.push(s2.pop());
			}
		}
		return d;
	}
	public void disp(){
		s1.disp();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithStacks q = new QueueWithStacks(3);
		q.push(1);
		q.push(2);
		q.push(3);
		q.disp();
		System.out.println();
		q.take();
		q.take();
		q.disp();
	}

}
