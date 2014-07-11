package SortAndSearch;
/*
 * Fisher and Yates shuffle algorithm 
 * 
 The key point of shuffle is to distribute all elements evenly
 
 The modern algorithm of Fisher and Yates Shuffle:
 To shuffle an array of n elements(index from 0 to n-1)
 	for i from n-1 downto 1 //i is the the last element of unstruck numbers
 		j <- a random integer with 0<=j<=i
 		exchange a[j] and a[i]
 * 
 * 
 * 
 * 
 * s:source array; r: result array; n:size of s
 * All arrays are 0-based
 * 1. when the size of input array is known:
 * r[0]=s[0]
 * for(i=1;i<=n-1;i++){
 * generate a random number j where 0<=j<=i
 * if(j != i)
 * 		r[i]=r[j]
 * r[j]=s[i]
 * }
 * 
 * **********************************************************
 * 2. when the size of input array is unknown (we can assume it's extremely large)
 * when s.hasMoreElement
 * generate a random number i where 0<=i<=current size of r
 * if(i==current size of r){
 *                 r.append(s.next)
 * }
 * else{
 *      r.append(s[j])
 *      r[j]=s.next
 * }
 *end
 * 


 	
 
 
 
 * 
 */
import java.util.*;

import javax.net.ssl.SSLContext;
public class FisherAndYatesShuffle {

//modern algorithm
	public void shuffleArray(int[] a){
		int n = a.length;
		if (n == 0 || n == 1){
			return;
		}
		for (int i = n - 1; i >= 1;i--){//i is the last index of the unstab
			Random r = new Random();
			int j = r.nextInt(i + 1);//generate a random number between 0 to i
			//swap a[i] and a[j]
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	
	
//inside out version - we always keep a shuffled array
//proof The inside-out shuffle can be seen to be correct by induction; 
//every one of the n! different sequences of random numbers that could be obtained from the calls of random will produce a different permutation of the values, 
//so all of these are obtained exactly once. 
	public int[] shuffleWithKnownSize(int[] s){
		int[] res = new int[s.length];
		res[0] = s[0];
		for(int i = 1; i <= s.length - 1; i++){
			Random r = new Random();
			int j = r.nextInt(i + 1);//generate a random integer between 0 to i
			if (j != i)
				res[i] = res[j];
			res[j] = s[i];
		}
		return res;
	}
	
	public ArrayList<Integer> shuffleWithUnknownSize(ArrayList<Integer> s){
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(!s.isEmpty()){
			int i = (int) (Math.random() * (res.size() + 1));//0<=i<=res.size()
			if(i == res.size()){
				//append to result ArrayList
				res.add(s.get(0));
			}
			else{
				//swap element_i of result ArrayList with the new coming element
				int element_i = res.get(i);
				res.set(i, s.get(0));
				res.add(element_i);
			}
			System.out.println(" res "+res.get(0));
			s.remove(0);
		}
		System.out.println(res.size());
		return res;
		
		
	}
	public static void main(String[] args){
		FisherAndYatesShuffle o = new FisherAndYatesShuffle();
		int[] a = {3,2,1,4,3};
		int[] d=o.shuffleWithKnownSize(a);
		for(int k:d)
			System.out.print(" "+k);

		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(2);
		b.add(1);
		b.add(4);
		b.add(3);
		ArrayList<Integer> c = o.shuffleWithUnknownSize(b);
		for(int i=0;i<c.size();i++){
			System.out.print(" "+c.get(i));
		}
	}

}
