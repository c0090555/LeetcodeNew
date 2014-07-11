/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
import java.util.Arrays;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if (n == 0)
			return res;
		if (n == 1)
			return new int[][] {{1}};
		for (int[] rol : res) {
			Arrays.fill(rol, -1);
		}

		int currDirect = 0;//0,1,2,3 stand for four directions
		int r = 0;
		int c = 0;
		for (int i = 1; i <= n * n; i++) {
			res[r][c] = i;
			//System.out.println(" r "+r+" c "+c+ " i "+i);
			switch (currDirect) {
			case 0:// move right
				if (c >= n - 1 || res[r][c + 1] != -1) {
					currDirect = (currDirect + 1) % 4;
					r++;//!!!need to switch to move down
				} else {
					c++;
				}
				break;
			case 1:// move down
				if (r >= n - 1 || res[r + 1][c] != -1) {
					currDirect = (currDirect + 1) % 4;
					c--;
				} else {
					r++;
				}
				break;
			case 2:// move left
				if (c <= 0 || res[r][c - 1] != -1) {
					currDirect = (currDirect + 1) % 4;
					r--;
				} else {
					c--;
				}
				break;
			case 3:// move up
				if (r <= 0 || res[r - 1][c] != -1) {
					currDirect = (currDirect + 1) % 4;
					c++;
				} else {
					r--;
				}
				break;
			default:
				break;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII o = new SpiralMatrixII();
		int n =1;
		int[][] res = o.generateMatrix(n);
		for(int[] rol:res){
			for(int e : rol)
				System.out.print(e + " ");
			System.out.println();
		}
	}

}
