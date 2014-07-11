/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL 
 
 */
class TreeLinkNode{
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	int val;
	TreeLinkNode(int v){
		left = null;
		right = null;
		next = null;
		val = v;
	}
}
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
    	connectHelper(root, null);
    	return;
    }
    public void connectHelper(TreeLinkNode node, TreeLinkNode parent){
    	if (node == null || (node.left == null && node.right == null)){
    		return;
    	}
    	node.left.next = node.right;
    	if (parent == null || node.next == null){
    		node.right.next = null;
    	}
    	else{
    		node.right.next = node.next.left;
    	}
    	connectHelper(node.left, node);
    	connectHelper(node.right, node);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
