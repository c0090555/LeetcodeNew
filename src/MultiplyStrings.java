/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
import java.math.BigInteger;
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		if (n1 == 0 || n2 == 0)
			return new String();
		if (n2 > n1){
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		BigInteger longNum = new BigInteger(num1);
		BigInteger res = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		for (int i = 0; i < num2.length(); i++){
			char c = num2.charAt(i);
			res = res.multiply(ten);
			BigInteger digit = new BigInteger(String.valueOf(c - '0'));
			digit = digit.multiply(longNum);
			res = res.add(digit);
		}
		
		return res.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings o = new MultiplyStrings();
		String num1 = "13333333333333333333332";
		String num2 = "12";
		System.out.print(o.multiply(num1, num2));
		
	}

}
