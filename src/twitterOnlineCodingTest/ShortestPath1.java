package twitterOnlineCodingTest;
/*
 * given N, use num * 2 or num + 1 to reach N, find the shortest path
 * e.g. N = 17, the shortest path is 1 -> 2 -> 4 -> 8 -> 16 -> 17, so return 6
 * 
 * Note: one-dimensional dp, need to separately take care of even and odd numbers
 */
public class ShortestPath1 {
	int solution(int N) {
	    // write your code in C90
		if (N <= 0) 
			return 0;
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= N; i++){
			if (i % 2 == 1){
				dp[i] = dp[i-1]+ 1;
			} else{
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			}
		}
		return dp[N];
	}
	public static void main(String[] args){
		ShortestPath1 o = new ShortestPath1();
		int N = 17;
		System.out.println(o.solution(N));
	}

}
