/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 */
public class MaximumSubarray {
	//approach 1 - O(n)
    public int maxSubArray1(int[] A) {
    	int n = A.length;
    	if (n == 0)
    		return 0;
    	int max_overall = A[0];
    	int max_endingHere = A[0];
    	for(int i = 1; i < n; i++){
    		if (max_endingHere < 0){
    			max_endingHere = A[i];
    			max_overall = Math.max(max_overall, A[i]);
    		}
    		else{
    			max_endingHere = max_endingHere + A[i];
    			max_overall = Math.max(max_overall, max_endingHere);
    		}
    		
    	}
    	return max_overall;    	
    }
    //approach 2 - Divide & Conquer !!!Divide & Conquer is a clue to think about binary divide
/*
idea from: http://joycelearning.blogspot.com/2013/10/leetcode-maximum-subarray.html
idea； use the idea of binary divide, 
we have three conditions for max subarray:
1. max subarray lies in the left half
2. max subarray lies in the right half
3. max subarray lies across the mid point
 
 */  
    public int maxSubArray(int[] A){
    	int n = A.length;
    	if (n == 0)
    		return 0;
    	return maxSubArray(A, 0, n-1);
    }
    
    public int maxSubArray(int[] A, int start ,int end){
    	if (start > end){
    		return Integer.MIN_VALUE;//!!!if start > end, we should return Integer.MIN_VALUE, if we return 0, then we will get wrong answers when all numbers are negative numbers
    	}
    	int mid = (start + end)/2;
    	//search left & right 
    	int leftMax = maxSubArray(A, start, mid-1);
    	int rightMax = maxSubArray(A, mid+1, end);
    	int max = Math.max(leftMax, rightMax);
    	//if max subarray lies across mid
    	int sum = 0;
    	int maxLeft = 0;//!!!since we have already got A[mid] here, we couldn't set maxLeft as Integer.MIN_VALUE
    	for (int i = mid - 1; i >= start; i--){
    		sum += A[i];
    		maxLeft = Math.max(maxLeft, sum);
    	}

    	sum = 0;
    	int maxRight = 0;
    	for (int i = mid + 1; i <= end; i++){
    		sum += A[i];
    		maxRight = Math.max(maxRight, sum);
    	}
    	
    	max = Math.max(max, maxLeft + A[mid] + maxRight); 
    	
    	return max;
    }
    	
    	
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray o = new MaximumSubarray();
		int[] a = {-2,0};
		System.out.print(o.maxSubArray(a));
	}

}
