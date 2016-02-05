package src.com.ctc.c3;
/*
 * CTCI Chap3 Q1 implement 3 stacks from an array.
 */
public class StackFromArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {1,2,2,2,3,4342,3442,4};
		int len = arr.length;
		int size1 = len/3;
		int size2 = len - 2*size1;
		Stacks s1 = new Stacks(size1);
		Stacks s2 = new Stacks(size1);
		Stacks s3 = new Stacks(size2);
		push(s1,arr, 1);
		s1.disp();
		System.out.println();
		push(s2,arr,2);
		s2.disp();
		System.out.println();
		push(s3,arr,3);
		s3.disp();
	}
	public static void push(Stacks s, Integer[]arr, int num){
		int start = (num-1)*(arr.length/3);
		int end = start+arr.length/3;;
		if(num == 3){
			end = arr.length;
		}
		for(int i=start; i< end; i++){
			boolean res = s.push(arr[i]);
			if(!res){
				System.out.println("Stack full");
				return;
			}
		}
	}
}
