/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   
 idea comes from: http://gongxuns.blogspot.com/2013/01/leetcodeunique-binary-search-trees-ii.html
 use recursion
 Note: we add null node to ArrayList if start > end in order to make sure we always have nodes in ArrayList
 */
import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTreesRecur(1, n);
	}

	public ArrayList<TreeNode> generateTreesRecur(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);//!!!here we add null node, instead of return empty res
		} else if (start == end) {
			res.add(new TreeNode(start));
		} else {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> left = generateTreesRecur(start, i - 1);
				ArrayList<TreeNode> right = generateTreesRecur(i + 1, end);
				for (TreeNode l : left){
					for (TreeNode r : right){
						TreeNode root = new TreeNode(i);//each time we create a new copy of root node
						root.left = l;
						root.right = r;
						res.add(root);
						
					}
				}

			}
		}
		return res;

	}

}
