/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

idea from:http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
Note: O(n) use a stack which stores all indexes whose value is bigger than previous ones
 */
import java.util.Stack;
import java.util.Arrays;
public class LargestRectangleInHistogram {
	 public int largestRectangleArea(int[] height) {
	    	int maxArea = 0;
	    	int[] h = new int[height.length + 1];
	    	h = Arrays.copyOf(height, height.length + 1);
	    	Stack<Integer> stack = new Stack<Integer>();
	    	int i = 0;
	    	while (i < h.length){
	        	if (stack.isEmpty() || h[stack.peek()] <= h[i]	){
	        		stack.push(i++);
	        	} else{
	        		int t = stack.pop();
	        		maxArea = Math.max(maxArea, h[t] * (stack.isEmpty()? i : (i - stack.peek() - 1)));
	        	}
	        }
	    	return maxArea;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
