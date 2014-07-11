package ITint5;

/*
 有一个环形公路上有n个加油站，第i个加油站的油量为ai。假设有一辆邮箱体积无穷大的汽车，初始邮箱是空的，汽车从加油站i行驶到加油站i+1需耗油g[i]。

 问是否能够选出某个加油站作为起点，使汽车能够绕环形公路行驶一圈返回到该加油站。

 实现函数int selectGasStation(int a[], int g[], int n)，如果存在满足条件的加油站，返回该加油站的序号(0-based)。否则返回-1。

 提示：n可能达到10^6，O(n2)的枚举算法会超出时间限制。

Solution:  The hard part of this problem is the following observation and proof:
notate the cost of each gas station as c[i] = a[i] - g[i], if the sum of all c[i] is < 0, then
we couldn't find a valid start gas station
assume i is the unique valid start point, then the sum of all nodes between k and i-1 (0<=k<i) must be less or equal than 0,
otherwise k will be another start point, similarly the sum of all nodes between i and k'(0<k'<=n-1) must be big or equal
to 0, otherwise we cannot go from i to 0,
then the target has become to find the first sub-array which ends in n-1 whose sum is big or equal to 0

idea from: http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html

 */
public class SelectGasStation {
	public int selectGasStation(int[] a, int[] g) {
		int leftGas = 0;
		int startNode = 0;
		int sum = 0;
		
		for (int i = 0; i < a.length; i++){
			leftGas += a[i] - g[i];
			sum += a[i] - g[i];
			if (sum < 0){
				startNode = i+1;//start node must be after i since sum < 0
				sum = 0;//!!key part: need to reset sum to prepare for next try
			}
		}
		return leftGas < 0 ? -1 : startNode;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {29,2,7,45,10,88,5,50,19,61,35,61,33,24,38,94,20,47,75}; 
		int[] g = {61,2,0,51,3,96,1,61,0,14,47,0,74,90,33,26,67,66,41};
		SelectGasStation o = new SelectGasStation();
		System.out.println(o.selectGasStation(a, g));
	}

}
