/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
Key idea: start from biggest numbers first
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int iA = m - 1;
		int iB = n - 1;
		int i = m + n - 1;
		while (iA>= 0 && iB >= 0){
			if(A[iA] > B[iB]){
				A[i] = A[iA];
				iA--;
			}
			else{
				A[i] = B[iB];
				iB--;
			}
			i--;
		}
		
		while(iB >= 0){//!!!need to process unfinished array B part
			A[i] = B[iB];
			i--;
			iB--;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
