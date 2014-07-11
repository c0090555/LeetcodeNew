/*
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 */
import java.util.*;
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int v) {
		label = v;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
public class CloneGraph {

	

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
		map.put(node, copyNode);
		queue.add(node);

		// BFS
		while (!queue.isEmpty()) {
			UndirectedGraphNode v = queue.remove();// dequeue
			ArrayList<UndirectedGraphNode> neighbors = v.neighbors;
			UndirectedGraphNode copyV;
			if (map.containsKey(v)) {
				copyV = map.get(v);
			} else {
				copyV = new UndirectedGraphNode(node.label);
				map.put(v, copyV);
			}

			for (UndirectedGraphNode u : neighbors) {
				UndirectedGraphNode copyU;
				if (!map.containsKey(u)) {// first time visit
					copyU = new UndirectedGraphNode(u.label);
					map.put(u, copyU);
					queue.add(u);// enqueue


				} else {
					copyU = map.get(u);
				}
				copyV.neighbors.add(copyU);

			}
		}

		return copyNode;

	}
	
	public static void main(String[] args){
		CloneGraph o = new CloneGraph();
		UndirectedGraphNode n = new UndirectedGraphNode(0);
		
		n.neighbors.add(n);
		n.neighbors.add(n);
		UndirectedGraphNode p = o.cloneGraph(n);
		System.out.println(p.label);
	}
}
