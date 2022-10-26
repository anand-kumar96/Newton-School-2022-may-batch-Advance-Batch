// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
       static List<List<Integer>>adj;
        Main(int N){
       adj=new ArrayList<>();
       for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());   
       }
   } 
    public static boolean detectCycle(boolean visited[],int node,int parent){
      visited[node]=true;
      for(Integer it:adj.get(node)){
          if(visited[it]==false){
              if(detectCycle(visited,it,node)){
                      return true;
              }    
          }else if(it!=parent){
                  return true;
          }    
      }
      return false;
    }
    public static boolean isCycle(int N){
     boolean visited[]=new boolean[N];
     Arrays.fill(visited,false);
     for(int i=0;i<N;i++){
        if(visited[i]==false){
         if(detectCycle(visited,i,-1)){
                 return true;
         }
        }
     }
     return false;
   }
     public static void addEdge(int u,int v){
             adj.get(u).add(v);
             adj.get(v).add(u);
     }
    public static void main (String[] args){
            Scanner sc=new Scanner(System.in);
            int N=sc.nextInt();
            int M=sc.nextInt();
             Main main=new Main(N);
             for(int i=0;i<M;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                main.addEdge(u,v);      
             }
        boolean result=main.isCycle(N);
        if(result==true){
         System.out.println("Yes");
        }else
         System.out.println("No");
        
    }
}
// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    Map<Object, HashSet<Object>> graph;
    Main(int n) {
        graph = new HashMap<>();
    }
    private void addEdge(int u, int v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }
        if(!graph.containsKey(v)) {
            graph.put(v,new HashSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    private boolean isCyclicHelper(Object currentNode, Object parentNode, Set<Object> visitedSet) {
        visitedSet.add(currentNode);

        HashSet<Object> neighbours =graph.get(currentNode);

        for(Object eachNeighbour : neighbours) {
            if(!visitedSet.contains(eachNeighbour)) {
                if(isCyclicHelper(eachNeighbour,currentNode,visitedSet)) {
                    return true;
                }
            }
            else if(((Integer)eachNeighbour).intValue()!=((Integer)parentNode).intValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclic() {
        Set<Object> visitedSet = new HashSet<>();

        for(Object eachKey : graph.keySet()) {
            if(!visitedSet.contains(eachKey)) {
                 
                if(isCyclicHelper(eachKey, null,visitedSet)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Main myclass = new Main(n);

        for(int i=0;i<m;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            myclass.addEdge(u,v);
        }
        System.out.println(myclass.isCyclic()?"Yes":"No");
    }
}


/*
Detect cycle in an undirected graph
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given an undirected graph, the task is to create a program to detect if there is a cycle in the undirected graph or not.
Input
The first line of input contains two integers N and M which denotes the no of vertices and no of edges in the graph respectively.
Next M lines contain space-separated integers u and v denoting that there is a directed edge from u to v.

Constraints:
1 <= N, M <= 1000
0 <= u, v <= N-1, u != v
There are no self loops or multiple edges.
Output
Print 'Yes' if there is a cycle in the graph otherwise print 'No'
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
4 3
0 1
1 2
2 3

Sample Output 2:
No

Explanation:
There is no cycle in this graph
*/
