/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.ArrayList;
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> curRow = new ArrayList<Integer>();
    	if (rowIndex < 0)
        	return curRow;
        ArrayList<Integer> preRow = new ArrayList<Integer>();
        curRow.add(1);
        preRow = curRow;

        for (int i = 1; i <= rowIndex; i++){
        	curRow = new ArrayList<Integer>();
        	for (int j = 0; j <= i; j++){
        		if (j == 0 || j == i)
        			curRow.add(1);
        		else{
        			int newVal = preRow.get(j - 1) + preRow.get(j);
        			curRow.add(newVal);
        		}
        	}
        	preRow = curRow;
        }
    	return curRow;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
