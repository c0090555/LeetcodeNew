/*
Divide two integers without using multiplication, division and mod operator.

Note: here we get a special property: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE
A trick here is to use long notation at the beginning to avoid overflow & avoid get Math.abs(Integer_MIN_VALUE) ==  Integer.MIN_VALUE

Key Idea: Binary Search
 */
public class DivideTwoNumbers {
	//solution 1 - Binary Search
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;//exception case
		if (dividend == 0)
			return 0;
		
		boolean pos = true;//positive or negative
		pos = (dividend > 0)?pos:!pos;
		pos = (divisor > 0)?pos: !pos;
		//since Math.abs(x) == x if x is an integer and x == Intger.MIN_VALUE, for convenience we all use long
		long a = dividend;//use long to avoid overflow & avoid Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE
		long b = divisor;
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		if (a < b){
			return 0;
		}
		int m = 1;		
		long q = b;
		while(q + q <= a ){//!!!binary search
			q = q<<1;
			m = m<<1;
		}
		m += divide((int)(a-q),(int) b);

		if (pos)
			return m;
		else
			return -m;
	}
	//solution 2 - Binary Search + Bit Manipulation
	//key idea: d and res should match
		public int divide2(int dividend, int divisor) {
			if (divisor == 0)
				return Integer.MAX_VALUE;//exception case
			if (dividend == 0)
				return 0;
			long a = Math.abs((long)dividend);
			long b = Math.abs((long)divisor);
			
			long d = b;
			long res= 1;
			while (d <= a){
				d = d << 1;
				res  = res << 1;
			}
			d = d >> 1;
			res = res >> 1;
			long r2 = 0;	
			
			for(;a > 0 ;d=d>>1){
				 while (a >= d){
					 a = a - d;
					 r2 += res;
					// System.out.println(r2);
				 }
				 res = res >> 1;
			}
			return (dividend ^ divisor)>>31 == 0 ? (int)r2:(int)(-r2);
			
		}
	public static void main(String[] args){
		DivideTwoNumbers o = new DivideTwoNumbers();
		int dividend = 6;
		int divisor = 4;
		System.out.println("res "+o.divide2(dividend, divisor));
	}
}
