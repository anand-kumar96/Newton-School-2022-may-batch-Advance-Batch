//https://leetcode.com/problems/01-matrix/
// method 01
/*
expalnation add all cordinate of 0 in queue and update ans=0; if matrix is not 0 update with -1
thn keep on searching by polling queue in all 4 dirn if -1 got thn update ans[in that dirn]=ans+1 and add that cordinate in queue
thn return 
*/
class Solution {
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
    public int[][] updateMatrix(int[][] mat) {
        // we are going to traverse 0 and try to find where is 1
        class Pair{
            int row;
            int col;
            Pair(int row,int col){
                this.row=row;
                this.col=col;
            }
        }
        
        Queue<Pair>q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    ans[i][j]=0;
                }else{
                    ans[i][j]=-1; 
                }
            }
        }
      
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int row=temp.row;
            int col=temp.col;
             int[]r={-1, 1, 0 , 0};
              int c[] ={0 ,0,-1,+1};
            for(int i=0;i<4;i++){
                int row1=row+r[i];
                int col1=col+c[i];
                if(isValid(row1,col1,n,m) && ans[row1][col1]==-1){
                ans[row1][col1]=ans[row][col]+1;
                q.add(new Pair(row1,col1));
                    
            }
    }
}
        return ans;
}
}
// method 02
class Solution {
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
    public int[][] updateMatrix(int[][] mat) {
        // we are going to traverse 0 and try to find where is 1
        class Pair{
            int row;
            int col;
            Pair(int row,int col){
                this.row=row;
                this.col=col;
            }
        }
        
        Queue<Pair>q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    ans[i][j]=0;
                }else{
                    ans[i][j]=-1; 
                }
            }
        }
      
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int row=temp.row;
            int col=temp.col;
             int[]r={-1, 1, 0 , 0};
              int c[] ={0 ,0,-1,+1};
            for(int i=0;i<4;i++){
                int row1=row+r[i];
                int col1=col+c[i];
                if(isValid(row1,col1,n,m) && ans[row1][col1]==-1){
                ans[row1][col1]=ans[row][col]+1;
                q.add(new Pair(row1,col1));
                    
            }
    }
}
        return ans;
}
}
