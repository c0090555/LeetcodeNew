/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 */
import java.util.ArrayList;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new ArrayList<String>();
		if (words == null || words.length == 0 || L == 0){
			String line = new String();
			res.add(line);
			return res;
		}
		int size = 0;
		int start = 0;
		for (int i = 0; i < words.length; i++){
			size += words[i].length();
			if (size > L){
				String line = padString(words, start, i-1, L);
				//System.out.println(line);
				res.add(line);
				size = words[i].length();
				start = i;
			}
			size++;
			
		}
		//process end part
		StringBuffer sb = new StringBuffer();
		int curLen = 0;
		String extraPad = createPad(1);
		for (int i = start; i < words.length; i++){
			sb.append(words[i]);
			curLen+=words[i].length();
			if (i != words.length - 1){
				sb.append(extraPad);
				curLen++;
			}			
		}
		extraPad = createPad(L - curLen);
		sb.append(extraPad);
		
		res.add(sb.toString());
		return res;
		
   }
	
	public String padString(String[] words, int start, int end, int targetLen){
		if (start > end)
			return null;
		StringBuffer sb = new StringBuffer();
		
		if (start == end){
			sb.append(words[start]);
			String pad = createPad(targetLen - words[start].length());
			sb.append(pad);
			return sb.toString();
		}
		
		int curLen = 0;
		for (int i = start; i <= end; i++)
			curLen += words[i].length();
		int diff = targetLen - curLen;
		int gap = diff / (end - start);
		int extraGap = diff % (end - start);
		String extraPad = createPad(1);

		for (int i = start; i <= end; i++){
			sb.append(words[i]);
			if (i != end){
				String pad = createPad(gap);
				sb.append(pad);
				if (extraGap > 0){
					sb.append(extraPad);
					extraGap--;
				}
			}
		}
		System.out.println(sb);
		return sb.toString();
		
		
	}
	public String createPad(int num){
		StringBuffer sb = new StringBuffer();
		while (num > 0){
			sb.append(' ');
			num--;
		}
		return sb.toString();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification o = new TextJustification();
		String[] words = {"a","b","c","d","e"};
		int L = 3;
		System.out.println(o.fullJustify(words, L));

	}

}
