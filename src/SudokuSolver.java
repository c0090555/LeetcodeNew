/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
 */
import java.util.Arrays;
import java.util.ArrayList;
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	char[][]board2 = solveSudokuRecur(board,0,0);
    	return ;
    }
    
    public char[][] solveSudokuRecur(char[][] board, int r, int c){
    	int[] position = getNextEmpty(board, r, c);
    	if (position[0] == -1){ 	
    		char[][] copy =(char[][])board.clone();
    		return copy;
    	}
    	else{
    		ArrayList<Integer> avail = findAvail(board, position[0], position[1]);
    		if (avail.isEmpty())
    			return null;
    		for (int a : avail){
    			board[position[0]][position[0]] = (char)(a+'0');
    			if (solveSudokuRecur(board, position[0], position[1]) != null)
    				return solveSudokuRecur(board, position[0], position[1]);
    			board[position[0]][position[0]] ='.';
    		}
    		return null;
    	}
    }
  
    public int[] getNextEmpty(char[][] board, int r, int c){
    	int[] position = new int[2];
    	Arrays.fill(position, -1);
    	position[0] = -1;
    	position[1] =-1;
    	while (r < 9 && c <9){
    		if (board[r][c] == '.'){
    			position[0] = r;
    			position[1] = c;
    			return position;
    		}
    		r = c==8? r+1 : r;
    		c = c==8? 0 : c+1;
    	}
    	return position;
    }
    public ArrayList<Integer> findAvail(char[][] board, int r, int c){
    	ArrayList<Integer> avail = new ArrayList<Integer>();
    	boolean[] checker = new boolean[9];
    	//check rows
    	for (int j = 0; j < 9; j++){
    		if (board[r][j] != '.')
    			checker[board[r][j] - '0' - 1] = true;
    	}
    	//check columns
    	for (int i = 0; i < 9; i++){
    		if (board[i][c] != '.')
    			checker[board[i][c] - '0' - 1] = true;
    	}
    	//check small square
    	int sRow = r / 3;
    	int sCol = c / 3;
    	for (int i = sRow * 3; i < sRow * 3 + 3; i++){
    		for (int j = sCol * 3; j < sCol * 3 + 3; j++){
    			if (board[i][j] != '.')
    				checker[board[i][j] - '0' - 1] = true;
    		}
    	}
    	
    	for (int k = 0; k < 9; k++)
    		if (!checker[k])
    			avail.add(k+1);
    	return avail;
    }
    public static void main(String[] args) {
		SudokuSolver o = new SudokuSolver();
		char[][] b = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		o.solveSudoku(b);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}

}
