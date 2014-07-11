/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Note: need to reach the last index
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int n = A.length; 
		if (n == 0)
			return false;
		int range = A[0];
		for(int i=0; i <= range; i++){
			if (range >= n-1)
				return true;
			range = Math.max(range, i + A[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
