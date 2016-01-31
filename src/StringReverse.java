//import static java.lang.System.*;
public class StringReverse {
	public static void main(){
		String test = "This is a new string";
		StringBuffer buf = new StringBuffer(test.length());
		for(int i=test.length()-1; i >=0 ; i--){
			buf.append(test.charAt(i));
		}
		System.out.printf("The reversed String: %s", buf.toString());
	}

}

