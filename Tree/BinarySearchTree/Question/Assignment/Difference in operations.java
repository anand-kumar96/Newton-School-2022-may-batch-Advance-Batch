// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static Node root;
    static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
  public static int findMinimum(Node currentNode){
        int min=currentNode.data;
        while(currentNode.left!=null){
            currentNode=currentNode.left;
            min=currentNode.data;
            
        }
        return min;
    }
    public static int findMaximum(Node currentNode){
            int max=currentNode.data;
        while(currentNode.right!=null){
            currentNode=currentNode.right;
            max=currentNode.data;
            
        }
        return max;
    }
    public static Node insert(Node root,int key){
    if(root==null){
        Node newNode=new Node(key);
        root=newNode;
        return newNode;
    }
    if(key<=root.data){
        root.left=insert(root.left,key);
    }else{
        root.right=insert(root.right,key);
    }
      return root;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    Main main=new Main();
    int n=sc.nextInt();
    for(int i=0;i<n;i++){
        int value=sc.nextInt();
       main.root=insert(main.root,value);
    }
    int min=findMinimum(main.root);
    int max=findMaximum(main.root);
    int product=min*max;
    int sum=min+max;
    // System.out.println(min+" "+max); 
   // System.out.println(product+" "+sum); 
    System.out.println(product-sum); 
    }
}

// method 2
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        int value=sc.nextInt();
        if(value<min){
            min=value;
        }
        if(value>max){
            max=value;
        }
    }
    System.out.println((min*max)-(min+max));
    }
}
 /*
 Difference in operations
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the root of a binary search tree. Calculate the difference between the product and sum of minimum and maximum elements of the binary search tree.
Input
Given root of binary search tree.

Constraints:
1<= node value<=100000
Output
print difference between product of minimum and maximum element of BST.
Example
Sample Input 1:
root = 4 2 6 1 3

Sample Output 1:
-1
Explanation: Product of maximum and minimum element is 6 and their sum is 7 so difference between these two is -1.
 */
