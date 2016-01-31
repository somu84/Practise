package src.com.prac;
import src.com.prac.TestArr;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,6};
		//System.out.println( array6(arr,0) );
		String a = "x";
		String b = "z";
		//System.out.println(strCopies(a,b,2));
		System.out.println(strDist(a, b));
	    
	}
	
	public static boolean array6(int[] nums, int index) {
		  if(index == nums.length)
		     return false;
		  if (nums[index] == 6)
		     return true;
		  return array6(nums, ++index);
		}
	public static boolean strCopies(String str, String sub, int n) {
		  if(str.length()<sub.length() && n>0)
		    return false;
		  if(n == 0)
		    return true;
		  if(str.substring(0, sub.length()).equals(sub))
		    return strCopies(str.substring(1), sub, n-1);
		    
		   return strCopies(str.substring(1), sub, n);
	}
	
	public static int strDist(String str, String sub) {
		  if(str.length()<sub.length())
		    return 0;
		  String st = getStr(str, sub);
		  return st.length();
		}

		public static String getStr(String str, String sub){
		  if(str.equals(""))
			   return str;
		  if(!str.substring(0, sub.length()).equals(sub))
		    return getStr(str.substring(1), sub);
		  if(!str.substring(str.length()-sub.length()).equals(sub))
			 return getStr(str.substring(0, str.length()-1), sub);
		  return str;
		}
}
