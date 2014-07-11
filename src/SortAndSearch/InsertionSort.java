package SortAndSearch;
/*
 * iterate the list, try to insert each element to the right position before it
 * Insertion Sort is very similar to Selection Sort.
 */

public class InsertionSort {
	public void insertionSort(int[] a){
		for(int i = 1; i < a.length; i++){
			int j = i;
			while(j>=1 && a[j - 1] > a[j]){
				swap(a, j-1, j);
				j--;
			}
		}
		
		return;
		
	}
	public void swap(int[] a, int m, int n){
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort o = new InsertionSort();
		int[] a = {3,2,1,5,2};
		o.insertionSort(a);
		for(int k : a)
			System.out.print(" "+k);
	}

}
