package ITint5;

import java.util.ArrayList;

public class Arrays {
	public int[] arrayUnion(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		ArrayList<Integer> union = new ArrayList<Integer>();
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				union.add(a[i]);
				i++;
			} else if (a[i] > b[j]) {
				union.add(b[j]);
				j++;
			} else {
				union.add(a[i]);
				i++;
				j++;
			}
		}
		while (i < m) {
			union.add(a[i]);
			i++;
		}
		while (j < n) {
			union.add(b[j]);
			j++;
		}
		if (union.size() == 0)
			return new int[0];
		// remove duplicate
		ArrayList<Integer> unionRes = new ArrayList<Integer>();
		unionRes.add(union.get(0));
		for (int k = 1; k < union.size(); k++) {
			if (union.get(k) == union.get(k - 1))
				continue;
			else{
				unionRes.add(union.get(k));	
			}	
		}
		int[] u = new int[unionRes.size()];
		for (i = 0; i < unionRes.size(); i++)
			u[i] = unionRes.get(i);
		return u;

	}

	public int[] arrayIntersect(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				intersect.add(a[i]);
				i++;
				j++;
			}
		}
		if (intersect.size() == 0)
			return new int[0];
		ArrayList<Integer> interRes = new ArrayList<Integer>();
		interRes.add(intersect.get(0));
		for (int k = 1; k < intersect.size(); k++) {
			if (intersect.get(k) == intersect.get(k - 1))
				continue;
			else{
				interRes.add(intersect.get(k));	
			}	
		}
		int[] inter = new int[interRes.size()];
		for (i = 0; i < interRes.size(); i++)
			inter[i] = interRes.get(i);
		return inter;
	}

	public static void main(String[] args) {
		Arrays o = new Arrays();
		int[] a = { 1, 1 };
		int[] b = {};
		System.out.println(o.arrayIntersect(a, b));
	}
}
