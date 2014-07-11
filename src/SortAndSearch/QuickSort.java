package SortAndSearch;
/*Note: in-place version: partition + recursive calls
 * 
 * 
 * 
 * 
 * Version 1:
 * // left is the index of the leftmost element of the subarray
  // right is the index of the rightmost element of the subarray (inclusive)
  // number of elements in subarray = right-left+1
  function partition(array, left, right, pivotIndex)
     pivotValue := array[pivotIndex]
     swap array[pivotIndex] and array[right]  // Move pivot to end
     storeIndex := left
     for i from left to right - 1  // left ² i < right
         if array[i] <= pivotValue
             swap array[i] and array[storeIndex]
             storeIndex := storeIndex + 1  // only increment storeIndex if swapped
     swap array[storeIndex] and array[right]  // Move pivot to its final place
     return storeIndex
 */



public class QuickSort {
	public int partition(int[] array, int start, int end, int pivotIndex){
		int pivotVal = array[pivotIndex];
		swap(array, pivotIndex, end);
		int storeIndex = start;
		for(int i = start; i < end ; i++){
			if(array[i] <= pivotVal){
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, storeIndex, end);
		return storeIndex;
	}
	
	public void quickSort(int[] array, int start, int end){
		if(start < end){ //determine the end condition
			int pivotNewIndex = partition(array, start, end, start);
			quickSort(array, start, pivotNewIndex - 1);
			quickSort(array, pivotNewIndex + 1 , end);
		}
		return;
	}
	
	public void swap(int[] arr, int i, int j){
		int temp = arr[i];
		System.out.println("i "+i+" j "+j);
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
	
/*
Another version of in-place quicksort
  
 */
	public void quickSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		quickSort2(arr, 0, arr.length - 1);
		System.out.println(arr[0]);
	}

	public void quickSort2(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			System.out.println(pivot + " p");
			if (start < pivot - 1)
				quickSort(arr, start, pivot - 1);
			if (pivot < end)
				quickSort(arr, pivot, end);

		}
	}

	public int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		int left = start;
		int right = end;
		while (left <=right) {
			while (left <= end && arr[left] < pivot) {
				left++;
			}
			while (right > 0 && arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		System.out.println(left + "left");
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort o = new QuickSort();
		int[] a = {1,1,1};
		o.quickSort(a,0,a.length-1);
		for(int k: a){
			System.out.print(k + " ");
		}
	}

}
