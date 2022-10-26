// method 03
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static List<List<Integer>>adj;
    Main(int V){
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    public static boolean dfs(int a,int b,int visited[]){
        visited[a]=1;
        for(Integer it:adj.get(a)){
            if(visited[it]==0){
            if(it==b){
                return true;
            }else{
                if(dfs(it,b,visited)){
                    return true;
                }
            }
          }
        }
        return false;
    }
    public static boolean checkpath(int a, int b,int V){
     int visited[]=new int[V];
     int x=a;
     int y=b;
     if(a>b){
         x=b;
         y=a;
     }
     for(int i=x;i<V;i++){
         if(visited[i]==0){
             if(dfs(i,b,visited)){
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
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int V=sc.nextInt();
    int E=sc.nextInt();
    Main main=new Main(V);
    for(int i=0;i<E;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        main.addEdge(u,v);
    }
    int a=sc.nextInt();
    int b=sc.nextInt();
    System.out.println(main.checkpath(a,b,V));
    }
}
// method 01
// using adjlist
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static List<List<Integer>>adj;
    Main(int V){
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    public static boolean checkpath(int a, int b,int V){
     int visited[]=new int[V];
     Stack<Integer>st=new Stack<>();
     st.add(a);
     while(!st.isEmpty()){
         int node=st.pop();
         if(visited[node]==0){
             visited[node]=1;
             if(node==b){
                 return true;
             }
         }
         for(Integer it:adj.get(node)){
             if(visited[it]==0){
                 st.push(it);
             }
         }
     }
     return false;
    }
    public static void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int V=sc.nextInt();
    int E=sc.nextInt();
    Main main=new Main(V);
    for(int i=0;i<E;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        main.addEdge(u,v);
    }
    int a=sc.nextInt();
    int b=sc.nextInt();
    System.out.println(main.checkpath(a,b,V));
    }
}

// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
   public class Main{
    Map<Object, HashSet<Object>> graph;
    Main() {
        graph = new HashMap<>();
    }
    private void addEdge(Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }
        if(!graph.containsKey(v)) {
            graph.put(v, new HashSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    private boolean checkIfPathExists(Object u, Object v) {
        Set<Object> visitedSet = new HashSet<>();
        Stack<Object> stack = new Stack<>();
        stack.add(u);
        while(!stack.isEmpty()) {
            Object currentNode = stack.pop();

            if(!visitedSet.contains(currentNode)) {
                if(currentNode == v) {
                    return true;
                }
                visitedSet.add(currentNode);
            }

            HashSet<Object> neighbours = graph.get(currentNode);
            for(Object eachNeighbour : neighbours) {
                if (!visitedSet.contains(eachNeighbour)) {
                    stack.add(eachNeighbour);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        for(int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            main.addEdge(u, v);
        }
        int u = scanner.nextInt();
        int v = scanner.nextInt();
        boolean result = main.checkIfPathExists(u, v);

        System.out.println(result);
    }
}

/*
Has Path
easy
hint
Hint

Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given an undirected graph G (V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true or false.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Input
Line 1: Two Integers V and E (separated by space)
Next E lines: Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
Line (E+2): Two integers v1 and v2 (separated by space)

Constraints :
2 <= V <= 1000
1 <= E <= 1000
0 <= v1, v2 <= V-1
Output
For each testcase in new line, you need to print true or false.
Example
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3

Sample Output 1 :
true

Explanation:
There are multiple path exists between 1 and 3. One of them is as such: 1 -> 2 -> 3.

*/
