/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL 
    
    
Note: essentially this is a BFS issue, we need to process this linking level by level    
 * 
 * 
 */
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>(); // for BFS
		LinkedList<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
		q.add(root);
		
		while (!q.isEmpty()){
			TreeLinkNode top = q.remove();
			q2.add(top);
			if (top.left != null)
				q.add(top.left);
			if (top.right != null)
				q.add(top.right);
		}
		
		
		connectHelper(q2);
		return;
	}

	// bfs
	public void connectHelper(LinkedList<TreeLinkNode> q) {
		while (!q.isEmpty()) {
			TreeLinkNode node = q.remove();
			if (node == null) {
				continue;
			}
			//System.out.println(node.val);
			if (node.left != null) {
				if (node.right != null) {
					node.left.next = node.right;
				} else {
					TreeLinkNode nodeCopy = node;
					TreeLinkNode next = findFirstNonNullChild(nodeCopy.next);

					node.left.next = next;
				}
			}
			if (node.right != null) {
				//System.out.println("node right " + node.right.val);
				if (node.next == null)
					node.right.next = null;
				else {
					TreeLinkNode nodeCopy = node;
					//System.out.println("nodeCopy " + nodeCopy.next.val);
					TreeLinkNode next = findFirstNonNullChild(nodeCopy.next);

					//System.out.println("next " + next.val);
					node.right.next = next;// find the non-null child node
				}
			}
		}
		return;

	}

	public TreeLinkNode findFirstNonNullChild(TreeLinkNode node) {
		TreeLinkNode child = null;

		while (node != null) {
			//System.out.println("NODE " + node.val);
			if (node.left != null) {
				child = node.left;

				break;
			}
			if (node.right != null) {
				child = node.right;
				break;
			}
			node = node.next;
		}
		//System.out.println("CHILD " + child);
		return child;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersInEachNodeII o = new PopulatingNextRightPointersInEachNodeII();
		TreeLinkNode root = new TreeLinkNode(2);
		root.left = new TreeLinkNode(1);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(0);
		root.left.right = new TreeLinkNode(7);
		root.right.left = new TreeLinkNode(9);
		root.right.right = new TreeLinkNode(1);
		root.left.left.left = new TreeLinkNode(2);
		root.left.right.left = new TreeLinkNode(1);
		root.left.right.right = new TreeLinkNode(0);
		root.right.right.left = new TreeLinkNode(8);
		root.right.right.right = new TreeLinkNode(8);
		root.left.right.left.left = new TreeLinkNode(7);

		//System.out.println("start");
		o.connect(root);
		

	}

	public void travel(TreeLinkNode root) {
		if (root == null) {
			//System.out.println("null");
			return;
		}
		//System.out.println(root.val);
		travel(root.left);
		travel(root.right);
	}
}
