/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

idea from:http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
Note: This problem needs some mathematical analysis.
 	  1. scan from right to left, find the first pair which violate the increasing order(i.e. num[i-1] > num[i]) e.g. 2,3 in 1,2,3
	  2. scan from right to left, find the first node which is bigger thant node i-1, swap node i-1 with it e.g. 1 3 2
	  3. for all node after the first node, sort 
 */
import java.util.Arrays;
public class NextPermutaion {
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n <= 1)
        	return;
        int start = 0;
        for (int i = n - 1; i >= 1; i--){
        	if (num[i-1] <num[i]){//scan from right to left, find the first pair which violate the ascending order(num[i-1] & num[i])
        		for(int j = n - 1; j >= i; j--){//scan from right to left, find the first number which is bigger than num[i-1], then swap it with num[i-1]
        			if(num[j] > num[i-1]){
        				swap(num, i-1, j);
        				break;
        			}
        		}
        		start = i;//after node i, we need to sort all the remaining numbers
        		break;
        	}
        }
        //sort all elements after start
       Arrays.sort(num, start, n);
    }
    public void swap(int[] num, int m, int n){
    	int temp = num[m];
    	num[m] = num[n];
    	num[n] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutaion o = new NextPermutaion();
		int[] num = {1,3,2};
		o.nextPermutation(num);
		int i = 1;
	}

}
