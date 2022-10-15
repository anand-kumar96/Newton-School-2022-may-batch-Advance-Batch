
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

public class Main {
    Node rootNode;
    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private Node insertNode(Node currentNode, int data) {
        if(currentNode == null) {
            Node newNode = new Node(data);
            currentNode = newNode;
        }
        else {
            if(data <= currentNode.data) {
                currentNode.leftChild = insertNode(currentNode.leftChild, data);
            }
            else {
                currentNode.rightChild = insertNode(currentNode.rightChild, data);
            }
        }
        return currentNode;
    }
    private int Main(Node currentRootNode, int low, int high) {
        if(currentRootNode == null) {
            return 0;
        }
        if(currentRootNode.data < low) {
            //go for right subtree only
            return Main(currentRootNode.rightChild, low, high);
        }
        if(currentRootNode.data > high) {
            //go for left subtree only
            return Main(currentRootNode.leftChild, low, high);
        }
        //go for both the left subtree and the right subtree only
        return (1 + Main(currentRootNode.rightChild, low, high)
                + Main(currentRootNode.leftChild, low, high));
    }    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int N = scanner.nextInt();
        Main Main = new Main();
        for(int i = 1; i <= N; i++) {
            int data = scanner.nextInt();
            Main.rootNode = Main.insertNode(Main.rootNode,data);
        }
        int count = Main.Main(Main.rootNode, low, high);
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
