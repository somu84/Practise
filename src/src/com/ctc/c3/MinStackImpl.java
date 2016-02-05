package src.com.ctc.c3;
/*
 * CTCI Chap3 Q2
 */
public class MinStackImpl {

	private Integer[] stack;
	private int top;
	private Integer[] minStack;
	private int minTop;
	//private MinStackImpl minStack;
	
	public MinStackImpl(int size){
		stack = new Integer[size];
		minStack = new Integer[size];
		top = 0;
		minTop = 0;
	}
	
	public void push(int d){
		if(top == 0){
			minStack[minTop] = d;
			//minTop++;
			stack[top] = d;
			top++;
			return;
		}
		else if(top<stack.length){
			if(minStack[minTop] > d){
				minStack[minTop+1] = d;
				minTop++;
			}
			stack[top] = d;
			top++;
		}
		return;
	}
	public Integer pop(){
		if(top < 0){
			return null;
		}
		
		top--;
		Integer d = stack[top];
		stack[top] = null;
		if(d == minStack[minTop]){
			minStack[minTop] = null;
			minTop--;
		}
		//top--;
		return d;
	}
	public Integer min(){
		return minStack[minTop];
	}
	public void disp(){
		for(Integer k: this.stack){
			System.out.println(k);
		}
	}
	public static void main(String args[]){
		MinStackImpl ms = new MinStackImpl(5);
		ms.push(5);
		ms.push(6);
		ms.push(1);
		ms.push(7);
		ms.push(9);
		ms.disp();
		System.out.println("Min "+ms.min());
		ms.pop();
		ms.pop();
		ms.pop();
		ms.disp();
		System.out.println("Min "+ms.min());
	}
}
