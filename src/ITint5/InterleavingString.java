package ITint5;

public class InterleavingString {
    public boolean isInterleaving(String str1, String str2, String str3) {
    	int len1 = str1.length();
    	int len2 = str2.length();
    	int len3 = str3.length();
    	if (len3 != len1 + len2)
    		return false;
    	if (len1 == 0)
    		return str2.equals(str3);
    	if (len2 == 0)
    		return str1.equals(str3);
    	
    	boolean[][] dp = new boolean[len1+1][len2+1];
    	dp[0][0] =  true;
    	for (int i = 0; i <= len1; i++){
    		for (int j = 0; j <= len2; j++){
    			if (i == 0 && j == 0)
    				dp[i][j] = true;
    			else if (i == 0)
    				dp[i][j] = (str3.charAt(j-1) == str2.charAt(j-1));
    			else if (j == 0)
    				dp[i][j] = (str3.charAt(i-1) == str1.charAt(i-1));
    			else if (str1.charAt(i-1) == str3.charAt(i+j-1) || str2.charAt(j-1) == str3.charAt(i+j-1))
    					dp[i][j] = dp[i-1][j] || dp[i][j-1];
    			else 
    				dp[i][j] =  false;
    		}
    	}
    	return dp[len1][len2];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
