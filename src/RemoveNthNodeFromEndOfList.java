/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Solution: use a dummyHead and step n nodes from dummyHead first
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || n == 0)
    		return head;
    	ListNode dummyHead = new ListNode(-1);
    	dummyHead.next = head;
    	ListNode run1 = dummyHead;
    	while (n > 0){
    		if (run1.next == null)//exception
    			return dummyHead;
    		run1 = run1.next;
    		n--;
    	}
    	ListNode run2 = run1;
    	run1 = dummyHead;
    	while(run2.next !=null){
    		run2 = run2.next;
    		run1 = run1.next;
    	}
    	run1.next = run1.next.next;
    	
    	return dummyHead.next;
    }
    public static void main(String[] args){
    	RemoveNthNodeFromEndOfList o = new RemoveNthNodeFromEndOfList();
    	ListNode h = new ListNode(1);
    	h.next = new ListNode(1);
    	h.next.next = new ListNode(2);
    	int n = 5;
    	ListNode r = o.removeNthFromEnd(h, n);
    	while(r!=null){
    		System.out.print(r.val+" ");
    		r = r.next;}
    }

}
