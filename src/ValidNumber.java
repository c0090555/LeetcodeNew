/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one

Note:
 *
 */
public class ValidNumber {
	 public boolean isNumber(String s) {
	    	if (s == null || s.length() == 0)
	    		return false;
	    	s = trim(s);//remove all preceding and trailing white space
	    	if (!checkLetter(s))
	    		return false;
	    	int e = checkE(s);
	    	if (e == -1){
	    		return checkDotNum(s, true);
	    	}
	    	else {
	    		String leftHalf = s.substring(0, e);
	    		String rightHalf = s.substring(e+1);
	    		return checkDotNum(leftHalf, true) && checkDotNum(rightHalf, false);
	    	}
	    	
	    }
	    
	    public String trim(String s){//!!!trim all preceding and trailing white space
	    	int i = 0;
	    	while (i < s.length() && s.charAt(i) == ' '){
	    		i++;
	    	}
	    	if (i == s.length())//s only has white space
	    		return new String();
	    	int j = s.length() - 1;
	    	while (j >= 0 && s.charAt(j) == ' '){
	    		j--;
	    	}    	
	    	return s.substring(i, j+1);    	    	   	
	    }
	    public boolean checkLetter(String s){
	    	int e  = 0;//num of e
	    	int dot = 0;//num of dot
	    	for (int i = 0; i < s.length(); i++){
	    		char c = s.charAt(i);
	    		if (c == 'e'){
	    			e++;
	    			if (e > 1)    				
	    				return false;
	    		}
	    		else if (c == '.'){
	    			dot++;
	    			if (dot > 2)
	    				return false;
	    		}
	    		else if (c == '+' || c == '-'){
	    			continue;
	    		}
	    		else if (c < '0' || c > '9')
	    			return false;
	    	}
	    	return true;    	
	    }
	    public int checkE(String s){
	    	int e = -1;//-1 means no 'e' inside this string
	    	for (int i = 0; i < s.length(); i++){
	    		char c = s.charAt(i);
	    		if (c == 'e'){
	    			e = i;
	    		}
	    	}
	    		return e;   	
	    }
	    public boolean checkDotNum(String s, boolean permitDot){//rightHalf of number(after 'e') doesn't permit '.'
	    	if (s.length() == 0){
	    		return false;
	    	}
	    	char c = s.charAt(0);
	    	if (c == '+' || c == '-'){
	    		s = s.substring(1);
	    	}
	    	if (s.length() == 0){
	    		return false;
	    	}
	    	int dot = 0;
	    	for (int i = 0; i < s.length(); i++){
	    		c = s.charAt(i);
	    		if (c == '.'){
	    			dot++;
	    			if (!permitDot || (i == s.length() -1 && s.length() == 1) || dot > 1){//Note: "3." is considered as a valid number
	    				return false;
	    			}
	    		}
	    		else if (c == '+' || c == '-'){
	    			return false;
	    		}
	    	}
	    	return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
