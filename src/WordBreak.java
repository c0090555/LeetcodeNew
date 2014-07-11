import java.util.HashSet;
import java.util.Set;

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
    	if(s==null || s.length()==0){
    		return false;
    	}
    	boolean[] dp = new boolean[s.length()+1];
    	 wordBreakDP(s,dict,dp);
    	 for(boolean d:dp){
    		 System.out.print(" "+d);
    	 }
 		System.out.println();

    	 return dp[s.length()];
    	 
    }
    
    public void wordBreakDP(String s, Set<String> dic, boolean[]dp){
    	dp[0]= true;
    	for(int i = 1; i <= s.length(); i++){
    		for(String st:dic){
    			if(i-1+st.length()-1<s.length()&&s.substring(i-1, i-1+st.length()).equals(st)){
    				//System.out.println("st "+st);
    				dp[i-1+st.length()] |= dp[i-1];
    			}
    		}
    		
    	}
    	
    	return;
    }
    
    
   
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak o = new WordBreak();
		String s = "aaaaaaa";
		HashSet<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		System.out.println(o.wordBreak(s, dict));
		
	}

}
