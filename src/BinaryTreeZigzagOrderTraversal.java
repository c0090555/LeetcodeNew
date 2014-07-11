/*
Binary Tree Zigzag Level Order Traversal Total Accepted: 4481 Total Submissions: 17229 My Submissions
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

idea comes from: http://gongxuns.blogspot.com/2012/12/leetcodebinary-tree-zigzag-level-order.html
 
 
 Note: we need to separate TreeNode and Integer visit sequence
 */

import java.util.ArrayList;
public class BinaryTreeZigzagOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
    		return res;
    	ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
    	toVisit.add(root);
    	boolean leftToRight = false;
    	while (!toVisit.isEmpty()){
    		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		for (TreeNode t : toVisit)
    			temp.add(t.val);
    		res.add(temp);
    		
    		for (int i = toVisit.size() - 1; i >= 0; i--){//start from the last element
    			TreeNode cur = toVisit.get(i);
    			if (leftToRight){
    				if (cur.left != null) next.add(cur.left);
    				if (cur.right != null) next.add(cur.right);
    			}
    			else {
    				if (cur.right != null) next.add(cur.right);
    				if (cur.left != null) next.add(cur.left);
    			}
    		}
    		toVisit = next;
    		leftToRight = leftToRight ? false : true;//!!!reverse the visit sequence

    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
