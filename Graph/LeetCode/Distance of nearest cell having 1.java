//https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

class Solution{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        class Pair{
            int row;
            int col;
            Pair(int row,int col){
                this.row=row;
                this.col=col;
            }
        }
        
        Queue<Pair>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        boolean Visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    q.add(new Pair(i,j));
                    Visited[i][j]=true;
            }
        }
    }
      
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int row=temp.row;
            int col=temp.col;
              int dirn[][]={
                  {0,-1}, // left
                  {0,+1},// right
                  {-1,0},//up
                  {1,0} //down
              };
            for(int i=0;i<dirn.length;i++){
                int row1=row+dirn[i][0];// row
                int col1=col+dirn[i][1];; // col
                if(row1<n &&
                  row1>=0 &&
                  col1<m  &&
                  col1>=0 &&
                   Visited[row1][col1]==false
                  ){
                     Visited[row1][col1]=true;
                    grid[row1][col1]=grid[row][col]+1;
                    q.add(new Pair(row1,col1));
                }
                    
            }
    }
        return grid;
    }
}
