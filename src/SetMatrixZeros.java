/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

O(1) solution: reuse the first row and first column as zero indicators

 */
public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		if (n == 0)
			return;
		
		//determine whether we need to set zeros for the first row and the first column
		boolean firstRowZero = false;
		boolean firstColZero = false;
		for (int i = 0; i < m; i++){
			if (matrix[i][0] == 0){
				firstColZero = true;
				break;
			}
		}
		for (int j = 0; j < n; j++){
			if (matrix[0][j]==0){
				firstRowZero = true;
				break;
			}
		}
		
		//!!!leave matrix[0][0] separately since matrix[0][0] will be used for both columns & rows
		//use the first column as indicator column
		for (int i = 1; i < m; i++){
			for (int j = 0; j < n; j++){
				if (matrix[i][j] == 0){
					matrix[i][0] = 0;
					break;
				}
			}
		}
		//use the first row as indicator row
		for (int j = 1; j < n; j++){
			for (int i = 0; i < m; i++){
				if (matrix[i][j] == 0){
					matrix[0][j] = 0;
					break;
				}
			}
		}
		
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if (firstColZero){
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
		if (firstRowZero){
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
