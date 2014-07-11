package OtherProblems;

/*
 Question: Find the maximum product sub-array of an array of integers. Given an integer N and an array of size N containing integers, 
 implement a function that returns the product of the contiguous sub array with the maximum product

 We have several variants for this problem here:
 Case 1: assume we only have integer input and there might be zero there
Solution 1:
 idea comes from: https://interviewjudge.com/solution-maximum-product-subarray/
 Analysis: 1, we maintain two variable max_here and min_here(both initialized to 0) to keep track of maximum and minimum value at a specific 
 position, here we need to pay attention that max_here is guaranteed to be at least 1 and min_here == 1 or negative
 2. we use max_element to keep track of the maximum number in case we only have one negative number(e.g. -1 0 -3 0)
 3. we use max_overall to keep track of the maximum product
 4. we use pairExists to check whether we have at least two negative numbers in a subarray
Solution 2:
idea from: http://www.mitbbs.com/mitbbs_article_t.php?board=JobHunting&gid=32438367&start=32438367&pno=-1
1. we can see the array as subarrays delimited by 0, and each of those 
subarrays can be processed indepedent of each other.
2. For each subarray without 0, if the count of negative elements is even, 
then the value of this subarray is the product of all elements. If the count
of negative elements is odd, then we need to throw away one negative 
element, this one is either the leftmost negative element, or the rightmost 
negative element.

 *
 *
 */
import java.util.*;
public class FindSubArrayWithMaxProduct {
	//Solution 1
	int findMaxProduct(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int max_here = 1;// record max here
		int min_here = 1;// record min here
		int max_element = a[0];// record the maximum element
		int max_overall = 0;// record the maximum product except the case that
							// we only have one negative number seperated by
							// zero
		int negatives = 0;// record the number of negative numbers
		boolean pairExists = false;

		for (int i = 0; i < a.length; i++) {
			max_element = Math.max(max_element, a[i]);
			if (a[i] > 0) {
				max_here = max_here * a[i];//update max_here
				min_here = Math.min(1, min_here * a[i]);//update min_here
			} else if (a[i] == 0) {
				//reset
				negatives = 0;
				max_here = 1;
				min_here = 1;
			} else {
				negatives++;
				if (negatives > 1) {//!!!if we have more than one negative numbers, then we could get maximum number by maximum_overall
					pairExists = true;
				}
				int temp = max_here;
				max_here = Math.max(min_here * a[i], 1);
				min_here = temp * a[i];
			}

			max_overall = Math.max(max_overall, max_here);

		}

		if (max_element > 0 || pairExists == true) {
			return max_overall;
		} else {
			return max_element;
		}

	}
	//Solution 2
	public int findMaxProduct2(int[] a){
		if (a == null || a.length == 0)
			return 0;
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		zeros.add(-1);
		int i = 0;
		while(i < a.length){
			if (a[i] == 0){
				zeros.add(i);
				
			}
			i++;
			
		}
		zeros.add(a.length);
		int max = 0;
		for (int k =0 ; k < zeros.size() - 1 ; k++){
			int s = zeros.get(k);
			int e = zeros.get(k + 1);
			System.out.println("s "+s+" e "+e);
			int value = blockCalculate(a, s, e);
			System.out.println("value "+value);

			max = Math.max(max, value);
			
		}
		return max;
		
		
		
		
	}
	public int blockCalculate(int[] a, int start, int end){//start and end are non-zero positions
		start = start + 1;
		end = end - 1;
		if(start > end || start >= a.length || end >= a.length){
			return 0;
		}
		if(start == end){
			return a[start];
		}
	
		int negatives = 0;
		int product = 1;
		for (int i = start; i <= end; i++){
			product *= a[i];
			if(a[i] < 0)
				negatives++;
		}
		if (negatives %2 == 0){
			return product;
		}
		else{
			//find the leftmost negative number
			int j = start;
			boolean leftStart = false;
			int left = 1;
			while (j <= end){
				if (leftStart)
					left *= a[j];
				if (a[j] < 0){
					leftStart = true;
				}
				
				j++;
			}
			int k = end;
			boolean rightStart = false;
			int right = 1;
			while (k >= start){
				if (rightStart)
					right *= a[k];
				if(a[k] < 0){
					rightStart = true;
				}
				k--;
			}
			return Math.max(left, right);
			
		}
		
	}
	
	
/*
Case 2: What if we have double numbers which are within -1.0 to 1.0, e.g. 0.5
idea from: https://www.youtube.com/watch?v=twaGE43dbu0
Key idea: need to discard currPos if currPos < 1
Basic idea:
Required variables: 
	Current Largest positive/negative product so far
	Global Largest positive/negative product
Procedures:
	With a positive value K:
		Current-Largest-Positive *= K
		Current-Largest-Negative *= K
	With a negative value K:
		Current-Largest-Negative = Current-Largest-Positive * K
		Current-Largest-Positive = Current-Largest-Negative * K
	With a negative value K (or initial state)
		Current-Largest-Poistive = Current-Largest-Negative = 1
	If Current-Largest-Positive < 1, drop it
		If it's less than 1, it cannot be part of LSP(Largest Subsequent Product) including future values
		Similar as max subsequent sum, we discard the temporary sum when it is less than 0
		

 
 Note: this solution is equivalent to the above Solution 1	
*/
public double findMaxProduct3(double[] a){
	if (a == null || a.length == 0)
		return 0;
	double globalMaxPos = 0;
	double globalMaxNeg = 0;
	double currPos = 1;
	double currNeg = 1;
	double max_distance = Math.abs(a[0]);//add this max_distance to handle the case we only have numbers (<1 & >-1)
	
	for(int i=0; i<a.length;i++){
		max_distance = Math.max(max_distance, Math.abs(a[i]));
		if(a[i]>0){
			currPos *= a[i];
			if(currNeg != 1)//olny update it when it is set before
				currNeg *= a[i];
		} else if(a[i] < 0){
			if(currNeg == 1){
				//The negative value can be computed by using Pos*a[i]
				currNeg = currPos * a[i];
				currPos =1;
			}
			else{
				double tempNeg = currNeg;
				currNeg = currPos * a[i];
				currPos = tempNeg * a[i];
			}
		}
		else{//it is 0
			currPos = 1;
			currNeg = 1;
		}
		
		if(currPos > globalMaxPos)
			globalMaxPos = currPos;
		if(currNeg < globalMaxNeg)
			globalMaxNeg = currNeg;//actually we don't need this global neg value, but for reference
		
		//last step, we need discard the current product if it is less than 1
		if(currPos < 1)
			currPos = 1;
	
	}
	if(max_distance<=1){
		return smallMaxProduct(a);
	}
	return globalMaxPos;
}
	
	public double smallMaxProduct(double[] a){//this method is specially for all input numbers are within -1 to 1
		//pick the largest one biggest positive and two smallest negative
		double max_number = 0;
		double min_number1 = 0;
		double min_number2 = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>0){
				max_number=Math.max(max_number, a[i]);
			}
			else if(a[i]<0){
				double temp = Math.max(min_number1, min_number2);
				temp = Math.max(temp, a[i]);
				if(a[i] != temp){
					if(temp==min_number1) min_number1=a[i];
					else if(temp==min_number2) min_number2=a[i];
				}
			}
		}
		return Math.max(max_number, min_number1*min_number2);
	}
	
	public static void main(String[] args){
		FindSubArrayWithMaxProduct o = new FindSubArrayWithMaxProduct();
		double[] a = {-0.9,0};
		System.out.println(o.findMaxProduct3(a));
	}

}
