package src.com.ctc.c20;

public class q11 {
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
		int size = maxSquare(str);
		System.out.println(size);
		
	}
}
