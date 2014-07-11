/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
Slope + Intercept

Note: Use slope to determine a line & Set an anchor point
need to pay attention to the case when two points on the same vertical line
 */
import java.util.Hashtable;

class Point{
	int x,y;
	Point(){
		x=0;y=0;
	}
	Point(int a, int b){
		x=a;y=b;
	}
}

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
    	if(points.length <= 2){
    		return points.length;
    	}
    	int globalMax = 2;
    	for(int i = 0; i < points.length - 1; i++){
    		Hashtable<Double, Integer> count = new Hashtable<Double, Integer>();
    		int samePointCount = 1;
    		int localMax = 0;
    		double slope = 0.0;
    		for(int j = i + 1; j < points.length; j++){
    			if(points[i].x == points[j].x && points[i].y == points[j].y){//same points
    				samePointCount++;
    			}
    			else{
    				if(points[i].x != points[j].x){
    					slope = (double)(points[j].y - points[i].y)/(points[j].x - points[i].x);
    					slope = slope + 0.0;
    					if(!count.containsKey(slope)){
    						count.put(slope, 1);
    					}
    					else{
    						int n = count.get(slope);
    						n++;
    						count.put(slope, n);
    					}
    				}
    				else{
    					slope = Double.MAX_VALUE;
    					if(!count.containsKey(slope))
    						count.put(slope, 1);
    					else{
    						int n = count.get(slope);
    						n++;
    						count.put(slope, n);
    					}
    				}
    				
    				
    			}

    		}
    		for(double key: count.keySet()){
    			if(count.get(key)>localMax)
    				localMax = count.get(key);
    		}
    		if(samePointCount + localMax > globalMax)
    			globalMax = samePointCount + localMax;
    	}
    	
    	return globalMax;
    	
    }
    
    public static void main(String[] args){
    	MaxPointsOnALine o = new MaxPointsOnALine();
    	Point[] points = new Point[3];
    	points[0] = new Point(4,0);
    	points[1] = new Point(4,-1);
    	points[2] = new Point(4,5);
    	System.out.println(o.maxPoints(points));
    }
    
//    [(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]

    
    
}
