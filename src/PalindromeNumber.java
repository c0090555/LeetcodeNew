import java.math.BigInteger;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x == 0)
			return true;
		if(x < 0)
			x = -x;
		int saveX = x;
		long res  = 0;
		while(x > 0){
			int residue =x%10;
			x /= 10;
			res *= 10;
			res += residue;
		}
		
		//System.out.println("res "+res);
		System.out.println(x);
		if ((int)res == saveX) 
			return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber o = new PalindromeNumber();
		int x =1;
		System.out.println(o.isPalindrome(x));
	}

}
