package OtherProblems;
/*
 * famous problem in programming perl: assume if all numbers are negative, then the max sub-array sum is 0
 * 
 */
public class FindSubArrayWithMaxSum {
	//Time Complexity: O(n)
	public int maxSum(int[] n){
		if (n ==  null || n.length == 0){
			return 0;			
		}
		int maxEndingHere = 0;
		int maxSoFar = 0;
		for (int i = 0; i < n.length; i++){
			maxEndingHere = Math.max(maxEndingHere + n[i], 0);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
		
	}
	
	//problem variant: What if we have to get at least one number from the array to construct the sub-array
	public int maxSum2(int[] n){
		if (n == null || n.length == 0)
			return 0;
		int maxEndingHere = 0;
		int maxSoFar = Integer.MIN_VALUE;//!!!need to set original maxSoFar as Integer.MIN_VALUE
		for (int i = 0; i < n.length; i++){
			maxEndingHere = Math.max(maxEndingHere + n[i], n[i]);//!!!have to involve n[i] since sub-array should be continuous
			maxSoFar = Math.max(maxSoFar, maxEndingHere);				
		}
		return maxSoFar;
	}
	
	
	//problem extension: What if we want to find the sub-array whose sum is closest to a target number t?
	//!!!cannot use the similar approach with the one in programming pearl since there may be two numbers
	//closest to the target number, e.g. both 1.5 and 0.5 are closest to target 1
	public int closestSum(int[] n, int t){
		if (n == null || n.length == 0)
			return 0;
		int distanceEndingHere = n[0] - t;
		int distanceSoFar = n[0] - t;
		for (int i = 1; i < n.length; i++){
			int distWithN = distanceEndingHere + n[i];
			//int distWithoutN = 
			
			
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubArrayWithMaxSum o = new FindSubArrayWithMaxSum();
		int[] n = {-1,-2,4,-3,4};
		System.out.println(o.maxSum2(n));
	}

}
