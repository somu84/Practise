package src.com.ctc.c3;
/*
 * Chap 3 Q6
 */
public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks s = new Stacks(5);
		s.push(2);
		s.push(5);
		s.push(1);
		s.push(4);
		s.push(3);
		//s.disp();
		Stacks r = sort(s);
		r.disp();
	}
	public static Stacks sort(Stacks s){
		Stacks min = new Stacks(5);
		//check.push(s.pop());
		while(!s.isEmpty()){
			int d = s.pop();
			while(!min.isEmpty() && min.peek()>d){
				s.push(min.pop());
			}
			min.push(d);
		}
		return min;
	}
}
