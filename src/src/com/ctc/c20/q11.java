package src.com.ctc.c20;

/**
 * This class is for the Dynamic Prog Solution
 * @author Somu
 *
 */
class point{
	int row;
	int height;
	
	point(int x, int y){
		this.row = x;
		this.height = y;
	}
}

/**
 * Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
 * 
 * Look the following for Solution: https://www.youtube.com/watch?v=vi_1eHCsR9A
 * @author Somu
 *
 */
public class q11 {
	
	/**
	 * The functions above main, is for the solution using O(1) space
	 * @param sqr
	 * @return
	 */
	public static int maxSquare(String[][] sqr){
		//Iterate the matrix columns wise
		int i=0;
		int j=0;
		int maxSize = 0;
		for(i=0; i<sqr.length; i++){
			if(maxSize > sqr.length -i )
				return maxSize;
			for(j = 0; j<sqr.length; j++){
				if(sqr[j][i].equals("B")){
					int lColSize = getCol(sqr, j, i);
					int uRowSize = getRow(sqr, j,i);
					int minSize = (int)Math.min(lColSize, uRowSize);
					int bRowSize = getRow(sqr,j+minSize-1,i);
					minSize = (int)Math.min(bRowSize, minSize);
					int rColSize = getCol(sqr,j,i+minSize-1);
					minSize = (int)Math.min(rColSize, minSize);
					if(minSize > maxSize)
						maxSize = minSize;
				}
			}
			
		}
		return maxSize;
	}
	
	/**
	 * 
	 * @param sqr
	 * @param row
	 * @param col
	 * @return
	 */
	public static int getCol(String[][] sqr, int row, int col){
		int size = 0;
		if(col > sqr.length - 1)
			return 1;
		for(int i=row; i<sqr.length; i++){
			if(sqr[i][col].equals("B")){
				size++;
			}
			else{
				return size<1?1:size;
			}
		}
		return size<1?1:size;
	}
	
	/**
	 * 
	 * @param sqr
	 * @param row
	 * @param col
	 * @return
	 */
	public static int getRow(String[][] sqr, int row, int col){
		int size = 0;
		if(row > sqr.length -1)
			return 1;
		for(int i=col; i<sqr.length; i++){
			if(sqr[row][i].equals("B")){
				size++;
			}
			else{
				return size<1?1:size;
			}
		}
		return size<1?1:size;
	}
	
	//Driver
	public static void main(String[] args){
		String[][] str = {{"W","B","B","B","B"},
						  {"B","W","B","B","W"},
						  {"W","W","B","B","B"},
						  {"W","B","B","B","B"},
						  {"B","B","B","B","B"}};
		//int size = maxSquare(str);
		
		//Dynamic Prog Soln
		int size = getMaxSqr(str);
		System.out.println(size);
		
	}
	
	/**
	 * This is the Dynamic Programming Solution
	 * @param args
	 * @return
	 */
	public static int getMaxSqr(String[][] args){
		point[][] memo = new point[args.length][args.length];
		populate(memo, args);
		return getMaxLength(memo);
		
	}
	
	/**
	 * This function will populate the memo
	 * @param memo
	 * @param args
	 */
	public static void populate(point[][]memo, String[][] args){
		for(int i=0; i<args.length; i++){
			for(int j=0; j<args.length; j++){
				if(args[i][j].equals("W")){
					memo[i][j] = new point(0,0);
					continue;
				}
				else{
					int r = 0, h = 0;
					if(i==0) r = 1;
					if(j == 0) h = 1;
					if(r == 0 && h == 0){
						r = memo[i-1][j].row + 1;
						h = memo[i][j-1].height + 1;
					}
					memo[i][j] = new point(r, h);
					continue;
				}
			}
		}
	}
	
	
	/**
	 * This function will get the max length
	 * @param memo
	 * @return
	 */
	public static int getMaxLength(point[][] memo){
		int maxLength = 0;
		for(int i = memo.length -1; i>= 0; i--){
			for(int j = memo.length -1; j >= 0; j--){
				int r = memo[i][j].row;
				int h = memo[i][j].height;
				int currLen = Math.min(r, h);
				if(currLen <= maxLength) continue;
				
				for(int a = currLen; a >= 1; a--){
					if(a <= maxLength) break;
					int row = j - a +1;
					int ht = i - a + 1;
					if(row < 0 || ht < 0) break;
					
					if(memo[i][row].row >= a && memo[ht][j].height >= a){
						maxLength = a;
						break;
					}
				}
			}
		}
		return maxLength;
	}
}
