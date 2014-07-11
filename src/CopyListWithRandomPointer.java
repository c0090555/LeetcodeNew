/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list
 */

import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		HashSet<RandomListNode> set = new HashSet<RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		set.add(newHead);

		RandomListNode newNode = newHead;
		RandomListNode oldNode = head;
		while (oldNode != null) {
			RandomListNode next = oldNode.next==null?null:new RandomListNode(-1);
			RandomListNode random = oldNode.random==null?null:new RandomListNode(-1);

			if (oldNode.next != null) {
				if (!set.contains(next)) {// check next
					next = new RandomListNode(oldNode.next.label);
					newNode.next = next;
					set.add(next);
				}
			}
			else
				newNode.next = null;
			if (oldNode.random != null) {// check random
				if (!set.contains(random)) {
					random = new RandomListNode(oldNode.random.label);
					newNode.random = random;
					set.add(random);
				}
			} else
				newNode.random = null;
			newNode = newNode.next;
			oldNode = oldNode.next;

		}

		return newHead;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListWithRandomPointer o = new CopyListWithRandomPointer();
		RandomListNode head = new RandomListNode(1);
		head.next = null;
		head.random = null;
		RandomListNode newHead =o.copyRandomList(head);
System.out.println(newHead.label);
	}

}
