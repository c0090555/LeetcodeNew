/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
idea comes from: http://blog.csdn.net/havenoidea/article/details/12869021

Note: use in-order traversal to find all "possible" nodes(whose value is bigger than its next node
 */
public class RecoverBinarySearchTree {
	TreeNode s1 = null;
	TreeNode s2 = null;
	TreeNode prev = null;
	
	public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = s1.val;
        s1.val = s2.val;
        s2.val =temp;
    }
	public void inorder(TreeNode root){
		if(root == null)
			return;
		inorder(root.left);
		if(prev != null && prev.val > root.val){
			if(s1==null){
				s1=prev;
				s2=root;
			}
			else{
				s2=root;
			}
		}
		prev = root;//record previous visited node
		inorder(root.right);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
