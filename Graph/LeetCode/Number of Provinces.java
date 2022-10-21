// https://leetcode.com/problems/number-of-provinces/
// method 01 --> dfs traversal
class Solution {
    int count;
    public void dfs(int start, List<List<Integer>>adjList,int visited[]){
       visited[start]=1;
        for(Integer eachnode:adjList.get(start)){
            if(visited[eachnode]==0){
              dfs(eachnode,adjList,visited);  
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        count=0;
        int row=isConnected.length;
       int visited[]=new int[row+1];
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<row;i++){
             adjList.add(new ArrayList<>());
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
       for(int i=0;i<row;i++){
               if(visited[i]==0){
               dfs(i,adjList,visited);
               count++;
               }
           }
        return count;
       }
}
// method 02
class Solution {
    public void dfs(int start,int[][] isConnected){
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[start][j]==1){
                isConnected[start][j]=isConnected[j][start]= 2; // mark it visited
                dfs(j,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[i][i]==1){
                dfs(i,isConnected);
                count++;
            }
        }
    return count;
    }
}
// 0--> not connected
//1--> connected
//2--> visited
