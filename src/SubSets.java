/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.ArrayList;
import java.util.Arrays;
public class SubSets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = S.length;
        res.add(new ArrayList<Integer>());//base case
        if (n == 0)
        	return res;
        Arrays.sort(S);//!!!keep elements in subset in non-descending order
        for (int i = 0; i < n ; i++){
        	ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        	next.addAll(res);
        	for (ArrayList<Integer> sol : res){
        		ArrayList<Integer> copy = (ArrayList)sol.clone();
        		copy.add(S[i]);
        		next.add(copy);
        	}
        	res = next;
        }
        return res;
        
    }
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = S.length;
        if (n == 0)
            return res;
        Arrays.sort(S);
        res.add(new ArrayList<Integer>());//empty set
        for (int e : S){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();            
            for (ArrayList<Integer> prev : res){
            	temp.add(new ArrayList<Integer>(prev));//clone ArrayList elements
                prev.add(e);
                temp.add(prev);
            }
            res = temp;
        }
        return res;
    }
    public static void main(String[] args){
    	SubSets o = new SubSets();
    	int[] S={1,2,3};
    	o.subsets2(S);
    }
}
