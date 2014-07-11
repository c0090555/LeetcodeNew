/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
import java.util.ArrayList;

public class InsertInterval {
	protected class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	// solution 1 - binary search - Time Complexity: O(logn) Space Complexity:
	// O(n)
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		int n = intervals.size();
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (n == 0) {
			res.add(newInterval);
			return res;
		}
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			Interval e = intervals.get(i);
			start[i] = e.start;
			end[i] = e.end;
		}

		// search first affected interval - left
		int first = -1;
		boolean mergeLeft = false;
		int target = newInterval.start;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (start[mid] <= target) {
				first = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (first >= 0 && end[first] >= newInterval.start) {
			mergeLeft = true;
		}

		// search last affected interval - right
		int last = -1;
		boolean mergeRight = false;
		target = newInterval.end;
		left = 0;
		right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (end[mid] >= target) {
				last = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (last != -1 && start[last] <= newInterval.end) {
			mergeRight = true;
		}

		for (int i = 0; i < first; i++) {
			res.add(intervals.get(i));
		}
		// mid part
		int newStart = newInterval.start;
		if (mergeLeft) {
			newStart = Math.min(start[first], newStart);
		} else {
			if (first != -1)
				res.add(intervals.get(first));
		}
		int newEnd = newInterval.end;
		if (mergeRight) {
			newEnd = Math.max(end[last], newEnd);
			res.add(new Interval(newStart, newEnd));

		} else {
			res.add(new Interval(newStart, newEnd));
			if (last != -1)
				res.add(intervals.get(last));
		}
		// right part
		if (last != -1)
			for (int i = last + 1; i < n; i++)
				res.add(intervals.get(i));
		return res;
	}

	// solution 2: traverse the whole intervals - update newInterval- Time Complexity: O(n); Space Complexity: O(n)
	public ArrayList<Interval> insert2(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		int n = intervals.size();
		if (n == 0) {
			res.add(newInterval);
			return res;
		}
		boolean needInsert = true;
		for (int i = 0; i < n; i++) {
			Interval curr = intervals.get(i);
			if (curr.end < newInterval.start || !needInsert) {
				res.add(curr);
				continue;
			} else {
				// check if there is overlap
				if (overlap(curr, newInterval)) {
					newInterval.start = Math.min(curr.start, newInterval.start);
					newInterval.end = Math.max(curr.end, newInterval.end);
				} else {
					res.add(newInterval);
					res.add(curr);
					needInsert = false;
				}
			}
		}
		if (needInsert){//process ending part
			res.add(newInterval);
		}

		return res;
	}

	public boolean overlap(Interval a, Interval b) {
		if (a.end < b.start || a.start > b.end)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1,2],[3,5],[6,7],[8,10],[12,16],
		// [1,2],[3,10],[12,16].
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		InsertInterval o = new InsertInterval();
		intervals.add(o.new Interval(1, 5));
		/*
		 * intervals.add(o.new Interval(3,5)); intervals.add(o.new
		 * Interval(6,7)); intervals.add(o.new Interval(8,10));
		 * intervals.add(o.new Interval(12,16));
		 */
		Interval newInterval = o.new Interval(2, 7);
		o.insert2(intervals, newInterval);
	}

}
