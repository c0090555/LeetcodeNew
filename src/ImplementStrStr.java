/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
Note: KMP
 */
public class ImplementStrStr {
	public String strStr(String haystack, String needle) {
    	if (haystack.length()==0&&needle.length()==0)
        	return "";
    	else if(haystack.length()==0)
    		return null;
    	else if(needle.length()==0)
    	    return haystack;
    	    
    	int[] T = constructPartialMatchTable(needle);
    	int m = 0;//start of match
    	int i = 0;//curr position in needle
    	while(m+i < haystack.length()){
    		if(haystack.charAt(m+i) == needle.charAt(i)){
    			if(i == needle.length()-1){
    				return haystack.substring(m);
    			} else{
    				i++;
    			}
    		} else{
    			m = m + i - T[i];//here if(T[i] == -1, then i==0, we need to move m by one)
    			i = T[i] == -1? 0:T[i];    			
    		}
    	}
    	return null;
    }
    public int[] constructPartialMatchTable(String needle){
    	int[] T = new int[needle.length()];//T[i] is exactly the length of the longest possible proper initial segment of W which is also a segment of the substring ending at W[i - 1]
    	T[0] = -1;
    	if(needle.length() <= 1)
    		return T;
    	T[1] = 0;
    	int pos = 2;//indicate the current position in needle
    	int cnd = 0;//indicate how many characters we have match in current matching
    	while (pos < needle.length()){
    		if (needle.charAt(pos-1) == needle.charAt(cnd)){
    			cnd++;
    			T[pos] = cnd;
    			pos++;
    		} else if (cnd > 0){
    			cnd = T[cnd];
    		} else{
    			T[pos] = 0;
    			pos = pos+1;
    		}
    	}
    	
    	
    	return T;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStrStr o = new ImplementStrStr();
		String haystack = "aacaaacaaad";
		String needle = "aacaaad";
		System.out.println(o.strStr(haystack, needle));
	}

}
