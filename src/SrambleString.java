import java.util.Arrays;

public class SrambleString {
	public boolean isScramble(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if (n1 == 0 || n2 == 0)
			return n1 == n2;
        if (n1 != n2)
            return false;
        if (n1 == 1)//!!base case
            return s1.equals(s2);
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < n1; i++) {
			if (c1[i] != c2[i])
				return false;
		}
		boolean res = false;
		for (int i = 1; i < n1; i++) {
			res |= isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i));
			res |= isScramble(s1.substring(0, i), s2.substring(n2 - i, n2))
					&& isScramble(s1.substring(i, n1), s2.substring(0, n2 - i));
			if (res)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SrambleString o = new SrambleString();
		String s1 = "ab";
		String s2 = "ba";
		System.out.println(o.isScramble(s1, s2));
	}

}
