/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

Note: slow-fast runner
 */
public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
		 if(head==null){
			 return null;
		 }
	     ListNode fast = head;
	     ListNode slow = head;
	     ListNode run = head;
	     while(slow!=null){//find the meet point
	    	
	    	 if(fast == null||fast.next == null){
	    		 return null;
	    	 }
	    	 if(slow == fast.next || slow == fast.next.next){
	    		 //System.out.println("slow "+slow.val);
	    		 break;
	    	 }
	    	 slow = slow.next;
	    	 fast = fast.next.next;
	    	 
	     }
	     //calculate the loop length
	     int  l = 1;
	     run = slow.next;
	     while(run != slow){
	    	 l++;
	    	 run = run.next;
	     }
		 //System.out.println("end "+l);

	     //reset
	     slow = head;
	     fast = head;
	     while(l>0){
	    	 fast = fast.next;
	    	 l--;
	     }
	    
	     while(fast != slow){
	    	 slow = slow.next;
	    	 fast = fast.next;
	     }
	     return slow;
	     
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycleII o = new LinkedListCycleII();
		ListNode h= new ListNode(3);
		h.next=new ListNode(2);
		h.next.next = new ListNode(0);
		h.next.next.next = new ListNode(-4);
		h.next.next.next.next = h.next;
		System.out.println(o.detectCycle(h).val);
	}

}
