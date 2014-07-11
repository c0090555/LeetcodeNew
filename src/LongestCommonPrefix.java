/*
Write a function to find the longest common prefix string amongst an array of strings.


 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	int n = strs.length;
    	StringBuilder sb = new StringBuilder();
    	if (n == 0)
    		return sb.toString();
    	int i = 0;
    	while(true){
    		for(String st : strs){
    			if(st.length() < i+1)
    				return sb.toString();
    		}
    		char c = strs[0].charAt(i);
    		for (int j = 1; j < n; j++){
    			if(strs[j].charAt(i) != c){
    				return sb.toString();
    			}
    		}
    		sb.append(c);
    		i++;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
