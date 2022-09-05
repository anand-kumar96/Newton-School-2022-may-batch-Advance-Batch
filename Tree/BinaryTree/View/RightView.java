package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
   Node rootNode;
    static class Node{  // this should be static
       Node leftChild;
        int data;
       Node rightChild;
        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;

        }
    }
    private void insertNode(int data) {
       Node newNode = new
               Node(data);
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
    private void getRightView(Node rootNode,int levelNumber,List<Integer>rightViewList){
    if(rootNode==null){
        return;
    }
    if(rightViewList.size()==levelNumber){
        rightViewList.add(rootNode.data);
    }
    getRightView(rootNode.rightChild,levelNumber+1,rightViewList);
    getRightView(rootNode.leftChild,levelNumber+1,rightViewList);
    }
    public static void main(String[] args) {
        RightView rightView=new RightView();
        System.out.println("Inserting randomNumber in tree:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);  //range -> 0 to 99
            System.out.print(randomNumber + " ");
            rightView.insertNode(randomNumber);
        }
        System.out.println();
        List<Integer>rightViewList=new ArrayList<>();
        rightView.getRightView(rightView.rootNode,0,rightViewList);  // we can't pass rootNode direct since we are dealing with object
        System.out.println("rightView :"+rightViewList );
    }
}
