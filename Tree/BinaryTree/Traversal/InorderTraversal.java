package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class InorderTraversal {
     Node rootNode;
    static class Node {  // this should be static
        Node leftChild;
        int data;
        Node rightChild;
        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }
    private void printInorder(Node rootNode){
        if(rootNode!=null){
            printInorder(rootNode.leftChild);
            System.out.print(rootNode.data+" ");
            printInorder(rootNode.rightChild);
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
        InorderTraversal inorderTraversal
                = new InorderTraversal();
        System.out.println("Inserting randomNumber in tree:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);  //range -> 0 to 99
            // System.out.println("Inserting " + randomNumber + " in the tree...");
            System.out.print(randomNumber + " ");
            inorderTraversal.insertNode(randomNumber);
        }
        System.out.println();
        System.out.println("Inorder");
        inorderTraversal.printInorder(inorderTraversal.rootNode);// direct rootNode can't pass we have to use object.rootNode

    }
}
