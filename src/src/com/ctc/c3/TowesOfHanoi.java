package src.com.ctc.c3;
/*
 * Chap3 Q4
 */

public class TowesOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks source = new Stacks(5);
		Stacks temp = new Stacks(5);
		Stacks target = new Stacks(5);
		for(int i = 0; i<5; i++)
			source.push(i);
		Hanoi(source, temp, target, 5);
		System.out.println("Source Tower: ");
		source.disp();
		System.out.println("Target Tower: ");
		target.disp();
	}
	public static void Hanoi(Stacks s, Stacks temp, Stacks target, int num){
		if(num == 1){
			int i = s.pop();
			target.push(i);
			return;
		}
		Hanoi(s, target, temp, num-1);
		Hanoi(s, temp, target, 1);
		Hanoi(temp, s, target, num-1);
	}

}
