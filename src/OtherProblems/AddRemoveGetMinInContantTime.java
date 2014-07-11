package OtherProblems;
/*
http://leetcode.com/2010/11/stack-that-supports-push-pop-and-getmin.html
 */
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
public class AddRemoveGetMinInContantTime {
	//solution 1 - Stack
	Stack<Integer> s = new Stack<Integer>();//stack to store all elements
	Stack<Integer> s_min = new Stack<Integer>();//stack to store current minimal value
	public void add1(int e){
		if (s.isEmpty()){
			s.push(e);
			s_min.push(e);
		} else{
			if (e <= s_min.peek()){
				s_min.push(e);
			}
			s.push(e);
		}
	}
	public int remove1(){
		if (s.isEmpty()){
			return Integer.MIN_VALUE;//exception
		} else{
			int t = s.pop();
			if (t == s_min.peek())
				s_min.pop();
			return t;
		}
	}
	public int getMin(){
		if (s_min.isEmpty())
			return Integer.MIN_VALUE;
		else
			return s_min.peek();
	}
	
	//solution 2 - Queue Amortized Time Complexity: O(1); LinekdList implements Deque<E>
	LinkedList<Integer> q = new LinkedList<Integer>();
	LinkedList<Integer> q_min = new LinkedList<Integer>();
	public void add2(int e){
		if (q.isEmpty()){
			q.add(e);
			q_min.add(e);
		} else{
			q.add(e);
			while (!q_min.isEmpty() && e < q_min.getLast()){
				q_min.removeLast();
			}
			q_min.add(e);
		}
	}
	public int remove2(){
		if (q.isEmpty()){
			return Integer.MIN_VALUE;//exception case
		} else{
			int t = q.remove();
			if (t <= q_min.getFirst()){
				q_min.remove();
			}
			return t;
		}
	}
	public int getMin2(){
		if (q_min.isEmpty())
			return Integer.MIN_VALUE;
		else
			return q_min.getFirst();
	}
	
	
	
	public static void main(String[] args){
		AddRemoveGetMinInContantTime o = new AddRemoveGetMinInContantTime();
		o.add2(3);
		o.remove2();
		o.add2(3);
		o.add2(2);
		o.remove2();

		System.out.println(o.getMin2());
		int[] a = {1,2,3};
		System.out.println(Arrays.toString(a));
	}
}
