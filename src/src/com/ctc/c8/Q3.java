package src.com.ctc.c8;

public class Q3 {

	public static void main(String[] args) {
		String str = new String("abc");
		combinations(str);
	}
	private static void combinations(String str){
		int length = str.length();
		StringBuffer output = new StringBuffer(length);
		combine(str, length, output, 0);
	}
	
	private static void combine(String str, int length, 
			StringBuffer output, int allowedStart){
		if(allowedStart == length){
			return;
		}
		else{
			for(int i=allowedStart; i< length; i++){
				output.append(str.charAt(i));
				System.out.println(output.toString());
				combine(str, length, output, i+1);
				output.deleteCharAt(output.length() - 1);
			}
		}
	}
}
