package src.com.prac;
import java.util.*;
public class FilterDuplicatesNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inpArr = {1,1,1,2,2,2,6,6,6,6,3,3,4,5,5,5,5};
		//Filter Duplicates using Map
		filterDupUsingMap(inpArr);
		//Filter Duplicates normally
		filterDupNormal(inpArr);
		//Filter Duplicates using sort
		filetafterSort(inpArr);
	}

	public static void filterDupUsingMap(int [] inpArr){
		//Your code here
		ArrayList<Integer> arr = new ArrayList <Integer>();
		for(int num: inpArr){
			if(!arr.contains(num)){
				arr.add(num);
			}
			else{
				System.out.print(num);
			}
		}
		System.out.println("\nFiltered Array");
		for(int num: arr){
			System.out.print(num);
		}
	}
	
	public static void filterDupNormal (int [] inpArr){
		//Your code here
		return;
	}
	
	public static void filetafterSort (int [] inpArr){
		//Your code here
		return;
	}
}
