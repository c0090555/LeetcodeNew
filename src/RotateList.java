/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null)
        	return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode run = head;
        int m = 0;//calculate length
        while(run!=null){
        	run = run.next;
        	m++;
        }
        n = n % m;
        if(n == 0)
        	return head;
        
        ListNode end = dummyHead;
        while(n > 0 && end.next != null){
        	end = end.next;
        	n--;
        }

        
        ListNode prev = dummyHead;
        ListNode start = head;
        while(end.next != null){
        	prev = start;
        	start = start.next;
        	end = end.next;
        }
        
        prev.next = null;
        end.next = dummyHead.next;
        dummyHead.next = start;
       
        return dummyHead.next;
    }
    
//method 2: from: http://fisherlei.blogspot.com/2013/01/leetcode-rotate-list.html
//we can connect the tail node with head node first, then break the list after travel (len - k%len) steps
    public ListNode rotateRight2(ListNode head, int n) {
    	if (n == 0 || head == null){
    		return head;
    	}
    	int len = 0;
    	ListNode run = head;
    	while (run.next != null){
    		run = run.next;
    		len++;
    	}
    	len++;//add length of last node
    	run.next = head;
    	run = head;
    	int step = len - n % len;
    	int k = 1;
    	while (k < step){
    		run = run.next;
    		k++;
    	}
    	ListNode newHead = run.next;
    	run.next = null;
    	return newHead;
    }	
   
    public static void main(String[] args){
    	RotateList o = new RotateList();
    	ListNode h = new ListNode(1);
    	h.next = new ListNode(2);
    	//h.next.next = new ListNode(3);
    	//h.next.next.next = new ListNode(4);
    	//h.next.next.next.next = new ListNode(5);
    	ListNode r = o.rotateRight2(h, 1);
    	while(r!= null){
    	System.out.println(r.val);
    	r = r.next;
    	}
    }
}
