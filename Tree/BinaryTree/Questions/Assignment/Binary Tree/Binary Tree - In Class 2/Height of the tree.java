import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Node> nodes= new ArrayList<>();
        for(int i=1;i<=n;i++){
            Node temp=new Node(i);
            nodes.add(temp);
        }
        Node root=nodes.get(0);// root is allways 1
        for(int i=1;i<n;i++){
            int source=sc.nextInt();
            int destination=sc.nextInt();
            Node sourceTemp=nodes.get(source-1);
            Node destinationTemp=nodes.get(destination-1);
            sourceTemp.list.add(nodes.get(destination-1));
            destinationTemp.list.add(nodes.get(source-1));
        }
        HashSet<Integer> visited=new HashSet<>();
        int height=findHeight(root, visited);
        System.out.print(height-1);
        
    }
    static int findHeight(Node root, HashSet<Integer> visited){
        if(root==null)
            return 0;
        int max=0;
        visited.add(root.data);
        ArrayList<Node> tempList=new ArrayList<>();
        tempList=root.list;
        for(Node iterator : tempList)
        {
            if(!visited.contains(iterator.data))
            {
               max=Math.max(max, findHeight(iterator,visited));  
            }
                
        }
        return max+1;
    }
    

}
class Node{
    int data;
    ArrayList<Node> list;
    Node(int x){
        data=x;
        list=new ArrayList<>();
    }
}

/*
Height of the tree
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a tree rooted at node 1, find the height of the tree. The height of the tree is the maximum number of edges between the root node and any node of the tree.
Input
First line contains N, the number of nodes in the tree.
N-1 lines follow containing u and v denoting an edge between node u and node v.
The input is guaranteed to be a tree.

1 <= N <= 100000
1 <= u,v <= N
u != v
Output
Output a single integer containing the height of the tree.
Example
Sample Input
4
1 2
2 3
1 4

Sample output
2

Sample Input
3
1 2
2 3

Sample output
2
*/
