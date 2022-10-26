//https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// method 01-->Using Dfs+Stack



class Solution
{
    //Function to return list containing vertices in Topological order. 
    public static void dfs(int node,int visited[],Stack<Integer>st,ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        for(Integer it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,st,adj);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int visited[]=new int[V];
    Stack<Integer>st=new Stack<>();
    int res[]=new int[V];
    for(int i=0;i<V;i++){
        if(visited[i]==0){
            dfs(i,visited,st,adj);
        }
    }
    int j=0;
    while(!st.isEmpty()){
        res[j++]=st.pop();
    }
    return res;
    }
}
// method 02
