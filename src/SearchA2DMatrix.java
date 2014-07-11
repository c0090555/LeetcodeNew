/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.


Note: search from right upper corner


method 2: use two binary searches, first binary search to locate the row, then the second binary search to locate the column
idea comes from: http://fisherlei.blogspot.com/2013/03/leetcode-search-2d-matrix-solution.html
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	if (m == 0) return false;
    	int n = matrix[0].length;
    	if (n == 0) return false;
    	int i = 0;
    	int j = n - 1;
    	while (i >= 0 && i <= m-1 && j >= 0 && j <= n-1){
    		if (target == matrix[i][j])
    			return true;
    		else if (target > matrix[i][j]){
    				i++;
    		}
    		else {
    			j--;
    		}
    	}
    	return false;
    }
    
    //method 2
    public boolean searchMatrix2(int[][] matrix, int target){
    	int m = matrix.length;
    	if (m == 0) return false;
    	int n = matrix[0].length;
    	if (n == 0) return false;
       	if (target < matrix[0][0])//!!!important: for initial check
    	    return false;
    	
    	int start = 0;
    	int end = m - 1;
    	while (start <= end){
    		int mid = start + (end - start)/2;
    		if (matrix[mid][0] == target)
    			return true;
    		else if (target > matrix[mid][0]){
    			start = mid + 1;
    		}
    		else {
    			end = mid - 1;
    		}
    	}
    	
    	int endRow = end;
    	start = 0;
    	end = n - 1;
    	while (start <= end){
    		int mid = start + (end - start)/2;
    		if (target == matrix[endRow][mid])
    			return true;
    		else if (target > matrix[endRow][mid])
    			start = mid + 1;
    		else {
    			end = mid - 1;
    		}
    	}
    	return false;
    }
    public static void main(String[] args){
    	SearchA2DMatrix o = new SearchA2DMatrix();
    	int[][] matrix = {{1}};
    	int target = 0;
    	System.out.println(o.searchMatrix2(matrix, target));
    }
}
