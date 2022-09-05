package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.View;
import java.util.*;

public class TopView {
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
    class Pair{
        Node currentNode;
        int levelNumber;
        Pair(int levelNumber,Node currentNode){
            this.levelNumber=levelNumber;
            this.currentNode=currentNode;
        }
    }
    private void insertNode(int data) {
    Node newNode = new
    Node(data);
    Queue<Node>queue = new LinkedList<>();
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
    private List<Integer>getTopView(){
        List<Integer>topView=new ArrayList<>();
        if(rootNode!=null){
            Map<Integer,Integer>levelMap=new TreeMap<>();
            Queue<Pair>queue=new LinkedList<>();
            queue.add(new Pair(0,rootNode));
            while(!queue.isEmpty()){
                Pair currentPair=queue.poll();
                int levelNumber=currentPair.levelNumber;
                Node currentNode= currentPair.currentNode;
                if(levelMap.get(levelNumber)==null){
                    levelMap.put(levelNumber,currentNode.data);
                }
                if(currentNode.leftChild!=null){
                    queue.add(new Pair(levelNumber-1,currentNode.leftChild));
                }
                if(currentNode.rightChild!=null){
                    queue.add(new Pair(levelNumber+1,currentNode.rightChild));
                }
            }
            for(Map.Entry<Integer, Integer> entry : levelMap.entrySet()) {
                topView.add(entry.getValue());
            }
            System.out.println("Level Map: " + levelMap);
//            for(Integer newKey:levelMap.keySet()){
//                topView.add(levelMap.get(newKey));
//            }
        }
        return topView;
    }
    public static void main(String[] args) {
        TopView topView=new TopView();
        System.out.println("Inserting randomNumber in tree:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);  //range -> 0 to 99
            System.out.print(randomNumber + " ");
            topView.insertNode(randomNumber);
        }
        System.out.println();
        System.out.println("TopView :");
        List<Integer>topViewList=topView.getTopView();
        System.out.println(topViewList);
    }
}
