/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

idea from: http://blog.csdn.net/lifajun90/article/details/10582733
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	return isMatch(s,0,p,0);
    }
    public boolean isMatch(String s, int indexS, String p, int indexP){
    	if (indexP >= p.length())
    		return indexS >= s.length();
    		
    	if (indexP + 1 <p.length() && p.charAt(indexP+1) == '*'){
    		//if s.charAt(indexS) matches p.charAt(p) 
    		while(indexS < s.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.')){
    			if (isMatch(s, indexS, p, indexP + 2))
    				return true;
    			indexS++;
    		}
    		return isMatch(s,indexS,p,indexP+2);//if not match, it's false
    	} else{
    		return ((indexS<s.length()&&(p.charAt(indexP)=='.'||p.charAt(indexP)==s.charAt(indexS))))&&isMatch(s,indexS+1,p, indexP+1);
    	}
    		
    		
    }
    public static void main(String[] args){
    	RegularExpressionMatching o= new RegularExpressionMatching();
    	String s ="ab";
    	String p = ".*c";
    	System.out.println(o.isMatch(s, p));
    }
    		
    
}
