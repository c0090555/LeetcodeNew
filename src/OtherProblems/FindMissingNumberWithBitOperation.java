package OtherProblems;
/*
An array A[1...n] contains all the integers from 0 to n except one. It would be easy to determine the missing
integer in O(n) time by using an auxiliary array B[0...n] to record which numbers appear in A. In this
problem, however, we cannot access an entire integer in A with a single operation. The elements of A are
represented in binary, and the only operation we can use to access them is Ófetch the jth bit of A[i],Ó which
takes constant time.
Show that if we use only this operation, we can still determine the missing integer in O(n) time.

idea from: http://www.cs.nyu.edu/courses/summer08/G22.1170-001/hw02-soln.pdf
Solution: divide and conquer  
Analysis:
we need ceil(lg(n+1)) digits to represent numbers from 0 to n, and the least significant bit is 0,  the most significant bit is ceil(lg(n+1))-1
for number between 0 to n, we have exactly 2^(ceil(lg(n+1)-1) numbers which is less than 2^(ceil(lg(n+1)-1) (including 0),
so let's get the [ceil(lg(n+1))-1]th digit of each number, split these numbers into two groups based on whether the value of this digit(0 or 1),
if the group zero's size is [ceil(lg(n+1)-1], then we know the missing number is within group one and the digit of that number is 1, vice versa
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
public class FindMissingNumberWithBitOperation
{	//assume n is at least 0(non-empty)
	public int findMiss(ArrayList<Integer> a){//array a stores all numbers from 0 to n except 1
		int n = a.size();
		if (n == 0)//if size is zero, then we have all used up all "zeros"
			return 1;
		if (n == 1)//if size is one, then we reach the last digit
			return (a.get(0) & 1) == 0 ? 1 : 0;
		int c = (int)Math.ceil(Math.log(n+1)/Math.log(2));
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		ArrayList<Integer> ones = new ArrayList<Integer>();
		for (int e : a){
			if (getOneDigit(e, c-1) == 0){
				zeros.add(e);
			} else{
				ones.add(e);
			}
		}
		if (zeros.size() == Math.pow(2, c-1)){
			return findMiss(ones) + (int)Math.pow(2, c-1);
		} else{
			return findMiss(zeros);
		}
		
	}
	
	public int getOneDigit(int i, int j){//get jth digit of integer i (j starts from zero), assume this method takes constant time
		i >>= j;
		i = i & 1;
		return i;
	}
	public static void main(String[] args){
		FindMissingNumberWithBitOperation o = new FindMissingNumberWithBitOperation();
		int[] a = {1,2,3,5,4};
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int e : a){
			input.add(e);
		}
		System.out.println(o.findMiss(input));
		
	}
}