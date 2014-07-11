/*
Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num.length == 0)
    		return null;
    	return sortedArrayToBST(num, 0, num.length - 1);
    	
    }
    public TreeNode sortedArrayToBST(int[] num, int start, int end){
    	if (start > end){
    		return null;
    	}
    	int mid = start + (end - start)/2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = sortedArrayToBST(num, start, mid - 1);
    	root.right = sortedArrayToBST(num, mid + 1, end);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
