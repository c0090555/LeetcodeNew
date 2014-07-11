/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 
Note: 
Solution 1: idea from:https://coderwall.com/p/outcbg
Calculate the raw area first, then calculate (raw area - histogram area) 
Solution 2: idea from: http://blog.unieagle.net/2012/10/31/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Atrapping-rain-water/
For a specific point, the amount of water it could contain depend on its leftHighest point and its rightHighest point(not including itself),
the water amount = min(leftHighest Height, righHighest Height) - A[i] if min(leftHighest Height, rightHighest Height) > A[i],
so scan twice
 */
public class TrappingRainWater {
	//Solution 1
    public int trap(int[] A) {
        int n = A.length; 
        if (n < 3){
        	return 0;
        }
        int maxIndex = 0;
        int rawArea = A[0];
        for (int i = 1; i < n; i++){//calculate raw area & find the "peak"
        	if (A[i] > A[maxIndex]){
        		maxIndex = i;
        	}
        	rawArea += A[i];
        }
        		
        int lMinIndex = 0;
        int lArea = 0;
        for(int i = 1; i <= maxIndex ; i++){
        	if(A[i] >= A[lMinIndex]){
        		lArea += (i - lMinIndex) * A[lMinIndex];
        		lMinIndex = i;
        	}
        }
        int rMinIndex = n - 1;
        int rArea = 0;
        for (int i = n-2; i>=maxIndex; i--){
        	if(A[i] >= A[rMinIndex]){
        		rArea += (rMinIndex - i)*A[rMinIndex];
        		rMinIndex = i;
        	}
        }
    	
    	return lArea + rArea + A[maxIndex]- rawArea;//!!!need to add A[maxIndex]
    	
    }
    //Solution 2
    public int trap2(int[] A) {
    	int n = A.length;
    	if (n <= 2)
    		return 0;
    	int[] left = new int[n];//left highest height
    	left[0] = 0;
    	int leftMax = A[0];
    	for (int i = 1; i < n; i++){
    		if (A[i-1] > leftMax){
    			leftMax = A[i-1];
    		}
    		left[i] = leftMax;
    	}
    	int[] right = new int[n];//right highest height
    	right[n-1] = 0;
    	int rightMax = A[n-1];
    	int sum = 0;
    	for (int i = n - 2; i >= 1; i--){//!!!here as soon as we get right[], we can calculate the amount of water which could be stored at A[i]
    		if (A[i+1] > rightMax){
    			rightMax = A[i+1];
    		}
    		right[i] = rightMax;
    		if (A[i] < Math.min(left[i], right[i])){
    			sum += Math.min(left[i], right[i]) - A[i];
    		}
    		
    	}
    	return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater o = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(o.trap2(A));
	}

}
