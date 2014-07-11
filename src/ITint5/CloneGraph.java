package ITint5;

//solution: DFS
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	static class GraphNode {
	    public int data;
	    public List<GraphNode> neighbors;
	    public GraphNode(int data) {
	        this.data = data;
	        neighbors = new ArrayList<GraphNode>();
	    }
	}
    public GraphNode cloneGraph(GraphNode node) {
    	if (node == null) return null;
    	HashMap<GraphNode, GraphNode> hash = new HashMap<GraphNode, GraphNode>();
    	cloneHelper(node, new GraphNode(node.data), hash);
    	return hash.get(node);
    }
    public void cloneHelper(GraphNode node, GraphNode copyNode, HashMap<GraphNode, GraphNode> hash){
    	hash.put(node, copyNode);
    	for (GraphNode n : node.neighbors){
    		if (!hash.containsKey(n)){
    			cloneHelper(n, new GraphNode(n.data), hash);
    		}
    		GraphNode copy = hash.get(n);
    		copyNode.neighbors.add(copy);
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
