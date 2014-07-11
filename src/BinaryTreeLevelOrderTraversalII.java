/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
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

Note: BFS
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		if (root == null)
			return res;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty() || !q2.isEmpty()) {
			q2 = new LinkedList<TreeNode>();
			level = new ArrayList<Integer>();
			while (!q.isEmpty()) {
				TreeNode top = q.remove();
				level.add(top.val);
				if (top.left != null)
					q2.add(top.left);
				if (top.right != null)
					q2.add(top.right);

			}
			q = q2;
			ArrayList<Integer> levelCopy = (ArrayList)level.clone();
			res.add(0,levelCopy);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
