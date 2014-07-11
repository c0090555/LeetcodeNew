/*
The set [1,2,3,É,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.ArrayList;

public class PermutationSequence {
	//Solution 1 - DFS TLE
	public String getPermutation(int n, int k) {
		if (k == 0)
			return new String();
		StringBuilder res= new StringBuilder();
		ArrayList<Integer> num=new ArrayList<Integer>();
		for (int i=1; i<= n; i++){
			num.add(i);
		}
		ArrayList<Integer> perm = new ArrayList<Integer>();
		int[] step = new int[1];
		dfs(num, k, step, perm, res);
		return res.toString();
	}

	public void dfs(ArrayList<Integer> num, int k, int[] step, ArrayList<Integer> perm,  StringBuilder res) {
		if (num.isEmpty()) {
			step[0]++;
			if (step[0] == k) {
				for (int n : perm) {
					res.append((char) (n + '0'));
				}
			}
			return;
		}
		for(int i = 0; i < num.size(); i++){
			int m = num.get(i);
			perm.add(m);
			num.remove(i);
			dfs(num, k, step, perm, res);
			num.add(i, m);
			perm.remove(perm.size()-1);
		}
		
	}
	//solution 2: mathematical analysis
	//idea from: http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
	//Note: assume the kth  element is  a1, a2, a3... an, then a1 is determined by k/(n-1)!, similar for a2 
	
	public String getPermutation2(int n, int k) {
		if (k <= 0)
			return new String();
		StringBuilder sb = new StringBuilder();
		boolean[] used = new boolean[11];
		for(int i = 0; i < n; i++){
			int factorial = 1;
			for (int j = 1; j <= n-1-i; j++)
				factorial *= j;
			int ai = (k-1)/factorial + 1;//!!!ai indicates the index in available numbers(start from 1) - use (k-1) instead k as absolute index
			int step = 0;
			for (int m = 1; m <= 10; m++){
				if (!used[m]){
					step++;
					if (step == ai){//find the aith unused number(ai starts from i)
						used[m] = true;
						sb.append((char)(m+'0'));
						break;
					}
						
				}
			}
			k -= (ai-1) * factorial;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence o = new PermutationSequence();
		int  n = 3;
		int k = 1;
		System.out.println(o.getPermutation2(n, k));
	}

}
