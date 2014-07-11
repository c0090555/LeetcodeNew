
/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Note: HashMap + double-linked List
for node: it saves the key & value

A trick for this kind of issue is to make some dummy nodes(e.g. dummy head and tail node)

*/
import java.util.HashMap;

//double-linked list
class Node{
	int value;
	int key;
	Node prev, next;
	Node(int k, int v){
		key = k;
		value = v;
		prev = null;
		next = null;
	}
}


public class LRUCache {

	
	private Node head, tail;//use head to save the most recently used cache, tail to save the least recently one
    private int capacity;
    private HashMap<Integer, Node> cache;
	
    public LRUCache(int capacity) {
    	tail = null;
    	head = null;
    	this.capacity = capacity;
    	cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
    	if(cache.containsKey(key)){
    		Node n = cache.get(key);
    		detach(n);
    		setHead(n);
    		//System.out.println("key "+key+"tail "+tail.value);
    		return n.value;     		
      	}
    	else{
    		return -1;
    	}
    }
    public void setHead(Node n){
    	if(head == null){
    		head = n;
    		tail = n;
    		head.prev = null;
    		tail.next = null;
    	}
    	else{
    		head.prev = n;
    		n.next = head;
    		head = n;
    		head.prev = null;
       	}
    	return;
    	
    }
    
    //detach Node n from the list
    public void detach(Node n){
    	if(n==null){
    		head = tail = null;
    		return;
    	}
    	//System.out.println("detach "+n.key);
    	//System.out.println(n.next.key);
    	if(n.next !=null) n.next.prev = n.prev;
    	else{//tail node
    		tail = n.prev;
    	}
    	if(n.prev != null) n.prev.next = n.next;
    	else{//head node
    		head = n.next;
    	}
    	n.prev = null;
    	n.next = null;
    }
    
    public void set(int key, int value) {
    	if(!cache.containsKey(key)){//new key
    		Node n = new Node(key, value);
    		//System.out.println("key "+key);
    		if(cache.size() < capacity){//still have room
    			setHead(n);
    			//System.out.println("x "+key +" "+tail.key);

    			cache.put(key, n);
    		}
    		else{//if full
    			//System.out.println(key);
    			//System.out.println(" "+key +" "+tail.key);

    			removeOldest();
    			setHead(n);
    			cache.put(key, n);
    		}
    	}
    	else{
    		Node n = cache.get(key);
    		n.value = value;//update value
    		//detach n
    		detach(n);
    		setHead(n);
    	}
    	
    }
    
    public void removeOldest(){
    	if(tail != null){
    		//System.out.println("oldest "+tail.key);
    		//System.out.println("dadf"+tail.key);
    		cache.remove(tail.key);
    		//note: when there is only one element, we need to update head as well
    		tail = tail.prev;
    		
    		if(tail == null){
    			head = null;
    		}
    		else{
    			tail.next = null;//update tail node
    		}
    	}
    	
    	return;
    }
    
    
    public static void main(String[] args){
    	LRUCache o = new LRUCache(3);
    	o.set(1,1);
    	o.set(2,2);
    	o.set(3, 3);
    	o.set(4, 4);
    	
    	
    	System.out.println(o.get(4));
    	System.out.println(o.get(3));
   	System.out.println(o.get(2));
    	System.out.println(o.get(1));
    	o.set(5, 5);

   	System.out.println(o.get(1));
   	System.out.println(o.get(2));
   	System.out.println(o.get(3));
   	System.out.println(o.get(4));
   	System.out.println(o.get(5));

//   	3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]

    //Output:	[4,3,2,-1,-1,-1,3,4,5]
   	//Expected:	[4,3,2,-1,-1,2,3,-1,5]
    }
}