package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.Traversal;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalIterative {
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
    private void printTreeLevelWise() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            if(temp!=null){
                System.out.print(temp.data+" ");
                if(temp.leftChild!=null){
                    queue.add(temp.leftChild);
                }
                if(temp.rightChild!=null){
                    queue.add(temp.rightChild);
                }
            }else{
                System.out.println();
                if(!queue.isEmpty()){
                queue.add(null);
            }
            }
        }
    }

    private void printTree() { // it is also a level order traversal but output is in single line not by level
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }

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
        LevelOrderTraversalIterative levelOrderTraversalIterative
                = new LevelOrderTraversalIterative();
        System.out.println("Inserting randomNumber in tree:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);  //range -> 0 to 99
            // System.out.println("Inserting " + randomNumber + " in the tree...");
            System.out.print(randomNumber + " ");
            levelOrderTraversalIterative .insertNode(randomNumber);
        }
        System.out.println();
        System.out.println("Current Tree: ");
        //levelOrderTraversalIterative.printTree();
        levelOrderTraversalIterative.printTreeLevelWise();
    }
}
