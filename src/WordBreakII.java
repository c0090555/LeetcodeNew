/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].


Idea comes from: http://blog.csdn.net/violet_program/article/details/12499125

Solution 1: DFS + memorization
Solution 2: DP + back track


 */
import java.util.*;

public class WordBreakII {

//Solution 1 - DFS + memorization
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}

		HashMap<String, ArrayList<String>> memorized = new HashMap<String, ArrayList<String>>();
		// find minimum and maximum length of dictionary words
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String st : dict) {
			int len = st.length();
			if (min > len)
				min = len;
			if (max < len)
				max = len;
		}

		res = wordBreakDFS(s, dict, min, max, memorized);
		return res;

	}

	public ArrayList<String> wordBreakDFS(String s, Set<String> dict, int min,
			int max, HashMap<String, ArrayList<String>> memorized) {
		if (memorized.containsKey(s)) {
			return memorized.get(s);
		}

		ArrayList<String> res = new ArrayList<String>();

		if (s == null || s.length() == 0)
			return res;

		if (dict.contains(s)) {
			res.add(s);
		}

		for (int i = min; i <= Math.min(s.length(), max); i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = s.substring(i);
				ArrayList<String> suffixBreak = wordBreakDFS(suffix, dict, min,
						max, memorized);
				if (!suffixBreak.isEmpty()) {
					for (String sb : suffixBreak)
						res.add(prefix + " " + sb);

				}

			}

		}
		memorized.put(s, res);
		return res;
	}

//Solution 2 DP + back track
	
	//use ArrayList<ArrayList<Integer>> to store all possible positions to insert space for a specific position
	public ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		int n = s.length();
		if(s==null ||s.length()==0)
			return res;
		//DP
		ArrayList<ArrayList<Integer>> pres = new ArrayList<ArrayList<Integer>>();//used to store all possible positions to insert space for a specific position
		//initialization
		for(int i=0;i<n;i++)
			pres.add(new ArrayList<Integer>());
		
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				String suffix = s.substring(j,i+1);
				if((j==0||pres.get(j-1).size()>0)&&dict.contains(suffix)){//key part: for a specific i, check its prefix and suffix
					System.out.println("i "+i+" j "+j+" suffix "+suffix);
					pres.get(i).add(j);
				}
				
			}
			
			
		}
		//back track
		res = wordBreakHelper(s, n, pres);
		return res;
		
	}
	
	
	//back track - from pres to res
	public ArrayList<String> wordBreakHelper(String s, int n, ArrayList<ArrayList<Integer>> pres){
		ArrayList<String> res = new ArrayList<String>();
		
		ArrayList<Integer> presIndex = pres.get(n-1);
		System.out.println("size "+presIndex.size());
		for(int j:presIndex)
			System.out.println("n "+n+" j"+j);
		for(int pre:presIndex){
			if(pre==0){
				res.add(s.substring(0,n));
				System.out.println("aaaa "+s.substring(0,n));
			}
			else{
				//use recursion here
				ArrayList<String> preres = wordBreakHelper(s, pre, pres);
				String suffix = s.substring(pre,n);
				for(String ss: preres){
					res.add(ss + " " + suffix);
				}
				
				
			}
		}
		return res;
		
	}
	 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII o = new WordBreakII();
		String s = "leetcode";
		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		ArrayList<String> res=o.wordBreak2(s, dict);
		System.out.println(res.size());
		for(String st:res){
			System.out.println(st);
		}
		
		

	}

}
