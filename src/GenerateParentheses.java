/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 
 Note: use recursion
 key points:
 1. number of left parentheses <= n
 2. number of right parentheses <= number of left parentheses
 e.g.:
 n == 1: ()
 n == 2: ( -> () -> ()( -> ()()
 		 ( -> (( -> (() -> (())
 
 
 */
import java.util.ArrayList;
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> res = new ArrayList<String>();
		generateParenthesisHelper(n, 0, 0, sb, res);
		return res;
	}
	public void generateParenthesisHelper(int n, int left, int right, StringBuilder sb, ArrayList<String> res){
		if (left == n && right == n){
			res.add((String)(sb.toString()));
		}
		if (left < n){
			StringBuilder copy = new StringBuilder(sb);
			copy.append('(');
			generateParenthesisHelper(n, left+1, right, copy, res);//use left + 1, not ++left
		} 
		if (right < left){
			StringBuilder copy = new StringBuilder(sb);
			copy.append(')');
			generateParenthesisHelper(n, left, right+1, copy, res);//use right + 1, not ++right
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses o = new GenerateParentheses();
		int n = 1;
		o.generateParenthesis(n);
	}

}
