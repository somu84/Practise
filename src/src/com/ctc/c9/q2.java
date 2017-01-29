package src.com.ctc.c9;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * @author Somu
 *
 */
public class q2 {
	/**
	 * The basic idea is to implement a normal sorting algorithm where you override 
	 * the compareTo method to compare the “signature” of each string. 
	 * In this case, the signature is the alphabetically sorted string.
	 * @author Somu
	 *
	 */
	static class AnagramComparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			return sortChars(arg0).compareTo(sortChars(arg1));
		}
		
		private String sortChars(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
	}

	/**
	 * Now, just sort the arrays, using this compareTo method instead of the usual one.
	 * Arrays.sort(array, new AnagramComparator());
	 */
}
