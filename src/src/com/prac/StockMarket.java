package src.com.prac;
/**
 * Given a list of stock prices over a number of days.
 * Write a function calculate the maximum profit.
 * 
 * i.e. Selling Price - Buying Price
 * @author Somu
 *
 */
public class StockMarket {
	
	/**
	 * This is a O(n) solution taking up constant space.
	 * 
	 * 
	 * @param pr
	 * @return
	 */
	
	public static float maxProfit(float[] pr){
		if(pr.length == 0)
			return 0;
		float minPrice = pr[0];
		float maxProfit = 0;
		for(int i=0; i<pr.length; i++){
			if(minPrice > pr[i]){
				minPrice = pr[i];
			}
			float currProfit = pr[i] - minPrice;
			if(maxProfit < currProfit){
				maxProfit = currProfit;
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		
		float [] price = {10,15,9,5,10,25,5,2};
		
		float profit = maxProfit(price);
		System.out.println(profit);
	}

}
