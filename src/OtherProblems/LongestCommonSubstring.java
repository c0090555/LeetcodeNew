package OtherProblems;
//find longest common suffix with DP
public class LongestCommonSubstring {

	public int longestCommonSubstring(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m == 0 || n == 0)
			return 0;
		int[][] LCS = new int[m + 1][n + 1]; // longest common suffix
		int max = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCS[i][j] = 0;// for empty string
				else if (s.charAt(i - 1) == t.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					max = Math.max(max, LCS[i][j]);
				} else {
					LCS[i][j] = 0;
				}
			}
		}
		return max;
	}
	public static void main(String[] args){
		LongestCommonSubstring o = new LongestCommonSubstring();
		String s = "abcd";
		String t = "abcde";
		System.out.println(o.longestCommonSubstring(s, t));
	}
}
