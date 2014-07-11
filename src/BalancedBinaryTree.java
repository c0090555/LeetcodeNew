/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	 public boolean isBalanced(TreeNode root) {
	        
	        int h = getHeight(root);
	        return h != -1;
	    }
	    
	    public int getHeight(TreeNode root){
	    	if (root == null)
	    		return 0;
	    	if (root.left == null && root.right == null)
	    		return 1;
	    	int leftHeight = getHeight(root.left);
	    	if (leftHeight == -1)
	    		return -1;
	    	int rightHeight = getHeight(root.right);
	    	if (rightHeight == -1)
	    		return -1;
	    	if (Math.abs(leftHeight - rightHeight) > 1)
	    		return -1;
	    	else 
	    		return Math.max(leftHeight, rightHeight) + 1;
	    }
}
