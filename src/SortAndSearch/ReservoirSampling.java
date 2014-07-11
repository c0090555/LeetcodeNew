package SortAndSearch;
//Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list S containing n items, where n is either a very large or unknown number. 
//this is a modified version of Fisher and Yates shuffle where we only concern the first k element
/*
Relation to Fisher-Yates shuffle：
Suppose one wanted to draw k random cards from a deck of playing cards (i.e., n=52).
A natural approach would be to shuffle the deck and then take the top k cards. 
In the general case, the shuffle also needs to work even if the number of cards in the deck is not known in advance, 
a condition which is satisfied by the inside-out version of the Fisher-Yates shuffle. 
 * 
 * 
* s: input array;r: result array;k: number of samples;n: length of input array
* All arrays are 0-based
* 1.when size of input array is known:
* for i in 0..k-1{
*         r[i]=s[i]
* }
* for i in k..n-1{
*         generate a random number j where 0<=j<=i
*         if(j<k){
*                 r[j]=s[i]
*  }
* }
************************** 
* 2.when size of input array is unknown
* for i in 0..k-1{
*   r[i]=s[i]
* }
* while s.hasMoreElement{
*   generate a random number i where 0<=i<=number of element processes in input array(counter)
*   if(i<k){
*           r[i]=s.next
*   }
* }  
* 
* 
*/
import java.util.*;
public class ReservoirSampling {
	public int[] sampleWithKnownSize(int[] s, int k){
		int[] r = new int[k];
		for(int i = 0; i <= k - 1; i++){
			r[i] = s[i];
		}
		for(int j = k; j <= s.length - 1; j++){
			//generate a random number ran between 0 to j
			Random ran = new Random();
			int m = ran.nextInt(j + 1);
			if(m <= k - 1){
				r[m] = s[j];
			}
		}
		return r;
	}
	
	public ArrayList<Integer> sampleWithUnknownSize(ArrayList<Integer> source, int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int counter = 0;
		while(!source.isEmpty()){
			if(counter < k){
				result.add(source.get(0));
				System.out.println(result.size());
			}
			else{
				
				int r = (int)(Math.random() * (counter + 1)); // Math.random() return a double number with positive sign(0.0<=number<1.0)
				System.out.println("r "+r + " counter "+counter	);

				if(r < k){
					System.out.println(" r"+r+" k "+k+" source "+source.get(0));
					result.set(r, source.get(0));
					
				}
				
			}
			counter++;
			source.remove(0);
			
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservoirSampling o = new ReservoirSampling();
		int[] a = {3,1,2,5,1};
		int k = 3;
		int[] c = o.sampleWithKnownSize(a, k);
		for(int m:c){
			System.out.print(" "+m);
		}
		
		System.out.println();
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(1);
		b.add(2);
		b.add(5);
		b.add(1);
		ArrayList<Integer> d = o.sampleWithUnknownSize(b, k);
		System.out.println("d size "+d.size());
		int size  = d.size();
		for(int j=0;j<size;j++){
			
			System.out.print(d.remove(0)+" ");
		}
	}

}
