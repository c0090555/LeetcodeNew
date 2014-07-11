/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


method2 comes from: http://blog.csdn.net/pickless/article/details/12033745
 *
 */
public class BestTimeToBuyAndSellStock {
	
	//method 1
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
        	return 0;
        int len = prices.length;
        int[] max = new int[len];
        int[] min = new int[len];
        //scan from left to right
        min[0] = prices[0];
        for (int i = 1; i < len; i++){
        	min[i] = Math.min(min[i - 1], prices[i]);
        }
        //scan from right to left
        max[len - 1] = prices[len - 1];
        for (int j = len - 2; j >= 0; j--){
        	max[j] = Math.max(min[j + 1], prices[j]);
        }
        
        int maxProfit = 0;
        for (int k = 0; k < len; k++){
        	maxProfit = Math.max(maxProfit, max[k] - min[k]);
        }
        return maxProfit;
    }
    
    public int maxProfit2(int[] prices) {
    	int len = prices.length;
    	if (len == 0 || len == 1)
    		return 0;
    	int profit = 0;
    	int min = prices[0];
    	for (int i = 1; i < len; i++){
    		profit = Math.max(profit, prices[i] - min);
    		min = Math.min(min, prices[i]);
    	}
    	
    	return profit;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
