package SortAndSearch;
/*
 * Note: scan the whole "unsorted" sublist to find its minimum value, swap it to the leftmost element of this
 * sublist
 */

public class SelectionSort {
	public void selectionSort(int[] a){
		int minIndex;
		int minVal;
			for(int i = 0; i < a.length; i++){
				minVal = a[i];
				minIndex = i;
				for(int j = i; j < a.length; j++){
					if(a[j] < minVal){
						minVal = a[j];
						minIndex = j;
					}
				}
				if(minIndex != i){
					System.out.println(a[minIndex]+" ");
					swap(a, minIndex, i);
				}
				
			}
			
			
			
		}
	public void swap(int[] a, int m, int n){
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}
		
	public static void main(String[] args){
		SelectionSort o = new SelectionSort();
		int[]a = { 3,3,2,15,6,4};
		o.selectionSort(a);
		for(int k : a){
			System.out.print(" "+k);
		}
	}
	
}
