package src.com.ctc.c3;
/*
 * Class to create Stacks from Array
 */

public class Stacks {
	private Integer[] stack;
	private int top;
	private boolean isFull;
	
	public Stacks(int size){
		stack = new Integer[size];
		top = 0;
		isFull = false;
	}
	public boolean push(int d){
		if(top <= stack.length -1){
			stack[top] = d;
			top++;
			if(top == stack.length)
				isFull = true;
			return true;
		}
		
		return false;
	}
	public Integer pop(){
		Integer d = null;
		if(top >= 0 && top < stack.length){
			top--;
			d = stack[top];
			stack[top] = null;
			//--top;
		}
		else if(top == stack.length){
			top--;
			d = stack[top];
			stack[top] = null;
			isFull = false;
			//--top;
		}
		return d;
	}
	public Integer peek(){
		Integer d = null;
		if(top >= 0 && top <= stack.length){
			d = stack[top-1];
		}
		return d;
	}
	public void disp(){
		for(Integer k: this.stack){
			System.out.println(k);
		}
	}
	public boolean getStackCap(){
		return isFull;
	}
	public int getTop(){
		return top;
	}
	public boolean isEmpty(){
		if (top <= 0)
			return true;
		return false;
	}
}
