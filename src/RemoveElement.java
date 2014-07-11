/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int n = A.length;
		if (n == 0)
			return 0;
		int storeIndex = 0;
		for (int i = 0; i < n ;i++){
			if (A[i] != elem){
				A[storeIndex] = A[i];
				storeIndex++;
			}
		}
		
		return storeIndex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement o = new RemoveElement();
		int[] A = {2,1,5,21};
		int elem = 1;
		System.out.println(o.removeElement(A, elem));
	}

}
