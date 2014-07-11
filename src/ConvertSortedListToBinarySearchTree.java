/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Another idea: http://gongxuns.blogspot.com/2012/12/leetcodeconvert-sorted-list-to-binary.html????

 */
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
//		if (head.next.next == null){
//			TreeNode root = new TreeNode(head.next.val);
//			root.left = new TreeNode(head.val);
//			return root;
//		}
			
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = head;

		while (fast.next != null) {		
			//System.out.println("fast "+fast.val);

			prev = slow;
			fast = fast.next;
			slow = slow.next;
			
			if (fast.next == null)
				break;
			fast = fast.next;
		}

		ListNode mid = slow;
		prev.next = null; // break list
		TreeNode root = new TreeNode(mid.val);
		//System.out.println(root.val);
		ListNode secondHead = mid.next;

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(secondHead);
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListToBinarySearchTree o = new ConvertSortedListToBinarySearchTree();
		ListNode h = new ListNode(-1);
		h.next = new ListNode(0);
		h.next.next = new ListNode(1);
		h.next.next.next = new ListNode(2);
		TreeNode root = o.sortedListToBST(h);
		System.out.println(root.val);
		System.out.println(root.left.left.val);
		
	}

}
