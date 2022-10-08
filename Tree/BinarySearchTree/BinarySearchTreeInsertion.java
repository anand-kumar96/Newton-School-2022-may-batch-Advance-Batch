package com.company.Newton_School.AdvanceDataStructure.Tree.BinarySearch_Tree;

import java.util.Scanner;

public class BinarySearchTreeInsertion {
    Node rootNode;
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    public  static void InorderTraversal(Node currentNode){
        if(currentNode!=null){
           InorderTraversal(currentNode.left);
            System.out.print(currentNode.data+" ");
            InorderTraversal(currentNode.right);
            }
        }
public static Node insert(Node currentNode,int value){
        if(currentNode==null){
            Node newNode=new Node(value);
            currentNode=newNode;
        }else{
            if(value<=currentNode.data){
                currentNode.left=insert(currentNode.left,value);
            }else{
                currentNode.right=insert(currentNode.right,value);
            }
        }
        return currentNode;
}
    public static void main(String[] args) {
        BinarySearchTreeInsertion binarySearchTreeInsertion=new BinarySearchTreeInsertion();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            int value=sc.nextInt();
            binarySearchTreeInsertion.rootNode=binarySearchTreeInsertion.insert(binarySearchTreeInsertion.rootNode,value);
        }
        binarySearchTreeInsertion.InorderTraversal(binarySearchTreeInsertion.rootNode);
    }
}
/*
 input 5

  10 5 20 12 30
  tree:-
         10
      5       20
           12      30


 */