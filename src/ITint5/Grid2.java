package ITint5;
public class Grid2 {
	 static class TrieNode{
		boolean end;
		TrieNode[] children;
		TrieNode(){
			end = false;
			children = new TrieNode[26];
		}
		public static void add(TrieNode root, String word, int index){
			if (index >= word.length())
				return;
			if (index == word.length()-1){
				root.end = true;
			}
			if (root.end)
				return;
			char c = word.charAt(index);
			if (root.children[c-'A'] == null)
				root.children[c-'A'] = new TrieNode();
			add(root.children[c-'A'], word, index+1);
		}
	}

    public boolean exists(char[][] grid, String[] patterns) {
    	int n = grid.length;
    	if (n == 0) return false;
    	int m = grid[0].length;
    	if (m == 0) return false;
    	int k = patterns.length; 
    	if (k == 0) return true;
    	//construct trie
    	TrieNode root = new TrieNode();
    	for (String pattern : patterns)
    		TrieNode.add(root, pattern, 0);
    	boolean[][] visit = new boolean[n][m];
    	for (int i = 0; i < n; i++){
    		for (int j = 0; j < m; j++){
    			if (exists(grid, visit, i, j, root, 0)){
    				return true;
    			}
    		}
    	}
    	return false;

    }
    public boolean exists(char[][] grid, boolean[][] visit, int row, int col, TrieNode root, int index){
		char c= grid[row][col];
		if (root.children[c-'A'] == null)
			return false;
		if (root.end)
			return true;
		int n = grid.length; int m = grid[0].length;
		if (row < 0 || row >= n || col < 0 || col >= m || visit[row][col])
			return false;
		visit[row][col] = true;
		if (exists(grid, visit, row+1, col, root, index+1)||exists(grid, visit, row-1, col, root, index+1)||exists(grid, visit, row, col+1, root, index+1)||exists(grid, visit, row, col-1,root, index+1)){
			return true;
		}
		visit[row][col] = false;
		return false;
	}
    public static void main(String[] args){
    	Grid2 o = new Grid2();
    	char[][] grid = {{'N'}};
    	String[] patterns = {"NYH","M","NAR"};
    	System.out.format("%s", o.exists(grid, patterns));
    }

}