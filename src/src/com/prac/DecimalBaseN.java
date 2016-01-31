package src.com.prac;
/*
 * Program to convert base 10 to n base number system.
 */

public class DecimalBaseN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Convert(22,10));
	}
	public static String Convert(Integer num, Integer base){
		if(num<base)
			return num.toString();
		Integer remain = num%base;
		String value = Convert(num/base, base)+remain.toString();
		return value;
	}
}
