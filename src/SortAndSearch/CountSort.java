package SortAndSearch;
/*
 * Time Complexity: O(n+r)
 * Space Complexity: O(n+r), r is the range of the numbers to be sorted
 * suitable for numbers in small range
 */

public class CountSort {
	public void countSort(int[] a){
		//locate the range of the numbers to be sorted
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++){
			if(a[i] < min){
				min = a[i];
			}
			if(a[i] > max){
				max = a[i];
			}
		}
		
		//count
		int[] count = new int[max - min + 1];
		for(int j = 0; j < a.length; j++){
			count[a[j] - min]++;						
		}
		
		//relocate
		int index = 0;
		for(int k = 0; k < count.length; k++){
			while(count[k] > 0){
				a[index] = k + min;
				count[k]--;
				index++;
			}
			
		}
		return;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountSort o = new CountSort();
		int[] a = {3,2,1,5,2};
		o.countSort(a);
		for(int k : a){
			System.out.print(" " + k);
		}
	}

}
