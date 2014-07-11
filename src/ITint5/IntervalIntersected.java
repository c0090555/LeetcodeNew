package ITint5;
/*
有n个左右端点都为整数的区间，判断每个区间是否有与其它某个区间相交（区间端点重合也算相交）。
Solution : line sweep
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Stack;

class Interval {
	  int start;  //区间左端点
	  int end;  //区间右端点
	  Interval(int s, int e){
		  start = s;
		  end = e;
	  }
	  Interval(){
		  
	  }
	}

public class IntervalIntersected {
    // intervals包含n个区间
    // 结果存放到isIntersected中(已分配空间)
    // isIntersected[i]表示第i个区间是否与其它区间相交
	//solution 1: create wrapper class - O(nlogn)
	class IntervalPair{
		public Interval m_interval;
		public int m_index;
		IntervalPair(Interval interval, int index){
			m_interval = interval;
			m_index = index;
		}
	}
	class IntervalPairComparator implements Comparator<IntervalPair>{
		public int compare(IntervalPair a, IntervalPair b){
			if (a.m_interval.start == b.m_interval.start){
				return a.m_interval.end - b.m_interval.end;
			} else{
				return a.m_interval.start - b.m_interval.start;
			}
		}
	}
	
	
    public void intersected(Interval[] intervals, boolean[] isIntersected) {
    	int n = intervals.length;
    	if (n <= 1)
    		return;
    	IntervalPair[] intervalPairs =  new IntervalPair[n];
    	for (int i = 0; i < n; i++)
    		intervalPairs[i] = new IntervalPair(intervals[i], i);
    		
    	Arrays.sort(intervalPairs, new IntervalPairComparator());
    	
    	IntervalPair current = intervalPairs[0];
    	for (int i = 1; i < n; i++){
    		if (intervalPairs[i].m_interval.start > current.m_interval.end){
    			current = intervalPairs[i];
    		} else{//overlapping
    			current.m_interval.end =  Math.max(current.m_interval.end, intervalPairs[i].m_interval.end);
    			isIntersected[current.m_index] = true;
    			isIntersected[intervalPairs[i].m_index] = true;
    		}
    	}
    }
    
	
	
	//solution 2: use hash + stack (too slow?)  - O(nlogn)
    public void intersected2(Interval[] intervals, boolean[] isIntersected) {
    	int n = intervals.length;
    	if (n <= 1)
    		return;
    	HashMap<Interval, Integer> hash = new HashMap<Interval, Integer>();
    	for (int i = 0; i < n ; i++)
    		hash.put(intervals[i], i);
    	Arrays.sort(intervals, new Comparator<Interval>(){
    		public int compare(Interval a, Interval b){
    			return a.end < b.end ? -1 : (a.end > b.end ? 1 : a.start - b.start);
    		}
    	});
    	
    	Stack<Interval> s = new Stack<Interval>();
    	ArrayList<Integer> merge = new ArrayList<Integer>();
    	s.push(intervals[0]);
    	merge.add(0);
    	for (int i = 1; i < n; i++){
    		Interval top  = s.pop();
    		if (intervals[i].start <= top.end){
    			Interval m = mergeInterval(top, intervals[i]);
    			s.push(m);
    		} else{
    			if (merge.size() > 1){
    				for (int j : merge){
    					isIntersected[hash.get(intervals[j])] = true;
    				}
    			}
    			merge = new ArrayList<Integer>();
    			s.push(intervals[i]);
    		}
			merge.add(i);
    	}
    	//ending part
		if (merge.size() > 1){
			for (int j : merge){
				isIntersected[hash.get(intervals[j])] = true;
			}
		}
    }

    public Interval mergeInterval(Interval a, Interval b){
        Interval res = new Interval();
        res.start = Math.min(a.start, b.start);
        res.end = Math.max(a.end, b.end);
        return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(32,40));
    	intervals.add(new Interval(8,12));
    	intervals.add(new Interval(0,10));
    	intervals.add(new Interval(14,16));
    	intervals.add(new Interval(1,3));
    	intervals.add(new Interval(25,28));
    	intervals.add(new Interval(20,30));

    	Interval[] i = intervals.toArray(new Interval[0]); 
    	IntervalIntersected o = new IntervalIntersected();
    	boolean[] isIntersected = new boolean[i.length];
    	o.intersected(i, isIntersected);
    	for (boolean e : isIntersected){
    		System.out.format("%s ", e);
    	}
	}
//[(32,40),(8,12),(0,10),(14,16),(1,3),(25,28),(20,30)]

}
