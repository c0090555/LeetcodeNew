package ITint5;
/*
给定两个字符串表示的整数a和b，计算它们的乘积a*b，结果也用字符串表示。

注意：a和b有可能是负数。对于0，只有一种合法的表示"0"，"-0"是不合法的。

assume we don't have '+' in input Strings

solution 1:
idea from: http://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/comment-page-1/#comment-198
1. reverse both of these two strings
2. assume int[] d stores the results for all digits, calculate the carries for each digits
3. remove redundant leading zeros
Time Complexity: O(m*n)
Space Complexity: O(m*n)
m and n are length of two input strings
 */
public class Multiply {
	 public String multiply(String a, String b) {
		 if (a.length() == 0||b.length() == 0)
			 return new String();
		 if (a.equals("0") || b.equals("0"))
			 return "0";
		 boolean positive = true;
		 if (a.charAt(0) == '-'){
			 a = a.substring(1);
			 positive = !positive;
		 }
		 if (b.charAt(0) == '-'){
			 b = b.substring(1);
			 positive = !positive;
		 }
		 int[] d = new int[a.length() + b.length()];
		 StringBuilder sb_a = new StringBuilder(a).reverse();
		 StringBuilder sb_b = new StringBuilder(b).reverse();
		 for (int i = 0; i < sb_a.length(); i++){
			 for (int j = 0; j < sb_b.length(); j++){
				 d[i+j] += (sb_a.charAt(i) - '0') * (sb_b.charAt(j) - '0');//!!here we need to use "+="
			 }
		 }

		 StringBuilder res = new StringBuilder();
		 for (int k = 0; k < d.length; k++){
			 int digit = d[k] % 10;
			 res.insert(0, digit);
			 int carry = d[k] / 10;
			 if (k < d.length - 1){
				 d[k+1] += carry;
			 }
		 }
		 //remove redundant leading zeros
		 while (res.length() > 0 && res.charAt(0) == '0')
			 res.deleteCharAt(0);
		 if (!positive)
			 res.insert(0, '-');
		 return String.valueOf(res);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiply o = new Multiply();
		String a = "-135";
		String b = "86291270936062618792";//86291270936062618792
		System.out.println(o.multiply(a, b));
	}

}
