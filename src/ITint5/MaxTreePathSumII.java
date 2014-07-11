package ITint5;
/*
 * Variant of max tree path sum, what if empty path isn't allowed? That means you have to pick up at least
 * two nodes from the tree to form the max path.
 */
public class MaxTreePathSumII {
	public static int max = Integer.MIN_VALUE;

	public int maxTreePathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
		if(root == null)
			return 0;

		maxTreePathSumHelper(root);
		return MaxTreePathSumII.max;

	}

	public int maxTreePathSumHelper(TreeNode root) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (TreeNode child : root.children){
			int childMax = maxTreePathSumHelper(child);
			if (childMax > max1){
				max2 = max1;
				max1 = childMax;
			} else if (childMax > max2){
				max2 =  childMax;
			}
		}
		if (max1 > Integer.MIN_VALUE && max2 > Integer.MIN_VALUE){//have two children
			max = Math.max(max, root.val + max1 +max2);
			max = Math.max(max, root.val + max1);
			max = Math.max(max, root.val + max2);
		} else if (max1 > Integer.MIN_VALUE){//have only one children
			max = Math.max(max, root.val + max1);			
		}
	
		return root.val + Math.max(0, Math.max(max1, max2));
	}
	public static void main(String[] args) {
    	TreeNode r = new TreeNode(-1);
    	TreeNode a = new TreeNode(-2);
    	TreeNode b = new TreeNode(-4);
    	r.children.add( a);
    	r.children.add(b);
    	MaxTreePathSumII o = new MaxTreePathSumII();
    	o.maxTreePathSum(r);
    	System.out.println(MaxTreePathSumII.max);
	}

}
