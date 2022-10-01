
// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

class Node{
    Node left;
    Node right;
    int data;
    Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
    }
class Main {
    public static void main (String[] args) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int q=sc.nextInt();
     Node temp=null;
     Node leftChild=null;
     Node rightChild=null;
     HashMap<Integer,Node>hm=new HashMap<>();
     for(int i=1;i<=n;i++){
         if(hm.containsKey(i)){
             temp=hm.get(i);
         }else{
              temp=new Node(0,null,null);
             hm.put(i,temp);
         }
        int l=sc.nextInt();
        int r=sc.nextInt();
        if(l!=-1){
            if(hm.containsKey(l)){
                leftChild=hm.get(l);
            }else{
                leftChild=new Node(0,null,null);
                 hm.put(l,leftChild);
            }
            temp.left=leftChild;
        }
            if(r!=-1){
            if(hm.containsKey(r)){
                rightChild=hm.get(r);
            }else{
                 rightChild=new Node(0,null,null);
                 hm.put(r,rightChild);
            }
             temp.right=rightChild;
        }
     }
      for(int i=0;i<q;i++){
          int a=sc.nextInt();
          if(a==1){
              int b=sc.nextInt();
              Node ans=hm.get(b);
              int c=sc.nextInt();
              query(ans,c);
          }else{
              int b=sc.nextInt();
              System.out.println(hm.get(b).data);
          }
      }

    }
    public static void query(Node ans,int c){
        if(ans==null){
            return;
        }
         ans.data+=c;
         query(ans.left,c);
         query(ans.right,c);
    }
}


// method 02


import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed

 class Main {
    int leftChild[];
    int rightChild[];
    int data[];

    private void performQuery1(int u, int x) {
        if(u == -1) {
            return;
        }

        data[u] = data[u] + x;
        performQuery1(leftChild[u], x);
        performQuery1(rightChild[u], x);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        main.leftChild = new int[N + 1];
        main.rightChild = new int[N + 1];
        main.data = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            main.leftChild[i] = scanner.nextInt();
            main.rightChild[i] = scanner.nextInt();
        }
        for(int i = 1; i <= Q; i++) {
            int q = scanner.nextInt();
            int u = scanner.nextInt();
            //1 u x - add x to all nodes in subtree of node u
            if(q == 1) {
                int x = scanner.nextInt();
                main.performQuery1(u, x);
            }
            //2 u - print the value of node u
            else {
                System.out.println(main.data[u]);
            }
        }
    }
}

/*
Query on Tree
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree of N nodes with root 1. Initially all nodes have value 0.
You have two type of queries
1 u x - add x to all nodes in subtree of node u
2 u - print the value of node u
Input
First line contains the integer N and Q, denoting the number of nodes in the binary tree and the number of queries respectively.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'
Next Q lines contains queries of two types:
1 u x
2 x
1 <= N, Q <= 5000
1 <= u <= N
1 <= x <= 5000
Output
For each query of type 2 print a single line containing the answer
Example
Sample Input 1:
9 5
2 4
5 3
6 -1
-1 7
-1 -1
-1 -1
9 8
-1 -1
-1 -1
1 2 5
1 1 3
2 7
1 4 2
2 6
Sample output 1:
3
8

Explanation: Given binary tree
1
/ \
2 4
/ \ \
5 3 7
/ / \
6 9 8
Query 1: add all nodes in subtree of 2 with 5
Query 2: add all nodes in subtree of 1 with 3
Query 3: value of node 7 is 3 now
Query 4: add all nodes in subtree of 4 with 2
Query 5: value of node 6 is 8 now
*/
