/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
import java.util.Stack;
public class LongestValidParentheses {
	//Solution 1: use a stack and a pointer
	//idea from: http://xixiaogualu.blogspot.com/2013/09/leetcode-longest-valid-parentheses.html
	public int longestValidParentheses(String s) {
		int n = s.length();
		if (n <= 1)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
		int start = 0;//indicate the start of a valid parenthese
		for (int i = 0; i < n; i++){
			char c = s.charAt(i);
			if (c == '('){
				stack.push(i);
			} else{//c == ')'
				if(stack.isEmpty()){//no left parentheses
					start = i + 1;
				} else{
					//!!!key part
					stack.pop();//pop up '('
					if (stack.isEmpty()){//if there is no left parentheses, e.g. ()()
						maxLen = Math.max(maxLen, i - start + 1);
					} else {//e,g, ((()
						maxLen = Math.max(maxLen, i - stack.peek());
					}
					
					
				}
			}
			
			
		}
		return maxLen;
	}
	//solution 2: DP
	//dp[i] represents the length of the longest valid parentheses start from index i
	public int longestValidParenthesesDP(String s) {
		int n = s.length();
		if (n <= 1)
			return 0;
		int[] dp = new int[n];
		int longest = 0;
		for (int i = n - 2; i >= 0; i--){
			if (s.charAt(i) == '('){//no valid parentheses start with ')'
				int j = i + dp[i+1] + 1; //e.g. ()()()
				if (j < n && s.charAt(j) == ')'){//if we find another ')',e.g. (())(), this case is specially useful when we have inner parentheses
					dp[i] = dp[i+1] + 2;
					if (j + 1 < n && s.charAt(j+1) == '(')//if we find a valid parentheses substring, then process the ending part, e.g. (())() or ()()
						dp[i] += dp[j+1];
				}

				
			}
			longest = Math.max(longest, dp[i]);
		}
		return longest;
	}	
	
	public static void main(String[] args){
		String s = "(((()(()";
		LongestValidParentheses o = new LongestValidParentheses();
		o.longestValidParenthesesDP(s);
	}
}
