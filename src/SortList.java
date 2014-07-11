/*
 * Sort a linked list in O(n log n) time using constant space complexity.
Idea comes from: http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/

Steps:
1. break the list into two sublists in middle
2. recursively sort the two sublists
3. merge the two sublists


 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSortList(head);
	}

	public ListNode mergeSortList(ListNode head) {
		// note: set up termination condition
		if (head == null || head.next == null) {
			return head;
		}

		ListNode run = head;
		ListNode leftHead = head;
		ListNode rightHead = head;

		// calculate the length
		int count = 0;
		while (run != null) {
			run = run.next;
			count++;
		}

		int mid = count / 2;
		int countHalf = 0;
		run = head;

		while (run != null) {
			countHalf++;
			ListNode l = run;
			run = run.next;
			if (countHalf == mid) {// Note: need to update rightHead and break
									// the list
				rightHead = run;
				l.next = null;
			}

		}
		ListNode left = mergeSortList(leftHead);
		ListNode right = mergeSortList(rightHead);

		ListNode merged = merge(left, right);
		return merged;
		// return new ListNode(18);

	}

	public ListNode merge(ListNode p, ListNode q) {
		if (p == null) {
			return q;
		}
		if (q == null) {
			return p;
		}

		ListNode head = null;
		if (p.val < q.val) {
			head = p;
			p = p.next;
		} else {
			head = q;
			q = q.next;
		}

		ListNode run = head;
		while (p != null && q != null) {
			if (p.val < q.val) {
				run.next = p;
				run = run.next;
				p = p.next;
			} else {
				run.next = q;
				run = run.next;
				q = q.next;
			}

		}
		// process remaining sublist
		while (p != null) {
			run.next = p;
			run = run.next;
			p = p.next;
		}
		while (q != null) {
			run.next = q;
			run = run.next;
			q = q.next;
		}
		// System.out.println("head "+head.val);
		return head;

	}

	public static void main(String[] args) {
		SortList o = new SortList();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		System.out.println(head.next.val);
		ListNode sort = o.sortList(head);
		while (sort != null) {
			System.out.println(sort.val);
			sort = sort.next;
		}
	}

}
