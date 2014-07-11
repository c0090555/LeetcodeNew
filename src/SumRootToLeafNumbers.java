
public class SumRootToLeafNumbers {
	int cum = 0;
	
	public int sumNumbers(TreeNode root) {
		cum =0;
		sumTraversal(root,0);
        return cum;
    }
	public void sumTraversal(TreeNode n,  int preVal){
		if(n==null){
			return;
		}
		int curVal =preVal*10+n.val;

		if(n.left==null && n.right==null){//leaf node
			cum+= curVal;
		}
		if(n.left != null){
			sumTraversal(n.left, curVal); 
		}
		if(n.right !=null){
			sumTraversal(n.right, curVal);
		}
		
	}
	
	public static void main(String[] args){
		SumRootToLeafNumbers o = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(o.sumNumbers(root));
	}
	
	
}
