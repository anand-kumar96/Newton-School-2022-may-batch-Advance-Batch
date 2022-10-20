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
