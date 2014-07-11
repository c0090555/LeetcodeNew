/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
idea from: http://fisherlei.blogspot.com/2013/01/leetcode-combination-sum-ii-solution.html
Note: dfs + skip the duplicates

 */
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        if (n == 0)
        	return res;
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        combHelper(num, target, 0, 0, path, res);
        return res;
    	
    }
    public void combHelper(int[] num, int target, int start, int currSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
    	int n = num.length;
    	if (currSum > target)
    		return;
    	if (currSum == target){
    		ArrayList<Integer> copy = (ArrayList<Integer>)path.clone();
    		res.add(copy);
    		return;
    	}
    	for (int i = start; i < n; i++){//!!use a for loop here
        	path.add(num[i]);
        	combHelper(num, target, i+1, currSum + num[i], path, res);//!!!start becomes (i+1)
        	path.remove(path.size()-1);
        	//!!!skip the duplicates
        	while (i<n-1 && num[i] == num[i+1]){
        		i++;
        	}
    	}
    }

}
