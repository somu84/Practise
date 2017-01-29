package src.com.ctc.c9;

/**
 * 	Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 *	Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
 *	Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 * 	@author Somu
 *
 */
public class q5 {
	/**
	 * Use ordinary binary search, but when you hit an empty string, advance to the next non-empty string; 
	 * if there is no next non-empty string, search the left half.
	 * @param arr
	 * @param str
	 * @return
	 */
	public static int BinarySearch(String[] arr, String str){
		int first = 0;
		int last = arr.length -1;
		while(first < last){
			
			int mid = (first + last) / 2 + first;
			while(arr[mid].equals("") && mid <= last){
				mid +=1;
			}
			int ret = arr[mid].compareTo(str);
			if(ret == 0){
				return mid;
			}
			else if(ret < 0){
				first = mid + 1;
			}
			else {
				last = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		//String str[] = new String[“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”];
		String[] str = {"at", "", "", "", "", "ball", "", "", "car", "", "", "dad","", ""};
		System.out.println(BinarySearch(str, "ball"));
		System.out.println(BinarySearch(str, "ballcar"));
	}

}
