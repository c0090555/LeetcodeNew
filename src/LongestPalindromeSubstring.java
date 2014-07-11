/*
 Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

We have a very fancy O(n) here:http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html which isn't easy to get the idea.
 *
 */
public class LongestPalindromeSubstring {
	// O(n^2) solution, search from each number, expand to both sides, e.g. aba
	// & abba
	// idea from:
	// http://fisherlei.blogspot.com/2012/12/leetcode-longest-palindromic-substring.html
	public String longestPalindrome1(String s) {
		int n = s.length();
		if (n <= 1) {
			return s;
		}
		String[] res = new String[1];
		res[0] = "";
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				expand(s, i, i + 1, res);
			}
			expand(s, i, i, res);
		}
		return res[0];
	}

	public void expand(String s, int b, int e, String[] res) {
		int step = e - b + 1;
		int i = b;
		int j = e;
		for (i = b, j = e; i - 1 >= 0 && j + 1 < s.length(); i--, j++) {
			if (s.charAt(i - 1) != s.charAt(j + 1)) {
				break;
			}
			step += 2;
		}
		if (step > res[0].length()) {
			res[0] = s.substring(i, j + 1);
		}
	}

	// DP p[i,j]
	/*
	 * 1. = 1 if i==j 
	 * 2. = s[i] == s[j] if j = i+1 
	 * 3. = s[i] == s[j] && p[i+1,j-1] if j > i+1 0 1 2 3 example: a b b a 0 a 1 0 1 4 1 b 1 2 0 2 b 1 0 3
	 * a 1
	 * 
	 * O(n^2)
	 */
	// two-dimensional array, actually p[i,j] only depends on s[i]==s[j] and
	// p[i+1,j-1] if j>i+1, so we could compute them in column-order
	public String longestPalindrome(String s) {
		int n = s.length();
		if (n <= 1)
			return s;
		boolean[][] dp = new boolean[n][n];
		int start = -1;
		int end = -1;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
					dp[j][i] = i == j + 1 ? (s.charAt(i) == s.charAt(j))
							: (s.charAt(i)==s.charAt(j)&&dp[j + 1][i - 1]);

			
				if (dp[j][i]  &&max < i-j+1) {
					start = j;
					end = i;
					max = i-j+1;
				}
				dp[i][i] = true;

			}
		}
		//System.out.println(start+" "+end);
		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeSubstring o = new LongestPalindromeSubstring();
		String s = "abb";
		System.out.println(o.longestPalindrome(s));
	}

}
