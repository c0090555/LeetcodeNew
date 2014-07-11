package ITint5;

public class MinAllOne {
	 public int findMinAllOne(int a) {
	        if (a == 0)
	            return -1;
	        double product = 1;

	        for (int d = 1; d <= 38; d++){
	            if (product/a == (int)product/a){
	                return d;
	            }
	            product *= 10;
	            product++;
	        }   
	        return -1;
	    }
	 public static void main(String[] args){
		 int a = 1017;
		 MinAllOne o = new MinAllOne();
		 System.out.println(o.findMinAllOne(a));
	 }
}
