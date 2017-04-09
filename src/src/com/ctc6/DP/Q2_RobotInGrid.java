package src.com.ctc6.DP;

public class Q2_RobotInGrid {
	public static int countWays(boolean[][] maze){
		int[][] T = new int[maze.length][maze[0].length];
		T[0][0] = 1;
		for(int i=1; i<T.length; i++){
			if(maze[i][0]){T[i][0] = T[i-1][0];}
		}
		for(int i=1; i<T[0].length; i++){
			if(maze[0][i]){T[0][i] = T[0][i-1];}
		}
		for(int i= 1; i<T.length; i++){
			for(int j=1; j<T[i].length; j++){
				if(maze[i][j]){ T[i][j] = T[i][j-1]+T[i-1][j];}
			}
		}
		return T[T.length-1][T[0].length-1];
	}
	
	public static void main(String[] args){
		boolean[] [] maze = {{true, false, true},{true, true, true},{true, true, true}};
		System.out.println(countWays(maze));
	}

}
