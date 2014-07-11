package ITint5;

/*
 * 验证字符串expr是否为合法的算术表达式。expr中只包含：

数字'0'-'9'。
二元运算符'+', '-'。
括号'(', ')'。
样例：

expr="1"  合法的表达式，返回true
expr="10+(2-(31+(4)))"  合法的表达式，返回true
expr="-1"  不合法的表达式，返回false
expr="1+"  不合法的表达式，返回false
提示：此题可使用表达式求值中类似的递归算法。

idea:
1. check parenthesis
2. check plus and minus
3. check numbers

 */
import java.util.Stack;
public class Validation
{
    public boolean validate(String expr) {
    	int len = expr.length( );
    	if (len == 0)
    		return true;
    	int leftPInt = -1;
    	int rightPInt = -1;
    	int plusInt = -1;
		Stack<Integer> s = new Stack<Integer>();

    	for (int i = 0; i < len; i++){
    		char a = expr.charAt(i);
    		if (a == '('){
    			leftPInt = i;
    			s.push(i);
    		}
    		else if (a == ')'){
    			if (s.isEmpty())
    				return false;
    			s.pop();
    		}
    		else if (a == '+' || a == '-'){
    			plusInt = i;
    		}
    	}
    	if (!s.isEmpty())
    		return false;
    	if (leftPInt != -1){//find the matching right parenthesis
    		s.push(leftPInt);
    		for (int i = leftPInt + 1; i < len; i++){
        		char a = expr.charAt(i);
    			if (a == '('){
    				s.push(i);
    			} else if (a == ')'){
    				s.pop();
    				if (s.isEmpty()){
    					rightPInt = i;
    					break;
    				}
    			}
    			else if (isOperator(a)){
    				plusInt = i;
    			}
    		}
    		//leftPInt and rightPInt divide the expr into three parts
    		int len1 = leftPInt;
    		int len2 = rightPInt - leftPInt + 1;
    		int len3 = len - 1 - rightPInt;
    		if (len1 > 0 ){
    			if (len1 == 1 || !isOperator(expr.charAt(len1-1)))
    				return false;
    			if (!validate(expr.substring(0, len1-1)))
    				return false;
    		}
    		if (len3 > 0){
    			if (len3 == 1 || !isOperator(expr.charAt(len1+len2)))
    				return false;
    			if (!validate(expr.substring(len1+len2)))
    				return false;
    		}
    		if (len2 == 2)
    			return false;
    		if (!validate(expr.substring(len1+1, len1+len2-1)))
    			return false;
    	}
    	else if (plusInt == 0 || plusInt == len - 1){
    		return false;
    	}
    	else if (plusInt != -1 && (!validate(expr.substring(0, plusInt))||!validate(expr.substring(plusInt + 1)))){
    		return false;
    	}
    	else if (expr.charAt(0) == '0'&&len >1 )
            return false;
    	return true;	
    	
    }
    public boolean isOperator(char c){
    	return c == '+' || c == '-';
    }
    
    public static void main(String[] args){
    	Validation o = new Validation();
    	String expr = "(((1)-(2))+3+(4-50)+60)";
    	System.out.println(o.validate(expr));
    }
   
}
