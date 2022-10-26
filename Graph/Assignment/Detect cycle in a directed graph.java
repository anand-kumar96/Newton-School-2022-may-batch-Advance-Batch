//method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework
// don't change the name of this class
// you can add inner classes if needed
class Main{
       static List<List<Integer>>adj;
        Main(int N){
       adj=new ArrayList<>();
       for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());   
       }
   } 
    public static boolean detectCycle(boolean visited[],int node,boolean dfsVisited[]){
      visited[node]=true;
      dfsVisited[node]=true;
      for(Integer it:adj.get(node)){
          if(visited[it]==false){
              if(detectCycle(visited,it,dfsVisited)){
                      return true;
              }    
          }else if(dfsVisited[it]==true){
                  return true;
          }    
      }
      dfsVisited[node]=false;
      return false;
    }
    public static boolean isCycle(int N){
     boolean visited[]=new boolean[N];
      boolean dfsVisited[]=new boolean[N];
     Arrays.fill(visited,false);
    Arrays.fill(dfsVisited,false);
     for(int i=0;i<N;i++){
        if(visited[i]==false){
         if(detectCycle(visited,i,dfsVisited)){
                 return true;
         }
        }
     }
     return false;
   }
     public static void addEdge(int u,int v){
             adj.get(u).add(v);
     }
    public static void main (String[] args){
            Scanner sc=new Scanner(System.in);
            int N=sc.nextInt();
            int M=sc.nextInt();
             Main main=new Main(N);
            for(int i=0;i<M;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                if(u>=N || v>=N){
                    System.out.println("Yes");
                    return;     
                }
                main.addEdge(u,v);      
             }
        boolean result=main.isCycle(N);
        if(result==true){
         System.out.println("Yes");
        }else
         System.out.println("No");  
    }
}

/*
Detect cycle in a directed graph
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a directed graph, detect the presence of a cycle in the graph.
Input
The first line of input contains two integers N and M which denotes the no of vertices and no of edges in the graph respectively.
Next M lines contain space-separated integers u and v denoting that there is a directed edge from u to v.

Constraints:
1 <= N, M <= 1000
0 <= u, v <= N-1, u != v
There are no self loops or multiple edges.
Output
The method should return 1 if there is a cycle else it should return 0.
Example
Sample Input 1:
4 5
0 1
1 2
2 3
3 0
0 2

Sample Output 1:
Yes

Explanation:
There is a cycle with nodes 0, 1, 2, 3

Sample Input 2:
4 4
0 1
1 2
2 3
0 3

Sample Output 2:
No

Explanation:
There is no cycle in this graph
*/
