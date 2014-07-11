/*
Extension of DecodeWays: 
Print Out All Decoding Way 
 */
import java.util.ArrayList;
import java.util.HashMap;
public class DecodeWayII {
	public ArrayList<ArrayList<String>> decode(String s){
		int n = s.length();
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (n == 0)
			return res;
		char[] map = new char[27];
		char c = 'A';
		for (int i = 1; i < 27; i++){
			map[i] = c;
			c++;
		}	
		
		HashMap<String, ArrayList<String>> hashM = new HashMap<String, ArrayList<String>>();
		res = decodeDP(s, 0, hashM);
		
			
		return res;
	}
	public ArrayList<ArrayList<String>> decodeDP(String s, int start_index, HashMap<String, ArrayList<String>> map){
		if (start_index < 0){
			return null;
		}
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (start_index == s.length()){
			return res;
		}
		if (s.charAt(start_index) != '0'){
			if (start_index < s.length() - 1 && Integer.parseInt(s.substring(start_index, start_index+2))<=26){
				ArrayList<ArrayList<String>> temp = decodeDP(s, start_index+2, map);
				for (int i = 0; i < temp.size(); i++){
					ArrayList<String> tempSol = temp.get(i);
					tempSol.add(0, s.substring(start_index, start_index + 2));
					res.add((ArrayList)tempSol.clone());
					tempSol.remove(0);
					tempSol.add(0,s.substring(start_index+1, start_index+2));
					tempSol.add(0,s.substring(start_index, start_index+1));
					res.add((ArrayList)tempSol.clone());
				}
			} else{
				ArrayList<ArrayList<String>> temp = decodeDP(s, start_index+2, map);
				for (int i = 0; i < temp.size(); i++){
					ArrayList<String> tempSol = temp.get(i);
					tempSol.add(0,s.substring(start_index+1, start_index+2));
					tempSol.add(0,s.substring(start_index, start_index+1));
					res.add((ArrayList)tempSol.clone());
				}				
			}
			
			
		} else{
			start_index ++;
		}
		
		return res;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> sol = new ArrayList<String>();
		String s = "132";
		DecodeWayII o = new DecodeWayII();
		res = o.decode(s);
		System.out.println(res);
		
	}

}
