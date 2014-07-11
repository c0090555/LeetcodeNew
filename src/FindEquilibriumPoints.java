/*In a 2D matrix of dimensions M*N, find number of "equilibrium" points. 
A point (i, j) is said to be an "equilibrium" point only if all following conditions hold:
a) sum of rows 1...(i-1) =  sum of rows (i+1)...M
b) sum of columns 1...(j-1)  = sum of columns (j+1)...N
*/
public class FindEquilibriumPoints {
	public int findEquilibrium(int[][] matrix){
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (n == 0)
			return 0;
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		for (int i = 0; i < m; i++){
			left[i][0] = 0;
			right[i][n-1] = 0;
			for (int p = 1, q = n -2; p <= n-1 && q >= 0; p++, q--){
				left[i][p] = left[i][p-1] + matrix[i][p];
				right[i][q] = right[i][q+1] + matrix[i][q+1];
			}
		}
		for (int j = 0; j < n; j++){
			up[0][j] = 0;
			down[0][j] = 0;
			for (int p = 1, q = m - 2; p <= m-1 && q >= 0; p++, q--){
				up[p][j] = up[p-1][j] + matrix[p][j];
				down[q][j] = down[q+1][j] + matrix[q][j];
			}
		}
		int num = 0;
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (left[i][j] == right[i][j] && up[i][j] == down[i][j])
					num++;
			}
		}
		return num;
	}
	public static void main(String[] args){
		FindEquilibriumPoints o = new FindEquilibriumPoints();
		int[][] matrix = {{1,1,1},{1,1,1},{1,1,2}};
		System.out.println(o.findEquilibrium(matrix));
	}
}
