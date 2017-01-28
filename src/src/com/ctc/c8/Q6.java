package src.com.ctc.c8;
/**
 * Implement the “paint fill” function that one might see on many image editing programs. 
 * That is, given a screen (represented by a 2-dimensional array of Colors), 
 * a point, and a new color, fill in the surrounding area until you hit a border of that color.
 * @author Somu
 *
 */

public class Q6 {
	//Define a color enum
	enum Color{Red, Yello, Blue, Green};
	//Recursive function to fill the color
	public static boolean paintFill(Color[][] screen, int x, int y, Color oColor, Color nColor){
		if(x <0 && y <0 || x >= screen[0].length && y>= screen.length){
			return false;
		}
		if(screen[x][y] == oColor){
			screen[x][y] = nColor;
			paintFill(screen, x+1, y, oColor, nColor);
			paintFill(screen, x-1, y, oColor, nColor);
			paintFill(screen, x,y+1, oColor, nColor);
			paintFill(screen, x, y-1, oColor, nColor);
		}
		return true;
	}

}
