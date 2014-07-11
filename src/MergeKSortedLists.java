/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Idea: use a min-heap(PriorityQueue)
Time Complexity: O(nlogk), k is the number of lists, n is the total number of nodes
 
Note: specially take care of the null ListNode case 
 */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode dummyHead = new ListNode(-1);
		int n = lists.size();
		int k = 0;
		for (ListNode node : lists) {//check how many non-null ListNodes we have
			if (node != null)
				k++;
		}
		if (n == 0 || k == 0)
			return dummyHead.next;

		ListNode run = dummyHead;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k,
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						return a.val < b.val ? -1 : a.val > b.val ? 1 : 0;
					}
				});
		for (ListNode node : lists) {
			if (node != null)// PriorityQueue doesn't allow null while ArrayList allows null
				pq.add(node);
		}
		while (!pq.isEmpty()) {
			ListNode min = pq.remove();
			run.next = min;
			run = run.next;
			if (min.next != null)// if that list hasn't been finished
				pq.add(min.next);
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
