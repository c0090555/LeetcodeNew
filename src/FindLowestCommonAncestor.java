/*
1. with pointer to parent node
method 1 - if these two nodes are not in very deep positions, then we can calculate the depth of them first,
from the lower one n2, make the depth difference steps to new position n2', then start form both of n1 and n2,
move at the same pace, find the first meet point

method 2 - step up from both nodes at the same time at the same pace, use a HashMap to record the paths

2. without pointers:
method 3 use recursive


 */

public class FindLowestCommonAncestor {
	//method 1
	public TreeNode findLCA1(TreeNode n1, TreeNode n2){
		return null;
	}
	
	public int getHeight(TreeNode root){
		if (root == null)
			return 0;
		int height = 0;
		while (root != null){
			height++;
			//root = root.parent;
		}
		return height;
	}
	
	//method 3
	public TreeNode findLCA3(TreeNode root, TreeNode m, TreeNode n){
		if (root == null){
			return null;
		}
		if (root == m || root == n){
			return root == m ? m : n;
		}
		
		TreeNode l_res = findLCA3(root.left, m, n);
		TreeNode r_res = findLCA3(root.right, m, n);
		if (l_res != null && r_res != null){
			return root;
		}
		else return l_res != null ? l_res : r_res;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
