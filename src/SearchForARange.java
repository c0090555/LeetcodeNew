/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]

 */
import java.util.Arrays;
public class SearchForARange {
	// idea: search left range and right range separately, using binary search
	public int[] searchRange(int[] A, int target) {
		int[] range = new int[2];
		int n = A.length;
		Arrays.fill(range, -1);
		if (n == 0) {
			return range;
		}

		int left = 0;
		int right = n - 1;
		boolean found = false;
		// search left range
		while (left <= right) {
			int mid = (left + right)/2;
			if(A[mid] >= target){
				if (A[mid] ==  target){
					 found = true;
				}
				right = mid - 1;
			} else{
				left = mid + 1;
			}
		}
		
		if (!found)//!!! if we couldn't find target, then left's final value will be 0 instead of -1, add this logic to avoid this
			return range;//!!target not found, no need to process any further
		range[0] = left;
		//search right range
		left = 0;
		right = n - 1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (A[mid] <= target){
				left = mid + 1;
			} else{
				right = mid - 1;
			}		
		}
		range[1] = right;
		return range;

	}
//solution 2 - a better way to search left & right range with binary search(key point: record possible values)
	public int[] searchRange2(int[] A, int target) {
		int[] range = new int[2];
		Arrays.fill(range, -1);
		int n = A.length;
		if (n == 0)
			return range;
		//search the first element which is equal to target 
		int left = 0;
		int right = n - 1;
		while (left <= right){
			int mid = left + ((right - left)>>1);
			if (A[mid] == target){
				range[0] = mid;//!!!record possible value here
				right = mid - 1;
			} else if (A[mid] > target){
				right = mid - 1;
			} else{
				left = mid + 1;
			}		
		}
		//search the last element which is equal to target
		left = 0;
		right = n - 1;
		while (left <= right){
			int mid = left + ((right - left)>>1);
			if (A[mid] == target){
				range[1] = mid;//!!!record possible value here
				left = mid + 1;
			} else if (A[mid] > target){
				right = mid - 1;
			} else{
				left = mid + 1;
			}
		}
		return range;
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange o = new SearchForARange();
		int[] A = { 1,2,3,4};
		int target = 2;
		int[] res = o.searchRange(A, target);
		System.out.println(o.searchRange2(A, target)[0]);
		System.out.println(o.searchRange2(A, target)[1]);

	}

}
