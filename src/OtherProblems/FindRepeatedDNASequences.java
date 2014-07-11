package OtherProblems;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
All DNA is composed of sequences of four "letters" of nucleotides, whose abbreviations are A, C, G, and T, strung together, for example: "AAGATCCGTC".  A typical chromosome (a very long DNA molecule) may have several millions of these letters strung together.  When studying DNA, it is sometimes useful to know when a particular sequence of letters is repeated.

For this problem, we would like to identify all the 10-letter-long sequences that occur more than once in any given chromosome.  Write a program that prints out all such sequences to the standard output stream, sorted in alphabetical order.  Start with this code:
input: AAGATTAACCATCGATGGAAGATTAACC
output: on stand out:  AAGATTAACC
 
idea: 
Solution 1: use encode to save storage
encode each window first
we have A,T,C,G fours cases which requires two bits to encode, so 10-letter-long sequence needs 20 bits which is less than the size of integer:
Worst case Time Complexity: assume both encode and decode takes O(1) time, total time includes the following aspects: 
1. building hashmap for all windows: O(n)
2. construct priority queue: O(n)
3. heap sort: O(nlgn)
4. decode and print out: O(n)
Total: O(nlgn)
Worst case Space Complexity:
1. frequency hashmap: O(k) (k <= 4^10)
2. priority queue: O(k)
3. StringBuilder window and other intermediate StringBuilder - O(1)
Total: O(k)

Solution 2:
To speed up, we store "window" Strings instead of their coding value in HashMap: 
Worse case Time Complexity: O(n)
Worse case Space Complexity: O(k) (k <= 4^10)
 
 
*/ 
import java.io.InputStream;
import java.util.HashMap; 
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class FindRepeatedDNASequences
{
  public void processEntireChromosome(InputStream chromosome) throws IOException 
  {
	  StringBuilder window = new StringBuilder();
	  int currC = -1;
	  //assume we have at least 10 characters in the stream
	  for (int i = 1; i <= 10; i++){
		  currC = chromosome.read();
		 window.append((char)currC);
	  }
	  HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
	  frequency.put(encode(window), 1);
	  currC = chromosome.read();
	  while(currC != -1){
		  window.deleteCharAt(0);
		  window.append((char)currC);
		  int code = encode(window);
		  if (!frequency.containsKey(code))
			  frequency.put(code, 1);
		  else {
			  int count = frequency.get(code);
			  frequency.put(code, count+1);
		  }
		  currC = chromosome.read();
	  }
	  
	  PriorityQueue<Integer> seq =  new PriorityQueue<Integer>(100000, new Comparator<Integer>(){
		  public int compare(Integer a, Integer b){
			  return a < b ? 1 : (a > b ? -1 : 0);
		  }
	  });
	  
	  for (int k : frequency.keySet()){
		  int v = frequency.get(k);
		  if (v > 1)
			  seq.add(k);
	  }
	  
	  while (!seq.isEmpty()){
		  currC = seq.remove();
		  System.out.println(decode(currC));
	  }
	  
  }
  public int encode(StringBuilder window){
	  HashMap<Character, Integer> encodeMap = new HashMap<Character, Integer>();
	  encodeMap.put('A', 0);
	  encodeMap.put('C', 1);
	  encodeMap.put('G', 2);
	  encodeMap.put('T', 3);
	  
	  int code = 0;
	  for (int i = 0; i < window.length(); i++){
		  char c = window.charAt(i);
		  code |= encodeMap.get(c);
		  code <<= 2;
	  }
	  return code;
  }
  
  public StringBuilder decode(int e){
	  StringBuilder de = new StringBuilder();
	  char[] decodeMap = new char[4];
	  decodeMap[0] = 'A';
	  decodeMap[1] = 'C';
	  decodeMap[2] = 'G';
	  decodeMap[3] = 'T';
	  for (int i = 20; i>=2; i-=2){
		  int digit = e >> i;
		  digit &= 3; //only preserve the last two digits
		  de.append(decodeMap[digit]);
	  }
	  return de;
  }
  
  public void processEntireChromosome2(InputStream chromosome) throws IOException 
  {
	  StringBuilder window = new StringBuilder();
	  int currC = -1;
	  //assume we have at least 10 characters in the stream
	  for (int i = 1; i <= 10; i++){
		  currC = chromosome.read();
		 window.append((char)currC);
	  }
	  HashMap<String, Integer> frequency = new HashMap<String, Integer>();
	  frequency.put(window.toString(), 1);
	  currC = chromosome.read();
	  while (currC != -1){
		  window.deleteCharAt(0);
		  window.append((char)currC);
		  String currS = window.toString();
		  if (!frequency.containsKey(currS)){
			  frequency.put(currS, 1);
		  } else{
			  int count = frequency.get(currS);
			  frequency.put(currS, count+1);
		  }
		  currC = chromosome.read();
	  }
	  
	  ArrayList<String> validWindows = new ArrayList<String>();
	  for (String s : frequency.keySet()){
		  int v = frequency.get(s);
		  if (v > 1){
			  validWindows.add(s);
		  }
	  }
	  
	  //LDS Radix Sort - O(n*k), k=10		  
	  for (int i = 9;i>=0;i--){
		  ArrayList<String> As = new ArrayList<String>();
		  ArrayList<String> Cs = new ArrayList<String>();
		  ArrayList<String> Gs = new ArrayList<String>();
		  ArrayList<String> Ts = new ArrayList<String>();
		  for (String w : validWindows){
			  char c = w.charAt(i);
			  switch(c){
				  case 'A':
					  As.add(w);
					  break;
				  case 'C':
					  Cs.add(w);
					  break;
				  case 'G':
					  Gs.add(w);
					  break;
				  case 'T':
					  Ts.add(w);
					  break;
				  default:
					  break;
			  }
		  }
		  validWindows  = new ArrayList<String>();
		  validWindows.addAll(As);
		  validWindows.addAll(Cs);
		  validWindows.addAll(Gs);
		  validWindows.addAll(Ts);
	  }
	  
	  //print out
	  for (String validWin : validWindows){
		  System.out.println(validWin);
	  }
  }
  public static void main(String[] args) throws IOException {
	  FindRepeatedDNASequences o = new FindRepeatedDNASequences();
	  FileInputStream chromosome = new FileInputStream("/Users/yisongwang/Desktop/test");
	  o.processEntireChromosome2(chromosome);
	  
  }
  
} 