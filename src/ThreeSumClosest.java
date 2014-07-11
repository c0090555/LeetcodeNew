/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.Arrays;
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {//!!return value should be the sum of three numbers, not the min distance
    	int n = num.length;
    	if (n < 3)
    		return -1;
    	int minDist = Integer.MAX_VALUE;
    	int minSum = 0;
    	Arrays.sort(num);
    	int i = 0;
    	while (i <= n-3){
    		int left = i + 1;
    		int right = n - 1;
    		int t = target - num[i];
    		while (left < right){
    			int val = num[left] + num[right];
    			if (val == t){
    				return target;
    			} else if (val > t){
    				if (Math.abs(val -t) < minDist){
    					minSum = val + num[i];
    					minDist =  Math.abs(val - t);
    				}
    				right--;
    			} else{
    				if (Math.abs(val - t) < minDist){
    					minSum = val + num[i];
    					minDist = Math.abs(val - t);
    				}
    				left++;
    			}
    		}
    		i++;
    		while(i < n && num[i] == num[i-1])
    			i++;
    		
    	}
    	return minSum;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest o = new ThreeSumClosest();
		int[] num = {0,0,0};
		int target = 1;
		System.out.println(o.threeSumClosest(num, target));
	}

}
