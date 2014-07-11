/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Note: DP
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
    	if (n == 0)
    		return 0;
    	if (n == 1)
    		return 1;
    	int[] dp = new int[n];
    	dp[0] = 1;
    	dp[1] = 2;
    	for(int i = 2; i < n; i++){
    		dp[i] = dp[i-2] + dp[i-1];
    	}
    	return dp[n-1];
    }
    
    //recursion - TLE
    public int climbStairsRecur(int n){
    	if (n <= 0)
    		return 0;
    	if (n ==1)
    		return 1;
    	if (n == 2)
    		return 2;
    	return climbStairsRecur(n-1) + climbStairsRecur(n-2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		ClimbingStairs o = new ClimbingStairs();
		System.out.println(o.climbStairsRecur(n));
	}

}
