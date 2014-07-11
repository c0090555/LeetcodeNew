/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		int len = 0;
		ListNode run = head;
		while (run != null){
			run = run.next;
			len++;
		}
		if (k > len || k == 1)
			return head;
		int m = len / k;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode curr = head;
		ListNode next = head.next;
		ListNode prev = dummyHead;
		
		for (int i = 1; i <= m; i++){
			int j = k-1;
			while(j>0){//step k-1 steps
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;//update next;
				j--;
			}
			prev = curr;
			curr = curr.next;
			if(curr!= null)//!!!curr may be null
			next = curr.next;
		}
		return dummyHead.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		int k = 3;
		ReverseNodesInKGroup o = new ReverseNodesInKGroup();
		ListNode newH = o.reverseKGroup(head, k);
		int b = 2;
	}

}
