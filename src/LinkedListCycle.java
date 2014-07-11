/*
 * 
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

Idea:
slow-fast runner approach
Simultaneously go through the list by ones (slow iterator) and by twos (fast iterator). If there is a loop the fast iterator will go around that loop twice as fast as the slow iterator. The fast iterator will lap the slow iterator within a single pass through the cycle. Detecting a loop is then just detecting that the slow iterator has been lapped by the fast iterator.

Idea from: http://ostermiller.org/find_loop_singly_linked_list.html

 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast1 = head;
		ListNode fast2 = fast1.next;
		ListNode slow = head;
		while (slow != null && fast1 != null && fast2 != null) {
			
			fast1 = fast1.next;
			if (slow == fast1) {
				return true;
			}
			if (fast1 == null)
				return false;
			fast2 = fast1.next;
			if (slow == fast2) {
				return true;
			}
			System.out.println("slow "+slow.val+"fast1 "+fast1.val+"fast2 "+fast2.val);
			slow = slow.next;
			fast1 = fast2;//need to update fast1
		}
		return false;
	}

	public static void main(String[] args){
		ListNode h = new ListNode(3);
		h.next = new ListNode(2);
		h.next.next = new ListNode(0);
		h.next.next.next = new ListNode(-4);
		h.next.next.next.next = h.next;
		LinkedListCycle o = new LinkedListCycle();
		System.out.println(o.hasCycle(h));
	}
}
