//Program to print all permutations of a string.
/*For ex: ab = ab, ba
 * 
 */
package src.com.prac;

public class AllPermutation {

	public static void main(String[] args){
		permute("abc");
	}
	
	public static void permute(String str){
		int length = str.length();
		StringBuffer output = new StringBuffer(length);
		boolean[] used = new boolean[length];
		
		permutation(str, length, output, used, 0);
	}
	
	public static void permutation(String str, int length, 
			StringBuffer output, boolean[] used, int position)
	{
		if (length == position){
			System.out.println(output);
		}
		else{
			for(int i = 0; i<length; i++){
				if(used[i] == true) continue;
				
				used[i] = true;
				output.append(str.charAt(i));
				permutation(str, length, output, used, position+1);
				output.deleteCharAt(output.length() - 1);
				used[i] = false;
			}
		}
	}

}
