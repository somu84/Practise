package src.com.ctc.c20;

//import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated.
 * @author Somu
 *
 */
public class q9 {

	/**
	 * MaxHeap for values below the median.
	 * MinHeap for values above the median.
	 * 
	 * The median is O(1) and the inserts/updates are O(log n).
	 * 
	 */
	//private Comparator<Integer> maxHeapComparator, minHeapComparator;
	private static PriorityQueue<Integer> maxHeap;
	private static PriorityQueue<Integer> minHeap;
	
	
	/**
	 * When a new value arrives it is placed in minHeap, if it's less than or equal to the median.
	 * Otherwise it is placed in the maxHeap.
	 * 
	 * The Heap Sizes can be equal or the minHeap can have one more than maxHeap.
	 * @param randomNumber
	 */
	public void addNewNumber(int randomNumber){
		if(maxHeap.size() == minHeap.size()){
			if(minHeap.peek() != null && randomNumber > minHeap.peek()){
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			}
			else{
				maxHeap.offer(randomNumber);
			}
		}
		else{
			if(randomNumber < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			}
			else{
				minHeap.offer(randomNumber);
			}
		}
	}
	
	/**
	 * The median will be largest value of maxHeap.
	 * @return
	 */
	public static double getMedian(){
		if(maxHeap.isEmpty()) return minHeap.peek();
		else if(minHeap.isEmpty()) return maxHeap.peek();
		if(maxHeap.size() == minHeap.size()){
			return ((minHeap.peek() +maxHeap.peek())/2 );
		}
		else if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}
		else
			return minHeap.peek();
	}
	
	
}
