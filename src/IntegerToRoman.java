/*
Given an integer, convert it to a roman numeral.

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


public class IntegerToRoman {
	//method 1
    public String intToRoman(int num) {
    	if (num <= 0 || num > 3999)
    		return new String();
    	StringBuffer sb = new StringBuffer();
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	int[] keys = {
    		1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    	};
    	map.put(1000, "M");
    	map.put(900, "CM");
    	map.put(500, "D");
    	map.put(400, "CD");
    	map.put(100, "C");
    	map.put(90, "XC");
    	map.put(50, "L");
    	map.put(40, "XL");
    	map.put(10, "X");
    	map.put(9, "IX");
    	map.put(5, "V");
    	map.put(4, "IV");
    	map.put(1, "I");
    	
    	
    	for (int i = 0; i < keys.length; i++){
    		int key = keys[i];
    		if (num == 0)
    			break;
    		if (num / key > 0){
    			int time = num / key;
    			while (time > 0){
    				String st = map.get(key);
    				//System.out.println(st);
    				sb.append(map.get(key));
    				time--;
    			}
    			num = num % key;
    			
    		}
    		
    		
    	}
    	return sb.toString();
        
    }
    
    //method 2: from http://blog.csdn.net/ithomer/article/details/8800505
    public String intToRoman2(int num) {
    	if (num <= 0 || num > 3999)
    		return new String();
    	StringBuffer sb = new StringBuffer();
    	int[] value = {
        		1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
    	String[] roman = {
    			"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    	};
    	int i = 0;
    	while (num > 0){
    		System.out.println(i);
    		if(num >= value[i]){///here must have "="
    			sb.append(roman[i]);
    			System.out.println(roman[i]);
    			num -= value[i];
    		}
    		else{
    			i++;
    		}
    	}
    	return sb.toString();
  	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman o = new IntegerToRoman();
		int num = 1;
		System.out.println(o.intToRoman2(num));
	}

}
