/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
import java.util.ArrayList;
import java.util.Arrays;
public class SubSetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
    	int n = num.length;
    	if (n == 0)
    		return res;
    	Arrays.sort(num);//sort first
    	//n == 1
    	ArrayList<Integer> sol = new ArrayList<Integer>();
    	sol.add(num[0]);
    	res.add(sol);
    	
    	ArrayList<ArrayList<Integer>> newAdd= new ArrayList<ArrayList<Integer>>();
    	newAdd.add(sol);    	
    	
    	for(int i = 1; i < n; i++){
    		ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
    		ArrayList<ArrayList<Integer>> nextNewAdd = new ArrayList<ArrayList<Integer>>();
    		//!!!key part: update new add
        	if (num[i] == num[i - 1]){
        		//update new add
        		for (ArrayList<Integer> newAddSet : newAdd){
        			ArrayList<Integer> newAddCopy = (ArrayList)newAddSet.clone();
        			newAddCopy.add(num[i]);
        			nextNewAdd.add(newAddCopy);
        		}
        	
        	} else{
        		//update nextNewAdd
        		for (ArrayList<Integer> set : res){
        			ArrayList<Integer> copy = (ArrayList)set.clone();
        			copy.add(num[i]);
        			nextNewAdd.add(copy);
        		}
        		
        	}
        	
        	//update next
        	next.addAll(res);
    		next.addAll(nextNewAdd);
    		res = next;
    		newAdd = nextNewAdd;    		
    		
    	}
    	return res;
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (n == 0)
            return res;
        Arrays.sort(num);
        ArrayList<Integer> oneNum = new ArrayList<Integer>();
        oneNum.add(num[0]);
        res.add(oneNum);
        
        ArrayList<ArrayList<Integer>> newAdd = new ArrayList<ArrayList<Integer>>();
        newAdd.add((ArrayList<Integer>)oneNum.clone());
        for (int i = 1; i < n; i++){
            ArrayList<ArrayList<Integer>> nextNewAdd = new ArrayList<ArrayList<Integer>>();
            if (num[i] != num[i-1]){
                for (ArrayList<Integer> prev : res){
                    ArrayList<Integer> copy = (ArrayList<Integer>)prev.clone();
                    copy.add(num[i]);
                    nextNewAdd.add(copy);
                }
            } else{
                for (ArrayList<Integer> newE : newAdd){
                    ArrayList<Integer> copy = (ArrayList<Integer>)newE.clone();
                    copy.add(num[i]);
                    nextNewAdd.add(copy);
                }
            }
            newAdd = nextNewAdd;
            res.addAll(newAdd);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSetsII o = new SubSetsII();
		int[] num = {1,2};
		o.subsetsWithDup2(num);
	}

}
