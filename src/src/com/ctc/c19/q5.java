package src.com.ctc.c19;

import java.util.ArrayList;
import java.util.HashMap;

public class q5 {
	public static void checkGuess(String sol, String guess){
		HashMap<Character, ArrayList<Integer>> guessHash = new HashMap<>();
		//Fill the hash
		for(int i=0; i<sol.length(); i++){
			char t = sol.charAt(i);
			if(guessHash.containsKey(t)){
				ArrayList<Integer> pos = guessHash.get(t);
				pos.add(i);
				guessHash.put(t,pos);
			}
			else{
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(i);
				guessHash.put(t, pos);
			}
		}
		//Iterate through the guess and check in the hash to determine a hit or pseudo hit
		int h=0, ph=0;
		for(Integer i=0; i<guess.length(); i++){
			char g = guess.charAt(i);
			if(guessHash.containsKey(g)){
				ArrayList<Integer> pos = guessHash.get(g);
				if(pos.contains(i)){
					h++;
					pos.remove(i);
				}
				else{
					ph++;
					pos.remove(0);
				}
				if(pos.isEmpty())
					guessHash.remove(g);
			}
		}
		System.out.println("Hits: "+h+" Pseudo Hit: "+ph);
	}
	
	public static void main(String[] args){
		checkGuess("YBGY", "RGGR");
	}

}
