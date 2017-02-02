package src.com.ctc.c19;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an integer between 0 and 999,999, print an 
 * English phrase that describes the integer (eg, “One Thousand, Two Hundred and Thirty Four”).
 * @author Somu
 *
 */
public class q6 {
	static String[] ones = {"","One ","Two ","Three ", "Four ","Five ","Six ","Seven ","Eight ","Nine "};
	static String[] teen = {"","Eleven","Twelve", "Thirteen","Fourteen",
							"Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] tens = {"","","Twenty ","Thirty ","Forty ","Fifty ",
							"Sixty ","Seventy ","Eighty ","Ninety "};
	static String[] hundreds = {" "," ","Hunderd ", "Thousand ", "Ten Thousand ","Hundred Thousand "};
							
	
	public static void numberConvert(int n){
		int num = n;
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuffer res = new StringBuffer();
		while(num > 0){
			int rem = num%10;
			num = num/10;
			arr.add(rem);
		}
		int l = arr.size();
		for(int i=arr.size()-1; i>1; i--){
			res.append(ones[arr.get(i)]);
			res.append(hundreds[i]);
		}
		if(res.length() != 0)
			res.append("and ");
		//Populate the tens and the ones
		if(arr.get(1) == 1){ 
			if(arr.get(0) == 0){
				res.append("Ten");
			}
			else{
				res.append(teen[arr.get(0)]);
			}
		}
		else {
			res.append(tens[arr.get(1)]);
			res.append(ones[arr.get(0)]);
		}
		System.out.println(res.toString());
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		numberConvert(in.nextInt());
	}

}
