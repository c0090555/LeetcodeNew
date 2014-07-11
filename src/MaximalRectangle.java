/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	int m = matrix.length;
    	if (m == 0)
    		return 0;
    	int n = matrix[0].length;
    	if (n == 0)
    		return 0;
    	int[][] num = new int[m][n];
    	for (int j = 0; j < n; j++)
    		if (matrix[0][j] == '1')
    			num[0][j] = 1;
    	for (int i = 1; i < m; i++){
    		for (int j = 0; j < n ; j++){
    			if (matrix[i][j] == '1'){
    				num[i][j] = num[i-1][j] + 1;
    			}
    			else
    				num[i][j] = 0;
    		}
    	}
    	
    	int max = 0;
    	for (int i =0; i<m; i++){
    		for (int j=0; j<n;j++){
    			if (num[i][j] > 0){
    				int c = j;
    				int minHeight = num[i][c];
    				int width = 1;
    				max = Math.max(minHeight*width, max);
    				while (c>=1 && num[i][c-1] > 0){
    					width++;
    					minHeight = Math.min(minHeight, num[i][c-1]);
    					max = Math.max(max, minHeight*width);
    					c--;
    				}
    			}
    		}
    	}
    	return max;
    }
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        int[][] height = new int[m][n];//!!!height represents the max height of each histogram at each point 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    height[i][j] = ((i==0)? 1 : (height[i-1][j] + 1));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (height[i][j] > 0){
                    int c = j;
                    int h = height[i][j];
                    max = Math.max(max, h);
                    c--;
                    while(c>=0 && height[i][c] > 0){
                        h = Math.min(height[i][c], h);
                        max = Math.max(max, (j-c+1) * h);
                        c--;
                    }
                }
            }
        }
        return max;   
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle o = new MaximalRectangle();
		char[][] matrix = {{'1','1'}};
		o.maximalRectangle2(matrix);
		
	}

}
