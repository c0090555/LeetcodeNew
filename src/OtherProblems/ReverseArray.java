package OtherProblems;
public class ReverseArray {
	public void reverse(int[] a){
		int n = a.length;
		for (int i = 0, j = n - 1; i < j; i++,j--){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

	}
	public static void main(String[] args){
		int[] a = {1,2,3};
		ReverseArray o = new ReverseArray();
		o.reverse(a);
		for (int i : a)
			System.out.println(i);
	}

}
