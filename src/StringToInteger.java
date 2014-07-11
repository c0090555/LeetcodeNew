/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, Integer.MAX_VALUE (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    public int atoi(String str) {
    	if (str == null || str.length() ==0)
    		return 0;
    	long res = 0;
    	boolean positive = true;
    	int i = 0;
    	for (i=0; i < str.length(); i++){
    		if (str.charAt(i) != ' ')
    			break;
    	}
    	
    	if (str.charAt(i) == '+' || str.charAt(i) == '-'){
    		if (i == str.length() - 1 || !isNum(str.charAt(i + 1)))
    			return 0;
    		else {
    			if (str.charAt(i) == '-')
    				positive = false;
    			i++;
    		}
    	} else if (!isNum(str.charAt(i))){
    		return 0;
    	}
    	
    	while (i < str.length() && isNum(str.charAt(i))){
    		res *= 10;
    		res += str.charAt(i) - '0';   
    		i++;
    	}
    	if (positive && res > Integer.MAX_VALUE)
    		return Integer.MAX_VALUE;
    	else if (!positive){
    		res = res * (-1);
    		if (res < Integer.MIN_VALUE)
    			return Integer.MIN_VALUE;
    	}
    	
    	return (int)res;
    	
    		
    			
        
    }
     
    public boolean isNum(char c){
    	return c <= '9' && c>= '0';
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger o = new StringToInteger();
		String st = "2147483647";
		System.out.println(o.atoi(st));
	}

}
