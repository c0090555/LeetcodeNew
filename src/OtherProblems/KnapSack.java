package OtherProblems;
/*
0-1 Knapsack problem. 
Given n objects and a “knapsack.” 
Item i weighs wi > 0 kilograms and has value vi > 0. 
Knapsack has capacity of W kilograms. 
Goal:  fill knapsack so as to maximize total value.

Solution:
use dp[i][w] to indicate the maximal value we can get by trying to add item 0, 1, 2, ... i
hence we can get the following recursive relation:
1. dp[i][w] = 0 if wi > w 
2. dp[i][w] = max{dp[i-1][w-wi] + vi, dp[i-1][w]} 

Time Complexity: O(n*W), n is the number of items and W is the maximum capacity of the thief
 *
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Item{
	int w;
	int v;
	Item(int w, int v){
		this.w = w;
		this.v = v;
	}
}
public class KnapSack
{
	public int getMaximalValue(Item[] items, int capacity){
		Arrays.sort( items, new Comparator<Item>(){//sort items by weight
			public int compare(Item a, Item b){
				return a.w < b.w ? -1 : (a.w > b.w ? 1 : 0);
			}
		});
		int[][] dp = new int[items.length+1][capacity+1];
		boolean[][] prev = new boolean[items.length+1][capacity+1];
		int max = 0;
		for (int i = 1; i <= items.length; i++){
			for (int j = 1; j <= capacity; j++){
				int wi = items[i-1].w; int vi = items[i-1].v;
				if (wi > j){
					continue;
				}
				dp[i][j] = Math.max( dp[i-1][j-wi] + vi, dp[i-1][j] );
				max = Math.max( dp[i][j], max );
			}
		}
		
		return max;
		
	}
	
	public static void main(String[] args){
		KnapSack o = new KnapSack();
		//test case
		ArrayList<Item> items = new ArrayList<Item>();
		items.add( new Item(1,6) );
		items.add( new Item(2,2) );
		items.add( new Item(4,3) );
		items.add( new Item(4,4) );
		Item[] input = items.toArray(new Item[0]);
		int capacity = 3;
		System.out.println(o.getMaximalValue( input, capacity ));
		
	}

}


