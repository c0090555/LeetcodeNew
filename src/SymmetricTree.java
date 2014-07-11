/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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
 */
import java.util.LinkedList;
public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricIter(root);
	}
	
	//recursive approach
	public boolean isSymmetricRecur(TreeNode a, TreeNode b){
		if (a == null && b == null)
			return true;
		else if (a == null)
			return false;
		else if (b == null)
			return false;
		
		return (a.val == b.val) && isSymmetricRecur(a.left, b.right) && isSymmetricRecur(a.right, b.left);
		
	}
	
	//iterative approach - idea comes from: http://gongxuns.blogspot.com/2012/12/leetcodesymmetric-tree.html
	public boolean isSymmetricIter(TreeNode root){
		LinkedList<TreeNode> left = new LinkedList<TreeNode>();//queue for left branch
		LinkedList<TreeNode> right = new LinkedList<TreeNode>();//queue for right branch
		left.add(root.left);//!!!LinkedList allows null value
		right.add(root.right);
		while (!left.isEmpty() && !right.isEmpty()){
			TreeNode l_top = left.remove();
			TreeNode r_top = right.remove();
			if ((l_top == null&& r_top != null)||(l_top != null && r_top == null))
				return false;
			if (l_top != null){
				if (l_top.val != r_top.val)
					return false;
				left.add(l_top.left);
				left.add(l_top.right);
				right.add(r_top.right);
				right.add(r_top.left);
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(2);
		SymmetricTree o = new SymmetricTree();
		
		System.out.println(o.isSymmetric(r));

	}

}
