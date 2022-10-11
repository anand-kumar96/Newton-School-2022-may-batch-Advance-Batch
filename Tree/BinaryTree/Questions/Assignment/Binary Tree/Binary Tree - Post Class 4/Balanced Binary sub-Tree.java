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
    getHeight(hm.get(1));
   System.out.println(count);
  }
  static int count=0;
    private static int getHeight(Node node){
        if(node==null) return 0;
        int l=getHeight(node.left);
        int r=getHeight(node.right);
        if(Math.abs(l-r)<=2){
            count++;
        }
        return l+r+1;
    }
}

/*
Balanced Binary sub-Tree
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree, with root 1, find the number of balanced subtrees of the given tree.
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
Let S[u] denote the size of subtree at node u.
The subtree at node u is said to be Balanced if abs(S[leftchild(u)] - S[rightchild(u)]) <= 2
A null node is assumed to be a subtree with size 0.
Input
The input consists of N+1 lines.
First line contains the integer N, denoting the number of nodes in the binary tree.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'

1 <= N <= 100000
Output
Print a single line containing the number of balanced subtrees of the given tree
Example
Sample Input 1:
6
2 4
5 3
-1 -1
-1 -1
6 -1
-1 -1
Sample output 1:
5

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3
/
6
Except subtree at node 1 every other subtree is balanced

*/
