package ITint5;
/*
有一个包含n个元素的首尾相连的环形数组arr，计算最大的子段和（允许空段）。

样例：数组[1, 3, -2, 6, -1]，最大子段和应该为9，对应的子段为[6, -1, 1, 3]。


idea:
two cases:
1. max consecutive sum lies in non-rotated array, just solve it like max sub-array
2. max consecutive sum lies in rotated array, find the minimum sub-array whose sum is less than zero, then use
the sum of whole array minus these minimum sum to get the maximum sub-array sum
 */
public class MaxConsSum2 {
    public int maxConsSum2(int[] arr) {
    	int n = arr.length;
    	if (n == 0)
    		return 0;
    	return Math.max(nonRotateMaxConsSum(arr), rotateMaxConsSum(arr));
    }
    
    public int nonRotateMaxConsSum(int[] arr){
    	int maxSoFar = 0;
    	int max = 0;
    	for (int i = 0; i < arr.length;i++){
    		maxSoFar += arr[i];
    		if (maxSoFar < 0)
    			maxSoFar = 0;
    		else
    			max = Math.max(max, maxSoFar);
    	}
    	return max;
    }
    
    public int rotateMaxConsSum(int[] arr){
    	//find the total sum
    	int sum = 0;
    	for (int e : arr)
    		sum += e;
    	//find the minimum consecutive sum
    	int minSoFar = 0;
    	int min = 0;
    	for (int i = 0; i< arr.length; i++){
    		minSoFar += arr[i];
    		if (minSoFar > 0)
    			minSoFar = 0;
    		else
    			min = Math.min(min, minSoFar);
    	}
    	return sum - min;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,-2,6,1};
		MaxConsSum2 o = new MaxConsSum2();
		System.out.println(o.maxConsSum2(arr));
	}

}
