package ITint5;
/*
 * 有一个n*m的二维整型数组矩阵matrix，计算它的最大子矩阵和（允许子矩阵为空）。

提示：时间复杂度O(n^3)，可以先尝试完成最大连续子段和问题。

idea from: http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
Here we can assume m == n for simplicity, otherwise we need to compare O(m^2*n) and O(m*n^2) and find the minimum

idea: fix left column and right column borders, then calculate the continuous sum in that range, then 
find the max continuous vertical sum
Time Complexity: O(n^3)
 */
import java.util.Arrays;
public class MatrixMaxSum {
	public int maxRectSum(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int max_overall = 0;
		int[] temp = new int[m];
		for (int left = 0; left < n; left++){
			Arrays.fill(temp, 0);
			for (int right = left; right < n; right++){
				for (int i = 0; i < m; i++){
					temp[i] += matrix[i][right];
				}
				int maxTemp = findMaxInOneDimension(temp);
				if (max_overall < maxTemp)
					max_overall = maxTemp;
			}
		}
		return max_overall;
	}
	public int findMaxInOneDimension(int[] arr){
		int n = arr.length;
		if (n == 0)
			return 0;
		int max_overall = 0;
		int max_soFar = 0;
		for (int i = 0; i < n; i++){
			max_soFar += arr[i];
			if (max_soFar < 0)
				max_soFar = 0;
			max_overall = Math.max(max_overall, max_soFar);
		}
		return max_overall;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
