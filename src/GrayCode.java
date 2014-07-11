/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

Note: reuse (n-1) case
 * 
 */
import java.util.ArrayList;
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		sol.add(0);
		if (n <= 0)
			return sol;
		sol.add(1);		
		if (n == 1){
			return sol;
		}
		for (int i = 2; i <= n; i++){
			ArrayList<Integer> newSol = new ArrayList<Integer>();
			for(int e : sol){
				newSol.add(e);				
			}
			for(int j = sol.size()-1; j >= 0; j--){
				int k = sol.get(j);
				newSol.add(k | (1<<(i-1)));
			}
			sol = newSol;
		}
		return sol;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
