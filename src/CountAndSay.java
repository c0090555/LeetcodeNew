/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
import java.util.HashMap;

public class CountAndSay {
	public String countAndSay(int n) {
		String res = new String();
		if (n == 0) {
			return res;
		}
		if (n == 1) {
			return "1";
		}

		res = "1";// base case
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int j = 1;
			int count = 1;
			while (j < res.length()) {
				if (res.charAt(j) == res.charAt(j - 1)) {
					count++;
				} else {
					sb.append(String.valueOf(count));
					sb.append(res.charAt(j - 1));//!!here we need to append the previous char

					count = 1;
				}
				j++;
			}
			// process ending part
			sb.append(String.valueOf(count));
			sb.append(res.charAt(j - 1));
			
			res = sb.toString();
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay o = new CountAndSay();
		int n = 7;
		System.out.println(o.countAndSay(n));
	}

}
