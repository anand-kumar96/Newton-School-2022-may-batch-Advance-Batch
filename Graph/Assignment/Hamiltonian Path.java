import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    List<List<Integer>> graph;
    Set<Object> visitedSet;
   Main(int N) {
        graph = new ArrayList<>();
        for(int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visitedSet = new HashSet<>();
    }
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    public boolean checkIfHamiltonianPathExistsHelper(int u, int N) {
        if(visitedSet.size() == N) {
            return true;
        }
        boolean result = false;
        List<Integer> neighbours = graph.get(u);
        for(Integer eachNeighbour : neighbours) {
            if(visitedSet.contains(eachNeighbour)) {
                continue;
            }
            visitedSet.add(eachNeighbour);
            result = result || checkIfHamiltonianPathExistsHelper(eachNeighbour, N);
            visitedSet.remove(eachNeighbour);
        }
        return result;
    }
    public boolean checkIfHamiltonianPathExists(int N) {
        for(int i = 1; i <= N; i++) {
            visitedSet.add(i);
            if(checkIfHamiltonianPathExistsHelper(i, N)) {
                return true;
            }
            visitedSet.remove(i);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
       Main main = new Main(N);
        for(int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
           main.addEdge(u, v);
        }
        int result = (main.checkIfHamiltonianPathExists(N) ? 1 : 0);
        System.out.println(result);
    }
}

/*
Hamiltonian Path
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
A Hamiltonian path is a path in an undirected or directed graph that visits each vertex exactly once. Given an undirected graph, the task is to check if a Hamiltonian path is present in it or not.
Input
The first line consists of two space- separated integers N and M denoting the number of vertices and number of edges. Then in the next M lines are space- separated pairs u, v denoting an edge from u to v.

Constraints:
1 <= N <= 15
1 <= M <= 15
1 <= u, v <= N
Output
For each test case in a new line print 1 if a Hamiltonian path exists else print 0.
Example
Sample Input
4 4
1 2
2 3
3 4
2 4

Sample Output
1

Sample Input
4 3
1 2
2 3
2 4

Sample Output
0

*/
