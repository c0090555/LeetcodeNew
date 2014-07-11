package ITint5;
/*
数组points包含二维平面上的n个点，找出一条直线使得它穿过的点最多。返回该直线穿过的点的数量。

题目来源：CRACKING THE CODING INTERVIEW 10.6

提示：判断2个浮点数是否相等时，请允许最多1.0e-7的误差范围。

idea from: http://www.itint5.com/discuss/237/%E5%A6%82%E6%9E%9C%E7%94%A8%E6%96%9C%E7%8E%87%E5%92%8C%E6%88%AA%E8%B7%9D%E8%A1%A8%E7%A4%BA%E4%B8%80%E6%9D%A1%E7%9B%B4%E7%BA%BF%EF%BC%8C%E7%94%B1%E4%BA%8Edouble%E7%9A%84%E7%B2%BE%E5%BA%A6%EF%BC%8Cc
idea 1: calculate the slope for each point, then sort the slope to find the maximal lines going through it - Time Complexity: O(n^2)
idea 2: overwrite hashCode and equals functions for class Line, and then use a Map to count the number of lines - Time Complexity: O(n^2)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Line {
	static class Point{
		double x, y;
		Point(double x, double y){
			this.x = x; this.y = y;
		}
	}
	private final double epsilon = 0.0000001 ;
    public int maxPointsOnLine(Point[] points) {
    	int m = points.length;
    	if (m <= 1)
    		return m;
    	int maxNum = 0;
    	for (int i = 0; i < m - maxNum; i++){
    		ArrayList<Double> slopes = new ArrayList<Double>();
    		for (int j = i+1; j < m; j++){
    			if (!equal(points[i].x, points[j].x)){
    				slopes.add((points[i].y-points[j].y)/(points[i].x-points[j].x));
    			} else{
    				slopes.add(Double.MAX_VALUE);
    			}
    		}
    		int currNum = getMostSlopes(slopes) + 1;
    		maxNum = Math.max(maxNum, currNum);
    	}
    	return maxNum;
    }
    public int getMostSlopes(ArrayList<Double> slopes){
    	if (slopes.size()==0)
    		return 0;
    	Collections.sort(slopes);
    	int maxNum = 0;
    	int counter = 1;
    	for (int i = 1; i < slopes.size(); i++){
    		if (equal(slopes.get(i),slopes.get(i-1))){
    			counter++;
    		} else{
    			maxNum = Math.max(maxNum, counter);
    			counter = 1;
    		}
    	}
    	maxNum = Math.max(maxNum, counter);
    	return maxNum;
    }
    public boolean equal(double a, double b){
    	return Math.abs(a-b) <= epsilon;
    }
    
    
    /***************/
    //idea 2
    private double slope;
    private double intercept;
    Line(Point a, Point b){
    	if (equal(a.x, b.x)){
    		slope = Double.MAX_VALUE;
    		intercept = a.x;//x-axis intercept
    	} else{
    		slope = (a.y - b.y)/(a.x - b.x);
    		intercept = a.y - a.x * slope;
    	}
    }
    Line(){
    	
    }
    @Override 
    public int hashCode(){
    	int s =  (int)(this.slope * 1000);
    	int i =  (int)(this.slope * 1000);
    	return s | i;
    }
    @Override
    public boolean equals(Object o){
    	Line l = (Line)o;
    	return equal(this.slope, l.slope)&&equal(this.intercept, l.intercept);
    }
    
    
    public int maxPointsOnLine2(Point[] points) {
    	int m = points.length;
    	if (m <= 2)
    		return m;
    	HashMap<Line, Integer> map = new HashMap<Line, Integer>();
    	for (int i = 0; i < m; i++){
    		for (int j = i + 1; j < m; j++){
    			Line l = new Line(points[i], points[j]);
    			if (map.containsKey(l)){
    				map.put(l, map.get(l) + 1);
    			} else{
    				map.put(l, 1);
    			}
    		}
    	}
    	int maxNum = 0;
    	for (Map.Entry<Line, Integer> entry: map.entrySet()){
    		if (entry.getValue() > maxNum)
    			maxNum = entry.getValue();
    	}
    	//use c to indicate the number of points on this line which has most points, then Cn2=n*(n-1)/2=maxNum
    	int c = 0;
    	c = (int)((1.0 + Math.sqrt(1+8*maxNum))/2);
    	return c;
    }	
    
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		Point[] points = new Point[n];
		points[0] = new Point(1,1);
		points[1] = new Point(2,2);
		points[2] = new Point(3,3);
		points[3] = new Point(4,4);
		
		Line o = new Line();
		
		System.out.println(o.maxPointsOnLine2(points));
	}

}
