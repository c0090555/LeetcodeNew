package OtherProblems;
import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonSubsequenceVariants {
/*
Introduction to algorithms 15.4
Show how to compute the length of an LCS using only 2*min(m,n) entries in the c table plus O(1) additional space. 
Then show how to do this using min(m,n) entries plus O(1) addition space.
 */
//using only 2*min(m,n) entries in the c table plus O(1) additional space
	public int getLCS1(String a, String b){ //Time Complexity: O(m*n)
		//skip edge cases
		int m = a.length();
		int n = b.length();
		int k = Math.min(m, n);
		if (m < n){//make sure b is the shorter string
			String temp = b;
			b = a;
			a = temp;
			m = a.length();
			n = b.length();
		}
		int[] curr = new int[k];
		int[] next = new int[k];
		//initialize first row
		for (int j = 0; j < n; j++){
			curr[j] = b.charAt(j) == a.charAt(0) ? 1 : 0;
		}
		for (int i = 1; i < m; i++){
			char c = a.charAt(i);
			Arrays.fill(next, 0);//clear next
			for (int j = 0; j < n; j++){
				if (c == b.charAt(j))
					next[j] = j==0? 1:(next[j-1]+1);
				else{
					next[j] = j==0? curr[j] : Math.max(next[j-1], curr[j]);
				}
			}
			curr = Arrays.copyOf(next, k);
		}
		return curr[k-1];
	}
	
	//using min(m,n) entries plus O(1) addition space.
	public int getLCS2(String a, String b){ //Time Complexity: O(m*n)
		//skip edge cases
		int m = a.length();
		int n = b.length();
		int k = Math.min(m, n);
		if (m < n){//make sure b is the shorter string
			String temp = b;
			b = a;
			a = temp;
			m = a.length();
			n = b.length();
		}
		int[] curr = new int[k];
		//initialize curr
		for (int j = 0; j < n; j++){
			curr[j] = a.charAt(0) == b.charAt(j) ? 1 : 0;
		}
		for (int i = 1; i < m; i++){
			char c = a.charAt(i);
			for (int j = 0; j < n; j++){
				if (c == b.charAt(j)){
					curr[j] = j==0 ? 1 : (curr[j-1] + 1);
				} else{
					if (j > 0)
						curr[j] = Math.max(curr[j], curr[j-1]);
				}
			}
		}
		return curr[k-1];
	}
//15.4-3 Give a memorized version of LCS-LENGTH that runs in O(m*n) time
	public int getLCS(String a, String b){
		if (a.length() == 0 || b.length() == 0)
			return 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return getLCSWithMemorization(a, a.length()-1, b, b.length()-1, map);
			
			
	}
	public int getLCSWithMemorization(String a, int ai, String b, int bi,HashMap<String, Integer> map){
		if (ai < 0 || bi < 0)
			return 0;
		String code = hashCode(ai, bi);
		if (map.containsKey(code))
			return map.get(code);
		int res = 0;
		if (a.charAt(ai) == b.charAt(bi)){
			res = 1 + getLCSWithMemorization(a, ai-1, b, bi-1, map);
		} else{
			res = Math.max(getLCSWithMemorization(a, ai-1, b, bi, map), getLCSWithMemorization(a, ai, b, bi-1, map));
		}
		map.put(code, res);
		return res;
	}
	public String hashCode(int ai, int bi){
		//encode
		return "a"+String.valueOf(ai)+"b"+String.valueOf(bi);
	}
	
	public static void main(String[] args){
		LongestCommonSubsequenceVariants o = new LongestCommonSubsequenceVariants();
		String a = "";
		String b = "";
		System.out.format("res: %s",o.getLCS(a, b));
	}
}
