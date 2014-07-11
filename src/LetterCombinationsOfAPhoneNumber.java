/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
import java.util.HashMap;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		if (digits.length() == 0){
		    res.add("");
			return res;
		}
		HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
		for (int i = 2; i <= 6; i++) {
			char c = (char) ('2' + i - 2);
			char p = (char) ('a' + (i - 2) * 3);
			ArrayList<Character> val = new ArrayList<Character>();
			val.add(p);
			val.add((char) (p + 1));
			val.add((char) (p + 2));
			map.put(c, val);
		}
		ArrayList<Character> val = new ArrayList<Character>();

		for (char c = '7'; c <= '9'; c++) {
			val = new ArrayList<Character>();
			char start = ' ';
			char end = ' ';
			if (c == '7') {
				start = 'p';
				end = 's';
			}
			if (c == '8') {
				start = 't';
				end = 'v';
			}
			if (c == '9') {
				start = 'w';
				end = 'z';
			}
			for (char p = start; p <= end; p++)
				val.add(p);
			map.put(c, val);
		}
		char c = '0';
		val = new ArrayList<Character>();
		val.add(' ');
		map.put(c, val);

		res = letterCombinationsHelper(digits, 0, map, res);

		return res;
	}

	public ArrayList<String> letterCombinationsHelper(String digits, int index,
			HashMap<Character, ArrayList<Character>> map, ArrayList<String> res) {
		if (index >= digits.length())
			return res;
		char curr = digits.charAt(index);
		if (!map.containsKey(curr)) {
			return letterCombinationsHelper(digits, index + 1, map, res);
			
		}
		ArrayList<String> next = new ArrayList<String>();
		if (res.isEmpty()) {
			ArrayList<Character> val = map.get(curr);
			for (char v : val) {
				StringBuilder sb = new StringBuilder();
				sb.append(v);
				next.add(sb.toString());
			}
		} else {
			for (String st : res) {
				ArrayList<Character> val = map.get(curr);
				for (char v : val) {
					StringBuilder sb = new StringBuilder(st);
					sb.append(v);
					next.add(sb.toString());
				}
			}
		}
		res = next;
		return letterCombinationsHelper(digits, index + 1, map, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfAPhoneNumber o = new LetterCombinationsOfAPhoneNumber();
		String digits = "222";
		o.letterCombinations(digits);
	}

}
