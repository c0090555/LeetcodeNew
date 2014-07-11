package ITint5;

public class GridVisit {

	 public boolean existPath(int[] x, int[] y) {
	        int n = x.length;
	        if (n != y.length)
	            return false;
	        if (n <= 1)
	            return true;
	        int prev = 0;
	        int dx = x[1] - x[0];
	        int dy = y[1] - y[0];
	        if (dx != 0 && dy != 0)
	                return false;
	        else 
	            if(dx == 0 && dy == 0)
	                 return false; 
	        else 
	            if (dx == 0)
	                prev = 1;
	        else
	                prev = -1;
	            
	          
	       for (int i = 2; i < n; i++){
	            dx = x[i] - x[i-1];
	            dy = y[i] - y[i-1];
	            if (dx != 0 && dy != 0)
	                return false;
	            else 
	                if(dx == 0 && dy == 0)
	                    return false; 
	            else 
	                if (dx == 0){
	                	if (prev != -1)
	                		return false;
	                	prev = 1;
	                }
	                    
	            else{
	            	if (prev != 1)
	            		return false;
	            	prev = -1;
	            }
	        }
	        
	        return true;
	    }
	 public static void main(String[] args){
		 int[] x = {0,0,0,0,2,2,4,4};
		 int[] y = {1,3,5,6,3,6,3,5};
		 GridVisit o = new GridVisit();
		 System.out.println(o.existPath(x, y));
	 }
}
