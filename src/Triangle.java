/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Discuss

 
 create a Hashtable<Integer, Integer> to hash index to its relevant current minimum path sum
 */
import java.util.ArrayList;
import java.util.Hashtable;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0){
        	return 0;
        }        
        
        
        Hashtable<Integer, Integer> preRowSum = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> curRowSum = new Hashtable<Integer, Integer>();
        ArrayList<Integer> curRow = triangle.get(0);
        preRowSum.put(0, curRow.get(0));
        
        //process level by level
        for (int i = 1; i < n; i++){
        	curRowSum = new Hashtable<Integer, Integer>();
        	curRow = triangle.get(i);//this row has i+1 elements
        	for (int j = 0; j <= i; j++){
        		int newVal;
        		if (j == 0){//edge element
        			newVal = preRowSum.get(0) + curRow.get(0);
        		}
        		else if (j == i){//edge element
        			newVal = preRowSum.get(i-1) + curRow.get(j);
        		}
        		else{//middle elements
        			newVal = Math.min(preRowSum.get(j-1), preRowSum.get(j)) + curRow.get(j);    

        		}
    			curRowSum.put(j, newVal);

        	}
        	preRowSum = curRowSum;
        	
        	
        }
        
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++)
        	min = Math.min(preRowSum.get(k), min);
        return min;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub//[[-1],[2,3],[1,-1,-1]]

		Triangle o = new Triangle();
		ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(-1);
		t.add(r);
		r = new ArrayList<Integer>();
		r.add(2);
		r.add(3);
		t.add(r);
		r = new ArrayList<Integer>();
		r.add(1);
		r.add(-1);
		r.add(-1);
		t.add(r);
		System.out.println(t);
		
		System.out.println(o.minimumTotal(t));
	}

}
