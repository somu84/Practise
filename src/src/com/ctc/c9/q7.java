package src.com.ctc.c9;

import java.util.ArrayList;
import java.util.Collections;

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
