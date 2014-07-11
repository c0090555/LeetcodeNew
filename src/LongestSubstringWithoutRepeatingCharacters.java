/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.HashMap;
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1)
        	return n; 
        HashMap<Character,Integer> hash = new HashMap<Character, Integer>();
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++){
        	char c = s.charAt(i);
        	if (!hash.containsKey(c)){
        		hash.put(c, i);
        		len++;
        	} else{
        		maxLen = Math.max(maxLen, len);
        		int prev = hash.get(c);
        		len = i - (prev + 1) + 1;//recalculate the len
        		
        		//!!!key part: update hash
        		HashMap<Character,Integer> newHash = new HashMap<Character, Integer>();
        		for (int j = prev + 1; j <= i; j++){
        			char p = s.charAt(j);
        			newHash.put(p, j);
        		}
        		hash = newHash;
        	}
        }
        //process ending part
        maxLen = Math.max(maxLen, len);
        return maxLen;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(o.lengthOfLongestSubstring(s));
	}

}
