package src.com.ctci17.Hard;

public class MaxValoumeInHistogram {
	public static int computeVolume(int[] histo){
		int[] leftMaxes = new int[histo.length];
		int leftMax = histo[0];
		for(int i=0; i<histo.length; i++){
			leftMax = Math.max(leftMax, histo[i]);
			leftMaxes[i] = leftMax;
		}
		int rightMax = histo[histo.length-1];
		int sum = 0;
		for(int i=histo.length-1; i>=0; i--){
			rightMax = Math.max(rightMax, histo[i]);
			int secondTall = Math.min(leftMax, rightMax);
			if(secondTall > histo[i]){
				sum += secondTall - histo[i];
			}
		}
		return sum;
	}

}
