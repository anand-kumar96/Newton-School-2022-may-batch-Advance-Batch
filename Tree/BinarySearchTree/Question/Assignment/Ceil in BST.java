//method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static int ceil;
    Node rootNode;
    static class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int data){
            this.data=data;
            leftChild=rightChild=null;
        }
    }
    public static void inorderTraversal(Node currentNode,int x){
        if(currentNode!=null){
            inorderTraversal(currentNode.leftChild,x);
            if(currentNode.data==x){
                ceil=currentNode.data;
                System.out.println(ceil);
                return;
            }else if(currentNode.data>x){
                ceil=currentNode.data;
                System.out.println(ceil);
                return; 
            }
            inorderTraversal(currentNode.rightChild,x);
        }
    }
    public static Node insertNode(Node currentNode,int data){
        if(currentNode==null){
            Node newNode=new Node(data);
            currentNode=newNode;
            return currentNode;
        }
        if(data<currentNode.data){
            currentNode.leftChild= insertNode(currentNode.leftChild,data);
        }else{
            currentNode.rightChild= insertNode(currentNode.rightChild,data);
        }
        return currentNode;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Main main=new Main();
    for(int i=0;i<n;i++){
        int data=sc.nextInt();
        main.rootNode=insertNode(main.rootNode,data);
    }
    int x=sc.nextInt();
    ceil=-1;
    main.inorderTraversal(main.rootNode,x);
    if(ceil<=-1){
        System.out.println(ceil);
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
    private int getCeilOfBST(Node currentNode, int X) {
        if(currentNode == null) {
            return -1;
        }
        if(currentNode.data == X) {
            return currentNode.data;
        }
        if(currentNode.data < X) {
            return getCeilOfBST(currentNode.rightChild, X);
        }
        int ceilInLeftSubtree = getCeilOfBST(currentNode.leftChild, X);
        return (Math.max(currentNode.data, ceilInLeftSubtree));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Main Main = new Main();
        for(int i = 0; i < N; i++) {
            int data = scanner.nextInt();
            Main.rootNode = Main.insertNode(Main.rootNode, data);
        }
        int X = scanner.nextInt();
        int ceil = Main.getCeilOfBST(Main.rootNode, X);
        System.out.println(ceil);
    }
}

// method 03
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    Node rootNode;
    static class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int data){
            this.data=data;
            leftChild=rightChild=null;
        }
    }
    public static int getCeilofTree(Node currentNode,int x){
    if(currentNode==null){
        return -1;
    }
    if(currentNode.data==x){
        return currentNode.data;
    }if(currentNode.data<x){
     return getCeilofTree(currentNode.rightChild,x);
    }
    int ceildata=getCeilofTree(currentNode.leftChild,x);
     if(currentNode.data>ceildata){
         return currentNode.data;
    }else{
        return ceildata;
    }
    }
    public static Node insertNode(Node currentNode,int data){
        if(currentNode==null){
            Node newNode=new Node(data);
            currentNode=newNode;
            return currentNode;
        }
        if(data<currentNode.data){
            currentNode.leftChild= insertNode(currentNode.leftChild,data);
        }else{
            currentNode.rightChild= insertNode(currentNode.rightChild,data);
        }
        return currentNode;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Main main=new Main();
    for(int i=0;i<n;i++){
        int data=sc.nextInt();
        main.rootNode=insertNode(main.rootNode,data);
    }
    int x=sc.nextInt();
    int ceil=main.getCeilofTree(main.rootNode,x);
    System.out.println(ceil);
    }
}
