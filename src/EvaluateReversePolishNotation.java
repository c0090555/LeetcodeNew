/*
 * Note: Use a stack to store numbers, each time meet an operator, 
 * pop two elements from the stack, do the operation, 
 * then push the result into the stack as a new number
 */
import java.util.Stack;
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens){
		Stack<Integer> num = new Stack<Integer>();
		int v;
		
		for(int i = 0; i < tokens.length; i++){
			String s = tokens[i];
			boolean isOp = isValidOperator(s);
			//System.out.println(isOp);
			if(!isOp){
				v =  Integer.valueOf(s);
				num.push(v);
			}
			else{
				if(num.size()<2){
					return -1;
				}
				int m = num.pop();
				int n = num.pop();
				num.push(operate(n,m,s));
			}
		}
		return num.pop();
	}
	
	public static boolean isValidOperator(String s){
		if(s.compareTo("+") == 0 || s.compareTo("-") == 0 || s.compareTo("*") == 0 || s.compareTo("/") == 0){
			return true;
		}
		return false;
	}
	
	public static int operate(int a, int b, String opt){
		if(opt.equals("+")){
			return a+b;
		}
		else if(opt.equals("-")){
			return a-b;
		}
		else if(opt.equals("*")){
			return a*b;
		}
		else if(opt.equals("/")){
			return a/b;
		}
		else{
			return Integer.MIN_VALUE;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluateReversePolishNotation o = new EvaluateReversePolishNotation();
		String[] st = {"0","3","/"};
		System.out.println(o.evalRPN(st));
	}

}
