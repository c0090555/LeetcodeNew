/*
Given an expression like {a, {b, c}, {{d}, e, f}}
Output: a + 2 * (b + c) + 3 * d + 2 * (e + f)

level sum，一个多重nested array，例如{a,{b,c},{{d},e}}，返回level sum = a + 2 * (b + c) + 3 * d + 2 * e。
 
incompleted...
 * 
 * 
 */
public class LevelSum {
	public int levelSum(String st){
		if (st == null || st.length() == 0)
			return -1;
		int w = 1;//weight
		int i = 0;
		int sum = 0;
		while (i < st.length()){
			char c = st.charAt(i);
			if (c == '{'){
				w++;
			}
			else if(c == '}'){
				w--;
			}
			else if(c == ','){
				continue;
			}
			else{
				int val;
			}
			
		}
		return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
