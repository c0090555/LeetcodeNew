

/*
 * reverse a linkedlist
 * 
 * 
 * idea comes from: http://www.programmerinterview.com/index.php/data-structures/reverse-a-linked-list/
 * 
 * method1: iterative approach
 * method2: recursive approach
 * 
 */
public class ReverseLinkedList {
	//method 1: key idea: treat the first two nodes specially, start from the third node,
	/*for each node: 
	 * 1. we need to store its next node first, 
	 * 2. then set its next node point to its previous node,
	 * 3. move to its next node
	 
	 */
	   static class ListNode{
	    	ListNode prev = null;
	    	ListNode next = null;
	    	int val;
	    	ListNode(int v){
	    		val = v;
	    	}
	    }
	public ListNode reverseList(ListNode head){

		if (head == null || head.next == null)//if no node or there is only one node
			return head;
		ListNode prev = null;//Note: prev node initialized to null
		
		while(head != null){
			ListNode next = head.next;//store the next node
			head.next = prev;//make the current node points to its previous node
			prev = head;//update previous node
			head = next;//update current node
		}
		
		return prev;
		
		
	}
	
	/*
	 method 2: key point: we need to figure out what we should we do in base case and we need to do during recursive calls
	 example: 1->2->3->4
	  
	 *
	 */
	public ListNode reverseListRecur(ListNode head){
		if (head == null || head.next == null)//if no node or there is only one node
			return head;
		if (head.next == null){//tail node: we just need to return it since it will be the new head of reversed list
			return head;
		}
		ListNode newHead = reverseListRecur(head.next);
		head.next.next = head;//for example: for node 3, we need its next node to point to itself
		head.next = null;//then we don't need node 3 to point to node 4 anymore
		
		return newHead;
		
	}
	
	//method 3
	// dum -> 1 -> 2 -> 3
	//key idea: maintain dumHead and curr, record next next element, move the next element after dumHead
	public ListNode reverseList3(ListNode head){
		if (head == null)
			return null;
		ListNode dumHead = new ListNode(-1);
		dumHead.next = head;
		ListNode prev = dumHead;
		ListNode curr = head;
		ListNode next = curr.next;
		while (next != null){
			curr.next = next.next;//1-> 3
			next.next = prev.next;//2-> 1
			prev.next = next;//dum -> 2
			next = curr.next;
		}
		return dumHead.next;
	}



	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList o = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode newH = o.reverseList(head);
		while(newH!=null){
			System.out.println(newH.val);
			newH=newH.next;
		}
	}

}
