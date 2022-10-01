//https://my.newtonschool.co/playground/code/h6xwfitts6i0/

// method 01

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
     Scanner sc=new Scanner(System.in);
     int count=0;
     int n=sc.nextInt();
     for(int i=0;i<n;i++){
         int a=sc.nextInt();
         int b=sc.nextInt();
         if(a==-1 && b==-1){
             count++;
         }
     }
   System.out.println(count);
    }
}


// method 02

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Node{
    Node leftChild;
    Node rightChild;
    int data;
    Node(int data){
        this.data=data;
        leftChild=rightChild=null;
    }
}
class Main {
 static int count=0;
 public static void calculateleave(Node root){
  if(root!=null){
      if(root.leftChild==null && root.rightChild==null){
          count++;
      }
      calculateleave(root.leftChild);
      calculateleave(root.rightChild);
  }
 }
    public static void main (String[] args) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     Node root=null;
     Node left=null;
     Node right=null;
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
                left=hm.get(l);
            }else{
                left=new Node(l);
                hm.put(l,left);
            }
            root.leftChild=left;
        }
        if(r!=-1){
            if(hm.containsKey(r)){
                left=hm.get(r);
            }else{
                right=new Node(r);
                hm.put(r,right);
            }
            root.rightChild=right;
        }
     }
     calculateleave(hm.get(1));
      System.out.println(count);
    }
   
}
/*
Count Leaves in Binary Tree
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree, count the number of leaves in it. A node having no child node is called a leaf.
Input
The first line contains the integer N, denoting the number of nodes in the binary tree.
Next N lines contain two integers, denoting the left and right child of the i-th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'

1 <= N <= 100000
Output
Print the number of leaves in the binary tree
Example
Sample Input 1:
7
2 4
5 3
-1 -1
-1 7
6 -1
-1 -1
-1 -1

Sample output 1:
3

Explanation: Given binary tree
1
/ \
2 4
/ \ \
5 3 7
/
6
Node 3, 6, 7 are the leaves here
*/
