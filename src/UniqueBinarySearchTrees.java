/*
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * 
 * 
 DP: try all combination
 */
import java.util.HashMap;
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		return numTrees(n, map);
	}
	public int numTrees(int n, HashMap<Integer, Integer> map){
		if (map.containsKey(n)){
			return map.get(n);
		}
		int number = 0;
		for (int i = 1; i <= n; i++){
			if (i ==  1 || i == n){
				number += numTrees(n-1, map);
			}
			else{
				number += numTrees(i-1, map) * numTrees(n-i, map);//left subtree * right subtree
			}
		}
		map.put(n, number);
		return number;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
