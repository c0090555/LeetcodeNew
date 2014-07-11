/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
import java.util.HashMap;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder.length != inorder.length || preorder.length == 0)
    		return null;
    	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    	for (int i = 0; i < inorder.length; i++){
    		hash.put(inorder[i], i);
    	}
    	return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hash);
    }
    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> hash){
    	if(pStart > pEnd || iStart > iEnd)
    		return null;
    	TreeNode root = new TreeNode(preorder[pStart]);
    	int rootInorder = hash.get(root.val);
    	int leftNum = rootInorder - iStart;
    	int rightNum = iEnd - rootInorder;
    	root.left = buildTreeHelper(preorder, pStart + 1, pStart + leftNum, inorder, rootInorder - leftNum, rootInorder - 1, hash);
    	root.right = buildTreeHelper(preorder, pEnd - rightNum + 1, pEnd, inorder, rootInorder + 1, iEnd, hash);
    	return root;
    }

}
