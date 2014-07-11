/*
Given a binary tree, return the in-order traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


Solution: iterative 
idea comes from: http://leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
method 1: use a current pointer to indicate which node we are visiting, if current = null, then we need to print its value, 
go to its right subtree
Key point for method 1: use current to control which node we are visiting

method 2: based on the observation: The last traversed node must not have a right child, we can refactor the code

method 3: Morris algorithm. Time: O(n) but space O(1).  Please refer to http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
Key idea: use the right null child of the in-order predecessor of one node in its left subtree


 */
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
	// method 1
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;
		boolean done = false;
		while (!done) {
			if (current != null) {// if we haven't reached null
				s.push(current);
				current = current.left;// move left
			} else {// reach the null node
				if (s.isEmpty()) {// check whether we have nodes which are
									// needed to be visited or not
					done = true;
				} else {
					current = s.pop();
					res.add(current.val);
					current = current.right;

				}

			}

		}
		return res;

	}
	
	//method 2
	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;//use current to control which node should be pushed into stack
		while(!s.isEmpty() || current != null){
			if (current != null){
				s.add(current);
				current = current.left;
			}
			else{
				current =  s.pop();
				res.add(current.val);
				current = current.right;
			}
		}
		return res;
	}
	
	
//Morris Algorithm for in-order traversal
//Analysis:
/*
 * ArrayList<Integer> res = new ArrayList<Integer>();
For current node:
1. If its left child is null, then add it into res, go to its right child
2. If its left child isn't null, then find its predecessor node in its left subtree, 
check this predecessor node's right child, 
a. if right child is null, then set this right child to current node, move current to its left child
b. if right child isn't null, set right child to null to recover the tree structure and add current node to res,
move to its right child

Repeat 1 and 2 until current node is null
For pre-order traversal, it's similar with this in-order traversal


*/
	public ArrayList<Integer> inorderTraversal3(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		TreeNode current = root;
		while (current != null){
			if (current.left == null){
				res.add(current.val);
				current = current.right;
			} else{
				//find its predecessor node in its left subtree
				TreeNode prev = current.left;
				while (prev.right != null && prev.right != current){
					prev = prev.right;
				}
				if (prev.right == null){//first time visit
					prev.right = current;
					current = current.left;//move to its left child
				}
				else {
					prev.right = null;
					res.add(current.val);
					current = current.right;
				}
			}
		}
		return res;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
