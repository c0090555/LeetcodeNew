/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Note: dfs
 */
import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		boolean[] used = new boolean[n+1];
		ArrayList<Integer> sol = new ArrayList<Integer>();
		
		if(n<=k){
			for(int i =1; i <= n; i++)
				sol.add(i);
			res.add(sol);
			return res;
		}	
		
		for(int i = 1; i <= n - k + 1; i++){
			dfs(used, i, k, sol,res);
		}
		return res;
			
		
	}
	public void dfs(boolean[] used,  int current_num, int k, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		int n = used.length -  1;//we set used length as n+1
		//use current_num
		used[current_num] = true;
		sol.add(current_num);
		int need = k - sol.size();//!!calculate how many more numbers we still need
		if (sol.size() == k){//we have already found k numbers
			ArrayList<Integer> copy = (ArrayList<Integer>)sol.clone();
			res.add(copy);
		}
		else{
			for (int i = current_num + 1; i <= n - need + 1; i++){
				dfs(used, i, k, sol, res);
			}			
		}
		sol.remove(sol.size()-1);
		used[current_num] = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations o = new Combinations();
		int n = 10;
		int k = 2;
		//o.combine(n, k);
		System.out.println(o.combine(n, k));
		int j = 0;
	}

}
