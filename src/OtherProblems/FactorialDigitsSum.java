package OtherProblems;
/*
Problem: factorial digits sum。比如input为10，因为10！= 3628800，就返回sum的值 = 3+6+2+8 ...，

idea: Java BigInteger class
 */
import java.math.BigInteger;

public class FactorialDigitsSum {
	public int facDigitSum(int n){
		String s = Integer.toString(n);
		BigInteger res = new BigInteger(s);
		for (int i = n - 1; i >= 1; i--){//i shouldn't reach 0
			s = Integer.toString(i);
			BigInteger factor = new BigInteger(s);
			System.out.println("facotr" +factor);
			res = res.multiply(factor);
			System.out.println(res);
		}
		int sum = 0;
		System.out.println("res"+res);

		s = res.toString();
		System.out.println("factorial "+s);
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			sum += c - '0';
			System.out.println(sum+" sum");
		}
		return sum;
	}
	public static void main(String[] args){
		FactorialDigitsSum o = new FactorialDigitsSum();
		int n = 3;
		System.out.println(o.facDigitSum(n));
	}
	
}
