package SortAndSearch;
/*LSD Radix Sort: Worst Case: O(kn) for n keys with fewer than k digits
 * 
 */

public class RadixSort {
	public void LSDRadixSort(int[] a){//assume base = 10
		int[] bucket = new int[10];
		int[] b = new int[a.length]; //helper array
		
		//find the maximum value to determine k
		int max = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
			}
		}
		
		int exp = 1; //exponent
		while(max / exp > 0){
			bucket = new int[10];
			
			//counting sort
			for(int i = 0; i < a.length; i++){
				bucket[(a[i] / exp) % 10] ++;				
			}
			//find the final locations - accumulate
			for(int j = 1; j < bucket.length; j++){
				bucket[j] += bucket[j - 1];
			}
			for(int k = 0; k < a.length; k++){
				bucket[a[k] / exp % 10]--;//zero-based
				b[bucket[(a[k] / exp) % 10]] = a[k];				
			}
			for(int m = 0; m < a.length; m++){
				a[m] = b[m];
			}
			exp *= 10;
		}
		
		
		return;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSort o = new RadixSort();
		int[] a = {3,2,1,5,2};
		o.LSDRadixSort(a);
		for(int k:a){
			System.out.print("  "+k);
		}
	}

}
