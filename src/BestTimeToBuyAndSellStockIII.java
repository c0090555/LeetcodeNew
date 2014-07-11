/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

idea comes from: http://blog.csdn.net/pickless/article/details/12034365
scan twice: scan from left to right first to get the max profit which could be achieved before current time(index i) - (O(n))
then scan from right to left to get the max profit after index i - (O(n))
use O(n) to get the max profit from left[i] + right[i]
 */

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1)
        	return 0;
        int[] left = new int[len];
        int min = prices[0];
        for (int i = 1; i < len; i++){
        	left[i] = Math.max(left[i-1], prices[i] - min);//!!!left[] indicates the max profit which could be gotten before current index(but it doesn't have to be at current index time)
        	min = Math.min(min, prices[i]);
        }        
        
        int[] right = new int[len];
        int max = prices[len - 1];
        for (int j = len - 2; j >= 0; j--){
        	right[j] = Math.max(right[j+1], max - prices[j]);//!!!same as left[]
        	max = Math.max(max, prices[j]);
        }
        
        int maxProfit = 0;
        for (int k = 0; k < len; k++)
        	maxProfit = Math.max(maxProfit, left[k] + right[k]);
        
        return maxProfit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
