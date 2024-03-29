/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Note: two dimensional DP - sub-optimal structure
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		if (n == 0)
			return 0;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		//initialize dp[i][0] & dp[0][j] 
		for (int i = 1; i < m; i++){
			dp[i][0] += dp[i-1][0];
			dp[i][0] += grid[i][0];
		}
		for (int j = 1; j < n; j++){
			dp[0][j] += dp[0][j-1];
			dp[0][j] += grid[0][j];
		}
		for (int i = 1; i < m ; i++){
			for (int j = 1; j < n; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
