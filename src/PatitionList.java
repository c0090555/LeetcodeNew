/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PatitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode dumLess = new ListNode(-1);
		ListNode dumMore = new ListNode(-1);
		ListNode less = dumLess.next;//initialized to 0
		ListNode more = dumMore.next;//initialized to 0
		ListNode run = head;
		
		while (run != null){
			ListNode next = run.next;
			if (run.val < x){
				if (less == null){
					less = run;
					dumLess.next = less;//!!!less initialized to 0, so we need to reconnect them
				}
				else {
					less.next = run;
					less = less.next;
				}
			} else{
				if (more == null){
					more = run;
					dumMore.next = more;//!!!more initialized to 0, so we need to reconnect them
				}
				else {
					more.next = run;
					more = more.next;
				}
			}
			run.next = null;
			run = next;
		}
		
		if (less == null)
		    return dumMore.next;
		else{
		    less.next = dumMore.next;
		    return dumLess.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 1->4->3->2->5->2
		PatitionList o = new PatitionList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		int x = 3;
		o.partition(head, x);
	}

}
