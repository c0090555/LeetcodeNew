/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?


method 1: count sort - need two passes
method 2: need two index pointers - enhanced quicksort - idea from: http://jane4532.blogspot.com/2013/06/sort-color-leetcode.html
method 3: use three index pointers - low, mid, high to reference three colors
 */
public class SortColors {
	//method 1
	public void sortColors1(int[] A) {
		int n = A.length;
		if (n == 0)
			return;
		int red = 0;
		int white = 0;
		int blue = 0;
		for (int i = 0; i < n; i++){
			int color = A[i];
			switch(color){
				case 0: 
					red++;
					break;
				case 1:
					white++;
					break;
				case 2:
					blue++;
					break;
				default:
					break;
			}			
		}
		int j = 0;
		while (j < n){
			if (red > 0){
				A[j] = 0;
				red--;
			}
			else if (white > 0){
				A[j] = 1;
				white--;
			}
			else{
				A[j] = 2;
				blue--;
			}
			j++;
		}
		
		
		
		
	}
	//method 2
	public void sortColors(int[] A) {
		int n = A.length;
		if (n == 1)
			return;
		int i = 0;
		while (i < n && A[i] == 0)//remove all heading zeros
			i++;		
		int j = n - 1;
		while (j >= 0 && A[j] == 2)//remove all tailing twos
			j--;
		
		
		System.out.println(i+" "+j);
		int p = i;//start from i
		while (p <= j){
			System.out.println(" p "+p+" i "+i +" j "+j );

			if (A[p] == 0){
				swap(A, p, i);
				i++;
			}
			else if (A[p] == 2) {
				swap(A, p, j);
				j--;
			} 

			if(A[p] == 1 || p == i)//!!!key part: p == i, we need to move p when p == i
				p++;
			}					
	}
	public void swap(int[] A, int m, int n){
		int temp = A[m];
		A[m] = A[n];
		A[n] = temp;
	}

	//method 3
	public void sortColors3(int[] A){
		int n = A.length;
		if (n == 0)
			return;
		int low = 0;
		int mid = 0; 
		int high = n - 1;
		while (mid <= high){//!!!here we need '=' to process the case like "1 0"
			int color = A[mid];
			if (color == 0){
				swap(A, low, mid);
				low++;
				mid++;
			} else if (color == 1){
				mid++;
			} else{//color == 2
				swap(A, mid, high);
				high--;
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		SortColors o = new SortColors();
		int[] A = { 1,0};
		o.sortColors3(A);
		for (int a : A)
			System.out.print(a + " ");
	}
}
