/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: method 1 uses a size-one array to store the minDepth
	  method 2 uses recursion
	  method 3 uses bfs
	  
method 2 & 3 come from: http://gongxuns.blogspot.com/2012/12/leetcode-minimum-depth-of-binary-tree.html	  
 */
import java.util.LinkedList;
public class MinimumDepthofBinaryTree {
	  public int minDepth(TreeNode root) {
	        if (root == null)
	            return 0;
	        int[] depth = new int[1];
	        minDepthHelper(root, 1, depth);
	        return depth[0];
	    }
	    
	  	//method 1 - size-one array
	    public void minDepthHelper(TreeNode root, int curDepth, int[] depth){
	    	if (root == null){
	    		return;
	    	}
	    	if (root.left == null && root.right == null){
	    	    if (depth[0] == 0)
	    	        depth[0] = curDepth;
	    	    else
	    		    depth[0] = Math.min(depth[0], curDepth);
	    	}
	    	curDepth++;

	    	minDepthHelper(root.left, curDepth, depth);
	    	minDepthHelper(root.right, curDepth, depth);
	    	
	    	
	    }
	    //method 2 - recursive
	    public int minDepth2(TreeNode root){
	    	if (root == null)
	    		return 0;
	    	if (root.left == null && root.right == null)//leaf node
	    		return 1;
	    	
	    	if (root.left == null){
	    		return 1 + minDepth2(root.right);
	    	} else if (root.right == null){
	    		return 1 + minDepth2(root.left);
	    	} else{
	    		return 1 + Math.min(minDepth2(root.left), minDepth2(root.right));
	    	}	    	
	    	
	    }
	    //method 3 - bfs
	    public int minDepth3(TreeNode root){
	    	if (root == null)
	    		return 0;
	    	LinkedList<TreeNode> q = new LinkedList<TreeNode>();
	    	q.add(root);
	    	LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
	    	int count = 1;
	    	
	    	while (!q.isEmpty() || !q2.isEmpty()){
	    		q2 = new LinkedList<TreeNode>();
	    		while (!q.isEmpty()){
	    			TreeNode top = q.remove();
	    			if (top.left == null && top.right == null)
	    				return count;
	    			if (top.left != null)
	    				q2.add(top.left);
	    			if (top.right != null)
	    				q2.add(top.right);
	    			
	    		}
	    		count++;
	    		q = q2;
	    	}
	    	
	    	return count;
	    }
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
