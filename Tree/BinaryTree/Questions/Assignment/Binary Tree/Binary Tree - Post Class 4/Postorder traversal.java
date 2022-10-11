import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
 class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
      this.data=data;
      left=right=null;
    }
  }
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Node leftChild=null;
    Node rightChild=null;
    Node root=null;
    HashMap<Integer,Node>hm=new HashMap<>();
    for(int i=1;i<=n;i++){
      if(hm.containsKey(i)){
         root=hm.get(i);
      }else{
        root=new Node(i);
        hm.put(i,root);
      }
      int l=sc.nextInt();
      int r=sc.nextInt();
      if(l!=-1){
        if(hm.containsKey(l)){
          leftChild=hm.get(l);
        }else{
          leftChild=new Node(l);
          hm.put(l,leftChild);
        }
        root.left=leftChild;
      }
      if(r!=-1){
        if(hm.containsKey(r)){
          rightChild=hm.get(r);
        }else{
          rightChild=new Node(r);
          hm.put(r,rightChild);
        }
        root.right=rightChild;
      }

    }
    Postorder(hm.get(1));
    }
    public static void Postorder(Node root){
      if(root!=null){
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data+" ");
      }
    }
}

/*
Postorder traversal
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree, with root 1, print the postorder traversal of the tree.
Algorithm Postorder(tree)
1. Traverse the left subtree
2. Traverse the right subtree
3. Visit the root
Input
The input consists of N+1 lines.
First line contains the integer N, denoting the number of nodes in the binary tree.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'

1 <= N <= 100000
Output
Print a single line containing N space separated integers representing the postorder traversal of the given tree
Example
Sample Input 1:
5
2 4
5 3
-1 -1
-1 -1
-1 -1
Sample output 1:
5 3 2 4 1

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3

*/
