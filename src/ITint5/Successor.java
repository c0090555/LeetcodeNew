package ITint5;
/*
给定一个包含N个整数的集合S={0,1,…,N-1}，设计一个数据结构实现以下操作：

从S中删除x。函数为removeNum(x)。
查找x的后继：S中最小的y使得y>=x。函数为query(x)。如果x没有后继，返回-1。
评测系统会首先调用函数init(N)，您可以在此进行一些初始化操作。s

idea from: http://www.itint5.com/discuss/265/%E8%AF%B7%E9%97%AEo-1-%E7%9A%84%E8%AF%A5%E6%80%8E%E4%B9%88%E5%81%9A
Solution: disjoint set(path compression + union by rank)
Time Complexity: O(1) for both operations(amortized)
 */
class UnionFindSet{
	public int[] id;//
	public int[] sz;//size of each set
	public int[] mc;//maximal element of each set
	UnionFindSet(int n){
		id = new int[n];
		sz = new int[n];
		mc = new int[n];
		for (int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
			mc[i] = i;
		}
	}
	public int find(int p){//use path compression
		if (id[p] == p)
			return p;
		return id[p] = find(id[p]);
	}
	public void unionSet(int p, int q){//use union by rank
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]){//append i to j
			id[i] = j;
			sz[j] += sz[i];
			mc[j] = Math.max(mc[i], mc[j]);
		} else{//append j to i
			id[j] = i;
			sz[i] += sz[j];
			mc[i] = Math.max(mc[i], mc[j]);
		}
	}
	public int getMaxInSet(int p){//return the max number in p's set
		return mc[find(p)];
	}
}




public class Successor {
	private boolean[] delete;
	private int n;
	private UnionFindSet uf;

	public void init(int N) {
		delete = new boolean[N];
		n = N;
		uf = new UnionFindSet(N);
	}

	public void removeNum(int x) {
		if (x<0||x>=n)
			return;
		delete[x] = true;
		if (x-1>=0&&delete[x-1]==true)
			uf.unionSet(x, x-1);
		if (x+1<n&&delete[x+1]==true)
			uf.unionSet(x, x+1);
	}

	public int query(int x) {
		if (x<0||x>=n)
			return -1;
		if (!delete[x])//if x hasn't been deleted
			return x;
		int mc = uf.getMaxInSet(x) + 1;
		return mc < n ? mc : -1;
	}


}
