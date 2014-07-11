/*
My Submissions
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Solution 1: use a integer array of size 32 to represent each bit of an integer number, accumulate on each bit and put the result mod 3, then we got the result
Solution 2: http://www.cnblogs.com/daijinqiao/p/3352893.html


 */
public class SingNumberII {
	//solution 1
	public int singleNumber(int[] A) {
		int[] bit = new int[32];
		int res = 0;
		int t = 1;
		for(int i = 0; i<A.length;i++){
			for(int j=0;j<32;j++){
				bit[j]+=(A[i]>>j)&1;
				bit[j]%=3;
			}
		}
		//convert binary number to decimal number
		for(int j=0;j<32;j++){
			res += bit[j]*t;
			t*=2;
		}
		return res;
	}

}
