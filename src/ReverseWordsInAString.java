/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {
	public String reverseWords(String s) {
		if (s.length() == 0)
			return s;
		StringBuilder wholeReverse = reverseString(s, 0, s.length() - 1);
		String s2 = wholeReverse.toString();
		StringBuilder res = new StringBuilder();
		int i = 0, j = 0;// start and end position of each word
		while (i < s2.length()) {
			if (s2.charAt(i) != ' ') {
				j = i + 1;
				while (j < s2.length() && s2.charAt(j) != ' ') {
					j++;
				}
				res.append(reverseString(s2,i,j-1));
				res.append(' ');
				i = j;
			}
			else{
				i++;
			}
		}
		res.deleteCharAt(res.length()-1);//remove redundant ' '
		return res.toString();
	}
	public StringBuilder reverseString(String s, int start, int end) {
		if (start > end)
			return new StringBuilder();
		StringBuilder sb = new StringBuilder(s.subSequence(start, end + 1));
		for (int i = start, j = end; i < j; i++, j--){
			char tmp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j,  tmp);
		}
		return sb;
	}
	public static void main(String[] args){
		ReverseWordsInAString o = new ReverseWordsInAString();
		String s = "hello world";
		System.out.format("%s", o.reverseWords(s));
	}
}
