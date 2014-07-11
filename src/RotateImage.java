/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?


Note: need to distribute four directions' elements evenly

 
Follow up:
What if we need to rotate a M*N image? 
Offset
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1)
			return;

//process from outer side to inner side - need to process from layer 0 to layer (n/2) - 1
		for (int layer = 0; layer < n/2; layer++){
			//locate first and last element in this layer
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++){//!!here we need i < last to distribute four directions' elements evenly
				int offset = i -  first;
				//save top
				int temp = matrix[layer][first + offset];
				//left -> top
				matrix[layer][first + offset] = matrix[last - offset][layer];
				//bottom -> left
				matrix[last - offset][layer] = matrix[n-1-layer][last - offset];
				//right -> bottom
				matrix[n-1-layer][last - offset] = matrix[first + offset][n-1-layer];
				//top -> right
				matrix[first + offset][n-1-layer] = temp;
			}
			
		}
		
		

	}
	public static void main(String[] args){
		RotateImage o = new RotateImage();
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		o.rotate(matrix);
		for(int[] row : matrix){
			for(int e : row){
				System.out.print(" "+e);
			}
			System.out.println();
		}
	}
}
/*
 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25


1  2  3  4
5  6  7  8
9 10 11 12



*/