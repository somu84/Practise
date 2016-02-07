package src.com.prac;
/*
 * Write a program which checks if a 2D array is a sub-array of another 2D array
 */
public class ArrayMatch {

	public static void main(String[] args) {
		int[][]arr   = {{7,2,8,3,4,5,5,8,6,4}, 
						{6,7,3,1,1,5,8,6,1,9}, 
						{8,9,8,8,2,4,2,6,4,3}, 
						{3,8,3,9,5,0,5,3,2,4}, 
						{9,5,0,9,5,0,5,8,1,3}, 
						{3,8,4,3,8,4,5,3,8,4}, 
						{6,4,7,3,5,3,0,2,9,3}, 
						{7,0,5,3,1,0,6,6,0,1}, 
						{0,8,3,4,2,8,2,9,5,6}, 
						{4,6,0,7,9,2,4,1,3,7}};
		
		int[][]test = {{9,5,0},
					   {3,8,4},
					   {3,5,3}};
		
		boolean match = isMatch(arr, test);
		System.out.println(match);
		return;
	}
	public static boolean isMatch(int[][]arr, int[][]test){
		int row = arr.length - test.length;
		int col = arr[0].length - test[0].length;
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(arr[i][j] == test[0][0]){
					int v = 0;
					for(int g=1; g<test.length; g++){
						for(int h=1; h<test[0].length; h++){
							if(arr[i+g][j+h] == test[g][h]){
								v = 1;
							}
							else{
								v = 0;
								break;
							}
						}
					}
					if(v==1){
						return true;
					}
				}
			}
		}
		return false;
	}
}
