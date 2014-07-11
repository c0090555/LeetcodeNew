/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Note: use a Stack
 */
import java.util.Stack;
public class ValidParentheses {
	public boolean isValid(String s) {
		int n = s.length();
		if (n < 2){
			return false;
		}
		Stack<Character> k = new Stack<Character>();
		for (int i = 0; i < n; i++){
			char c = s.charAt(i);
			switch (c){
				case '(':
					k.push(c);
					break;
				case '{':
					k.push(c);
					break;
				case '[':
					k.push(c);
					break;
				case ')':
					if (k.isEmpty() || k.pop() != '(')
						return false;
					break;
				case '}':
					if (k.isEmpty() || k.pop() != '{')
						return false;
					break;
				case ']':
					if (k.isEmpty() || k.pop() != '[')
						return false;
					break;
				default:
					return false;
			}
		}
		if (k.isEmpty())
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
