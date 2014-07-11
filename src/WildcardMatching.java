/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

Note: use brute-force dfs will have TLE
Solution 2: idea from: http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
use *s and *p to indicate s.charAt(i) and p.charAt(j):
1. if *s == *p || *p == '?', then that means we have a match here and we can move forward, i++, j++
2. if *p == '*', then means one or many characters of s are available from here, save this i for s
3. if *s != *p && *p != '?', then we need to check the backward for p to search for a '*'
  a. if we cannot find a '*', then return false
  b. if we find a '*', move p to the next position of this '*', save the current i as the new stored index for s

Solution 1: dp
 */
public class WildcardMatching {
	
    public boolean isMatch(String s, String p) {
    	p = starPreprocess(p);
    	int m = s.length();
    	int n = p.length();
    	if (m == 0 || n == 0)
    		return false;
    	s = " "+s;
    	p = " "+p;
    	boolean[][] dp = new boolean[m+1][n+1];
    	dp[0][0] = true;
    	return false;
    
    }
	
	
	
	
	
	
	
	
	
	
	//solution 2
	
    public boolean isMatch2(String s, String p) {
    	p = starPreprocess(p);
    	int m = s.length();
    	int n = p.length();
    	if (m == 0 || n == 0)
    		return false;
    	int i = 0;
    	int j = 0;
    	int saveS = -1;
    	int saveP = -1;
    	int star = -1;
    	while(i != m || j != n){
    		if (i == m && j != n){//s reach the end
    			for (int k = j ; k < p.length(); k++){
    				if (p.charAt(k) != '*')
    					return false;    				
    			}
    			return true;
    		}
    		if (i != m && j == n){
    			if (saveP != -1){//no start before it
    				return false;
    			} else{
    				i = saveS++;
    				j = saveP;
    				continue;
    			}
    		}
    		if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
    			i++; j++; continue;
    		}
    		else if (p.charAt(j) == '*'){
    			while(j < n && p.charAt(j) == '*')
    				j++;
    			saveP = j;
    			saveS = i;
    			j++;
    			continue;
    		} else {//not match
    			if (saveP == -1){
    				return false;
    			}
    			else {
    				j = saveP + 1;
    				i = saveS + 1;
    				continue;
    			}
    		}
    		
    		
    	}
    	return true;
    }
    
    
    
    public String starPreprocess(String p){//pre-process consecutive '*'
    	StringBuilder sb = new StringBuilder();
    	for (int j = 0; j < p.length(); j++){
    		char b = p.charAt(j);
    		sb.append(b);
    		if(b == '*'){
    			while(j+1 < p.length() && p.charAt(j+1) == '*'){
    				j++;
    			}  			
    		}
    	}
    	return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching o = new WildcardMatching();
		String s = "aa";
		String p = "*";
		System.out.println(o.isMatch(s, p));
	}

}
