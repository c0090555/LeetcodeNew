package SortAndSearch;
/*
 * Non-recursive version of quicksort(slight variant of in-place recursive quicksort
 * implement our own stack to store parameters
 */
import java.util.Stack;

public class QuickSortNonRecur {
	public void quickSort(int[] a){
		quickSort(a,0,a.length-1);
	}
	public void quickSort(int[] a, int start, int end){
		Stack<Integer> p = new Stack<Integer>();//parameter stack
		int newStart;
		int newEnd;
		int pivotNewIndex;
		if(start>=end){
			return;
		}
		p.push(end);
		p.push(start);
		while(!p.isEmpty()){
			newStart = p.pop();
			newEnd = p.pop();
			pivotNewIndex = partition(a, newStart, newEnd, newEnd);
			if(pivotNewIndex - 1 > newStart){
				p.push(pivotNewIndex - 1);
				p.push(newStart);
			}
			if(pivotNewIndex + 1 < newEnd){
				p.push(newEnd);
				p.push(pivotNewIndex +1 );
			}
		}
		return;
	}
	public int partition(int[] a, int start, int end, int pivotIndex){
		int pivotVal = a[pivotIndex];
		int storeIndex = start;
		swap(a, pivotIndex, end);
		for(int i = start; i < end; i++){
			if(a[i] <pivotVal){
				swap(a, storeIndex, i);
				storeIndex++;
			}	
		}
		swap(a, storeIndex, end);
		return storeIndex;
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortNonRecur o = new QuickSortNonRecur();
		int[] a = {2,3,5,1,2,4};
		o.quickSort(a);
		for(int k: a){
			System.out.print(k + " ");
		}
	}
}
