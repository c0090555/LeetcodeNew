package SortAndSearch;
/*
 * Divide & Conquer (Divide to one-element section then merge)
 */

public class MergeSort {
	public void mergeSort(int[] a){
		mergeSort(a, 0, a.length-1);
	}
	public void mergeSort(int[] a, int start, int end){
		if(start<end){
			int mid = start + (end-start)/2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
			
		}
	}
	
	public void merge(int[] a, int start, int mid, int end){
		int[] helper = new int[end-start+1];//helper array
		int leftStart = start;
		int rightStart = mid + 1;
		int index = 0;
		
		//copy array
		for(int i = start; i <= end; i++){
			helper[i - start] = a[i];
		}
		
		while(leftStart <= mid && rightStart <= end){
			if(helper[leftStart - start] <= helper[rightStart - start]){
				a[index] = helper[leftStart - start];
				leftStart++;
			}
			else{
				a[index] = helper[rightStart -start];
				rightStart++;
			}
			index++;
		}
		
		//merge remaining left part if necessary
		while(leftStart <= mid){
			a[index] = helper[leftStart - start];
			leftStart++;
			index++;
		}
		return;
	}
	public static void main(String[] args){
		MergeSort o = new MergeSort();
		int[] a = {2,3,1,1,4};
		o.mergeSort(a);
		for(int k:a){
			System.out.print(" "+k);
		}
	}
}
