package ITint5;
/*
二维平面上有n个点，已按照x坐标从左到右排序（所有点的x坐标均不同），存放在数组points中。

需要从最左边的点出发，先向右扫描访问一些点，到达最右边的点，然后再向左扫描，访问第一次没有访问的点，最后回到最左边的点。扫描过程中经过的总的欧式距离要最小。返回这个最小的欧式距离。

idea from: http://blog.csdn.net/a83610312/article/details/12522077
http://www.itint5.com/discuss/280/%E5%8D%A1%E4%BD%8F%E4%BA%86%E6%B1%82%E6%8F%90%E7%A4%BA

idea: use dp, imagine we have two lines starting from the point[0] at the same time, use cost[i][j] to
indicate the minimum cost when we reach i on one line and reach j on the other line, for simplicity,
let's assume j >= i, i.e. point j is always farther than point j

 */
public class VisitPoints {
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x; this.y = y;
		}
	}
    public double minDist(Point[] points) {
    	int n = points.length;
    	double[][] cost = new double[n][n];
    	for (int i = 0; i < n; i++){
    		for (int j = i; j < n; j++){
    			if (j - i > 1){//if the distance between i and j is bigger than one, then the shortest path comes from j - 1
    				cost[i][j] = cost[i][j-1] + getDist(points[j-1], points[j]);
    			} else{//find the minimum distance between 0 and j - 1
    				double minDist = cost[0][i] + getDist(points[0], points[j]);
    				for (int k = 1; k < j; k++){
    					minDist = Math.min(minDist, cost[k][i] + getDist(points[k], points[j]));
    				}
    				cost[i][j] = minDist;
    			}
    		}
    	}
    	return cost[n-1][n-1];
    }
    
    public double getDist(Point a, Point b){
    	return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisitPoints o =new VisitPoints();
		int n = 2;
		Point[] points = new Point[n];
		points[0] = new Point(0,0);
		points[1] = new Point(100,0);
 		System.out.println(o.minDist(points));
	}

}
