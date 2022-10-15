import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
// class Node{
//     int data;
//     Node left;
//     Node right;
//     Node(int data){
//         this.data=data;
//         left=right=null;
//     }
// }
class Main {
//    static Node temp1,temp2,temproot=null;
//     public static void AncestralPath(Node rootNode,int x){
//         if(rootNode!=null){
//             if(rootNode.data==x){
//                 temproot=rootNode;
//                 return;
//             }
//             AncestralPath(rootNode.left,x);
//             AncestralPath(rootNode.right,x);
//         }
//     } 
//     public static void AncestralPathHelper(Node currentNode,int u,int v){
//      AncestralPath(currentNode,u);
//      temp1=temproot;
//      temproot=null;
//       AncestralPath(currentNode,v);
//       temp2=temproot;
//        temproot=null;
//       System.out.println(temp1.data);
//        System.out.println(temp2.data);
//     }
    
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int q=sc.nextInt();
    int arr[]=new int[n+1];
    arr[1]=1;
    for(int i=1;i<=n;i++){
         int l=sc.nextInt();
         int r=sc.nextInt();
         if(l!=-1){
             arr[l]=l+arr[i];
         }
         if(r!=-1){
             arr[r]=r+arr[i];
         }
    }
    for(int i=0;i<q;i++){
        int u=sc.nextInt();
       int v=sc.nextInt();
       System.out.println(arr[u]-arr[v]+v);
    }
    }
}

//     Node leftchild=null,rightchild=null,root=null;
//     HashMap<Integer,Node>hm=new HashMap<>();
//     for(int i=1;i<=n;i++){
//         if(hm.containsKey(i)){
//             root=hm.get(i);
//         }else{
//             root=new Node(i);
//             hm.put(i,root);
//         }
//         int l=sc.nextInt();
//         int r=sc.nextInt();
//         if(l!=-1){
//             if(hm.containsKey(l)){
//                 leftchild=hm.get(l);
//             }else{
//                 leftchild=new Node(l);
//                 root.left=leftchild;
//             }
//             hm.put(l,leftchild);
//         }
//         if(r!=-1){
//             if(hm.containsKey(r)){
//                 rightchild=hm.get(r);
//             }else{
//                 rightchild=new Node(r);
//                 root.right=rightchild;
//             }
//             hm.put(r,rightchild);
//         }

//     }
//     for(int i=0;i<q;i++){
//       int u=sc.nextInt();
//       int v=sc.nextInt();
//       sum=0;
//       if(hm.containsKey(u)){
//          temp1=hm.get(u);
//       }
//       AncestralPathHelper(hm.get(1),);
//     }
    
//     }
// }

/*
Ancestral Path Sum
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree of N nodes, with root 1 and Q queries with nodes u and v. For each query find the sum of nodes on the shortest path from u to v, where node v is the ancestor of node u.
Input
First line contains the integer N and Q, denoting the number of nodes in the binary tree and the number of queries respectively.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'
Next Q lines contain two integers u and v
1 <= N <= 10000
1 <= Q <= 100000
1 <= u, v <= N
Output
Print Q lines denoting the sum of nodes on the shortest path from u to v
Example
Sample Input 1:
6 3
2 4
5 3
-1 -1
-1 -1
6 -1
-1 -1
6 2
3 1
5 5
Sample output 1:
13
6
5

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3
/
6
Query 1: 6+5+2 = 13
Query 2: 3+2+1 = 6
Query 3: 5

*/
