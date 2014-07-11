/*
 * 
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
I=1
V=5
X=10
L=50
C=100
D=500
M=1000
 */
import java.util.HashMap;

public class RomanToInteger { 
	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int sum = 0;
		if (s.length() == 1)
			return map.get(s.charAt(0));
		
		int newStart = 0;
		int i = 0;
		while (i < s.length() - 1){
			int cur = map.get(s.charAt(i));
			int next = map.get(s.charAt(i + 1));
			if (cur < next){
				sum += next - cur;
				newStart = i + 2;
				i = i + 2;
			}
			else{
				sum += cur;
				i++;
			}
		}
		
			
		if (newStart != s.length())
				sum += map.get(s.charAt(s.length()-1));
		return sum;
		
	}

}
