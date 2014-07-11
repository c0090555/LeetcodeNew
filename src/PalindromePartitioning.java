/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * 
 * 
 */
import java.util.*;

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

		
		
		if (s == null || s.length() == 0) {
			return res;
		}
		ArrayList<String> sol = new ArrayList<String>();
		 partitionDFS(s,0,sol,res);
		return res;

	}

	public void partitionDFS(String s, int start, ArrayList<String> sol,ArrayList<ArrayList<String>> res){
		//termination condition
		if(start>=s.length()){
			res.add(new ArrayList<String>(sol));//make a copy and add the copy to the result
			return;
		}
		else{
			for(int end=start;end<s.length();end++){
				if(isPalindrome(s, start, end)){
					sol.add(s.substring(start,end+1));
					partitionDFS(s,end+1,sol,res);
					sol.remove(sol.size()-1);//key part: need to restore sol
					
					
				}
				
			}
			
			return;
		}	
	
	}

	public boolean isPalindrome(String s, int b, int e) {
		if(b>e||b<0||e>=s.length()){
			return false;
		}
		while(b<e){
			if(s.charAt(b)!=s.charAt(e))
				return false;
			b++;
			e--;
		}
		
		return true;
	}

	public void partitionHelper(String s, ArrayList<ArrayList<String>> res) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "seeslaveidemonstrateyetartsnomedievalsees";
		String s="ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk";
		PalindromePartitioning o = new PalindromePartitioning();
		ArrayList<ArrayList<String>> res = o.partition(s);
		for (int i = 0; i < res.size(); i++) {
			ArrayList<String> e = res.get(i);
			System.out.println("res ");
			for (String st : e) {
				System.out.print(st + " ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
