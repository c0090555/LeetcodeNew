/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 
Note: use a Stack and a Queue to store the post-order TreeNodes, then travel the whole queue to reset all TreeNodes' children nodes
 */
import java.util.LinkedList;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	// solution 1: use an extra queue
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		s.add(root);
		while (!s.isEmpty()) {
			TreeNode top = s.pop();
			if (top.right != null) {
				s.push(top.right);
			}
			if (top.left != null) {
				s.push(top.left);
			}

			q.add(top);
		}

		while (!q.isEmpty()) {
			TreeNode top = q.pop();
			System.out.println("val " + top.val);
			top.left = null;
			top.right = q.isEmpty() ? q.peek() : null;
		}
	}

	// solution 2 - recursion
	public void flatten2(TreeNode root) {
		root = flattenTreeHelper(root);
	}

	public TreeNode flattenTreeHelper(TreeNode root) {//!!return the last node in the tree after reconstruction
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null)// leaf node
			return root;
		TreeNode lastLeftNode = flattenTreeHelper(root.left);
		TreeNode lastRightNode = flattenTreeHelper(root.right);
		if (lastLeftNode != null) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;
			lastLeftNode.right = temp;
		}

		return lastRightNode == null ? lastLeftNode : lastRightNode;//!! lastRightNode may be null
	}
	
	// solution 3 - reverse post-order traversal
	//idea: https://www.evernote.com/shard/s255/sh/fe6491d4-ac55-4818-a4dd-34c9fa1c94f4/678b4a5c3c87513f93531b2194b3d620
	static TreeNode temp = null;//!! use static variable temp to record previously visited TreeNode
	public void flatten3(TreeNode root) {
		temp = null;//need to clean up static variable before we use it
		reversePostOrder(root);
		return;
	}
	public void reversePostOrder(TreeNode root){//!!temp indicated the previously visited node
		if (root != null){
			reversePostOrder(root.right);
			reversePostOrder(root.left);
			root.right = temp;
			root.left = null;
			temp = root;

			
		}
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		o.flatten3(root);
	}
}
