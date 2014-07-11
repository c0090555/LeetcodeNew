/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

idea from: http://rafal.io/posts/leetcode-6-zigzag-conversion.html
Note: characters go into rows in this order 1,2,..n,n-1,n-2...2,1,2,...n, we just need to track this row change
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows <= 1)
			return s;
		int n = s.length();
		int row = 0;
		boolean flag = false;//!!!the start value of flag should be false since it will be flagged immediately at row 0
		StringBuilder[] rows = new StringBuilder[nRows];
		for(int j = 0; j < nRows; j++){
			rows[j] = new StringBuilder();
		}
		for (int i = 0; i < n; i++){
			rows[row].append(s.charAt(i));
			if (row == 0 || row == nRows-1)
				flag = !flag;
					
			if (flag){
				row++;
			} else{
				row--;
			}
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < nRows; i++){
			res.append(rows[i]);
		}
		return res.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion o = new ZigZagConversion();
		int nRows = 2;
		String s = "helloworld";
		System.out.println(o.convert(s, nRows));
	}

}
