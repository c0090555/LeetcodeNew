package ITint5;
/*
 * 给定两个字符串表示的非负整数a和b，计算它们的和a+b，结果也用字符串表示
 Solution: reverse string, then write recursive function
 Time Complexity: O(n)
 Space Complexity: O(n)
 n = Math.max(a.length(), b.length())
 */
public class Add {
    //返回a+b的结果
    public String add(String a, String b) {
    	if (a.length() == 0 || b.length() == 0)
    		return a.length() == 0 ? b : a;
    	StringBuilder res = new StringBuilder();
    	addRecur(new StringBuilder(a).reverse(), 0, new StringBuilder(b).reverse(), 0, 0, res);
    	return res.toString();
    }
    public void addRecur(StringBuilder sb_a, int i, StringBuilder sb_b, int j, int carry, StringBuilder res){
    	if (i >= sb_a.length()){
    		for (int k = j; k < sb_b.length(); k++){
    			int digit = sb_b.charAt(k) - '0';
    			digit += carry;
    			carry = digit / 10;
    			digit = digit % 10;
    			res.insert(0, digit);
    		}
    		if (carry != 0)
    			res.insert(0, carry);
    	}
    	else if (j >= sb_b.length()){
    		for (int k = i; k < sb_a.length(); k++){
    			int digit = sb_a.charAt(k) - '0';
    			digit += carry;
    			carry = digit / 10;
    			digit = digit % 10;
    			res.insert(0, digit);
    		}
    		if (carry != 0)
    			res.insert(0, carry);
    	}
    	else{
    		int digit = (sb_a.charAt(i) - '0') + (sb_b.charAt(j) - '0') + carry;
    		carry = digit / 10;
    		digit = digit % 10;
    		res.insert(0, digit);
    		addRecur(sb_a, i+1, sb_b, j+1, carry, res);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add o = new Add();
		String a = "11110110111";
		String b = "0";
		System.out.println(o.add(a, b));
	}

}
