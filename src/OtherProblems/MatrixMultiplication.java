package OtherProblems;
/*
 * Memorization approach
 */
import java.util.Arrays;
public class MatrixMultiplication {
	public int getMinimumCost(int[][] matrix){
		//skip validation of matrix
		int n = matrix.length;
		int[][] m = new int[n][n];
		for (int[] a : m)
			Arrays.fill(a, Integer.MAX_VALUE);
		return getMin(matrix, m, 0, matrix.length-1);
	}
	public int getMin(int[][] matrix, int[][] m, int start, int end){
		if (m[start][end] != Integer.MAX_VALUE)
			return m[start][end];
		if (start == end){
			m[start][end] = 0;
			return 0;
		}
		for (int k = start; k < end; k++){
			m[start][end] = Math.min(m[start][end], getMin(matrix, m, start, k) + getMin(matrix, m, k+1, end) + matrix[start][0]*matrix[k][1]*matrix[end][1]);
			
		}
		return m[start][end];	
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1,2},{2,10},{10,1}};
		MatrixMultiplication o = new MatrixMultiplication();
		System.out.println(o.getMinimumCost(matrix));
	}
}
