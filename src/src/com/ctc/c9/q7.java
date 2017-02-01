package src.com.ctc.c9;

import java.util.ArrayList;
import java.util.Collections;

/*
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter 
 * than the person below him or her. Given the heights and weights of each person in the circus, 
 * write a method to compute the largest possible number of people in such a tower.
 * 	Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 *	Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 */
public class q7 {
	static class Joker implements Comparable<Joker>{
		Integer height;
		Integer weight;
		
		Joker(int height, int weight){
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Joker arg0) {
			int val1 = this.height.compareTo(arg0.height);
			if(val1 == 0){
				int val2 = this.weight.compareTo(arg0.weight);
				return val2;
			}
			return val1;
		}
		
		public boolean isBefore(Joker j){
			if(this.height <= j.height && this.weight <= j.weight )
				return true;
			return false;
		}
		
	}
	
	/**
	 * Step 1. Sort all items by height first, and then by weight.
	 * Step 2. Find the longest sequence which contains increasing heights and increasing weights.
		To do this, we:
		a) Start at the beginning of the sequence. Currently, max_sequence is empty.
		b) If, for the next item, the height and the weight is not greater than those of the previous item, we mark this item as “unfit” .
		c) If the sequence found has more items than “max sequence”, it becomes “max sequence”.
		d) After that the search is repeated from the “unfit item”, until we reach the end of the original sequence.
	 */
	ArrayList<Joker> items;
	ArrayList<Joker> lastFoundSeq;
	ArrayList<Joker> maxSeq;
	//Returns longer Sequence
	ArrayList<Joker> seqWithMaxLength(ArrayList<Joker> seq1, ArrayList<Joker> seq2){
		return seq1.size() > seq2.size() ? seq1: seq2;
	}
	
	//Fills next seq w decreased weights & returns index of 1st unfit item.
	int fillNextSeq(int startFrom, ArrayList<Joker> seq){
		int firstUnfitItem = startFrom;
		if(startFrom < items.size()){
			for(int i = 0; i < items.size(); i++){
				Joker item = items.get(i);
				if(i==0 || items.get(i-1).isBefore(item)){
					seq.add(item);
				}else{
					firstUnfitItem = i;
				}
			}
		}
		return firstUnfitItem;
	}
	
	//Fill the max length sequence
	void findMaxSeq(){
		Collections.sort(items);
		int currentUnfit = 0;
		while(currentUnfit < items.size()){
			ArrayList<Joker> nextSeq = new ArrayList<Joker>();
			int nextUnfit = fillNextSeq(currentUnfit, nextSeq);
			maxSeq = seqWithMaxLength(maxSeq,nextSeq);
			if(nextUnfit == currentUnfit) break;
			else currentUnfit = nextUnfit;
		}
	}
	

}
