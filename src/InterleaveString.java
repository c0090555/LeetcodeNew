/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
We can use DFS but it's TLE(cannot pas OJ test cases)

idea comes from: http://fisherlei.blogspot.com/2012/12/leetcode-interleaving-string.html

Solution: DP, use a two dimensional array match[i][j] to indicate whether s3(i+j) match s1(i) + s2(j)

Initialization: match[0][0] true
Transformation function: 
1. match[i][j] |= match[i-1][j] if s1.charAt(i-1) == s3.charAt(i+j-1), else match[i][j] == false
That is match[i][j] = (s1.lastChar == s2.lastChar) && match[i-1][j]


2. match[i][j-1] |= match[i][j-1] if s2.char(j-1) == s3.charAt(i+j-), else match[i][j] == false
That is match[i][j] = (s2.lastChar == s2.lastChar) && match[i][j-1]
 
 *
 */
public class InterleaveString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len3 != len1 + len2)
			return false;
		
		boolean[][] match = new boolean[len1 + 1][len2 + 1];//match[i][j] indicate we got a match with len1 long s1 and len2 long s2
		
		// initialization
		match[0][0] = true;
		int i = 1;
		while (i <= len1) {//!!!here we use while loop instead of for loop since since we get any mismatch, we don't need to do further comparison
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) 
				match[i][0] |= match[i - 1][0];
			i++;
		}
		int j = 1;
		while (j <= len2) {//!!!here we use while loop instead of for loop since since we get any mismatch, we don't need to do further comparison
			if (s2.charAt(j - 1) == s3.charAt(j - 1))
				match[0][j] |= match[0][j - 1];
			j++;
		}

		for (i = 1; i <= len1; i++) {
			for (j = 1; j <= len2; j++) {
				char c = s3.charAt(i + j - 1);
				if (c == s1.charAt(i - 1)) {//if s1.lastChar == s3.lastChar, then match[i][j] depends on match[i-1][j](its previous case)
					match[i][j] = match[i-1][j] || match[i][j];
				}
				if (c == s2.charAt(j - 1)){//if s2.lastChar == s3.lastChar, then match[i][j] depends on match[i][j-1](its previous case)
					match[i][j] = match[i][j-1] || match[i][j];
				}

			}

		}
		return match[len1][len2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
