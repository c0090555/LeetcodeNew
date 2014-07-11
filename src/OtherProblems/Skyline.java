package OtherProblems;
/*
Problem Description: 
http://uva.onlinejudge.org/external/1/105.pdf


Solution: use the idea of segment interval - line sweep
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

class Triplet{
	int l;
	int h;
	int r;
	public Triplet(int l, int h, int r){
		this.l =  l;
		this.h = h;
		this.r = r;
	}
}

public class Skyline {
	public ArrayList<Triplet> findSkyline(ArrayList<Triplet> a){
		int n = a.size();
		if (n == 0 || n == 1)
			return a;
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> start = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> finish = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < a.size(); i++){
			int l = a.get(i).l;
			if (!set.contains(l))
				set.add(l);
			if (!start.containsKey(l)){
				ArrayList<Integer> b = new ArrayList<Integer>();
				b.add(i);
				start.put(l, b);
			}
			int r = a.get(i).r;
			if (!set.contains(r))
				set.add(r);
			if (!finish.containsKey(r)){
				ArrayList<Integer> b = new ArrayList<Integer>();
				b.add(i);
				finish.put(r, b);
			}
		}
		ArrayList<Triplet> res = new ArrayList<Triplet>();
		ArrayList<Integer> points = new ArrayList<Integer>();
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()){
			points.add(iterator.next());
		}
		Collections.sort(points);
		PriorityQueue<Integer> height = new PriorityQueue<Integer>(1000, new Comparator<Integer>(){//max-heap
			public int compare(Integer a, Integer b){
				return Integer.valueOf(a) < Integer.valueOf(b) ? 1 : (Integer.valueOf(a) == Integer.valueOf(b) ? 0 : -1);
			}
		});
		
		ArrayList<Integer> b = start.get(points.get(0));
		for (int j : b){
			height.offer(a.get(j).h);
		}
		int prevH = height.peek();
		int pStart = points.get(0);
		int currH = -1;
		
		for (int i = 1; i < points.size(); i++){
			int p = points.get(i);
			if (finish.containsKey(p)){
				ArrayList<Integer> finishList = finish.get(p);
				for (int f : finishList)
					height.remove(a.get(f).h);
			}
			if (start.containsKey(p)){
				ArrayList<Integer> startList = start.get(p);
				for (int s : startList)
					height.offer(a.get(s).h);
			}
			currH = height.size() == 0 ? 0 : height.peek();
			if (currH != prevH){
				res.add(new Triplet(pStart, prevH, points.get(i)));
				prevH = currH;
				pStart = points.get(i);
			} 
		}
		if (currH == prevH && pStart != points.get(points.size()-1)){
			res.add(new Triplet(pStart, prevH, points.get(points.size()-1)));
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Skyline o = new Skyline();
		ArrayList<Triplet> a = new ArrayList<Triplet>();
		a.add(new Triplet(1, 11, 5));
		a.add(new Triplet(2, 6, 7));
		a.add(new Triplet(3, 13, 9));
		a.add(new Triplet(12, 7, 16));
		a.add(new Triplet(14, 3, 25));
		a.add(new Triplet(19, 18, 22));
		a.add(new Triplet(23, 13, 29));
		a.add(new Triplet(24, 4, 28));
		ArrayList<Triplet> r = o.findSkyline(a);
		for (Triplet e : r){
			System.out.format("%s %s %s %n", e.l, e.h, e.r);
		}
	}

}
