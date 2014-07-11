package twitterOnlineCodingTest;
/*
A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0..N−1]. Sets S[K] for 0 ≤ K < N are defined as follows: 
S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }. 
Sets S[K] are finite for each K.
Write a function:
int solution(int A[], int N);
that, given an array A consisting of N integers, returns the size of the largest set S[K] for this array. The function should return 0 if the array is empty.
For example, given array A such that:
  A[0] = 5    A[1] = 4    A[2] = 0
  A[3] = 3    A[4] = 1    A[5] = 6
  A[6] = 2
the function should return 4, because set S[2] equals { 0, 5, 6, 2 } and has four elements. No other set S[K] has more than four elements.
Assume that:
N is an integer within the range [0..1,000,000];
the elements of A are all distinct;
array A contains all elements from the integer interval [0..N−1].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2014 bs
 */
import java.util.HashSet;
import java.util.Iterator;
public class Problem2 {
	int solution(int A[]) {
	    // write your code in C90
		int N = A.length;
		if (N <= 1)
			return N;
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int e : A)
			hash.add(e);
		int maxStep = 0;
		while (!hash.isEmpty()){
			int minValue = -1;
			Iterator<Integer> t = hash.iterator();
			while(t.hasNext()){
				minValue = Math.min(minValue, t.next());
			}
			int step = 0;
			while(minValue < N && minValue >=0){
				step++;
				hash.remove(minValue);
				minValue = A[minValue];
			}
			maxStep = Math.max(maxStep, step);
		}
		return maxStep;
	}
	public int findMinIndex(int[] A, boolean[] visit){
		int min_value = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < A.length; i++){
			if (!visit[i]){
				if (A[i] < min_value){
					min_value = A[i];
					min_index = i;
				}
			}
		}
		return min_index;
	}
	public static void main(String[] args){
		Problem2 o = new Problem2();
		int[] A = {5,4,0,3,1,6,2};
		System.out.println(o.solution(A));
	}
}
