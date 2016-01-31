package src.com.prac;

public class TestArr {
	private int [][]test_arr;// = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	
	TestArr(){
	}
	TestArr(int [][]newArr){
		test_arr = newArr;
	}
	//Gives the row Count
	public int methodA(){
		return test_arr.length;
	}
	//Gives the col count
	public int methodB(){
		return test_arr[0].length;
	}
	//Return the value at an index
	public int methodC(int i, int j){
		if(i < test_arr.length && j < test_arr[0].length){
			return test_arr[i][j];
		}
		return -1;
	}
	//Find a value
	public boolean checkNum(int num){
		int maxRow = test_arr.length - 1;
		int maxCol = test_arr.length - 1;
		if(num < test_arr[0][0] || num > test_arr[maxRow][maxCol]){
			return false;
		}
		for(int i=0; i<= maxRow ; i++){
			if(num >= test_arr[i][0] && num <= test_arr[i][maxCol]){
				for(int j=0; j<=maxCol; j++){
					if(num == test_arr[i][j]){
						return true;
					}
				}
			}
		}
		return false;
	}
}
