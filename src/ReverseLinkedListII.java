/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ² m ² n ² length of list.

Key point: need to be familiar with how to reverse the whole linked list(tip: just need to see two nodes at one time + store the next node)

 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int step = n - m;
		if (n - m <= 0)
			return head;
	   ListNode dummyHead = new ListNode(-1);
	   dummyHead.next = head;
	   ListNode prev = dummyHead;
	   head = dummyHead;

	   ListNode rHead = null;//head of reverse list
	   ListNode rTail = null;//tail of reverse list
	   
	   while(m>0){
		   prev = head;
		   head = head.next;
		   m--;
		   
	   }
	   rTail = head;//store tail of reverse part
	   rHead = prev;//store the last element before reverse part
	   
	   prev = head;
	   head = head.next;
	  
	   //System.out.println(head.val);
	   ListNode next=null;
	   //System.out.println("step "+step);
	   while(step > 0){
		   //System.out.println(head.val);
		   next = head.next;
		   head.next = prev;
		   prev = head;
		   head = next;
		   step--;
	   }
	   
	   rHead.next = prev;
	   rTail.next = next;
	   
	   return dummyHead.next;
	   
	   
	   
	   }
	   public static void main(String[]argss){
		   ReverseLinkedListII o = new ReverseLinkedListII();
			ListNode head = new ListNode(1);
			head.next = new ListNode(2);
			head.next.next = new ListNode(3);
			head.next.next.next = new ListNode(4);
			ListNode newH = o.reverseBetween(head,1,4);
			while(newH!=null){
				System.out.println(newH.val);
				newH=newH.next;
			}
	   }
}
