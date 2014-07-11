package SortAndSearch;
//introduced in Jon Bentley's Programming Pearls 
//specially good for extremely large number of  elements
//key idea:  It works by thinking of a chunk of memory as a set of numbered bits. 
//Each number to be sorted should be thought of as a bit in that chunk of memory.
//So, after all the bits are set, then it is a simple matter to obtain the sorted numbers by starting from the beginning (or the end if reverse order is required) and checking if a bit is set.  If so, then it is moved to the output buffer. 

//pay attention to the potential overflow the range & not suitable for array with duplicate elements
//Time complexity: O(n)



public class BitMapSort {
	public void bitmapSort(int[] a){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++){
			if(max < a[i]){
				max = a[i];
			}
			if(min > a[i]){
				min = a[i];
			}
		}
		
		long N = max - min;//attention to possible overflow here
		byte[] bitmap = new byte[(int)N / 8 + 1];//array index must be integer
		
		for(int i = 0; i < a.length; i++){
			bitmap[(int)((long)(a[i] - min) / 8)] |= 1 << (long)(a[i] - min) % 8;//find bucket first, then locate the element in bucket									
		}

		int k = 0;
		for(int i = 0; i < bitmap.length; i++){
			for(int j = 0; j < 8; j++){
				if((bitmap[i] & (1 << j) )> 0){//key part: find position
					a[k] = i * 8 + j + min;//need to add min back
					k++;
				}
				
			}
			
		}
		return;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitMapSort o = new BitMapSort();
		int[] a = {3,4,2,6,1};
		o.bitmapSort(a);
		for(int k:a)
			System.out.print(" "+k);
	}

}
