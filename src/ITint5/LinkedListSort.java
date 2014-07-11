package ITint5;
/*
对一个单链表原地（in-place）排序。即直接对链表结点排序。返回排序后链表的头结点。

链表结点的定义为（请不要在代码中再次定义该结构）：

C/C++
struct ListNode {
    int val;
    ListNode *next;
}
Java
public class ListNode {
    public int val;
    public ListNode next;
}
提示：可以尝试使用归并排序算法。
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int v){
    	val = v;
    	next = null;
    }
}
public class LinkedListSort {
	   public ListNode sort(ListNode head) {
		  return mergeSort(head);
		   
		   
	   }
	   public int getLen(ListNode head){
		   int len = 0;
		   ListNode run = head;
		   while(run != null){
			   len++;
			   run = run.next;
		   }
		   return len;
	   }
	   
	   public ListNode mergeSort(ListNode head){
		   int len = getLen(head);
		   if (len <= 1)
			   return head;
		   ListNode run = head;
		   int mid = len / 2;
		   for (int i = 1; i <= mid-1; i++){
			   run =  run.next;
		   }
		   ListNode next = run.next;
		   run.next = null;
		   mergeSort(head);
		   mergeSort(next);
		   return merge(head, next);
	   }
	   public ListNode merge(ListNode h1, ListNode h2){
		   ListNode dummyHead = new ListNode(-1);
		   ListNode run = dummyHead;
		   while (h1 != null && h2 != null){
			   if (h1.val <= h2.val){
				   run.next = h1;
				   h1 = h1.next;
			   } else{
				   run.next = h2;
				   h2 = h2.next;
			   }
		   }
		   return dummyHead.next;
	   }
}
