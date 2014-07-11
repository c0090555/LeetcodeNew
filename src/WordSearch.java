/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int p = board.length; 
        if (p == 0)
        	return false;
        int q = board[0].length;
        if (q == 0)
        	return false;
        boolean[][]visit= new boolean[p][q];
        boolean[] res = new boolean[1];
        for (int i = 0; i < p; i++){
        	for (int j = 0; j < q; j++){
        		if(board[i][j]==word.charAt(0)){
        			visit[i][j] = true;
        			res[0] |=dfs(board, visit, word, i, j, 0, res);
        			if(res[0])
        				return res[0];
        			visit[i][j] = false;
        		}
        	}
        }
        return res[0];
    }
    public boolean dfs(char[][] board, boolean[][] visit, String word, int row, int col, int step, boolean[] res){
    	int n = word.length();
    	if (step == n-1 || res[0]){//!!!key part: if res[0] == true, then we have already found a workable solution, no need to go to other branches
    		return true;
    	}
    	int p = board.length;
    	int q = board[0].length;
    	
    	
    	//try four directions
    	step++;
    	if (row - 1 >= 0&&!visit[row-1][col]&&word.charAt(step)==board[row-1][col]){
    		visit[row-1][col] = true;
    		res[0]|=dfs(board, visit, word, row-1, col, step, res);
    		visit[row-1][col] = false;
    	}
       	if (row + 1 < p &&!visit[row+1][col]&&word.charAt(step)==board[row+1][col]){
    		visit[row+1][col] = true;
    		res[0]|=dfs(board, visit, word, row+1, col, step, res);
    		visit[row+1][col] = false;
    	}
       	if (col - 1 >= 0&&!visit[row][col-1]&&word.charAt(step)==board[row][col-1]){
    		visit[row][col-1] = true;
    		res[0]|=dfs(board, visit, word, row, col-1, step, res);
    		visit[row][col-1] = false;
    	}
       	if (col + 1 < q &&!visit[row][col+1]&&word.charAt(step)==board[row][col+1]){
    		visit[row][col+1] = true;
    		res[0]|=dfs(board, visit, word, row, col+1, step, res);
    		visit[row][col+1] = false;
    	}
    	return res[0];
    		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch o = new WordSearch();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
		String word = "ACED";
		System.out.println(o.exist(board, word));
	}

}
