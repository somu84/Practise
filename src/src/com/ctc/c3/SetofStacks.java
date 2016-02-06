package src.com.ctc.c3;
/*
 * CTCI Chap3 Q3 : Set Of Stacks.
 */
import java.util.ArrayList;

public class SetofStacks {
	static int SIZE = 5;
	ArrayList<Stacks> ss;
	int count;
	
	public SetofStacks(){
		ss = new ArrayList<Stacks>();
		count = 0;
	}
	public void push(int i){
		Stacks s = getLastStack();
		if(s != null && !(s.getStackCap())){
			s.push(i);
		}
		else{
			s = new Stacks(SIZE);
			s.push(i);
			ss.add(s);
			count++;
		}
		return;
	}
	public Integer pop(){
		Stacks s = getLastStack();
		Integer i = s.pop();
		if(i == null){
			count--;
			s = getLastStack();
			i = s.pop();
		}
		return i;
	}
	
	public Integer pop(int index){
		Stacks s = ss.get(index);
		Integer i = s.pop();
		return i;
	}
	private Stacks getLastStack(){
		if(count == 0)
			return null;
		return ss.get(count-1);
	}
	
	public void disp(){
		int c = 1;
		for(Stacks s: ss){
			System.out.println("Stack #"+ c+" :");
			s.disp();
			c++;
		}
	}
	
	public static void main(String[] args){
		SetofStacks s = new SetofStacks();
		for(int i = 1; i<11; i++){
			s.push(i);
		}
		
		s.pop(0);
		s.disp();
	}
}
