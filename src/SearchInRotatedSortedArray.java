/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.s
Note: any time there will be one half sorted
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int n = A.length;
		if (n == 0)
			return -1;
		return searchHelper(A, 0, n-1, target);
	}

	public int searchHelper(int[] A, int start, int end, int target) {
		if (start > end)// not found
			return -1;
		int left = start;
		int right = end;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > target) {
				if (A[left] <= A[mid]){//!!!key part: use left sorted first base on the target's range
					if(target >= A[left]){
						right = mid - 1;
					} else{
						left  = mid + 1;
					}
				} else{//right sorted
					right = mid - 1;
					
				}
				

			} else{//A[mid] < target
				if (A[mid] <= A[right]){//!!!key part: use right sorted first base on the target's range
					if (target <= A[right]){
						left = mid + 1;
					} else{
						right = mid - 1;
					}
					
				} else{//left sorted
					left = mid +1;
				}
				
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
		int[] A = {4,5,6,7,0,1,2};
		int target = 1;
		System.out.println(o.search(A, target));
	}

}
