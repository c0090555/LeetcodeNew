/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.ArrayList;
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        pathSumHelper(root, sum, path, res);
        return res;
    }
    public void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
    	if (root == null){
    		return;
    	}
    	sum -= root.val;
    	path.add(root.val);
    	if (root.left == null && root.right == null){
    		if (sum == 0){
    			res.add(path);
    		}
    	}
    	ArrayList<Integer> pathLeft = (ArrayList)path.clone();//Java pass by value but for Oject Java is like pass by reference
    	ArrayList<Integer> pathRight = (ArrayList)path.clone();
    	pathSumHelper(root.left, sum, pathLeft, res);
    	pathSumHelper(root.right, sum, pathRight, res);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
