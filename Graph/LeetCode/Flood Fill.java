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
