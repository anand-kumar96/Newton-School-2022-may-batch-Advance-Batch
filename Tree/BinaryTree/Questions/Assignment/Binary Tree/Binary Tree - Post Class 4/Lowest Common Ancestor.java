import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Node {
  Node left;
  Node right;
  int data;
  Node(int data) {
    this.data = data;
    right = null;
    left = null;
  }
}
class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int q=scn.nextInt();
    Node root, leftchild, rightchild;
    HashMap < Integer, Node > hm = new HashMap <>();
    for (int i = 1; i <= n; i++) {
      if (hm.containsKey(i))
        root = hm.get(i);
      else {
        root = new Node(i);
        hm.put(i, root);
      }

      int l = scn.nextInt();
      int r = scn.nextInt();

      if (l != -1) {
        if (hm.containsKey(l))
          leftchild = hm.get(l);
        else {
          leftchild = new Node(l);
          hm.put(l, leftchild);
        }
        root.left = leftchild;
      }
      
      if (r != -1) {
        if (hm.containsKey(r))
          rightchild = hm.get(r);
        else {
          rightchild = new Node(r);
          hm.put(r, rightchild);
        }
        root.right = rightchild;
      }
    }
    for(int i=0;i<q;i++){
        int a=scn.nextInt();
        int b=scn.nextInt();
        Node x=hm.get(a);
        Node y=hm.get(b);
        System.out.println(lowestCommonAncestor(hm.get(1),x,y).data);
    }
  }
  public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null || root==p||root==q){
            return root;
        }
        Node left=lowestCommonAncestor(root.left, p,q);
        Node right=lowestCommonAncestor(root.right, p,q);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else
        return root;
    }
}

/*
Lowest Common Ancestor
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree of N nodes, with root 1 and Q queries with nodes u and v. For each query find the lowest common ancestor of nodes u and v.
The lowest common ancestor between two nodes u and v is defined as the lowest node in T that has both u and v as descendants (where we allow a node to be a descendant of itself).
Expected time complexity - O(N) per query
Input
First line contains the integer N and Q, denoting the number of nodes in the binary tree and the number of queries respectively.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'
Next Q lines contain two integers u and v
1 <= N, Q <= 10000
1 <= u, v <= N
Output
Print Q lines denoting the lowest common ancestor of the respective query
Example
Sample Input 1:
6 3
2 4
5 3
-1 -1
-1 -1
6 -1
-1 -1
3 6
2 5
6 4
Sample output 1:
2
2
1

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3
/
6
*/
