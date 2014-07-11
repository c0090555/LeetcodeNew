/*
 * Iterative approach
 * Idea comes from: http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
 * Idea: use a stack and a pointer to record previously visited node
 */
import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreePostOrderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode prev = null;
		s.push(root);
		
		while(!s.isEmpty()){
			TreeNode cur = s.peek();
			if(prev == null || prev.left == cur || prev.right == cur){//traverse down
				if(cur.left != null){
					s.push(cur.left);
				}
				else if(cur.right != null){
					s.push(cur.right);
				}
				else{
					res.add(cur.val);
					s.pop();
				}
			}
			else if(prev == cur.left){//traverse up from left side
				if(cur.right != null){
					s.push(cur.right);
				}
				else{
					res.add(cur.val);
					s.pop();
				}
				
			}
			else{//traverse up from right side
				res.add(cur.val);
				s.pop();
			}
			prev = cur;
			
			
		}
		
		return res;
		
		
	}
	
	
	//another solution
	//use two stacks
	// a reverse of pre-order traversal
	/*
	 * Push the root node to the first stack.
Pop a node from the first stack, and push it to the second stack.
Then push its left child followed by its right child to the first stack.
Repeat step 2) and 3) until the first stack is empty.
Once done, the second stack would have all the nodes ready to be traversed in post-order. Pop off the nodes from the second stack one by one and you’re done.
	 */
	public ArrayList<Integer> postorderTraversalWithTwoStack(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()){
			TreeNode cur = s1.pop();
			s2.push(cur);
			if(cur.left != null){
				s1.push(cur.left);
			}
			if(cur.right != null){
				s1.push(cur.right);
			}
		}
		
		while(!s2.isEmpty()){
			res.add(s2.pop().val);
		}
		return res;
		
	}
}
