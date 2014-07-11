/*Merge Intervals 
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
idea comes from: http://gongxuns.blogspot.com/2012/12/leetcode-merge-intervals.html

Sort First!!!
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}



public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0)
			return res;
		
		Comparator<Interval> c = new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start > b.start ? 1 : (a.start == b.start ? 0 : -1);
			}
		};
		
		Collections.sort(intervals, c);
		
		int i = 0;
		while (i < intervals.size()){
			int j = i + 1;
			int end = intervals.get(i).end;
			while (j < intervals.size() && end >= intervals.get(j).start){
				end = Math.max(end, intervals.get(j).end);
				j++;
			}
			res.add(new Interval(intervals.get(i).start, end));
			i = j;//note: we need to start from j			
		}
		
		return res;
		
		
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
