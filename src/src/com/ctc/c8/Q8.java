package src.com.ctc.c8;

import java.util.ArrayList;
import java.util.List;

public class Q8 {
	private static class Position{
		int row;
		int col;
		Position(int i, int j){
			this.row = i;
			this.col = j;
		}
	}
	
	public static Position[] solveNQueenOneSoln(int n){
		Position[] pos = new Position[n];
		boolean hasSol = solveUtil(n,0,pos);
		if(hasSol){
			return pos;
		}
		else{
			return new Position[0];
		}
	}
	
	public static boolean solveUtil(int n, int row, Position[] pos){
		if(row == n)
			return true;
		for(int col = 0; col < n; col++){
			boolean foundSafe = true;
			for(int queen = 0; queen < row; queen++){
				if(pos[queen].col == col || pos[queen].row - pos[queen].col == row - col || 
						pos[queen].row + pos[queen].col == row + col){
					foundSafe = false;
					break;
				}
			}
			if(foundSafe){
				pos[row] = new Position(row, col);
				if(solveUtil(n, row+1, pos)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	public static void main(String args[]){
		Position[] pos = solveNQueenOneSoln(4);
		for(Position p: pos){
			System.out.println("Queen "+p.row+" at Colum:"+p.col);
		}
		
		//All Soutions
		List<List<String>> res = solveNQueens(4);
		System.out.println("Total number of possible solutions: "+res.size());
		for(List<String> r: res){
			for(String p: r){
				System.out.println(p);
			}
			System.out.println("Next Solution");
		}
	}
	
	/**
	 * Code to find list of all possible solutions
	 */
	public static List<List<String>> solveNQueens(int n){
		List<List<String>> result = new ArrayList<>();
		Position[] pos = new Position[n];
		solve(0,pos,result,n);
		return result;
	}
	
	public static void solve(int current, Position[] pos, List<List<String>> result, int n){
		if(n == current){
			StringBuffer buff = new StringBuffer();
			List<String> oneRes = new ArrayList<>();
			for(Position p: pos){
				for(int i=0; i<n; i++){
					if(p.col == i){
						buff.append("Q");
					}else{
						buff.append(".");
					}
				}
				oneRes.add(buff.toString());
				buff = new StringBuffer();
			}
			result.add(oneRes);
			return;
		}
		
		for(int i=0; i<n; i++){
			boolean foundSafe = true;
			for(int j=0; j<current; j++){
				if(pos[j].col == i || pos[j].col - pos[j].row == i - current ||
						pos[j].col + pos[j].row == i+current){
					foundSafe = false;
					break;
				}
			}
			if(foundSafe){
				pos[current] = new Position(current, i);
				solve(current+1, pos, result, n);
			}
		}
	}
}
