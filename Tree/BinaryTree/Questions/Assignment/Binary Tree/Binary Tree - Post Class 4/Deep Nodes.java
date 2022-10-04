// method 01

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
  static int k;
  public static void findDeepNode(Node root){
    if(root!=null){
      int count=0;
      int count1=0;
    Queue<Node>q=new LinkedList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
      Node temp=q.poll();
      if(temp!=null){
       //System.out.print("data--> "+temp.data+" ");
        count++;
        if(temp.left!=null){
         q.add(temp.left);
        }
        if(temp.right!=null){
         q.add(temp.right);
        }
      }else{
        System.out.print(count+" ");
        count1++;
        count=0;
        if(!q.isEmpty()){
          q.add(null);
        }

      }
    }
    for(int i=0;i<k-count1;i++){
  System.out.print("0"+" ");
  }
  }
  }
    public static void main (String[] args) {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   k=n;
   Node leftchild=null;
   Node rightchild=null;
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
         leftchild=hm.get(l);

       }else{
         leftchild=new Node(l);
          root.left=leftchild;
       }
        hm.put(l,leftchild);
     }
    if(r!=-1){
       if(hm.containsKey(r)){
         rightchild=hm.get(r);
       }else{
         rightchild=new Node(r);
          root.right=rightchild;
       }
       hm.put(r,rightchild);
     }

   }
   findDeepNode(hm.get(1));
    }
}

// method 02
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
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();                  //Nos of Nodes
    Node root, leftchild, rightchild;       //Initilize root,left,right
    HashMap < Integer, Node > hm = new HashMap <>(); // hashmap for int and Nodes
    for (int i = 1; i <= n; i++) {
      if (hm.containsKey(i))
        root = hm.get(i);
      else {
        root = new Node(i);
        hm.put(i, root);
      }
      int l = sc.nextInt();
      int r = sc.nextInt();
    //Left Child
      if (l != -1) {
        if (hm.containsKey(l))
          leftchild = hm.get(l);
        else {
          leftchild = new Node(l);
          hm.put(l, leftchild);
        }
        root.left = leftchild;
      }
      //Right Child
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
    arr=new int[n];
    deepNodes(hm.get(1));
    for(int j=0;j<n;j++){
      System.out.print(arr[j]+" ");
    }
  }
  static int[]arr;
private static void deepNodes(Node root){
    if(root==null) return;
    int result=0;
    int i=0;
    Queue<Node> qu=new LinkedList<>();
    qu.add(root);
    qu.add(null);
    List<List<Integer>>list=new ArrayList<>();
    List<Integer> t=new ArrayList<>();
    while(!qu.isEmpty()){
      Node temp=qu.poll();
      if(temp!=null){
            t.add(temp.data) ;
            if(temp.left!=null) qu.add(temp.left);
            if(temp.right!=null) qu.add(temp.right);
      }else{
            List<Integer>t2=new ArrayList<>(t);
            list.add(t2);
            arr[i]=t2.size();
            t.clear();
            i++;
        if(!qu.isEmpty()){
           qu.add(null); 
        }  
      } 
    }
}
}


/*
Deep Nodes
easy
hint
Hint

Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree of N nodes, with root 1, find the number of nodes at depth D of the tree for all D from 1 to N, where depth of root node is taken to be 1.
Input
First line contains the integer N, denoting the number of nodes in the binary tree.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'

1 <= N <= 100000
Output
Print a single line containing N integers denoting the number of nodes at depth D of the tree.
Example
Sample Input 1:
5
2 4
5 3
-1 -1
-1 -1
-1 -1
Sample output 1:
1 2 2 0 0

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3


*/
