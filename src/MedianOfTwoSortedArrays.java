/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Note: this is a variant of binary search or find kth element with quick select approach

method 1 idea: http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
method 1: 
a0, a1, ... a(m/2),     a(m/2+1)...a(m-1)
section 1               section 2
b0, b1, ... b(n/2),     b(n/2+1)...b(n-1)
section 3				section 4

First, if (m+n) is odd, we just need to return the ((m+n)/2 + 1)th number, else we need to calculate the average for number (m+n)/2 and (m+n)/2+1
Observation: 
if(m+n)/2 + 1 > k : 1. if a(m/2) >= b(n/2), then section 2 could be discarded
					2. if a(m/2) <= b(n/2), then section 4 could be discarded
if(m+n)/2 + 1 < k : 1. if a(m/2) >= b(n/2), then section 3 could be discarded
 					2. if a(m/2) <= b(n/2), then section 1 could be discarded
Discard the bigger median's right half or the smaller median's left half. 


idea: http://blog.csdn.net/zxzxy1988/article/details/8587244

??k odd even have the same situation???




 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if (m == 0 && n == 0)//!!necessary edge case
			return 0;
		
		if ((m+n) % 2 == 1){
			return getKth(A, 0, m -1, B, 0, n-1,(m+n)/2+1);
		} else{
			return (getKth(A, 0,m-1, B, 0, n-1, (m+n)/2)+getKth(A, 0, m-1, B, 0, n-1, (m+n)/2 + 1))/2.0;
		}
		
		
		
	}
	public int getKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k){//!!! k starts from 1
		int m = aEnd - aStart+1;
		int n = bEnd - bStart+1;
		//assume m is always smaller or equal to n for simplicity
		if (m > n)
			return getKth(B, bStart, bEnd, A, aStart, aEnd, k);
		
		if (aStart > aEnd){//A is empty
			return B[bStart + k-1];
		}
		if (bStart > bEnd){//B is empty
			return A[aStart +k-1];
		}
		if (k == 1){//!!necessary edge case
			return Math.min(A[aStart], B[bStart]);
		}
	
		//divide m into two parts
		int pa = Math.min(m, k/2);
		int pb = k - pa;
		if (A[aStart + pa - 1] < B[bStart + pb - 1]){
			return getKth(A, aStart + pa, aEnd, B, bStart, bEnd, k - pa);
		} else if (A[aStart + pa - 1] > B[bStart + pb - 1])
			return getKth(A, aStart, aEnd, B, bStart + pb, bEnd, k - pb);
		else {
			return A[aStart + pa - 1];
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSortedArrays o = new MedianOfTwoSortedArrays();
		int[] a = {2,3};
		int[] b = {1,4}; 
		System.out.println(o.findMedianSortedArrays(a, b));
	}

}
