/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
	//Solution 1: add from right to left
    public String addBinary(String a, String b) {
    	int n1 = a.length();
    	if (n1 == 0)
    		return b;
    	int n2 = b.length();
    	if (n2 == 0)
    		return a;
    	StringBuilder sb = new StringBuilder();
    	int i1 = n1 - 1;
    	int i2 = n2 - 1;
    	int carry = 0;
    	while (i1 >=0  && i2 >= 0){
    		int val = (a.charAt(i1) - '0') + (b.charAt(i2) - '0') + carry;
    		carry = val / 2;
    		val = val % 2;
    		sb.insert(0,(char)(val + '0'));
    		i1--;
    		i2--;
    	}
    	if(i1 >= 0 || i2 >= 0 || carry != 0){
    		while (i1 >= 0){
    			int val = (a.charAt(i1) - '0') + carry;
    			carry = val / 2;
    			val = val % 2;
    			sb.insert(0, (char) (val + '0'));
    			i1--;
    			if(carry == 0){
    				while(i1>=0){
    					sb.insert(0, a.charAt(i1));
    					i1--;
    				}
    			}
    		}

    		while(i2 >= 0){
      			int val = (b.charAt(i2) - '0') + carry;
    			carry = val / 2;
    			val = val % 2;
    			sb.insert(0, (char) (val + '0'));
    			i2--;
    			if(carry == 0){
    				while(i2>=0){
    					sb.insert(0, b.charAt(i2));
    					i2--;
    				}
    			}   			
    		}
    		if(carry != 0){
    			sb.insert(0, (char)(carry + '0'));
    		}
    	}
    	
    	return sb.toString();
    	
    }
    
    //Solution 2: reverse string first, then add from left to right
    public String addBinary2(String a, String b) {
    	int len1 = a.length();
    	int len2 = b.length();
    	if (len1 == 0)
    		return b;
    	if (len2 == 0)
    		return a;
    	StringBuilder sb1 = new StringBuilder(a);
    	sb1 = sb1.reverse();
    	StringBuilder sb2 = new StringBuilder(b);
    	sb2 = sb2.reverse();
    	StringBuilder res = new StringBuilder();
    	int carry = 0;
    	int i1 = 0;
    	int i2 = 0;
    	while(i1 < len1 || i2 < len2 || carry > 0){
    		int val = 0;
    		if (i1 < len1){
    			val += sb1.charAt(i1) - '0';
    		}
    		if (i2 < len2){
    			val += sb2.charAt(i2) - '0';
    		}
    		val += carry;
    		carry = val / 2;
    		val = val % 2;
    		res.append((char)(val+'0'));
    		i1++;
    		i2++;
    	}
    	return res.reverse().toString();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary o = new AddBinary();
		String a = "11";
		String b = "111";
		System.out.println(o.addBinary2(a, b));
	}

}
