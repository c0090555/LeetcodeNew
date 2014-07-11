/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return head;
    	ListNode dummyHead = new ListNode(-1);
    	dummyHead.next = head;
    	
    	ListNode prev = head;
    	ListNode curr = prev.next;
    	
    	while(curr!= null){
    		ListNode next = curr.next;
    		if(prev.val == curr.val){
    			prev.next = next;
    			curr = next;
    		}
    		else{
    			prev = curr;    
    			curr = curr.next; 			
    		}
    	}
    	return dummyHead.next;
    }
    public static void main(String[] args){
    	RemoveDuplicatesFromSortedList o = new RemoveDuplicatesFromSortedList();
    	ListNode h = new ListNode(1);
    	h.next = new ListNode(1);
    	h.next.next = new ListNode(2);
    	ListNode r = o.deleteDuplicates(h);
    	while(r!=null){
    		System.out.print(r.val+" ");
    		r = r.next;}
    }
}
