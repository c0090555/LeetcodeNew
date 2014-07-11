package ITint5;
/*
对于包含n个结点的二叉树（树中结点编号从1到n），已知前序和后序遍历序列，我们知道不一定能唯一的恢复这棵树。请计算出满足条件的二叉树的总数。
 */
public class CountValidTrees {
    public int countValidTrees(int[] preorder, int[] postorder) {
    	if (preorder.length != postorder.length || preorder.length == 0)
    		return 0;
    	int n = preorder.length;
    	return countHelper(preorder, 0, n-1, postorder, 0, n-1);
    }
    public int countHelper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
    	if (preStart >= preEnd || postStart >= postEnd)
    		return 1;
    	int n = preEnd -  preStart;
    	if (preorder[preStart] != postorder[postEnd])
    		return 0;
    	int post_left = -1;
    	for (int j = postStart; j <= postEnd; j++){
    		if (postorder[j] == preorder[preStart + 1]){
    			post_left = j;
    			break;
    		}
    	}
    	if (post_left == -1)
    		return 0;
    	int left_num = post_left - postStart + 1;
    	int right_num = n - 1 - left_num;
    	return countHelper(preorder, preStart + 1, preStart + left_num, postorder,  postStart, postStart + left_num - 1) *
    			countHelper(preorder, preEnd -  right_num + 1, preEnd, postorder, postEnd - right_num, postEnd - 1);
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
