// method 01 -->using dfs
//https://leetcode.com/problems/flood-fill/
class Solution {
    public void dfs( int ans[][],int[][] image, int row, int col, int newColor,
                    int iniColor,int delrow[],int delcol[]){
        ans[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!=newColor){
            dfs(ans,image,nrow,ncol,newColor,iniColor,delrow,delcol);
        }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int iniColor=image[sr][sc];
        int delrow[]={0,-1,0,+1};
        int delcol[]={-1,0,+1,0};
        dfs(ans,image,sr,sc,color,iniColor,delrow,delcol);
        return ans;
    }
}


// method 02
class Solution {
    public void dfs( int ans[][],int[][] image, int row, int col, int newColor,
                    int iniColor,int delrow[],int delcol[]){ 
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col]!=iniColor 
           || ans[row][col]==newColor){
            return;
           
        }
             ans[row][col]=newColor;
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                 int ncol=col+delcol[i];
                
                 dfs(ans,image,nrow,ncol,newColor,iniColor,delrow,delcol);
            }
            
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int iniColor=image[sr][sc];
         int delrow[]={0,-1,0,+1};
         int delcol[]={-1,0,+1,0};
       dfs(ans,image,sr,sc,color,iniColor,delrow,delcol);
        return ans;
    }
}
// method 03
class Solution {
    public void dfs( int ans[][],int[][] image, int row, int col, int newColor,
                    int iniColor){ 
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col]!=iniColor 
           || ans[row][col]==newColor){
            return;
           
        }
             ans[row][col]=newColor;
            
        //up
        dfs(ans,image,row-1,col,newColor,iniColor);
        //down
       dfs(ans,image,row+1,col,newColor,iniColor);
        //left
        dfs(ans,image,row,col-1,newColor,iniColor);
        // right
        dfs(ans,image,row,col+1,newColor,iniColor);
            
            
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int iniColor=image[sr][sc];
       dfs(ans,image,sr,sc,color,iniColor);
        return ans;
    }
}
