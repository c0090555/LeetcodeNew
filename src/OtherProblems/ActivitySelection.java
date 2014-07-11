package OtherProblems;
/*
Problem Description:
schedule several competing activities that require exclusive use of a common resource, with a goal of 
selecting a maximum-size set of mutually compatible activities

Each activity ai has a start time si and a finish time fi, where 0 <= si < fi < Infinity
 
Note: Sij = {ak from S, where fi <= sk < fk <= sj}, all activities between ai and aj (excluding ai and aj) 
 
Solution 1: Greedy Algorithm 
consider fm = min{fk: ak from Sij}, i.e. am has the smallest finish time in Sij
Then
1. Activity am is used in some maximum-size subset of mutually compatible activities of Sij
2. The subproblem Sim is empty, so that choosing am leaves the subproblem Smj as the only one that may be nonempty

Proof: 
For 1: suppose Aij is a maximum-size subset of mutually compatible activities of Sij and ak be the first activity to finish
two cases: 
a. am is within Aij, then 1 is proved
b. am isn't in Aij, let's construct another Aij' = Aij - ak + am, since all activities in Aij are disjoint and fm <= fk, then Aij' is also another 
maximal-size subset, 1 is proved
For 2: it's trival since am is the first activities to finish

Based on 1 and 2, we know only one subproblem is used in optimal solution(the other subproblem is guarantted to be empty) and when solving the 
subproblem Sij, we need consider only one choice: the one with the earliest finish time in Sij. Hence, we can use Greedy Algorithm to solve this problem. 
 
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Activity{
	int s;
	int e;
	public Activity(int s, int e){
		this.s = s;
		this.e = e;
	}
}

public class ActivitySelection
{
	//Solution 1: tail recursive version, Time Complexity: O(n)
	public ArrayList<Activity> findMaxSizeSubset(Activity[] a){
		//add two dummy activity a[0] and a[n+1] for easy operation
		ArrayList<Activity> list = new ArrayList<Activity>(Arrays.asList(a));
		list.add(0, new Activity(-1,-1));//a[0]
		list.add(new Activity(Integer.MAX_VALUE, Integer.MAX_VALUE));//a[n+1]
		Activity[] a2 = list.toArray(new Activity[0]);
		
		//sort by finish time first
		Arrays.sort(a2, new Comparator<Activity>(){
			public int compare(Activity m, Activity n){
				return m.e < n.e ? -1 : (m.e == n.e ? 0 : 1);
			}
		});
		return recursiveSelect(a2, 0, a2.length-1);
	}
	public ArrayList<Activity> recursiveSelect(Activity[] a, int i, int j){
		ArrayList<Activity> res = new ArrayList<Activity>();
		if(i >= j)
			return res;
		//!!!find the first activity in Sij
		int m = i+1;
		while (m < j && a[m].s < a[i].e){//get rid of all overlapping activities
			m++;
		}
		if (m < j){
			ArrayList<Activity> rest = recursiveSelect(a, m, j);
			res.add(a[m]);
			res.addAll(rest);
		}
		return res;
	}
	
	//solution 2: change tail recursion of solution1 into iterative solution, Time Complexity: O(n)
	public ArrayList<Activity> iterativeFindMaxSubsset(Activity[] a){
		//add two dummy activity a[0] and a[n+1] for easy operation
		ArrayList<Activity> list = new ArrayList<Activity>(Arrays.asList(a));
		list.add(0, new Activity(-1,-1));//a[0]
		list.add(new Activity(Integer.MAX_VALUE, Integer.MAX_VALUE));//a[n+1]
		Activity[] a2 = list.toArray(new Activity[0]);
		//sort by finish time first
		Arrays.sort(a2, new Comparator<Activity>(){
			public int compare(Activity m, Activity n){
				return m.e < n.e ? -1 : (m.e == n.e ? 0 : 1);
			}
		});
		
		ArrayList<Activity> res = new ArrayList<Activity>();
		int i = 0;
		int j = a2.length - 1;
		for (int m = 1; m < j ; m++){
			if (a2[m].s >= a2[i].e){
				res.add(a2[m]);
				i = m;
			}
		}
		return res;
	}
	
	//solution 3: DP, Time Complexity: O(n^3)
	/*
	 notate c[i,j] as the number of elements in a maximum-size subset of mutually compatible activities in Sij
	 c[i,j]  = 
	 1. 0 if Sij is empty
	 2. max{c[i,k] + 1 + c[k,j]} for all i<k<j if Sij isn't empty
	 */
	public int findMaxSubsetDP(Activity[] a){
		//add dummy activities
		ArrayList<Activity> list = new ArrayList<Activity>(Arrays.asList(a));
		list.add(0, new Activity(-1,-1));
		list.add(new Activity(Integer.MAX_VALUE, Integer.MAX_VALUE));
		Activity[] a2 = list.toArray(new Activity[0]);
 		int[][] dp = new int[a2.length][a2.length];
 		int[][] s = new int[a2.length][a2.length];//for back trace
 		for (int l = 2; l <= a2.length; l++){
 			for (int i = 0; i < a2.length - l + 1; i++){
 				int j = i + l - 1;
 				if (checkSij(a2, i, j)){
 	 				int max = 0;
 	 				for (int k = i+1; k < j; k++){
 	 					if (max < dp[i][k] + 1 + dp[k][j] && a2[k].s >= a2[i].e && a2[k].e <= a2[j].s){//!!we need a[k] to be compatible with a[i] and a[j]
 	 						max = dp[i][k] + 1 + dp[k][j];
 	 						s[i][j] = k;
 	 					}	
 	 				}
 	 				dp[i][j] = max;
 				}
 				
 			}
 		}
 		
 		ArrayList<Activity> res = printRes(a2, s, 0, a2.length-1);

 		return dp[0][a2.length-1];
	}
	
	public ArrayList<Activity> printRes(Activity[] a, int[][] s, int i , int j){
		ArrayList<Activity> res = new ArrayList<Activity>();
		if (s[i][j] > 0  && s[i][j] < s.length - 1){
			res.add(a[s[i][j]]);
			ArrayList<Activity> left = printRes(a, s, i, s[i][j]);
			res.addAll(left);
			ArrayList<Activity> right = printRes(a, s, s[i][j], j);
			res.addAll(right);
		}
		
		return res;
	}
	public boolean checkSij(Activity[] a, int i , int j){//return the first activity in Sij if Sij is non-empty, otherwise return -1
		for (int m = i+1; m < j; m++){
			if (a[m].s >= a[i].e && a[m].e <= a[j].s)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args){
		ActivitySelection o = new ActivitySelection();
		ArrayList<Activity> input = new ArrayList<Activity>();
		input.add(new Activity(1,2));
		input.add(new Activity(1,3));
		input.add(new Activity(2,4));
		Activity [] a = input.toArray(new Activity[0]);
		//ArrayList<Activity> res = o.iterativeFindMaxSubsset(a);
		//for (Activity e:res){
			//System.out.format("%s %s %n", e.s, e.e);
		//}
		System.out.println(o.findMaxSubsetDP(a));
	}
}
