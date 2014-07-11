

//BFS + start from boundaries
//find connected 'O' from boundaries
//idea comes from: http://fisherlei.blogspot.com/2013/03/leetcode-surrounded-regions-solution.html


import java.util.*;
public class SurroundedRegions {
	 public void solve(char[][] board) {
		 //queues for BFS
		 LinkedList<Integer> q_x = new LinkedList<Integer>();
		 LinkedList<Integer> q_y = new LinkedList<Integer>();
		 
		 int m = board.length;
		 if(m==0)
			 return;
		 int n = board[0].length;
		 if(n==0)
			 return;
		 
		 //check boundaries
		 for(int j=0;j<n;j++){
			 if(board[0][j]=='O'){
				 q_x.add(0);
				 q_y.add(j);
				 System.out.println("0 "+0+" j "+j);

				 board[0][j]='Y';
			 }
			 if(board[m-1][j]=='O'){
				 q_x.add(m-1);
				 q_y.add(j);
				 System.out.println("m-1 "+m+"j "+j);
				 board[m-1][j]='Y';
			 }
		 }
		 for(int i=0;i<m;i++){
			 if(board[i][0]=='O'){
				 q_x.add(i);
				 q_y.add(0);
				 board[i][0]='Y';
				 System.out.println("i "+i+" 0 "+0);

			 }
			 if(board[i][n-1]=='O'){
				 q_x.add(i);
				 q_y.add(n-1);
				 board[i][n-1]='Y';
				 System.out.println("i "+i+" n-1 "+n);

			 }
		 }
		 for(int i=0;i<q_x.size();i++)
			 System.out.println("q_x "+q_x.get(i)+" q_y "+q_y.get(i));
		 
		 
		 System.out.println("q_x "+q_x.size()+" q_y "+q_y.size());
		 
		 //BFS
		 while(!q_x.isEmpty()){
			 int cur_x = q_x.pop();
			 int cur_y = q_y.pop();
			 System.out.println("x "+cur_x+" y "+cur_y+" sizex "+q_x.size()+" sizey "+q_y.size());

			 if(cur_x+1<m && board[cur_x+1][cur_y]=='O'){
				 board[cur_x+1][cur_y]='Y';
				 q_x.add(cur_x+1);
				 q_y.add(cur_y);
			 }
			 if(cur_x-1>0 && board[cur_x-1][cur_y]=='O'){
				 board[cur_x-1][cur_y]='Y';
				 q_x.add(cur_x-1);
				 q_y.add(cur_y);
			 }
			 if(cur_y+1<n && board[cur_x][cur_y+1]=='O'){
				 board[cur_x][cur_y+1]='Y';
				 q_x.add(cur_x);
				 q_y.add(cur_y+1);
			 }
			 if(cur_y-1>0 && board[cur_x][cur_y-1]=='O'){
				 board[cur_x][cur_y-1]='Y';
				 q_x.add(cur_x);
				 q_y.add(cur_y-1);
			 }
			 
		 }
		 
		 //flip all 'O' to 'X' first, then flip all 'Y' to 'O'
		 for(int i=0;i<m;i++){
			 for(int j=0;j<n;j++){

				 if(board[i][j]=='O')
					 board[i][j]='X';
				 if(board[i][j]=='Y')
					 board[i][j]='O';
			 }
		 }
		 return;
		 
		 
		 
	 }
	 public static void main(String[] args){
		 SurroundedRegions o = new SurroundedRegions();
		 char[][] board ={{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		 o.solve(board);
				 
		 
		 for(int i=0;i<board.length;i++){
			 for(int j=0;j<board[0].length;j++){
				 System.out.print(" "+board[i][j]);
			 }
			 System.out.println();
		 }
				 
				//  ["OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"]
		 
	 }
}
