/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
Note: idea of DP, try to find the number which could jump to the longest distance
 */
public class JumpGameII {
	public int jump(int[] A) {
		int n = A.length;
		if (n <= 1)//!!note: if n == 1, then we need zero steps
			return 0;

		int step = 0;
		int prev = 0;
		int next = A[0];
		while (step <= n - 1 && prev < next && next < n - 1) {
			int max = 0;
			for (int i = prev + 1; i <= next; i++) {//!!only need start from prev since we have already used prev to calculate new next
				max = Math.max(max, i + A[i]);
			}
			step++;
			prev = next;
			next = max;
		}

		return step + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
