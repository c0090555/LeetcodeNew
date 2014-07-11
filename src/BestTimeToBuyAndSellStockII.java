/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1){
        	return 0;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++){
        	if (prices[i] < prices[i + 1])
        		max += (prices[i + 1] - prices[i]);
        }
        return max;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
