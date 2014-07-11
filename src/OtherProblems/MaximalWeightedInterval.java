package OtherProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int s;
	int e;
	int w;
	Interval(int s, int e, int w){
		this.s = s;
		this.e = e;
		this.w = w;
	}
}

/*
 * recursive relation: 
 * dp[i] indicates the maximal weight ending at interval i-1 (dp[0]==0)
 * use p[i] to represent the last interval which isn't overlapped with interval i
 * 
 * dp[i] =  max(dp(p[i])+v[i], dp[i-1]) since for each interval i we can pick it up or not
 * 			
 * a trick here to calculate p[i] is to use binary search				
 * 
 */

public class MaximalWeightedInterval {
	public int getMaxWeight(Interval[] intervals){
		Arrays.sort(intervals, new Comparator<Interval>(){//sort by ending point
			@Override
			public int compare(Interval a, Interval b){
				return a.e < b.e ? -1 : (a.e == b.e ? 0 : 1);
			}
		});
		int[] p = new int[intervals.length];
		p[0] = -1;
		for (int i = 1; i < p.length; i++){
			p[i] = findPrev(intervals, i);
		}
		
		int[] dp = new int[intervals.length+1];
		for (int i = 1; i < dp.length; i++){
			if (p[i-1] == -1)
				dp[i] = Math.max(intervals[i-1].w, dp[i-1]);
			else
				dp[i] =  Math.max(dp[p[i-1]+1] + intervals[i-1].w, dp[i-1]);//!!!p[i-1] + 1
		}
		return dp[intervals.length];
	}
	public int findPrev(Interval[] intervals, int i){//find the index of the last interval which isn't overlapped with interval i
		int target = intervals[i].s;
		int start = 0;
		int end = i - 1;
		int p = -1;//record all possible values
		while (start <= end){
			int mid = start + (end - start)/2;
			if (intervals[mid].e == target){//!!!what if we have more than one intervals meet this condition
				p = mid;
				break;
			} else if (intervals[mid].e > target){
				end = mid-1;
			} else{
				p = mid;
				start = mid+1;
			}
		}
		return p;
	}
	
	public static void main(String[] args){
		MaximalWeightedInterval o = new MaximalWeightedInterval();
		ArrayList<Interval> inter = new ArrayList<Interval>();
		inter.add(new Interval(1,3,1));
		inter.add(new Interval(3,3,2));
		inter.add(new Interval(4,6,2));
		inter.add(new Interval(2,5,10));
		Interval[] intervals = inter.toArray(new Interval[0]);
		System.out.println(o.getMaxWeight(intervals));
	}
	
}
