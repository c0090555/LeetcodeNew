/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

Note: use String split method + a stack, pay attention to edge cases and path reconstruction from stack
 */
import java.util.Stack;
public class SimplifyPath {
	public String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder();
		sb.append('/');
		if (path.length() <= 1)
			return sb.toString();
		String[] split = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < split.length; i++){
			if (split[i].length() > 0){
				if (split[i].equals(".")){
					continue;
				} else if (split[i].equals("..")){
					if (!stack.isEmpty()){
						stack.pop();
					}
				} else{
					stack.push(split[i]);
				}
			}
		}
		while(!stack.isEmpty()){//!!!reconstruct the path
			sb.insert(0,stack.pop());
			sb.insert(0, "/");
		}
		if (sb.length() > 1)//!!!if sb == "/", then do nothing
			sb.deleteCharAt(sb.length() - 1);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath o = new SimplifyPath();
		String path = "/abc/...";
		o.simplifyPath(path);
	}

}
