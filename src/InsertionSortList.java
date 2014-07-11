/*
 * Idea: http://www.cnblogs.com/feiling/p/3427232.html
 * Trick: create a dummy head with a very small value
 * 
 * Note: construct a new List + record next pointer in the original list
 * 
 */

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode p = dummyHead;
		ListNode q = head;
		ListNode next = null;
		while(q != null){
			ListNode prev = findRightPlace(p, q);
			//Save orignal next node
			next = q.next;
			
			//Key Part
			q.next = prev.next;
			prev.next = q;
			
			q = next;
			
			System.out.println();
			ListNode r = dummyHead;
			while(r!=null){
				System.out.print(r.val+" ");
				r = r.next;
			}
		}
		
		return dummyHead.next;

	}

	//need to find the right position to insert q
	public ListNode findRightPlace(ListNode p, ListNode q) {
		ListNode prev = null;
		ListNode curr = p;
		while(curr != null && curr.val <= q.val){
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h = new ListNode(3);
		h.next = new ListNode(4);
		h.next.next = new ListNode(1);
		h.next.next.next = new ListNode(2);
		InsertionSortList o = new InsertionSortList();
		ListNode newH = o.insertionSortList(h);
		while (newH != null) {
			System.out.print(" " + newH.val);
			newH = newH.next;
		}
	}

}
