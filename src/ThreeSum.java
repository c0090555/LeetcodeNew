/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
    
Note: a follow up of 2 sum
sort first then use sliding window approach
!!!we need to avoid duplicate elements here
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		if (n < 3)
			return res;
		Arrays.sort(num);
		int i = 0;
		while (i < n-2){
		
			int left = i+1;
			int right = n-1;
			int t = (-1) * num[i];
			while(left < right){
				int curr = num[left] + num[right];
				if (curr > t)
					right--;
				else if (curr < t)
					left++;
				else {
					ArrayList<Integer> sol = new ArrayList<Integer>();
					sol.add(num[i]);
					sol.add(num[left]);
					sol.add(num[right]);
					res.add(sol);
					left++;
					while (left < n  && num[left] == num[left-1])
						left++;
					right--;
					while (right >= 0 && num[right] == num[right+1])
						right--;
				}
			}	
			int j = i+1;
			while (j<=n-2 && num[i]==num[j]){//skip duplicate values
				j++;
			}
			i = j;
		}
		
		
		
		
		
		return res;

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum o = new ThreeSum();
		int[] num = {-1,0,1};
		ArrayList<ArrayList<Integer>> r = o.threeSum(num);
		for (ArrayList<Integer> s: r){
			for(int i: s){
				System.out.print(" "+i);
			}
			System.out.println();
		}
	}

}
