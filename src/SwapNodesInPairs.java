/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
	//iterative
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode curr = head;
		while (curr.next != null){
			ListNode next = curr.next;//save next node
			curr.next = next.next;
			next.next = curr;
			prev.next = next;
			//update prev & curr
			prev = curr;
			curr = curr.next;
			if (curr == null || curr.next == null)
				break;
		}
		return dummyHead.next;
		
	}
	
	//recursive ??? could we do it recursive?
	
	public ListNode swapPairsRecur(ListNode head) {
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesInPairs o = new SwapNodesInPairs();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		ListNode newH = o.swapPairs(head);
		while(newH!=null){
			System.out.println(newH.val);
			newH=newH.next;
		}
	}
}
