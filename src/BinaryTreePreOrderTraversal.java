/*
 * use stack
 */

import java.util.*;
public class BinaryTreePreOrderTraversal {
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
	     ArrayList<Integer> res = new ArrayList<Integer>();
	     if(root == null)
	    	 return res;
	     Stack<TreeNode> s = new Stack<TreeNode>();
	     s.push(root);
	     while(!s.isEmpty()){
	    	 TreeNode cur = s.pop();
	    	 res.add(cur.val);
	    	 if(cur.right != null){
	    		 s.push(cur.right);
	    	 }
	    	 if(cur.left != null){
	    		 s.push(cur.left);
	    	 }
	    	 
	    	 
	     }
	     return res;
	    
		 
	    }
}
