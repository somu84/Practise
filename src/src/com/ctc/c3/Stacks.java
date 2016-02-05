package src.com.ctc.c3;
/*
 * Class to create Stacks from Array
 */

public class Stacks {
	private Integer[] stack;
	private int top;
	
	public Stacks(int size){
		stack = new Integer[size];
		top = 0;
	}
	public boolean push(int d){
		if(top <= stack.length -1){
			stack[top] = d;
			top++;
			return true;
		}
		return false;
	}
	public Integer pop(){
		Integer d = null;
		if(top >= 0 && top < stack.length){
			d = stack[top];
			stack[top] = null;
			--top;
		}
		else if(top == stack.length){
			top--;
			d = stack[top];
			stack[top] = null;
			--top;
		}
		return d;
	}
	public Integer peek(){
		Integer d = null;
		if(top >= 0 && top < stack.length){
			d = stack[top];
		}
		else if(top == stack.length){
			top--;
			d = stack[top];
		}
		return d;
	}
	public void disp(){
		for(Integer k: this.stack){
			System.out.println(k);
		}
	}
}
