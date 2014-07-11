package twitterOnlineCodingTest;
/*
Find the number of "visible" nodes in a binary tree. 
A node is a "visible" node if the path from root to that node does not encounter any node of value higher than that node.
 */
class TreeNode{
	int val;
	TreeNode left = null, right = null;
	TreeNode(int v ){
		val = v;
	}
}

public class NumOfVisibleNodes {
	public int findVisible(TreeNode root){
		if (root == null)
			return 0;
		int[] sum = new int[1];
		int max = root.val;
		findVisibleHelper(root, max, sum);
		return sum[0];
	}
	public void findVisibleHelper(TreeNode root, int max, int[] sum){
		if (root == null){
			return;
		}
		if (root.val >= max){
			sum[0]++;
			max = root.val;
		}
		findVisibleHelper(root.left, max, sum);
		findVisibleHelper(root.right, max, sum);
	}
	public static void main(String[] args){
		NumOfVisibleNodes o = new NumOfVisibleNodes();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.left.left = new TreeNode(1);
		r.right = new TreeNode(0);
		System.out.println(o.findVisible(r));
	}
}
