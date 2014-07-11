/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


DFS
Anther DFS approach: http://fisherlei.blogspot.com/2012/12/leetcode-restore-ip-addresses.html
 */
import java.util.ArrayList;
public class RestoreIPAddresses {
	
	//DFS
    public ArrayList<String> restoreIpAddresses(String s) {
    	int len = s.length();
    	ArrayList<String> res = new ArrayList<String>();
    	if (len < 4 || len > 12){
    		
    	}
    	for(int i = 0; i <= 2; i++){
    		if(i >= len-3){
    			break;
    		}
			String s1 = s.substring(0, i+1);
    		if(isValidIP(s1)){
    			StringBuilder sb1 = new StringBuilder();
    			sb1.append(s1+".");
    			for(int j = i+1; j <= i+3; j++){
    				if(j >= len-2){
    					break;
    				}
    				String s2 = s.substring(i+1, j+1);
    				if(isValidIP(s2)){
        				StringBuilder sb2 = new StringBuilder(sb1);
    					sb2.append(s2+".");
    					for(int k = j+1; k <= j+3; k++){
    						if(k>=len-1){
    							break;
    						}
    						String s3 = s.substring(j+1, k+1);
    						String s4 = s.substring(k+1);
    						if(isValidIP(s3)&&isValidIP(s4)){
        						StringBuilder sb3 = new StringBuilder(sb2);
    							sb3.append(s3+".");
    							sb3.append(s4);
    							res.add(sb3.toString());   							
    						}
    					}

    				}
    			}
    		}
    	}
		return res;

    }
    
    public boolean isValidIP(String s){
    	if(s.length() == 0 || s.length() >= 4)
    		return false;
    	if(s.charAt(0)=='0')//!!!if the first character of s is '0', then the only valid case is s=="0"
    	    return s.length()==1;
    	int val = Integer.valueOf(s);
    	if(val >= 0 && val <= 255)
    		return true;
    	else
    		return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses o = new RestoreIPAddresses();
		String s = "010010";
		System.out.println(o.restoreIpAddresses(s));
	}

}
