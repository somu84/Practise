package src.com.ctc.c19;
//Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
public class q2 {

	/**
	 * This function checkes if the player has any row populated
	 * or any column populated
	 * or any of the two diagonals populated.
	 * @param p
	 * @return
	 */
	static int[][] board ;
	/**
	 * The logic is simple. The function will only be called after the player has made an entry.
	 * Assume that initially the board is 0 and Player 1 enters 1 and Player 2 enters 2.
	 * In which case, when calling the function we will also send the which player made the last
	 * entry and at which point was the entry made.
	 * @param p --> Which player 1/2
	 * @param x --> Row of last entry
	 * @param y --> Column of last entry
	 * @return
	 */
	static boolean didPlayerWin(int p, int x, int y){
		boolean win = false;
		if(x == y || x+y == board.length -1){
			int count = 1;
			//Check Diagonal
			for(int i=0; i<board.length; i++){
				if(board[i][i] != p)
					break;
				count++;
			}
			if(count == board.length)
				return true;
			//check opp diagonal
			count = 1;
			int n = board.length -1;
			for(int i=0; i<board.length; i++){
				if(board[i][n-i] != p)
					break;
				count++;
			}
			if(count == board.length)
				return true;
		}
		//Otherwise just check the row and column
		int count = 1;
		for(int i=x; i<board[0].length; i++){
			if(board[x][i] != p){
				break;
			}
			count++;
		}
		if(count == board.length)
			return true;
		//Check column win
		count = 1;
		for(int i=y; i<board.length; i++){
			if(board[i][y] != p){
				break;
			}
			count++;
		}
		if(count == board.length)
			return true;
		return false;
	}
	
	public static void main(String [] args){
		board = new int[][]{{0,1,2},{0,1,2},{0,1,0}};
		if(didPlayerWin(1, 1,1)){
			System.out.println("Player wins");
			return;
		}
		System.out.println("Player didn't win");
	}
}
