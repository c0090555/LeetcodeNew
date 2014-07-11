/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

Note: use two pointers & two hashmaps
 */
import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int n1 = S.length();
		int n2 = T.length();
		if (n1 == 0 || n2 == 0)
			return new String();
		HashMap<Character, Integer> hashS = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hashT = new HashMap<Character, Integer>();
		// calculate hashT
		for (int j = 0; j < n2; j++) {
			char t = T.charAt(j);
			if (!hashT.containsKey(t))
				hashT.put(t, 1);
			else {
				int countT = hashT.get(t);
				countT++;
				hashT.put(t, countT);
			}
		}

		int minLen = Integer.MAX_VALUE;
		int prev = 0;
		int currLen = 0;
		boolean done = false;
		String minWindow = new String();

		for (int i = 0; i < n1; i++) {
			char s = S.charAt(i);
			if (!hashT.containsKey(s)) {
				continue;
			} else {
				done = true;
				if (!hashS.containsKey(s)) {
					hashS.put(s, 1);
				} else {
					int countS = hashS.get(s);
					countS++;
					hashS.put(s, countS);
				}

				for (char t : hashT.keySet()) {
					if (!hashS.containsKey(t)) {
						done = false;
						break;
					} else {
						int countS = hashS.get(t);
						if (countS < hashT.get(t)) {
							done = false;
							break;
						}
					}
				}

				if (done) {// find all characters of T, try to shrink the size
					for (int k = prev; k <= i; k++) {
						char ps = S.charAt(k);
						if (!hashT.containsKey(ps))// only consider characters
													// from T
							continue;
						else {
							int countS = hashS.get(ps);
							countS--;
							hashS.put(ps, countS);
							if (countS >= hashT.get(ps)) {
								continue;
							} else {
								currLen = i - k + 1;
								if (currLen < minLen) {
									minLen = currLen;
									minWindow = S.substring(k, i + 1);
								}
								prev = k+1;//!!!update prev
								break;
							}
							
						}
					}
				}
			}
		}
		return minWindow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring o = new MinimumWindowSubstring();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		o.minWindow(S, T);
	}

}
