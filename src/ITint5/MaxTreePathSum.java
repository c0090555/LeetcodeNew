package ITint5;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
/*
给定一棵树的根结点，树中每个结点都包含一个整数值val。我们知道树中任意2个结点之间都存在唯一的一条路径，路径值为路径上所有结点值之和。请计算最大的路径值（允许路径为空）。
Since we allow the path to be empty, so the max starts with 0.
Time Complexity: O(n)
 */
public class MaxTreePathSum {
    public int maxTreePathSum(TreeNode root) {
    	int[] globalMax = new int[1];
    	return maxTreePathSumHelper(root, globalMax);
    }
    public int maxTreePathSumHelper(TreeNode root, int[] globalMax) {//return the max sum along the path from root to all its descendant leaf nodes   
    	if (root == null)
    		return 0;
    	int max1 = 0;//max1 >= max2
    	int max2 = 0;
    	//find the top two maximum path sum from its children
    	for (TreeNode child : root.children){
    		int childMax = maxTreePathSumHelper(child, globalMax);
    		if (childMax > max1){
    			max2 = max1;
    			max1 = childMax;
    		} else if(childMax > max2){
    			max2 = childMax;
    		}
    	}
    	
    	int local_max = root.val;
    	int tmp = root.val + max1;
    	if (tmp > local_max)
    		local_max = root.val + max1;
    	if (local_max > globalMax[0])
    		globalMax[0] = local_max;
    	tmp = local_max + max2;
    	if (tmp > globalMax[0])
    		globalMax[0] = tmp;
    	return local_max;
    }
    
    public static void main(String[] args){
    	TreeNode r = new TreeNode(1);
    	TreeNode a = new TreeNode(-22);
    	r.children.add( a);
    	r.children.add( new TreeNode(-3));
    	a.children.add(new TreeNode(-4));
    	
    	MaxTreePathSum o = new MaxTreePathSum();
    	int[] maxSum =  new int[1];
    	maxSum[0] = Integer.MIN_VALUE;
    	
    	System.out.println(o.maxTreePathSum(r));
    }

}