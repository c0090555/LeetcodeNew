/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
idea comes from: http://fisherlei.blogspot.com/2013/02/leetcode-longest-consecutive-sequence.html

my first try: count sort(O(n)) and scan the sorted result(O(n)), although it has O(n), but the count sort 
may have overflow issue, so this approach is not good enough

Then we could try to use HashSet<Integer> to indicate whether we have this number in the array, and for each
number, we try to "expand" it as much as possible, here we need to remove the traversed numbers, finally we get
the maximum length

 *
 */
import java.util.*;
public class LongestConsectiveSequence {
	public int longestConsecutive(int[] num) {
		if(num.length==0||num.length==1){
			return num.length;
		}
		int maxLen = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<num.length;i++){
			if(!set.contains(num[i])){
				set.add(num[i]);
			}
			
		}
		
		for(int i=0;i<num.length;i++){
			if(set.contains(num[i])){//Key part: expand the sequence as long as possible and remove all traversed numbers
				int curLen = 1;
				int curNum = num[i];
				set.remove(num[i]);
			
				while(set.contains(curNum-1)){//need to update curNum to expand the sequence
					curLen++;
					set.remove(curNum-1);
					curNum--;
				}
				
				curNum = num[i];//need to reset curNum to expand the sequnence in increasing order
				while(set.contains(curNum+1)){//need to update curNum to expand the sequence
					curLen++;
					set.remove(curNum+1);
					curNum++;
				}
				maxLen = Math.max(maxLen, curLen);
				
			}
		}
		return maxLen;

		
		
		
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,0,1};
		LongestConsectiveSequence o = new LongestConsectiveSequence();
		System.out.println(o.longestConsecutive(num));

	}

}
