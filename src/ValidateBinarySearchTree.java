/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
idea from: http://fisherlei.blogspot.com/2013/01/leetcode-validate-binary-search-tree.html
key idea: need to maintain max and min, for each node we need to check three cases:
1. whether root.val is within min and max
2. how about its left subtree
3. how about its right subtree
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return checkBST(root, Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	public boolean checkBST(TreeNode root, int max, int min){
		if(root==null)
			return true;
		if(root.val < max && root.val >min &&checkBST(root.left,root.val,min) &&checkBST(root.right,max,root.val)){
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args){
		ValidateBinarySearchTree o = new ValidateBinarySearchTree();
		TreeNode r =new TreeNode(10);
		r.left = new TreeNode(5);
		r.right = new TreeNode(15);
		r.right.left = new TreeNode(6);
		r.right.right = new TreeNode(20);
		System.out.println(o.checkBST(r, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}
}
