package src.com.ctc.c9;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order.
 * @author Somu
 *
 */
public class q1 {
	
	
	//This solution used O(n) additional space. Where n is the length of A
	public static void merge(Integer[]A, Integer[]B){
		int j=0, k=0;
		Integer[] C = new Integer[A.length];
		for(int i=0; i<C.length; i++){
			if(k>=B.length){
				C[i] = A[j];
				j++;
			}
			else if(A[j] == null){
				C[i] = B[k];
				k++;
			}
			else if(A[j] <= B[k]){
				C[i] = A[j];
				j++;
			}
			else{
				C[i] = B[k];
				k++;
			}
		}
		System.arraycopy(C,0, A, 0, C.length);
	}
	
	
	//This solution uses no additional space.
	public static void mergeInplace(Integer[] a, Integer[]b ){
		int k = a.length - 1;
		int n = 4 -1;
		int m = b.length -1;
		//We merge A and B from the back, by comparing each element.
		while(m >= 0 && n >= 0){
			if(a[n] > b[m]){
				a[k] = a[n];
				n--;
				k--;
			}
			else{
				a[k] = b[m];
				m--;
				k--;
			}
		}
		//This is for cases when b has more elements than a
		while(m >= 0){
			a[k--] = b[m--];
		}
	}
	public static void main(String args[]){
		Integer A[] = {5, 6,7,8,null, null, null, null, null};
		Integer B[] = {1,2,3,4,9};
		mergeInplace(A, B);
		
		for(int a:A){
			System.out.print(a+" ");
		}
	}

}
