/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
	//Solution 1: bucket sort - need to use A[A[i]-1] to store A[i]
	
	//idea from: http://fisherlei.blogspot.com/2012/12/leetcode-first-missing-positive.html
	public int firstMissingPositive(int[] A) {
		int n = A.length;
		if (n == 0)
			return 1;
		for (int i = 0; i < n; i++){			
			while (A[i] > 0 && A[i] < n && i != A[i] - 1){//swap A[i] to i position until we get an "invalid" A[i]
				if(A[A[i] - 1] == A[i])//!!!if A[A[i] - 1] == A[i], then that means we have already got a "fit" A[i] there, no need to do further exchange
					break;
				swap(A, i, A[i] - 1);
				//System.out.println(" i "+i+ "A[i] "+A[i]);
				
			}
		}
		
		for(int i = 0; i < n; i++){
			if (i != A[i] - 1){
				return i+1;
			}
		}
		 
			return n+1;//if we cannot find target in A, then that means A has 1 to n, so we need to return n + 1
		
	}
	public void swap(int[] a, int m, int n){
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}
	
	//Solution 2 :idea of bitmap sort - Space Complexity is O(n)(not meet the requirement)
	public int firstMissingPositive2(int[] A) {
		int n = A.length;
		if (n == 0){
			return 1;
		}
		int max = 0;
		for(int i = 0; i < n; i++)
			max = Math.max(max, A[i]);
		if(max == 0)
			return 1;
		byte[] bitmap = new byte[max/8 + 1];
		//System.out.println(max);
		for(int i = 0; i < n; i++){
			if(A[i] > 0){
				int byte_num = A[i]/8;
				bitmap[byte_num] = (byte) (bitmap[byte_num] | (1<<(A[i]%8)));//!! use '|' here
			}
		}
		for(int j = 0; j < bitmap.length; j++){
			for(int k= 0; k<=7; k++){
				if((bitmap[j] & (1<<k)) == 0){//!! use '&' here
					///System.out.println("j "+j+" k "+k);
					//restore the number
					if(j!=0 || k!=0)
					return j*8 + k;
				}
			}
		}
		return max+1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,2,3,4};
		FirstMissingPositive o = new FirstMissingPositive();
		System.out.println(o.firstMissingPositive(A));
	}

}
