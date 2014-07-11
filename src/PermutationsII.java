/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Note: a variant of Permutations, use sort + dfs(with boolean[] visit)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	int n = num.length; 
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (n == 0)
        	return res;
    	Arrays.sort(num);
    	boolean[] visit = new boolean[n];
    	ArrayList<Integer> perm = new ArrayList<Integer>();
    	dfs(num, visit, 0, perm, res);
    	return res;
    }
    public void dfs(int[] num, boolean[] visit, int step, ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> res){
    	int n = num.length;
    	if (step == n){
    		ArrayList<Integer> copy = (ArrayList<Integer>)perm.clone();
    		res.add(copy);
    		return;
    	}
    	for(int i = 0; i < n; i++){
    		if (!visit[i]){
    			visit[i] = true;
    			perm.add(num[i]);
    			dfs(num, visit, step + 1, perm, res);
    			visit[i] = false;
    			perm.remove(perm.size()-1);
    			//!!!after exhaustively dfs traversal num[i], we need to skip all numbers equal to num[i] to avoid duplicates
    			while(i < n-1 && num[i] == num[i+1])
    				i++;//!!!note we will have another i++ in for loop
    		}
    	}
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII o = new PermutationsII();
		int[] num = {1,1,2,2};
		ArrayList<ArrayList<Integer>> res = o.permuteUnique(num);
		System.out.println(res);
	}

}
