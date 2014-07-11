/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

idea from: http://jane4532.blogspot.com/2013/05/container-with-most-water-leetcode.html
Note: set two pointers l and r at the leftmost and rightmost sides, if height[l] <height[r], then we can move l by one to the right,
here is the proof: use A(i,j) to indicate the water amount between i and j, since height[l] < height[r], then for any j < r, we have A(l, j) < A(l, r) cause the amount of water is determined by the shorter board
Therefore, A(l, r) is biggest in this status and we can move l to the left side by one
!!if equal, we can move any of them
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int l = 0;
    	int r = height.length - 1;
    	int maxArea = 0;
    	while(l < r){
    		maxArea = Math.max(maxArea, (r-l) * Math.min(height[l], height[r]));
    		if (height[l] < height[r])
    			l++;
    		else
    			r--;
    	}
    	return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater o = new ContainerWithMostWater();
		int[] height = {1,2,3};
		System.out.println(o.maxArea(height));
	}

}
