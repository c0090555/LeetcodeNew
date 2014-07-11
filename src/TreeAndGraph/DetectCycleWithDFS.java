package TreeAndGraph;
/*
 * use dfs to detect cycle
 * case 1: undirected graph
 * case 2: directed graph
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DetectCycleWithDFS {
	//case 1: directed graph
	public boolean checkCycle(HashMap<Node, LinkedList<Node>> aList){
		//assume we have a least one node in the graph
		Map<Node, Integer> status = new HashMap<Node, Integer>();
		for (Node n : aList.keySet()){
			status.put(n, 0);
		}
		for (Node n : aList.keySet()){
			if (status.get(n) == 0 && !dfs(n, status, aList)){
					return false;
			}
		}
		return true;
	}
	public boolean dfs(Node curr, Map<Node, Integer> status, HashMap<Node, LinkedList<Node>> aList){
		status.put(curr, 1);
		for (Node n : aList.get(curr)){
			if (status.get(n) == 1){
				return false;
			}
			if (status.get(n) == 0 && !dfs(n, status, aList)){
				return false;
			}
		}
		status.put(curr, 2);
		return true;
	}
	//case 2: undirected graph(assuming two nodes cannot form a cycle)
	public boolean checkCycle2(HashMap<Node, LinkedList<Node>> aList){
		//assume we have a least one node in the graph
		Map<Node, Integer> status = new HashMap<Node, Integer>();
		for (Node n : aList.keySet()){
			status.put(n, 0);
		}
		for (Node n : aList.keySet()){
			if (status.get(n) == 0 && !dfs2(n, null, status, aList)){
					return false;
			}
		}
		return true;
	}
	public boolean dfs2(Node curr, Node prev, Map<Node, Integer> status, HashMap<Node, LinkedList<Node>> aList){//adding Node prev to detect cycle in undirected graph
		status.put(curr, 1);
		for (Node n : aList.get(curr)){
			if (n != prev && status.get(n) == 1){
				return false;
			}
			if (status.get(n) == 0 && !dfs2(n, curr, status, aList)){
				return false;
			}
		}
		return true;
	}
}
