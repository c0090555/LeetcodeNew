/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 
 */
public class DecodeWays {
//tedious way
	public int numDecodings2(String s) {
		int n = s.length();
		if (n == 0 || s.charAt(0) == '0') {
			return 0;
		}
		//validate for '0'		
		for (int i = 1; i < n; i++){
			if (s.charAt(i) == '0'){//invalidate case
				if (s.charAt(i-1) > '2' || s.charAt(i-1) == '0')
					return 0;
			}	
		}
		if (n == 1){
			return 1;
		}
		int[] num = new int[n];
		num[0] = 1;
		if (s.charAt(1)!= '0' && Integer.parseInt(s.substring(0,2)) <= 26)
			num[1] = 2;
		else
			num[1] = 1;
		
		for (int i = 2; i < n; i++){
			char c = s.charAt(i);
			if (c == '0'){
				num[i] = num[i - 2];
			} else{
				if(s.charAt(i-1) == '0'){
					num[i] = num[i-1];
				}
				else{
				if (Integer.parseInt(s.substring(i-1, i+1))<=26){
					num[i] = num[i-2] + num[i-1];
				}
				else
					num[i] = num[i-1];
			
				}
			}
			
		}
		
		
		return num[n-1];
	
	
	}
	
/*good dp way
observation: scan from right to left to avoid the following case: "101",
if we scan from left, then "01" will also be consider as a valid case,
create a dummy dp[n] which is initialized to 1 to simplify the code,
no need to worry about continuous '0' case since we get two consecutive '0's, 
then we will lost all previous values

*/
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0){
			return 0;
		}
		int[] num = new int[n+1];
		num[n] = 1;//!!!hard point: need to propagate the number to left side
		for (int i = n - 1; i >= 0; i--){
			if (s.charAt(i) != '0'){//only non-zero numbers could construct number from left to right
				if (i < n -1 && Integer.parseInt(s.substring(i, i+2)) <= 26){
					num[i] = num[i+1] + num[i+2];
				}
				else{
					num[i] = num[i+1];
				}
				
				
			}
		}
		return num[0];
	}	
	

	
	public static void main(String[] args){
		DecodeWays o = new DecodeWays();
		String s = "1005";
		System.out.println(o.numDecodings(s));
	}

}
