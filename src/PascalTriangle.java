/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.ArrayList;
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
        	return res;
        ArrayList<Integer> curRow = new ArrayList<Integer>();
        ArrayList<Integer> preRow = new ArrayList<Integer>();
        curRow.add(1);
        preRow = curRow;
        res.add(curRow);
        for (int i = 1; i < numRows; i++){
        	curRow = new ArrayList<Integer>();
        	for (int j = 0; j <= i; j++){
        		if (j == 0 || j == i)
        			curRow.add(1);
        		else{
        			int newVal = preRow.get(j - 1) + preRow.get(j);
        			curRow.add(newVal);
        		}
        	}
        	res.add(curRow);
        	preRow = curRow;
        }
    	return res;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
