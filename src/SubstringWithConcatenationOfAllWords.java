/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
Note: use HashMap
 */
import java.util.ArrayList;
import java.util.HashMap;
public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (L.length == 0 || L[0].length() == 0)
			return res;
		//construct hash
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for(String st : L){
			if (!hash.containsKey(st))
				hash.put(st, 1);
			else {
				int num = hash.get(st);
				hash.put(st, num + 1);
			}
		}
		int keyLen = L[0].length();
		int totalLen = keyLen * L.length;	//all strings have the equal length
		for (int i = 0; i <= S.length() - totalLen; i++){//!!!here i could be equal to S.length() - totalLen
			HashMap<String, Integer> copy = (HashMap<String, Integer>)hash.clone();
			boolean concatenation = true;
			for (int j = i; j < i + totalLen; j+=keyLen){
				String check = S.substring(j, j+keyLen);
				if (!copy.containsKey(check)){
					concatenation = false;
					break;
				} else{
					int num = copy.get(check);
					num--;
					if (num == 0)
						copy.remove(check);
					else
						copy.put(check, num);//!!!update hash
				}
			}
			if (!copy.keySet().isEmpty())
				concatenation = false;
			if (concatenation)
				res.add(i);
			
		}
		return res;
	}
	//enhanced version
	//The trick point for this solution is to move two pointers i & j
	  public ArrayList<Integer> findSubstring2(String S, String[] L) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        int n = L.length;
	        int totalLen = 0;
	        HashMap<String,Integer> hash = new HashMap<String, Integer>();
	        for(String st : L){
	            totalLen += st.length();
	            if(!hash.containsKey(st)){
	                hash.put(st, 1);
	            } else{
	                hash.put(st, hash.get(st) +1);
	            }
	        }
	        if (n==0 || S.length() < totalLen)
	            return res;
	        int keyLen = L[0].length();
	        int m = 0;//start position
	        int i = 0;//current match start position
	        int j = 0;//current match end position
	        for (m = 0; m <= keyLen - 1; m++){
	        	i = m;
	        	j = i;
	        	HashMap<String, Integer> copy = (HashMap<String, Integer>)hash.clone();
	        	while (j + keyLen - 1< S.length()){
	        		String current = S.substring(j, j+keyLen);
	        		if (!hash.containsKey(current)){//not a valid word
	        			i = j + keyLen;//reset
	        			j = i;
	        			copy = (HashMap<String, Integer>)hash.clone();
	        			continue;
	        		} else{
	        			if(!copy.containsKey(current)){//we don't need current
	        				i =findNextStartPosition(S, keyLen, i, j, copy);
	        			} else{
	        				if (copy.get(current) == 1){
	        					copy.remove(current);
	        				} else{
	        					copy.put(current, copy.get(current) - 1);
	        				}
	        				if(copy.keySet().isEmpty()){//find one
	        					res.add(i);
	        					j += keyLen;//move to next element
	        					if(j + keyLen - 1 < S.length()){//check next
	        						String next = S.substring(j,j+keyLen);
	        						if (!hash.containsKey(next)){
	        							continue;
	        						} else{
	        							copy.put(next, 1);//add next to hash
	        							i = findNextStartPosition(S, keyLen, i, j, copy);
	        						}
	        					}
	        					continue;//no need to increment j since we have already done it
	        				} 
	        			}
    					j += keyLen;
	        		}
	        	}
	        }
	        return res;
	    }
	  	public int findNextStartPosition(String S, int keyLen, int start, int curr, HashMap<String, Integer> copy){
	  		int i = start;
	  		int j= curr;
	  		String current = S.substring(j, j+keyLen);
	  		while(i <= j && !S.substring(i, i+keyLen).equals(current)){
				String needToRecover =  S.substring(i,i+keyLen);//recover deleted words
				if (!copy.containsKey(needToRecover)){
					copy.put(needToRecover,1);
				} else{
					copy.put(needToRecover, copy.get(needToRecover) + 1);
				}
				i+=keyLen;
			}
			i += keyLen;
			return i;
	  	}

	  	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringWithConcatenationOfAllWords o = new SubstringWithConcatenationOfAllWords();
		String S = "a";
		String[] L = {"a"};
		o.findSubstring2(S, L);
	}

}
