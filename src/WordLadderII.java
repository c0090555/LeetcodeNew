/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 
Analysis:
like WordLadder, we still need to do BFS level by level
we cannot remove the string we meet immediately cause that intermediate string may be used by another valid path as well,
e.g hem->hex->tex->ted
	hem->tem->tex->ted
if we remove tex when we get the first path, we will lose the second path

So we use a HashMap<String, ArrayList<ArrayList<String>>> to record all possible path to this String



!!!!! This code is too huge, need to be refactored
 */
import java.util.*;

public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		if (start.equals(end)) {
			path.add(start);
			paths.add(path);
			return paths;
		}

		LinkedList<String> q = new LinkedList<String>();
		LinkedList<String> q2 = new LinkedList<String>();
		HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
		
		if(dict.contains(start)){
			dict.remove(start);
		}
		
		
		ArrayList<String> needToDelete = new ArrayList<String>();
		q.add(start);
		boolean done=false;//indicate whether we have found end or not
		while (!q.isEmpty()&&done==false) {
			// level by level
			needToDelete = new ArrayList<String>();// used to store all String
													// needed to remove from
													// dictionary after this
													// level traversal
			HashSet<String> curLevelString = new HashSet<String>();
			while (!q.isEmpty()) {
				String cur = q.remove();
				//System.out.println("CUR "+cur);
				for (int i = 0; i < cur.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char[] cArray = cur.toCharArray();
						if (c == cArray[i])
							continue;
						cArray[i] = c;
						String newS = String.copyValueOf(cArray);
					
						if (newS.equals(end)||dict.contains(newS)) {
							//System.out.println("CURR "+cur+" NEWS "+newS);
							//System.out.println("map "+map);
							if (!map.containsKey(cur)) {
								paths = new ArrayList<ArrayList<String>>();
								path = new ArrayList<String>();
								path.add(cur);
								path.add(newS);
								paths.add(path);
								//System.out.println("1 "+paths);
								map.put(newS, paths);
							} else {
								paths=deepCopy(map.get(cur));
								//System.out.println("2 "+paths);

								for (int m = 0; m < paths.size(); m++) {
									path = paths.get(m);
									path.add(newS);

								}
								//System.out.println("2S "+paths);
								if(!map.containsKey(newS)){
									map.put(newS, paths);
								}
								else{
									ArrayList<ArrayList<String>> currPaths = map.get(newS);
									currPaths.addAll(paths);
									map.put(newS, currPaths);
								}
								
								
								
								//System.out.println("2PATHS "+paths);
								//System.out.println("2MAP "+map);
							}
							
							if(newS.equals(end)){
								done = true;
							}
							else{
							needToDelete.add(newS);
							if(!curLevelString.contains(newS)){
								q2.add(newS);
								curLevelString.add(newS);
							}
							//////System.out.println("newS "+newS);

							}
						}

					}

				}
				

			}
			////System.out.println("q "+q);
			// remove all dictionary strings which occur in this level
			for (int j = 0; j < needToDelete.size(); j++)
				if (dict.contains(needToDelete.get(j)))
					dict.remove(needToDelete.get(j));
			q = (LinkedList) q2.clone();
			q2 = new LinkedList<String>();
		}
		if(map.containsKey(end)){
			return map.get(end);
		}
		else{
			ArrayList<ArrayList<String>> emptyPaths = new ArrayList<ArrayList<String>>();
			return emptyPaths;
		}
	}
	
	public ArrayList<ArrayList<String>> deepCopy(ArrayList<ArrayList<String>> paths){
		ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>();
		for(int i=0;i<paths.size();i++){
			ArrayList<String> path = paths.get(i);
			ArrayList<String> pCopy = new ArrayList<String>();
			for(String st:path){
				pCopy.add(st);
			}
			copy.add(pCopy);
			
		}
		return copy;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII o = new WordLadderII();
		String s = "hot";
		String e = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");

		
		
		ArrayList<ArrayList<String>> res = o.findLadders(s, e, dict);
		////System.out.println(res.size());
		for(int i=0;i<res.size();i++){
			ArrayList<String> path = res.get(i);
			for(int j=0;j<path.size();j++){
				//System.out.print(" "+path.get(j));
			}
			//System.out.println();
		}
	}

}
