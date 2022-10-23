//https://leetcode.com/problems/rotting-oranges/
// method 01
 class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int numberofminutes=0;
        int freshOranges=0;
        Queue<Pair>q= new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        int dir[][]={{0,-1},
                    {-1,0},
                    {0,+1},
                    {+1,0},
                    };
            
          while(!q.isEmpty()){
             numberofminutes++;
            int size=q.size(); // important point--> n rotten can rotten  m orange in 1 minutes
            for(int i=0;i<size;i++){
            Pair temp=q.poll();
            int row1=temp.row;
            int col1=temp.col;
            for(int j=0;j<4;j++){
                int r=row1+dir[j][0];
                int c=col1+dir[j][1];
                if(r>=0 
                   && r<grid.length 
                   && c>=0 
                  && c<grid[0].length
                  && grid[r][c]==1
                  ){
                    grid[r][c]=2;
                    q.add(new Pair(r,c));
                    freshOranges--;
                }
            }
        }
            
    }
        numberofminutes--; // last added coordinate adding after freshOranges already become 0
        if(freshOranges==0){
            return numberofminutes;
        }else{
            return -1;
        }
 
    }
}
