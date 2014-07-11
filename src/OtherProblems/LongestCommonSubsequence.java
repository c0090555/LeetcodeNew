package OtherProblems;
//dp
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String s, String t){
     int m = s.length();
     int n = t.length();
     if (m== 0 || n == 0)
          return 0;
     int[][] LCS = new int[m+1][n+1];
     for (int i = 0; i <= m; i++){
          for (int j = 0; j <= n; j++){
               if (i == 0 || j == 0)
                    LCS[i][j] = 0;
               else if (s.charAt(i-1) == t.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
               } else{
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
               }
          }
     }
     return LCS[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence o = new LongestCommonSubsequence();
		String s = "abcd";
		String t = "bsctd";
		System.out.println(o.longestCommonSubsequence(s, t));
	}

}
