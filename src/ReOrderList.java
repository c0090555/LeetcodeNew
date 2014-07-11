/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,

reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…



You must do this in-place without altering the nodes' values.



For example,

Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
import java.util.*;
public class ReOrderList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}

		// slow-fast runner
		ListNode slow = head;
		ListNode fast = head;
		ListNode mid = null;
		ListNode run = head;

		Stack<ListNode> s = new Stack<ListNode>();

		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				fast = null;
			}
			//System.out.println("slow "+slow.val);
		}
		mid = slow;
		ListNode midNext = mid.next;
		if(mid.next== null){//only two elements
				return;
		}
		else{
			mid.next = null;
		}
		
		while (midNext != null) {
			s.push(midNext);
			midNext = midNext.next;
		}
			//System.out.println(s.size());
		while (!s.isEmpty()) {
			ListNode top = s.pop();
			ListNode next = run.next;
			run.next = top;
			top.next = next;
			run = next;
			//System.out.println(top.val);
			//System.out.println("next "+next.val);
		}

	}
	public static void main(String[] args){
		ReOrderList o = new ReOrderList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		o.reorderList(head);
		while(head!=null){
			System.out.print(" "+head.val);
			head = head.next;
		}
	}
	
}
