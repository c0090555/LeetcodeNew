package ITint5;
/*
有n个任务需要完成（编号1到n），任务之间有一些依赖关系，如果任务a依赖于任务b和c，那么只有当任务b和任务c完成之后才能完成任务a。给定所有的依赖关系，判断这些任务是否能够完成。如果能够完成，请给出一个合法的任务完成序列。

样例：
n=5
1->2,3
3->4

上述样例中任务1依赖于任务2和任务3，任务3依赖于任务4，那么存在合法的任务完成序列4,3,2,1,5


Solution:
reverse the map first and calculate the in-degree for all nodes, store all nodes whose indegree is zero in a stack and
try to get |V| zero in-degree nodes, if fail then return false
 */
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class JobScheduler {
    /*
     * deps[id]表示任务id所依赖的任务
     * 如果存在合法的任务完成序列，返回true，否则返回false
     * 合法的任务序列请存放在参数result中（已经分配空间）
     */
	//iterative approach
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
    	if (n == 0)
    		return false;
    	if (deps.size() == 0){
    		for (int i = 1; i <= n; i++)
    			result[i-1] =  i;
    		return true;
    	}
    	//reverse map & calculate in-degree for each node
    	HashMap<Integer, List<Integer>> rmap = new HashMap<Integer, List<Integer>>();
    	int[] indeg = new int[n+1];//start from 1
    	for(Map.Entry<Integer, List<Integer>> entry : deps.entrySet()){
    		int k1 = entry.getKey();
    		for (int k2 : entry.getValue()){
    			if (!rmap.containsKey(k2)){
    				rmap.put(k2, new LinkedList<Integer>());
    			}
    			rmap.get(k2).add(k1);
    			indeg[k1]++;
    		}
    	}
    	
    	Stack<Integer> s = new Stack<Integer>();//s stores all zero in-degree nodes
    	for (int i = 1; i <= n; i++){
    		if (indeg[i] == 0)
    			s.push(i);
    	}
    	//get |v| zero in-degree nodes
    	for (int i = 1; i <= n; i++){
    		if (s.isEmpty())
    			return false;
    		int currNode = s.pop();
    		result[i-1] = currNode;
    		if (rmap.containsKey(currNode)){//may have isolated nodes
    			for (int inNode : rmap.get(currNode)){
    				indeg[inNode]--;
    				if (indeg[inNode] == 0)
    					s.push(inNode);
    			}
    		}
    	}
    	return true;
    	
    }
    
    //recursive approach
    public boolean jobSchedule2(Map<Integer, List<Integer>> deps, int n, int[] result) {
    	if (n == 0)
    		return false;
    	if (deps.size() == 0){
    		for (int i = 1; i <= n; i++)
    			result[i-1] =  i;
    		return true;
    	}
    	//reverse map & calculate in-degree for each node
    	HashMap<Integer, LinkedList<Integer>> rmap = new HashMap<Integer, LinkedList<Integer>>();
    	int[] indeg = new int[n+1];//start from 1
    	for(Map.Entry<Integer, List<Integer>> entry : deps.entrySet()){
    		int k1 = entry.getKey();
    		for (int k2 : entry.getValue()){
    			if (!rmap.containsKey(k2)){
    				rmap.put(k2, new LinkedList<Integer>());
    			}
    			rmap.get(k2).add(k1);
    			indeg[k1]++;
    		}
    	}
    	LinkedList<Integer> zeroNodes = new LinkedList<Integer>();
    	for (int i = 1; i <= n; i++){
    		if (indeg[i] == 0)
    			zeroNodes.add(i);
    	}
    	return jobScheduleRecur(rmap, 0, indeg, result, zeroNodes);
    }
    public boolean jobScheduleRecur(Map<Integer, LinkedList<Integer>> rmap, int k, int[] indeg, int[] result, LinkedList<Integer> zeroNodes){
    	if (k == result.length)
    		return true;
    	if (zeroNodes.size() == 0)
    		return false;
    	int currNode = zeroNodes.remove();
    	result[k] = currNode;
    	if (rmap.containsKey(currNode)){
    		for(int inNode : rmap.get(currNode)){
    			indeg[inNode]--;
        		if (indeg[inNode]==0)
        			zeroNodes.add(inNode);	
    		}
    	}
    	return jobScheduleRecur(rmap, k+1, indeg, result,zeroNodes)	;
    	
    }
    
}