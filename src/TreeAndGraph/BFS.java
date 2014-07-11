package TreeAndGraph;
/*
 * implementation of Breath-First Search
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
import java.util.Queue;

public class BFS {
	public static Node[] nodes;
	public void bfs(HashMap<Node, LinkedList<Node>> aList, Node s){//source node
		//construct status map, assume we have at least one node in this graph
		HashMap<Node, Integer> status = new HashMap<Node, Integer>();
		HashMap<Node, Integer> distance = new HashMap<Node, Integer>();
		HashMap<Node, Node> parent = new HashMap<Node, Node>();
		for (Node n : aList.keySet()){
			status.put(n, 0);
			distance.put(n, Integer.MAX_VALUE);
			parent.put(n, null);
		}
		status.put(s, 1);
		distance.put(s, 0);
		Queue<Node> q = new LinkedList<Node>();
		q.offer(s);
		while (!q.isEmpty()){
			Node curr = q.poll();
			System.out.println(curr.val);
			for (Node n : aList.get(curr)){
				if (status.get(n) == 0){
					status.put(curr, 1);
					distance.put(n, distance.get(curr) + 1);
					parent.put(curr, n);
					q.offer(n);
				}	
					
			}
			status.put(curr, 2);
		}
		
		return;
		
	}
	public HashMap<Node, LinkedList<Node>> constructAList(boolean[][] matrix){
		int n = matrix.length;
		nodes = new Node[n];
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
		BFS o = new BFS();
		boolean[][] matrix = {{true,false,true},{false, true, false},{true, false, true}};
		HashMap<Node, LinkedList<Node>> map = o.constructAList(matrix);
		o.bfs(map, nodes[0]);
	}

}
