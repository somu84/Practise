package src.com.prac;
import java.util.*;

public class FilterDuplicates {

	public static void main(String[] args){
		String test = "Nimu Nimu Good Good";
		String[] testArr = test.split(" ");
		StringBuffer buf = new StringBuffer();
		Map <String, Integer> hp = new HashMap<String, Integer>();
		for(String a: testArr){
			if(hp.get(a) == null){
				hp.put(a, 1);
				buf.append(a+ " ");
			}
		}
		System.out.println(buf.toString());
		return;
	}
}
