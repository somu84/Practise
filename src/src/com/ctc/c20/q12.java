package src.com.ctc.c20;
/**
 * Class to store the result variables
 * @author Somu
 *
 */
class result{
	int maxSum = 0;
	int maxLeft = 0;
	int maxRight = 0;
	int maxUp = 0;
	int maxDown = 0;
}


/**
 * Given an NxN matrix of positive and negative integers, 
 * write code to find the sub-matrix with the largest possible sum.
 * @author Somu
 *
 */
public class q12 {
	
	/**
	 * This is a fucking awesome solution, using DP
	 * Sadly the complexity is O(n^3).
	 * Uses a modified Kedane's algo
	 * 
	 * https://www.youtube.com/watch?v=yCQN096CwWM&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=14
	 * @param arr
	 */
	public static void getMaxSum(int[][] arr){
		int[] tmp = new int [arr.length];
		result res = new result();
		for(int L=0; L<arr[0].length; L++ ){
			for(int i=0; i<arr.length; i++){
				tmp[i] = arr[i][L];
			}
			getMax(tmp, res, L, L);
			for(int R=L+1; R<arr[0].length; R++){
				for(int i=0; i<arr.length; i++){
					tmp[i] += arr[i][R];
				}
				getMax(tmp, res, L, R);
			}
		}
		
		//Display Result
		System.out.println("Max Sum is: "+res.maxSum);
		for(int i=res.maxLeft; i<=res.maxRight; i++){
			for(int j=res.maxUp; j<=res.maxDown; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Use Kedane's Algo to get the maxSum sub-array
	 * @param tmp
	 * @param L
	 * @param R
	 * @param maxSum
	 * @param maxLeft
	 * @param maxRight
	 * @param maxUp
	 * @param maxDown
	 */
	public static void getMax(
			int[] tmp, result res, int L, int R)
	{
		int currMax = tmp[0];
		int localMax = tmp[0];
		int up=0, dn = 0;
		int fup = 0, fdn = 0;
		
		for(int i=1; i<tmp.length; i++){
			if(tmp[i] > localMax+tmp[i]){
				localMax = tmp[i];
				up = i;
				dn = up;
			}
			else{
				localMax += tmp[i];
				dn++;
			}
			if(currMax < localMax){
				currMax = localMax;
				fup = up;
				fdn = dn;
			}
		}
		if(res.maxSum > currMax) return;

		res.maxSum = currMax;
		res.maxUp = fup;
		res.maxDown = fdn;
		res.maxLeft = L;
		res.maxRight = R;
		return;
	}
	
	
	//Driver
	public static void main(String[] args){
		int[][] arr = {{2,1,-3,-4,5},
					    {0,6,3,4,1},
					    {2,-2,-1,4,-5},
					    {-3,3,1,0,3}};
		
		getMaxSum(arr);
	}

}
