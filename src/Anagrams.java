/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

 */
import java.util.ArrayList;
import java.util.HashMap;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
    	int n = strs.length;
        if (n == 0)
        	return res;
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
    	for (int i = 0; i < n; i++){
    		String s = strs[i];
    		String sortS = sortWord(s);
    		//System.out.println(s);
    		//System.out.println(sortS);
    		if (!hash.containsKey(sortS)){
    			ArrayList<String> anagram = new ArrayList<String>();
    			anagram.add(s);
    			hash.put(sortS, anagram);
    		} else{
    			ArrayList<String> anagram = hash.get(sortS);
    			anagram.add(s);
    		}
    	}
    	
    	for(String st : hash.keySet()){
    		ArrayList<String> anagram = hash.get(st);
    		if (anagram.size() > 1){
    			for(String ss: anagram)
    				res.add(ss);
    		}
    	}
        return res;
    	
    }
    public String sortWord(String word){
    	if (word.length() == 0)
    		return word;
    	char[] c = word.toCharArray();
    	//insertion sort
    	for(int i = 1; i < c.length; i++){
    		int j = i;
    		while(j >= 1 && c[j-1] > c[j]){
    			swap(c, j-1, j);
    			j--;
    		}
    	}
    	return String.valueOf(c);
    }
    public void swap(char[] c, int m, int n){
    	char temp = c[m];
    	c[m] = c[n];
    	c[n] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams o = new Anagrams();
		String[] s = {"abc","aa","cba"};
		ArrayList<String> res = o.anagrams(s);
		System.out.println(res);
		
	}

}
