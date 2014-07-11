/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Note: DFS
 */
import java.util.ArrayList;
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int n = num.length;
        if (n == 0)
        	return new ArrayList<ArrayList<Integer>>();
       
        return permuteHelper(num, n-1);
       
    }
    //DFS1
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int position){
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       	if (position == 0){
    		ArrayList<Integer> perm = new ArrayList<Integer>();
    		perm.add(num[0]);
    		res.add(perm);
    		return res;
       	}
       	ArrayList<ArrayList<Integer>> prev = permuteHelper(num, position - 1);
       	for (ArrayList<Integer> prevPerm : prev){
       		for (int i = 0; i <= prevPerm.size(); i++){
       			ArrayList<Integer> copy = (ArrayList<Integer>)prevPerm.clone();
       			copy.add(i, num[position]);
       			res.add(copy);
       		}
       	}
       	return res;
    }
    //DFS2 - with a helper boolean array visit[]
    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
    	int n = num.length;
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (n == 0)
    		return res;
    	boolean[] visit = new boolean[n];
    	ArrayList<Integer> perm = new ArrayList<Integer>();
    	dfs(num, visit, 0, perm, res);
    	return res;
    }
    public void dfs(int[] num, boolean[] visit, int step, ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> res){
    	int n = num.length;
    	if (step == n){
    		ArrayList<Integer> copy = (ArrayList<Integer>)perm.clone();//!!!add the copy back to res
    		res.add(copy);
    		return;
    	}
    	for(int i = 0; i < n; i++){
    		if (visit[i] == false){
    			perm.add(num[i]);
    			visit[i] = true;
    			dfs(num, visit, step+1, perm, res);
    			perm.remove(perm.size()-1);
    			visit[i] = false;
    		}
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations o = new Permutations();
		int[] num = {1,2};
		ArrayList<ArrayList<Integer>> res = o.permute2(num);
		System.out.println(res);
	}

}
