package SortAndSearch;
/*
Moore's Voting Algorithm : find the majority element
Idea from: http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
Time Complexity: O(n) - in one pass
Space Complexity: O(1)
 */
public class VotingAlgorithm {
	public int find(int[] a){
		int counter = 0;
		int pointer = a[0];
		for (int i = 0; i < a.length ; i++){
			if (counter == 0){
				pointer = a[i];
				counter++;
			}	
			else if (a[i] == pointer){
				counter++;
			}
			else{
				counter--;
			}
		}
		return pointer;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VotingAlgorithm o = new VotingAlgorithm();
		int[] a = {1,2,1,2,2};
		System.out.println(o.find(a));
	}

}
