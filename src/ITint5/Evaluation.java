package ITint5;
/*
 * a good recursive solution comes from: http://www.itint5.com/discuss/50/case%E9%87%8C%E9%9D%A2%E6%9C%89%E4%B8%80%E4%B8%AA%E5%B8%A6%E8%B4%9F%E6%95%B4%E6%95%B0%E7%9A%84%EF%BC%8C%E5%B9%B6%E6%B1%82%E9%80%92%E5%BD%92%E5%AE%9E%E7%8E%B0
 *idea: divide and conquer, check '+''-''*', calculate '+''-' first 
 */
public class Evaluation {
	 public int evaluate(String expr) {
		 int plusInt = -1;//indicator for plus and subtraction
		 int mulInt = -1;//indicator for multiplication
		 int num = 0;
		 int sign = -1;
		 for (int i = 0; i < expr.length(); i++){
			 char c = expr.charAt(i);
			 if (c == '+' || c == '-'){
				 plusInt = i;
				 sign = (c == '+') ? 1 : -1;
			 } 
			 else if (c == '*')
				 mulInt = i;
			 num *= 10;
			 num += c - '0';
		 }
		 if (plusInt != -1)
			 return evaluate(expr.substring(0, plusInt)) + sign * evaluate(expr.substring(plusInt+1));
		 if (mulInt != -1)
			 return evaluate(expr.substring(0, mulInt)) * evaluate(expr.substring(mulInt+1));
		 return num;
	 }
}
