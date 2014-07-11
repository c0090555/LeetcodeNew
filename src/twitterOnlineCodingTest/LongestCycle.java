package twitterOnlineCodingTest;
/*
Given a permutation which contains numbers in the range [1, N], return the length of the largest cycle in the permutation. Function Signature: int longestCycle(vector<int> perm)

Sample Testcases:
a) longestCycle([2 3 1]) returns 3, since only cycle is (1 2 3) whose length is 3
b) longestCycle([5 4 3 2 1]) returns 2, since the permutation can be decomposed into (1 5), (2 4), (3)
 */
import java.util.ArrayList;
public class LongestCycle {
	public int longestCycle(ArrayList<Integer> perm){//not suitable for the case when all numbers are equal, e.g. [1 1 1]
		int n = perm.size();
		if (n <= 2)
			return n;
		ArrayList<Integer> copy = new ArrayList<Integer>(perm);
		copy.addAll(perm);
		int len = 1;
		int maxLen = 0;
		for (int i = 1; i < 2*n; i++){
			if (copy.get(i-1) <= copy.get(i)){
				len++;
			} else{
				maxLen = Math.max(maxLen, len);
				len = 1;
			}
		}
		maxLen = Math.max(maxLen, len);
		return maxLen;
	}
	public static void main(String[] args){
		LongestCycle o = new LongestCycle();
		ArrayList<Integer> perm = new ArrayList<Integer>();
		perm.add(5);
		perm.add(4);
		perm.add(3);
		perm.add(2);
		perm.add(1);
		System.out.println(o.longestCycle(perm));
	}
}
