package ITint5;
import java.util.Arrays;

public class NextPermutation {
	public boolean nextPermutation(int[] arr) {
		int n = arr.length;
		if (n <= 1)
			return false;
		int needToSwap = -1;
		for (int i = n - 1; i >= 1; i--){
			if (arr[i] > arr[i-1]){
				needToSwap = i - 1;
				break;
			}
		}
		if (needToSwap != -1){
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			for (int i = n-1; i > needToSwap; i--){
				if (arr[i] < min && arr[i] > arr[needToSwap]){
					min = arr[i];
					min_index = i;
				}
			}
			swap (arr, needToSwap, min_index);
			Arrays.sort(arr, needToSwap+1, n);
			return true;
		}
		return false;
	}
	
	public void swap(int[] arr, int m, int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation o = new NextPermutation();
		int[] arr = {-1, 0, 10000, 1};
		o.nextPermutation(arr);
		for (int e:arr){
			System.out.format("%s ", e);
		}
	}

}
