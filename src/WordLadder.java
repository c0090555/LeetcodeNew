/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

Analysis:
the basic idea should be BFS and we should consider this problem as a graph program

Similar Problem: Edit Distance

here have two solutions:
1.BFS: each time we get to a new valid word, let's remove it from dictionary since we only need to return the shorted length
Note: if we need to output all possible shortest paths, then we cannot do this
Note: start and end doesn't have to be in the dictionary

idea comes from: http://blog.csdn.net/zxzxy1988/article/details/8591890


2.double BFS(from two directions)
idea comes from: http://yucoding.blogspot.com/2013/08/leetcode-question-127-word-ladder.html


 */
import java.util.*;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		return ladderLengthBFS(start, end, dict);
	}

	// solution 1
	public int ladderLengthBFS(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}
		// need two queues to check each level
		LinkedList<String> q = new LinkedList<String>();
		LinkedList<String> q2 = new LinkedList<String>();
		q.add(start);
		String cur = q.get(0);
		int step = 1;

		// BFS - one level
		while (!q.isEmpty()) {//!!!Key part: two queues and two while loop
			step++;
			while (!q.isEmpty()) {
				cur = q.remove();
				//System.out.println("cur " + cur);
				for (int i = 0; i < cur.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (cur.charAt(i) == c) {
							continue;
						}
						// get a valid String mutation
						char[] cArray = cur.toCharArray();
						cArray[i] = c;
						String newS = String.copyValueOf(cArray);

						if (end.equals(newS)) {
							return step;
						}

						if (dict.contains(newS)) {
							q2.add(newS); // BFS
							// System.out.println("newS " + newS);
							dict.remove(newS);// remove this String from dict in
												// order to avoid looping
						}
					}

				}
			}
			// System.out.println(q2.size());
			q = (LinkedList<String>) q2.clone();//update q
			// System.out.println("q size " + q.size());
			q2 = new LinkedList<String>();

		}

		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder o = new WordLadder();
		String s = "red";
		String e = "tax";
		HashSet<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");

		System.out.println(o.ladderLength(s, e, dict));
	}

}
