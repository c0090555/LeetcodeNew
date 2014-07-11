/*
Implement pow(x, n).


implement O(n) methods

method 1: recursive method
method 2: recursive method
 */
public class Power {
	//method 1
	 public double pow(double x, int n) {
	       if (x == 0)
	    	   return 0;
	       if (n == 0)
	    	   return 1;
	       if (n == 1)
	           return x;
	       double result = Math.abs(x);
	       double absX = result;
	       
	       int absN = Math.abs(n);
	       int absN2 = absN;
	       
	       int k = 1;
	       while (absN / 2 > 0){
	    	   result = result * result;
	    	   absN = absN / 2;
	    	   k = k * 2;
	       }

	       if (absN2 > k){//absN is odd
	    	   result *= pow(absX, absN2 - k);	    	   
	       }	    	   

	       if (x < 0 && n % 2 == 1){	    	
	    	   result = (-1)*result;
	       }
	       if (n < 0)
	    	   result = 1/result;
		   
	       return result;
	    }
	 
	 //method 2
	 double power(double x, int n){
		 if (n == 0)
			 return 1;
		 double v = power(x, n/2);
		 
		 if (n % 2 == 1)
			 return  v * v * x;
		 else
			 return v * v;
		 
		 
	 }
	 double pow2(double x, int n){
		 if (x == 0)
			 return 0;
		 if (n < 0)
			 return 1/power(x, -n);
		 else 
			 return power(x,n);
	 }
	 
	 
	 public static void main(String[] args){
		 Power o = new Power();
		 double x  = 4.709758;
		 int n = -6;
		 o.pow(x, n);
		 //4.70975, -6


	 }
}
