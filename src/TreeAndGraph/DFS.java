package TreeAndGraph;
/*
 * implementation of Depth-First Search
 * 
 * we have three colors to represent three statuses:
 * 1. unvisited: white(0)
 * 2. visiting: grey(1)
 * 3. visited: black(2)
 Use HashMap<ListNode, LinkedList<ListNode>> as adjacent list

case 1: directed graph
case 2: undirected graph
 */
import java.util.HashMap;
import java.util.LinkedList;

class Node{
	public int val;
	Node(int v){
		val = v;
	}
}
public class DFS {
	public void dfs(HashMap<Node, LinkedList<Node>> aList){
		//construct status map, assume we have at least one node in the graph
		HashMap<Node, Integer> status = new HashMap<Node, Integer>();
		for (Node n : aList.keySet()){
			status.put(n, 0);
		}
		for (Node n : aList.keySet()){
			if (status.get(n) == 0){
				dfs_visit(n, status, aList);
			}
		}
	}
	public void dfs_visit(Node curr, HashMap<Node, Integer> status, HashMap<Node, LinkedList<Node>> aList){
		status.put(curr, 1);//visiting
		System.out.println(curr.val);
		for (Node n : aList.get(curr)){
			if (status.get(n) == 0){
				dfs_visit(n, status, aList);
			}
		}
		status.put(curr, 2);//visited
	}
	
	public HashMap<Node, LinkedList<Node>> constructAList(boolean[][] matrix){
		int n = matrix.length;
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++){
			nodes[i] = new Node(i);
		}
		HashMap<Node, LinkedList<Node>> map = new HashMap<Node, LinkedList<Node>>();
		for (int i = 0; i < n; i++){
			LinkedList<Node> list = new LinkedList<Node>();
			for (int j = 0; j < n; j++){
				if (i != j && matrix[i][j]){
					list.add(nodes[j]);
				}
			}
			map.put(nodes[i], list);
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS o = new DFS();
		boolean[][] matrix = {{true,false,true},{false, true, false},{true, false, true}};
		o.dfs(o.constructAList(matrix));
	}

}
