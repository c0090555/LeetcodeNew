/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


Idea comes from: http://jane4532.blogspot.com/2013/10/gas-stationleetcode.html?showComment=1390462608867#c9022995295061531718
Key idea: assume we start from station[i], if we cannot reach station[j], that means we cannot reach station[j] from any station between
station[i] and station[j](because each time when we reach a new station, the gas in the tank should be at least zero), so we should retry from j

 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int g = gas.length;
		int c = cost.length;
		if (g == 0 || c == 0 || g != c) {
			return -1;
		}
		for (int i = 0; i < g; i++) {
			int count = 1;
			int j = i;
			int tank = 0;
			while (count <= g) {
				int temp = tank+gas[j%g]-cost[j%g];
				System.out.println(temp);
				System.out.println("i "+i+" j "+j);
				if (tank + gas[j % g] >= cost[j % g]) {
					if (count == g)
						return i;
					tank += (gas[j % g] - cost[j % g]);
					count++;
					j++;
				} else {
					System.out.println("iii "+i+" JJJ "+j);
					i = j%g;

					break;
				}

			}

		}

		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation o = new GasStation();
		int[] gas = { 1, 2, 3, 3 };
		int[] cost = { 2, 1, 5, 1 };
		System.out.println("res" + o.canCompleteCircuit(gas, cost));

	}

}
