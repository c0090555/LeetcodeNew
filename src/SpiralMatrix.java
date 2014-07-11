/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Note: use a direction array to indicate the current direction
!!! wrong anwser
 */
import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0)
			return res;
		int n = matrix[0].length;
		if (n == 0)
			return res;
		boolean[][] visit = new boolean[m][n];
		int currDirect = 0;
		int i = 0;
		int j = 0;
		for (int step = 1; step <= m * n; step++) {
			visit[i][j] = true;
			res.add(matrix[i][j]);
			switch (currDirect) {
			case 0://move right
				if (j >= n - 1 || visit[i][j + 1]) {
					currDirect = 1;
					i++;
				}
				else{
					j++;
				}
				break;
			case 1://move dnow
				if (i >= m-1 || visit[i+1][j]){
					currDirect = 2;
					j--;
				}
				else{
					i++;
				}
				break;
			case 2://move left
				if (j <= 0 || visit[i][j-1]){
					currDirect = 3;
					i--;
				}
				else{
					j--;
				}
			break;
			case 3://move up
				if(i<=0 || visit[i-1][j]){
					currDirect = 0;
					j++;
				} else{
					i--;
				}
			break;
			default: 
			break;
			}
		}
		return res;
	}
	  public ArrayList<Integer> spiralOrder2(int[][] matrix) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        int m = matrix.length;
	        if (m == 0)
	            return res;
	        int n = matrix[0].length;
	        if (n == 0)
	            return res;
	        int direct = 0;//0 right, 1 down, 2 left, 3 up
	        int r = 0;
	        int c = 0;
	        for (int step = 1; step <= m * n; step++){
	            res.add(matrix[r][c]);
	            matrix[r][c] = Integer.MIN_VALUE;
	            switch (direct){
	                case 0:
	                    if (c == n-1 || matrix[r][c+1] == Integer.MIN_VALUE){
	                        direct = 1;
	                        r++;//!!key part
	                    }
	                    else{
	                        c++;
	                    }
	                break;
	                case 1:
	                    if (r == m-1 || matrix[r+1][c] == Integer.MIN_VALUE){
	                        direct = 2;
	                        c--;
	                    }
	                    else{
	                        r++;
	                    }
	                break;
	                case 2:
	                    if (c== 0 || matrix[r][c-1] == Integer.MIN_VALUE){
	                        direct = 3;
	                        r--;
	                    }
	                    else{
	                        c--;
	                    }
	                break;
	                case 3:
	                    if (r== 0 || matrix[r-1][c] == Integer.MIN_VALUE){
	                        direct = 0;
	                        c++;
	                    }
	                    else{
	                        r--;
	                    }
	                break;
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix o = new SpiralMatrix();
		int[][] matrix = { { 1,2,3},{4,5,6} };
		ArrayList<Integer> res = o.spiralOrder2(matrix);
		for (int r : res)
			System.out.println(r);
	}

}
