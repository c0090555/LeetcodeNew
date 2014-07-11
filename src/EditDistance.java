/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

idea from: http://www.cnblogs.com/feiling/p/3272872.html

DP - int[][] ed : ed[i][j] represent word1 at length i & word2 at length j
Base Condition: ed[0][0]=0; ed[0][j]=j;ed[i][0]=i;
Recursive Relation: 
ed[i][j] = 
1. if word1.charAt(i-1) ==  word2.charAt(j-1), then ed[i][j] = ed[i-1][j-1]
2. if word1.charAt(i-1) != word2.charAt(j-1), then ed[i][j] = minimum of {1+ed[i-1][j],1+ed[i][j-1], 1+ed[i-1][j-1]) 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][]ed = new int[m+1][n+1];
		//base condition
		for (int i = 1; i <= m; i++)
			ed[i][0] = i;		
		for (int j = 1; j <= n; j++)
			ed[0][j] = j;
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				char c1 = word1.charAt(i-1);
				char c2 = word2.charAt(j-1);
				if (c1 == c2){
					ed[i][j] = ed[i-1][j-1];
				} else{
					ed[i][j] = 1 + Math.min(ed[i-1][j], Math.min(ed[i][j-1], ed[i-1][j-1]));
				}
			}
		}
		return ed[m][n];
	}	

	

	public static void main(String[] args) {
		EditDistance o = new EditDistance();
		String word1 = "work";
		String word2 = "word";
		int r = o.minDistance(word1, word2);
		System.out.println(r);

	}
}
