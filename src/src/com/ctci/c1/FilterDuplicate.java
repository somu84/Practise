package src.com.ctci.c1;
/*
 * Cracking the Coding interview: Chap1: Q3
 * Write a method to remove all duplicates from a string.
 * Without using an extra copy of the array.
 */
public class FilterDuplicate {
	
	public static void main(String [] argv){
		String str = "abcaaad";
		char[] cs = removeDup(str.toCharArray());
		System.out.println(cs);
	}
	public static char[] removeDup(char[] cs){
		boolean[] hit = new boolean[256];
		for(int i=0; i<256; i++) hit[i] = false;
		int tail = 1;
		hit[cs[0]] = true;
		for(int j=0; j< cs.length; j++){
			if(!hit[cs[j]]){
				cs[tail] = cs[j];
				++tail;
				hit[cs[j]] = true;
			}
		}
		cs[tail] = 0;
		return cs;
	}
}
