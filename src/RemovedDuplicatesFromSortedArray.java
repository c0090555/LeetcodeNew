/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemovedDuplicatesFromSortedArray {
	 public int removeDuplicates(int[] A) {
		 int n = A.length;
		 if (n == 0 || n == 1)
			 return n;
		
		 int count = 1;
		 int num = 0;
		 int j = 0;
		 
		 for(int i=1; i<n;i++){
			 if(A[i-1] == A[i]){
				 count++;
			 } else{
				 if(count > 2)
					 count = 2;
				 num+=count;
				 while(count > 0){
					 A[j] = A[i-1];
					 j++;
					 count--;
				 }
				 count=1;//reset count
			 }
			 
		 }
		 //!!process tailing part
		 if(count > 2)
			 count = 2;
		 num+=count;
		 while(count > 0){
			 A[j] = A[n-1];
			 j++;
			 count--;
		 }
		 return num;
	 }
	 
	 //another neat solution here: http://jane4532.blogspot.com/2013/06/remove-duplicates-from-sorted.html
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemovedDuplicatesFromSortedArray o = new RemovedDuplicatesFromSortedArray();
		int[] a={1,2,2,2,2,3};
		System.out.println(o.removeDuplicates(a));
		for(int i: a)
		System.out.println(i);
	}

}
