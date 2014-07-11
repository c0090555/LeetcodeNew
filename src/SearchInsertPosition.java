/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Note: it always stops at position "start"
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int n = A.length;
		int start = 0;
		int end = n - 1;
		
		while (start <= end){
			int mid = (start + end)/2;
			if (target == A[mid]){
				return mid;
			} else if (target > A[mid]){
				start = mid + 1;
			} else{
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition o = new SearchInsertPosition();
		int[] A = {1,3,5,6};
		int target = 7;
		System.out.println(o.searchInsert(A, target));
	}

}
