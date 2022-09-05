package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.Traversal;

import java.util.LinkedList;
import java.util.Queue;
public class LevelOrderTraversalRecursive {
   Node rootNode;
    static class Node {  // this should be static
       Node leftChild;
        int data;
       Node rightChild;
        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
           Node rootNode;

        }
    }
// step 01

    private int getHeightOfBinaryTree(Node rootNode){
        if(rootNode==null){
            return -1;
        }
        int lheight=getHeightOfBinaryTree(rootNode.leftChild);
        int rheight=getHeightOfBinaryTree(rootNode.rightChild);
        return (Math.max(lheight,rheight)+1);
    }

    //step 02

    private void printCurrentLevel(Node currNode,int level){
        if(currNode==null){
            return;
        }if(level==0) {
            System.out.print(currNode.data+" ");
        }else{
            printCurrentLevel(currNode.leftChild,level-1);
            printCurrentLevel(currNode.rightChild,level-1);
        }
    }

    // step 03

    private void printTreeRecursiveLevelOrder() {
        int heightOfTree=getHeightOfBinaryTree(rootNode);
        for(int i=0;i<=heightOfTree;i++){
            printCurrentLevel(rootNode,i);
        }
    }

    private void insertNode(int data) {
       Node newNode = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        // first node of tree
        if (rootNode == null) {
            rootNode = newNode;
            return;
        }
        queue.add(rootNode);
        while (!queue.isEmpty()) {
           Node temp = queue.poll();
            if (temp.leftChild == null) {
                temp.leftChild = newNode;
                break;
            } else {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild == null) {
                temp.rightChild = newNode;
                break;
            } else {
                queue.add(temp.rightChild);
            }
        }
    }
    public static void main(String[] args) {
        LevelOrderTraversalRecursive levelOrderTraversalRecursive
                = new LevelOrderTraversalRecursive();
        System.out.println("Inserting randomNumber in tree:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);  //range -> 0 to 99
            System.out.print(randomNumber + " ");
            levelOrderTraversalRecursive.insertNode(randomNumber);
        }
        System.out.println();
        System.out.println("Current Tree: ");
        levelOrderTraversalRecursive.printTreeRecursiveLevelOrder();
    }
}
