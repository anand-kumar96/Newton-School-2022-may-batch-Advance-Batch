//https://leetcode.com/problems/unique-paths/
// Binomila solution--> without array
class Solution {
    public int uniquePaths(int m, int n) {
        int S=m+n-2;// total number of step need 
        int k=m-1;// number of steps that need to go down
      if((S-k)<k){
          k=S-k;
        }
        long way=1; // total number of diffferent path-->combination(S,k)-->sCk
        for(int i=0;i<k;i++){
            way=way*(S-i);
            way=way/(i+1);
        }
        return (int)way;
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        
        int S=m+n-2;// total number of step need 
        int k=m-1;// number of steps that need to go down
        long way=1; // total number of diffferent path-->combination(S,k)-->sCk
        for(int i=1;i<=k;i++){
            way=way*(S-k+i)/i;
        }
        return (int)way;
    }
}
// method 02--> Same as Minimum path sum --. with array
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int path[][]=new int[m][n];
        path[0][0]=0;
        // for 0th row
        for(int i=1;i<n;i++){
            path[0][i]=1;
        }
        // for 0th col
        for(int i=1;i<m;i++){
            path[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}
// (0,0)-->1
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int path[][]=new int[m][n];
        // for 0th row
        for(int i=0;i<n;i++){
            path[0][i]=1;
        }
        // for 0th col
        for(int i=0;i<m;i++){
            path[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}
/*
 to find ncr
 method 01
       if((n-r)<r){
          r=n-r;
        }
        long res=1; 
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return (int)res;
        
        
        // method 02
  
        long res=1; 
        for(int i=1;i<=r;i++){
            res=res*(n-r+i)/i;
            
        }
        return (int)res;
        
*/
/*
First of all you should understand that we need to do n + m - 2 movements : m - 1 down, n - 1 right, because we start from cell (1, 1).
Secondly, the path it is the sequence of movements( go down / go right),
therefore we can say that two paths are different
when there is i-th (1 .. m + n - 2) movement in path1 differ i-th movement in path2.
So, how we can build paths.
Let's choose (n - 1) movements(number of steps to the right) from (m + n - 2),
and rest (m - 1) is (number of steps down).
I think now it is obvious that count of different paths are all combinations (n - 1) movements from (m + n-2).
*/
