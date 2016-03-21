package src.com.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Movies {
	public static void main(String []args){
		ArrayList<String> movies = new ArrayList<String>();
		movies.add("The Wire");
		movies.add("The Wire");
		movies.add("The Wire");
		movies.add("DareDevil");
		
		List<String> topMovies = findTopK(movies, 3);
		System.out.println("Top three movies are: ");
		for(String k: topMovies){
			System.out.println(k);
		}
	}
	
	public static List<String> findTopK(ArrayList<String> movies, int k)
	{
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = populateMap(movies);
		List<Map.Entry<String, Integer>> sortedEntries = sortMap(map);
		if(k > sortedEntries.size())
			k = sortedEntries.size();
		for(int i = sortedEntries.size() - k; i< sortedEntries.size(); i++){
			result.add(sortedEntries.get(i).getKey());
		}
		return result;
	}
	
	public static Map<String, Integer> populateMap(ArrayList<String> movies){
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String movie: movies){
			if(map.containsKey(movies)){
				int count = map.get(movie);
				map.put(movie, count+1);
			}
			else{
				map.put(movie, 1);
			}
		}
		return map;
	}
	
	public static List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> sortedEntries = 
				new ArrayList<Map.Entry<String, Integer>>();
		sortedEntries.addAll(map.entrySet());
		Collections.sort(sortedEntries, new Comparator(){
			public int compare(Object o1, Object o2){
				return ((Comparable) ((Map.Entry)o1).getValue()).compareTo(((Map.Entry)o2).getValue());
			}
		});
		return sortedEntries;
	}
}

