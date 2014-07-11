import java.util.HashMap;

public class LRUCacheWithSentinel {
	   static class ListNode{
	    	ListNode prev = null;
	    	ListNode next = null;
	    	int key;
	    	int val;
	    	ListNode(int k, int v){
	    		key = k;
	    		val = v;
	    	}
	    }

	    private int capacity = 0;
	    private HashMap<Integer, ListNode> hash = new HashMap<Integer, ListNode>();
	    private int counter = 0;
	    private ListNode sentinel=null;
	    
	    public LRUCacheWithSentinel(int capacity) {
	        this.capacity = capacity;
	        counter = 0;
	        sentinel = new ListNode(-1, -1);
	        sentinel.prev = sentinel;
	        sentinel.next = sentinel;
	        hash = new HashMap<Integer, ListNode>();
	    }
	    
	    public int get(int key) {
	        if (!hash.containsKey(key)){
	        	return -1;
	        } else{
	        	ListNode visit = hash.get(key);
	        	//move visit to head
	        	visit.prev.next = visit.next;
	        	visit.next.prev = visit.prev;
	        	visit.next = sentinel.next;
	        	sentinel.next.prev = visit;
	        	visit.prev = sentinel;
	        	sentinel.next = visit;
	        	return visit.val;
	        }
	    }
	    
	    public void set(int key, int value) {
	        if (!hash.containsKey(key)){//splice a new node to head
	        	counter++;
	        	if (counter > capacity){//invalidate the least recently used item
	        		hash.remove(sentinel.prev.key);
	        		sentinel.prev.prev.next = sentinel;
	        		sentinel.prev =  sentinel.prev.prev;
	        		counter--;
	        	}
	        	ListNode add = new ListNode(key, value);
	        	add.next = sentinel.next;
	        	add.prev = sentinel;
	        	sentinel.next.prev = add;
	        	sentinel.next = add;
	        	hash.put(key, add);
	        	
	        } else{
	        	ListNode modify = hash.get(key);
	        	//move modify to head
	        	modify.prev.next = modify.next;
	        	modify.next.prev = modify.prev;
	        	modify.val = value;
	        	modify.next = sentinel.next;
	        	modify.prev = sentinel;
	        	sentinel.next.prev = modify;
	        	sentinel.next = modify;
	        }

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)
		LRUCacheWithSentinel o = new LRUCacheWithSentinel(2);
		o.set(2, 1);
		o.set(1, 1);
		o.set(2, 3);
		o.set(4, 1);
		System.out.println(o.get(1));
		System.out.println(o.get(2));
	}

}
