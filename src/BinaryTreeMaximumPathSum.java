/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
idea comes from: http://vialgorithms.blogspot.com/2013/08/binary-tree-maximum-path-sum.html

Note: Java cannot pass by reference, it pass by value.(e.g. int)
In order to pass by reference, there are a couple of methods:
1. Put int into a wrapper class. Pass class value(object).
2. Make the value into static variable.
3. Use single int[]. int[] xxx = new int[1].

Method 1: use an size-two array int[2] store, store[0] stores the current max root to node path, store[1]
stores the max value

Method 2: pass int[] and max, int[1] stores the max value; return the current node's max value of one child

 */
 
public class BinaryTreeMaximumPathSum {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	//method 1
    public int maxPathSum(TreeNode root) {
    	if (root == null)
    		return 0;
    	int[] store = maxPathSumHelper(root);
    	return store[1];
    }
    
    public int[] maxPathSumHelper(TreeNode root){
    	int[] store = new int[2];
    	if (root.left == null && root.right == null){//leaf node
    		store[0] = root.val;
    		store[1] = root.val;
    		return store;
    	}
    	int max = Integer.MIN_VALUE;
    	int childMax = 0;//only accept >0 child branch
    	int val = root.val;
    	if (root.left != null){    		
    		int[] left = maxPathSumHelper(root.left);
			max = Math.max(max, left[1]);
    		if (left[0] > 0){
    			val += left[0];
    			childMax = Math.max(childMax, left[0]);
    		}
    		
    	}
    	if (root.right != null){
    		int[] right = maxPathSumHelper(root.right);
			max = Math.max(max, right[1]);
    		if (right[0] > 0){
    			val += right[0];
    			childMax = Math.max(childMax, right[0]);
    		}
    	}

    	store[0] = childMax + root.val;
    	store[1] = Math.max(max, val);
    	return store;
    }
    
    //method 2
    int maxPathSumHelper2(TreeNode root, int[] max){
    	if (root == null){
    		return 0;
    	}
    	int left = maxPathSumHelper2(root.left, max);
    	int right = maxPathSumHelper2(root.right, max);
    	int value = Math.max(left, 0) + Math.max(right, 0) + root.val;
    	max[0] = Math.max(max[0], value);//update max[0] with value which is the maximum sum which passes through root
    	return Math.max(0, Math.max(left, right)) + root.val;
    	
    }
    
    //method 3 - revise of method 2
    int maxPathSumHelper3(TreeNode root, int[] max){
    	if (root.left == null && root.right == null){
    		max[0] = Math.max(max[0], root.val);
    		return root.val;
    	}
    	int value = root.val;
    	int childMax = 0;
    	if (root.left != null){
    		int left = maxPathSumHelper3(root.left, max);
    		if(left > 0){
    			value += left;
    			childMax = Math.max(childMax, left);
    		}
    	}
    	
    	if (root.right != null){
    		int right = maxPathSumHelper3(root.right, max);
    		if (right > 0){
    			value += right;
    			childMax = Math.max(childMax, right);
    		}
    	}
    	
    	max[0] = Math.max(max[0], value);
    	return root.val + Math.max(0, childMax);
    	    	
    }
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
