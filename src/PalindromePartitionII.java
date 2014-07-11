/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

idea comes from:http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html


Solution: DP
Analysis:

a b a b a a a b b
        i       n
        i  j    n
        
d[i,n] = min{d[i,j]+d[j+1,n]}, i<=j<=n
use a one-dimension dp[i] to stands for d[i,n], scan from i to n, if we found one palindrome, then d[i,j]=1,
hence dp[i]=min{1+dp[j+1]}, i<=j<=n
        
use p[i][j] to represent whether s(i,j) is a palindrome, so if s(i,j) is a palindrom, then it should meet the following condition:
s[i]=s[j]&&(j-i<2||p[i+1][j-1])

Attention with the initialization of dp: we use a dummy value to maintain the property of dp


 */
public class PalindromePartitionII {
	 public int minCut(String s) {
	        if(s==null||s.length()==0||s.length()==1)
	        	return 0;
	        int len = s.length();
		 	int[] dp = new int[s.length()+1];//dp stores the minimum number of cuts at each position
		 	boolean[][] p = new boolean[len+1][len+1];//default value: false
		 	
		 	
		 	//set up a dummy dp[len]
		 	for(int i=0;i<=len;i++){
	    	   dp[i] = len -1 -i;
		 	}
		 	for(int i=len-1;i>=0;i--){
		 		for(int j=i;j<len;j++){
		 			if((s.charAt(i)==s.charAt(j))&&(j-i<2||p[i+1][j-1]==true)){
		 				p[i][j]=true;//dp for palindrom
		 				dp[i]=Math.min(1+dp[j+1], dp[i]);
		 				
		 			}
		 			
		 			
		 		}
		 		
		 		
		 	}
		 	
		 	return dp[0];		 		    		 
		 
	 }
	
	 
	 public static void main(String[] args){
		 PalindromePartitionII o = new PalindromePartitionII();
		 String s = "abc";
		 System.out.println(o.minCut(s));
		 
		 
	 }
	 
}
