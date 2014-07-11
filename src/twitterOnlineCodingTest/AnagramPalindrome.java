package twitterOnlineCodingTest;
/*
Given a string, check if there exists some anagram of the string which is a palindrome.
Function Signature: bool anagramPalindrome(string word)

Sample Testcases:
a) anagramPalindrome("rotate") returns false, no anagram of "rotate" is a palindrome
b) anagramPalindrome("hanna") returns true, since using letters from "hanna", we can form the palindrome "nahan"

 */
import java.util.Arrays;
public class AnagramPalindrome {
	public boolean anagramPalinedrome(String word){
		int n = word.length(); 
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		char[] c = word.toCharArray();
		Arrays.sort(c);;
		boolean odd = false;
		int num = 1;
		for (int i = 1; i < n; i++){
			if (c[i-1] == c[i]){
				num++;
			} else{
				if (num % 2 == 1){
					if (odd)
						return false;
					else 
						odd = true;
				}
			}
		}
		//ending part
		if (num % 2 == 1 && odd){
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		AnagramPalindrome o = new AnagramPalindrome();
		String word = "hanna";
		System.out.println(o.anagramPalinedrome(word));
	}
}
