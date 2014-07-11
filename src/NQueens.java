/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
import java.util.ArrayList;
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	if (n == 0){
    		return res;
    	}
    	int[] sol = new int[n];//key part
    	placeQueen(n, sol, 0, res);
    	return res;
    }
    
    //place queen
    public void placeQueen(int n, int[] sol, int r,ArrayList<String[]> res){
    	if(r>=n){
    		String[] placement = transform(sol);
    		res.add(placement);
    		return;
    	}
    	for (int j = 0; j < n; j++){
    		if (feasible(sol, r, j)){
    			sol[r] = j;
    			placeQueen(n, sol, r+1, res);
    		}
    	}
    	
    }
    //check if feasible
    public boolean feasible(int[] sol, int r, int c){
    	for(int i=0; i < r; i++){
    		if (sol[i] == c)//check column
    			return false;
    		if (r - i == Math.abs(c - sol[i])){//check diagonal 
    			return false;
    		}
    	}
    	return true;
    }
    
    
    //transform
    public String[] transform(int[] sol){
    	String[] placement = new String[sol.length];
    	for (int i = 0; i < sol.length; i++){
    		StringBuilder row = new StringBuilder();
    		for (int j = 0; j < sol.length; j++){
    			if (j == sol[i]){
    				row.append('Q');
    			} else{
    				row.append('.');
    			}
    		}
    		placement[i] = row.toString();
    	}
    	return placement;
    }
    
    public ArrayList<String[]> solveNQueens2(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n == 0){
            return res;
        }
        int[] sol = new int[n];//!!!key part: sol[i] indicates we place a queen at row i & column sol[i]
        placeQueen2(sol, 0, res);
        return res;
    }
    public void placeQueen2(int[] sol, int r, ArrayList<String[]> res){
        if (r >= sol.length){
            String[] layout = transform(sol);
            res.add(layout);
        }
        for (int j = 0; j < sol.length; j++){
            if (isValid(sol, r, j)){
                sol[r] = j;
                placeQueen2(sol, r+1, res);
                sol[r] = -1;
            }
        }
            
    }
    
    public boolean isValid(int[] sol, int r, int c){
        for (int i = 0; i <= r-1; i++){
            if (sol[i] == c)
                return false;
            if (Math.abs(sol[i]-c) == r - i)
                return false;
        }
        return true;
    }
    
    public String[] transform2(int[] sol){
        String[] layout = new String[sol.length];
        int i = 0;
        for (int c : sol){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sol.length; j++){
                if (j != c)
                    sb.append('.');
                else
                    sb.append('Q');
            }
            layout[i] = sb.toString();
            i++;
        }
        return layout;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens o = new NQueens();
		int n = 1;
		ArrayList<String[]> res = o.solveNQueens2(n);
		System.out.println(res);
		int j =0;
	}

}
