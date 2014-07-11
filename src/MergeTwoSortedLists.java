/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Note: this problem needs to use nodes from the original two lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	if (l2 == null)
    		return l1;
    	ListNode dummyHead = new ListNode(-1);
    	ListNode run = dummyHead;
    	while (l1 != null && l2 != null) {
    		if (l1.val <= l2.val){
    			run.next = l1;
    			ListNode next = l1.next;
    			l1.next = null;
    			l1 = next;
    		} else{
    			run.next = l2;
    			ListNode next = l2.next;
    			l2.next = null;
    			l2 = next;
    		}
    		run = run.next;
    	}
    	if (l1 == null)
    		run.next = l2;
    	if (l2 == null)
    		run.next = l1;
    	return dummyHead.next;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedLists o = new MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		ListNode r = o.mergeTwoLists(l1, l2);
		while(r!=null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}
