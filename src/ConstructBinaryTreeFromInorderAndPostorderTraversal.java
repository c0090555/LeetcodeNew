/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
import java.util.HashMap;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
    	for (int i = 0; i < inorder.length; i++)
    		hash.put(inorder[i], i);
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length -1,hash);
    }
    public TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, HashMap<Integer,Integer> hash){
    	if (iStart > iEnd)
    		return null;
    	System.out.println(pStart + " " +pEnd);
    	TreeNode root = new TreeNode(postorder[pEnd]);
    	int rootInorder = hash.get(root.val);
    	int leftNum = rootInorder - iStart;
    	int rightNum = iEnd - rootInorder;
    	root.left = buildTreeHelper(inorder, rootInorder - leftNum, rootInorder - 1, postorder, pEnd - (leftNum+rightNum), pEnd - rightNum - 1, hash);
    	root.right = buildTreeHelper(inorder, rootInorder + 1, iEnd, postorder, pEnd -  rightNum, pEnd - 1, hash);
    	return root;
    }
    public static void main(String[] args){
    	ConstructBinaryTreeFromInorderAndPostorderTraversal  o = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
    	int[] inorder = {1,3,2};
    	int[] postorder = {3,2,1};
    	TreeNode t = o.buildTree(inorder,postorder);
    }

}
