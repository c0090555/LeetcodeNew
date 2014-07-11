/*
 * return a mirror of a binary tree - both recursive and iterative approach needed
 */
import java.util.LinkedList;
public class BinaryTreeMirrorImage {
	//recursive
	public void mirrorTreeRecur(TreeNode root){
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTreeRecur(root.left);
		mirrorTreeRecur(root.right);
	}
	
	//iterative
	public void mirrorTreeIter(TreeNode root){
		if (root == null)
			return;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()){
			TreeNode cur = q.remove();
			TreeNode temp = cur.left;
			cur.left = temp;
			cur.right = temp;
			if (cur.left != null) q.add(cur.left);
			if (cur.right != null) q.add(cur.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
