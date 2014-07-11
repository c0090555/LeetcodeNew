package ITint5;

import java.util.List;
import java.util.LinkedList;
class TreeNode{
	TreeNode left, right;
	int v;
	TreeNode(int v){
		left = null;
		right = null;
		this.v = v;
		this.val = v;
		children = new LinkedList<TreeNode>();
	}
	public int val;
    public LinkedList<TreeNode> children; //该结点所有的儿子结点
}
class TreeNodeUtil{
	public static boolean isNullNode(TreeNode r){
		return r == null;
	}
	public static TreeNode getLeftChildNode(TreeNode r){
		return r == null ? null : r.left;
	}
	public static TreeNode getRightChildNode(TreeNode r){
		return r == null ? null : r.right;
	}
}


//Time Complexity: O(lgn) by master therom
public class CountCompleteBinayTreeNodes {
	   public int countNodes(TreeNode root) {
	        if (TreeNodeUtil.isNullNode(root))
	            return 0;
	        int leftSubH = getLeftHeight(TreeNodeUtil.getLeftChildNode(root));
	        int rightSubH = getLeftHeight(TreeNodeUtil.getRightChildNode(root));
	        if (leftSubH == rightSubH){
	            return (1 << leftSubH)  - 1 + 1 + countNodes(TreeNodeUtil.getRightChildNode(root));
	        }else{
	            return countNodes(TreeNodeUtil.getLeftChildNode(root)) + 1 + (1<<rightSubH) - 1;
	        }
	    }
	    
	    public int getLeftHeight(TreeNode root){
	       int len = 0;
	        while (!TreeNodeUtil.isNullNode(root)){
	            len++;
	            root = TreeNodeUtil.getLeftChildNode(root);
	        }
	        return len;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Math.pow(2, 2.0);
	}

}
