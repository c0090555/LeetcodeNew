package SortAndSearch;
/*
 *Note: build heap(max-heap or min-heap) + repeatedly remove the biggest(or smallest) value and insert it into
 *array, then reconstruct the heap  
 * 
 * Two ways of constructing the heap: siftDown and siftUp
 * 
 * 
 * 
 * 
 */

public class HeapSort {
	
	public void heapSortIncreasing(int[] a){//sort in increasing order needs min-heap
		maxHeapify(a);
		int end  = a.length - 1;
		while( end >= 0  ){
			swap(a, 0, end);
			end--;
			siftDown(a, 0,end);
		}
		return;
	}
	
	public void maxHeapify(int[] a){
		int start = (a.length - 1) / 2;////last parent
		while(start >= 0){
			siftDown(a, start, a.length - 1);
			start--;
		}
		return;
	}
	
	
	public void siftDown(int[] a, int start, int end){//sift down from root to leaves
		int root = start;
		int leftChild = (root * 2) + 1;
		int rightChild = (root * 2) + 2;
		int swap;// used to record max value
		
		//main heap order
		while(leftChild <= end){//if left child exists
			swap = root;
			if(a[leftChild] > a[root]){
				swap = leftChild;
			}
			if(rightChild <= end && a[rightChild] > a[swap]){//if right child exists
				swap = rightChild;
			}
			if(swap != root){
				swap(a, root, swap);
				root = swap;
				leftChild = (root * 2) + 1;
				rightChild = (root * 2) + 2;
			}
			else{
				return;//meet heap order
			}
		}
	}
	
///////////////////////
	public void heapSortDecreasing(int[] a){
		//note: we need one helper array here since we cannot do the similar stuffs like siftDown operations
		int[] b= new int[a.length];
		for(int i = 0; i < a.length; i++){
			b[i] = a[i];
		}
		for(int j = a.length - 1; j >= 0; j--){
			minHeapify(b);
			a[j] = b[0];
			b[0] = Integer.MAX_VALUE;
		}
		
	}
	
	public void minHeapify(int[] a){
		int end = 1;
		while(end < a.length){
			siftUp(a, 0, end);
			end++;
		}
		return;
	}
	
	
	public void siftUp(int[] a, int start, int end){
		int child = end;
		int parent = child / 2;
		while(parent >= start){//maintain heap order
			if(a[child] < a[parent]){
				swap(a, child, parent);
				child = parent;
				parent = child / 2;
			}
			else{
				return;
			}
			
		}
		
	}
	
	
	
	public void swap(int[] a, int i, int j){
		//System.out.println(" "+a[i]+" "+a[j]+" ");
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort o = new HeapSort();
		int[] a = {3,2,1,5,2};
		o.heapSortDecreasing(a);
		for(int k: a){
			System.out.print(" " + k);
		}
	}

}
