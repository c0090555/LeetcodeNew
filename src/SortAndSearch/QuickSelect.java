package SortAndSearch;
//two solutions here
//solution 1: use two extra ArrayLists to store element smaller and bigger than pivot separately
//idea comes from:http://pine.cs.yale.edu/pinewiki/QuickSelect
//solution 2: use two pointers instead of two ArrayLists - use iterative solution to save spaces
//idea comes from: http://en.wikipedia.org/wiki/Selection_algorithm
//Time complexity of both solutions are O(n)


import java.util.ArrayList;

public class QuickSelect {
	
	//solution 1 - with two extra ArrayLists(recursive approach)
	public int selectKth1(ArrayList<Integer> a, int k){
		int len = a.size();
		if(k <= 0 || k > len) return -1;
		ArrayList<Integer> bigger = new ArrayList<Integer>();
		ArrayList<Integer> smaller = new ArrayList<Integer>();
		int pivot = a.get(0);
		for(int i = 1; i < a.size(); i++){
			int element = a.get(i);
			if(element < pivot)
				smaller.add(element);
			else if(element > pivot)
				bigger.add(element);
			
		}
		if(k > smaller.size() && k <= a.size() - bigger.size()){
			return pivot;
		}
		else if(k <= smaller.size())
			return selectKth1(smaller, k);
		else return selectKth1(bigger, k - (len - bigger.size()));
		
		
	}
	
	//solution 2 - with two extra pointers(iterative approach)
	public int selectKth2(int[] a, int k){
		if(k < 0 || k > a.length)
			return -1;
		return selectKth2(a, 0, a.length-1, k);
	}
	
	public int selectKth2(int[] a, int start, int end, int k){
		int pivotNewIndex = 0;
		int pivotIndex = start;
		int pivotDist;
		if(start < 0 || end > a.length || start > end){
			return -1;
		}
		while(start <= end){
			pivotNewIndex = partition(a, start, end, pivotIndex);
			System.out.println("pivotIndex "+pivotNewIndex);
			 for (int i = 0; i < a.length; i++) {
                 System.out.print(a[i] + " ");
			 }
			 System.out.println();
			pivotDist = pivotNewIndex - start + 1;
			if(pivotDist == k)
				return a[pivotNewIndex];
			else if(pivotDist > k)
				end = pivotNewIndex - 1;
			else {
				start = pivotNewIndex + 1;
				k -= pivotDist;//need to update k here
				pivotIndex = start;
			}
		}
		
		return -1;
	}
	public int partition(int[] a, int start, int end, int pivotIndex){
		 int pivotVal = a[pivotIndex];
		 int storeIndex = start;
		 swap(a, pivotIndex, end);
		 for(int i = start; i < end; i++){
			 if(a[i] < pivotVal){
				 swap(a, storeIndex, i);
				 storeIndex++;
			 }
		 }
		swap(a, end, storeIndex);
		return storeIndex;
		
	}
	public void swap(int[] a, int m, int n){
		//System.out.println("m "+m+" n "+n);
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
		return;
	}
	
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSelect o = new QuickSelect();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(2);
		a.add(1);
		a.add(1);
		a.add(5);
		System.out.println("solution1 "+o.selectKth1(a, 5));
		
		int[] b = {3,2,1,1,5};
		System.out.println("solution2 "+o.selectKth2(b, 1));
	}

}
