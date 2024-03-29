package twitterOnlineCodingTest;
/*
This is a demo task. You can read about this task and its solutions in this blog post.
A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
For example, consider the following array A consisting of N = 7 elements:
A[0] = -7   A[1] =  1   A[2] = 5
A[3] =  2   A[4] = -4   A[5] = 3
A[6] =  0
P = 3 is an equilibrium index of this array, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
P = 6 is also an equilibrium index, because:
A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = 0
and there are no elements with indices greater than 6.
P = 7 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
Write a function
class Solution { public int solution(int[] A); }
that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
Assume that:
N is an integer within the range [0..10,000,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
For example, given array A such that
A[0] = -7   A[1] =  1   A[2] = 5
A[3] =  2   A[4] = -4   A[5] = 3
A[6] =  0
 */
import java.util.Arrays;
public class Demo {
	  public int solution(int[] A) {
	        // write your code in Java SE 7
		  int n = A.length;
		  if (n == 0)
			  return -1;
		  long[] left = new long[n];
		  long[] right = new long[n];
		  for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--){
			  left[i] = left[i -1] + A[i];
			  right[i] = right[j+1] + A[j];
		  }
		  if(right[0] == 0)
			  return 0;
		  if(left[n-1] == 0)
			  return n-1;
		  for (int i = 1; i < n-1; i++){
			  if (left[i-1] == right[i+1])
				  return i;
		  }
		  return -1;
	  }
}
