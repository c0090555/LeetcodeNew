/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Note: check rows, columns & squares
 */

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// check rows
		for (int i = 0; i < 9; i++) {
			boolean[] checker = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (checker[board[i][j] - '0' - 1])
						return false;
					else
						checker[board[i][j] - '0' - 1] = true;
				}
			}
		}
		//check columns
		for (int j = 0; j < 9; j++){
			boolean[] checker = new boolean[9];
			for (int i = 0; i < 9; i++){
				if (board[i][j] != '.'){
					if (checker[board[i][j] - '0' - 1]){
						return false;
					} else
						checker[board[i][j] - '0' - 1] = true;
				}
			}
		}
		//check small squares
		for (int m = 0; m < 3; m++){
			for (int n = 0; n < 3; n++){
				boolean[] checker = new boolean[9];
				for (int i = m * 3; i < m * 3 + 3; i++){
					for (int j = n * 3; j < n * 3 + 3; j++){
						if (board[i][j] != '.'){
							if (checker[board[i][j] - '0' -1])
								return false;
							else
								checker[board[i][j] - '0' -1] = true;
						}
					}
				}
				
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
