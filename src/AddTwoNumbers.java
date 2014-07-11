/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	if (l2 == null)
    		return l1;
    	
    	ListNode dummyHead = new ListNode(-1);
    	ListNode curr = dummyHead;
    	int carry = 0;
    	while (l1 != null && l2 != null){
    		int val = (l1.val + l2.val + carry) % 10;
    		carry = (l1.val + l2.val + carry) / 10;
    		curr.next =  new ListNode(val);
    		l1 = l1.next;
    		l2 = l2.next;
    		curr = curr.next;
    	}
    	ListNode remain = null;
    	if (l1 != null) 
    		remain = l1;
    	else if (l2 != null) 
    		remain = l2;
    	while (remain != null){
    		int val = (remain.val + carry) %10;
    		carry = (remain.val + carry) / 10;
    		curr.next = new ListNode(val);
    		remain = remain.next;
    		curr = curr.next;
    	}
    	if (carry != 0){
    		curr.next = new ListNode(carry);
    	}
    	
    	return dummyHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers o = new AddTwoNumbers();
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		ListNode b = new ListNode(3);
		b.next = new ListNode(4);
		ListNode r = o.addTwoNumbers(h, b);
		while(r!= null){
			System.out.println(r.val);
			r=r.next;
		}
	}

}
