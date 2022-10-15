
// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int s=sc.nextInt();
     int e=sc.nextInt();
     int n=sc.nextInt();
     int arr[]=new int[n];
     for(int i=0;i<n;i++){
         arr[i]=sc.nextInt();
    }
    if(s>arr[n-1]){
         System.out.println("0");
          return;
    }
     if(e<arr[0]){
         System.out.println("0");
          return;
    }
    int x=-1;
    int y=-1;
     for(int i=0;i<n;i++){
    if(arr[i]>=s){
          x=i;
          break;
         }
    }

    for(int i=n-1;i>=0;i--){
         if(arr[i]<=e){
          y=i;
          break;
         }
    }
 if(x!=-1 && y!=-1){
 System.out.println(y-x+1);
          return;
     }
     if(x==-1 && y!=-1){
         System.out.println(y+1);
         return;
     }
    }
}

// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
   static Node root;
   static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public static int countsNode(Node root,int low,int high){
        if(root==null){
            return 0;
        }
        if(root.data<low){
            // go right sub tree
            return countsNode(root.right,low,high);
        }
        if(root.data>high){
            // go left sub tree
            return countsNode(root.left,low,high);
    }
       // go  left and right sub tree both
            return (1+countsNode(root.right,low,high)+countsNode(root.left,low,high));
    }
    public static Node insert(Node root,int data){
        if(root==null){
            Node newNode=new Node(data);
            root=newNode;
            return root;
        }
        if(data<=root.data){
            root.left= insert(root.left,data);
        }else{
          root.right= insert(root.right,data);
        }
        return root;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    Main main=new Main();
    int low=sc.nextInt();
    int high=sc.nextInt();
    int n=sc.nextInt();
    for(int i=0;i<n;i++){
        int data=sc.nextInt();
        main.root=insert(main.root,data);
    }
    int count=main.countsNode(main.root,low,high);
    System.out.println(count);

    }
}

/*
Count nodes
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a BST, count the total number of nodes that lie within a given range.
Input
The first line contains two space-separated integers low and high.
Second line contains a single space-separated integer N.
Next line contains N space-separated integer denoting node value of the tree in inorder-traversal manner.
Output
print number of nodes which lies between low to high {both are inclusive}.
Example
Sample Input 1:
4 9
5
3 4 8 9 15

Sample Output 1:
3

Explanation:
the three number lies in the given range [4, 9]
*/
