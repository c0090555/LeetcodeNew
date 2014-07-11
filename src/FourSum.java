/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ² b ² c ² d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    
Note: sliding window: time complexity: O(n3); space complexity: O(1)
    
 */
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		if (n < 4)
			return res;
		Arrays.sort(num);
		int i = 0;
		while (i <= n - 4) {
			int j = i + 1;
			while (j <= n - 3) {
				int left = j + 1;
				int right = n - 1;
				int t = target - (num[i] + num[j]);
				while (left < right) {//no equal here since num[left] and num[right] should be two different elements
					if (num[left] + num[right] == t) {
						ArrayList<Integer> sol = new ArrayList<Integer>();
						sol.add(num[i]);
						sol.add(num[j]);
						sol.add(num[left]);
						sol.add(num[right]);
						res.add(sol);
						// search next left
						left++;
						while (left <= n - 1 && num[left - 1] == num[left])
							left++;
						// search next right
						right--;
						while (right >= 0 && num[right] == num[right + 1])
							right--;
					} else if (num[left] + num[right] > t) {
						right--;
					} else
						left++;
				}

				j++;
				while (j < n && num[j] == num[j - 1])//find next unique j
					j++;

			}

			i++;
			while (i < n && num[i - 1] == num[i])//find next unique i
				i++;

		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum o = new FourSum();
		int[] num = {5,0,2,-5,-5,4,-5,1,-1};
		int target = -5;
		ArrayList<ArrayList<Integer>> res = o.fourSum(num, target);
	}

}
