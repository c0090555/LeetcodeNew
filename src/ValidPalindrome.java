/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
    	if(s.length()==0)
    		return true;
    	s = s.toLowerCase();
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if ( (c >= 'a' && c<= 'z') || (c >= '0' && c <= '9'))
    			sb.append(c);
    	}
    	s = sb.toString();
    	int start = 0;
    	int end = s.length() - 1;
    	while(start<end){
    		if(s.charAt(start) != s.charAt(end))
    			return false;
    		start++;
    		end--;
    	}
        return true;
    }
    
    public static void main(String[] args){
    	ValidPalindrome o = new ValidPalindrome();
    	String s = "1a2";
    	System.out.println(o.isPalindrome(s));
    }
}
