/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return head;
    	ListNode dummyHead = new ListNode(-1);
    	dummyHead.next = head;
    	ListNode prev = dummyHead;
    	ListNode curr = head;
    	while(curr != null){
    		ListNode temp = curr;
    		int len = 0;
    		while(temp != null && curr.val == temp.val){
    			temp = temp.next;   		
    			len++;
    		}

    		if(len == 1){
    			prev.next = curr;
    			prev = curr;
    		} else{
    			prev.next = temp;
    		}
    		curr = temp;
       	}
    	return dummyHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedListII o = new RemoveDuplicatesFromSortedListII();
    	ListNode h = new ListNode(1);
    	h.next = new ListNode(1);
    	//h.next.next = new ListNode(2);
    	ListNode r = o.deleteDuplicates(h);
    	while(r!=null){
    		System.out.print(r.val+" ");
    		r = r.next;}
	}

}
