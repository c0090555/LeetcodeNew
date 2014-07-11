/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

idea comes from: http://zhaohongze.com/wordpress/2013/12/10/leetcode-candy/
idea: scan twice from both directions and need to handle the case that previous child only has one candy
 */
public class Candy {
	public int candy(int[] ratings) {

		int num = 0;
		int n = ratings.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int[] candy = new int[n];

		for (int i = 0; i < ratings.length; i++) {
			candy[i] = 1;
		}

		for (int i = 1; i < n; i++) {//scan from left to right
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}

		}
		
		for(int i=n-2;i>=0;i--){
			if((ratings[i]>ratings[i+1])&&(candy[i]<=candy[i+1])){//to handle the case that previous child only has one candy
				candy[i]=candy[i+1]+1;
			}

		}
		
		for(int j:candy)
			num+=j;
		return num;

	}
}
