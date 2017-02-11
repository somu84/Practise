package src.com.ctc.c20;

public class q12 {
	
	public static void getMaxSum(int[][] arr){
		int[] tmp = new int [arr.length];
		int maxSum=0;
		int maxLeft = 0, maxRight = 0, maxUp=0, maxDown=0;
		for(int L=0; L<arr[0].length; L++ ){
			for(int R=L; R<arr[0].length; R++){
				for(int i=0; i<arr.length; i++){
					tmp[i] = arr[i][L];
				}
				getMax(tmp, L, R, maxSum, maxLeft, maxRight, maxUp, maxDown);
			}
		}
		
		//Display Result
		System.out.println("Max Sum is: "+maxSum);
		for(int i=maxLeft; i<=maxRight; i++){
			for(int j=maxUp; j<=maxDown; j++){
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
			int[] tmp, int L, 
			int R, int maxSum, 
			int maxLeft, int maxRight,
			int maxUp, int maxDown)
	{
		int currMax = tmp[0];
		int localMax = tmp[0];
		int up=0, dn = 0;
		
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
			}
		}
		if(maxSum > currMax) return;

		maxSum = currMax;
		maxUp = up;
		maxDown = dn;
		maxLeft = L;
		maxRight = R;
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
