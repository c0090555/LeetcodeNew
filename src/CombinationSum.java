/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
Note: DFS(use for loop)
idea from: http://fisherlei.blogspot.com/2013/01/leetcode-combination-sum-solution.html

 */
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = candidates.length;
        if (n == 0)
        	return res;
       candidates = getUniqueSet(candidates);    
       ArrayList<Integer> path = new ArrayList<Integer>();
       combHelper(candidates, target, 0, 0, path, res);
       return res;
    }
    public void combHelper(int[] candidates, int target, int start, int currSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
    	int n = candidates.length;
    	if (currSum > target){
    		return;
    	}
    	if (currSum == target){
    		ArrayList<Integer> copy = (ArrayList<Integer>)path.clone();
    		res.add(copy);
    		return;
    	}
    	for (int i = start; i < n; i++){//!!!use for loop here to control which number we want to add 
    		path.add(candidates[i]);
    		combHelper(candidates, target, i, currSum + candidates[i], path, res);
    		path.remove(path.size()-1);
    	}
    }
      
    public int[] getUniqueSet(int[] candidates){
    	Arrays.sort(candidates);
    	int storeIndex = 0;
    	for (int i = 1; i < candidates.length; i++)
    		if (candidates[i-1] != candidates[i]){
    			storeIndex++;
    			candidates[storeIndex] = candidates[i]; 
    		}
    	return Arrays.copyOf(candidates, storeIndex+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
