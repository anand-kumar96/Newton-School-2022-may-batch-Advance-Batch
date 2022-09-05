package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.Traversal;
import java.util.*;
public class PreInPostOrderTraversal {
    Node rootNode;
    static class Node{
        Node leftChild;
        int data;
        Node rightChild;
        Node(int data){
            this.data=data;
            leftChild=rightChild=null;
        }
    }
    // instead of using hashmap use stack pair to reduce space
    class Pair{
        Node CurrentNode;
        int freq;
        Pair(Node CurrentNode,int freq) { // necessary to put both
            this.freq = freq;
            this.CurrentNode=CurrentNode;
        }
    }

    // inserting data

    private void insertNode(int data){
        Node newNode=new Node(data);
        if(rootNode==null){
            rootNode=newNode;
            return;
        }
        Queue<Node>queue=new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            if(temp.leftChild==null){
                temp.leftChild=newNode;
                break;
            }else{
                queue.add(temp.leftChild);
            }
            if(temp.rightChild==null){
                temp.rightChild=newNode;
                break;
            }else{
                queue.add(temp.rightChild);
            }
        }
    }


// all 3 traversal
    private void PreOrderTraversal(Node rootNode,List<Integer>testPreOrderList){
        if(rootNode!=null){
            testPreOrderList.add(rootNode.data);
            PreOrderTraversal(rootNode.leftChild,testPreOrderList);
            PreOrderTraversal(rootNode.rightChild,testPreOrderList);
        }
    }
    private void InOrderTraversal(Node rootNode,List<Integer>testInOrderList){
        if(rootNode!=null) {
            InOrderTraversal(rootNode.leftChild,testInOrderList);
            testInOrderList.add(rootNode.data);
            InOrderTraversal(rootNode.rightChild,testInOrderList);
        }

    }
    private void PostOrderTraversal(Node rootNode,List<Integer>testPostOrderList){
        if(rootNode!=null) {
            PostOrderTraversal(rootNode.leftChild, testPostOrderList);
            PostOrderTraversal(rootNode.rightChild, testPostOrderList);
            testPostOrderList.add(rootNode.data);
        }
    }


// to verify that all 3 order output same or not

   private boolean verifyOutput(List<Integer>testPreOrderList,
                                List<Integer>testInOrderList,
                                List<Integer>testPostOrderList,
                                List<Integer>PreOrderList,
                                List<Integer>InOrderList,
                                List<Integer>PostOrderList){
       PreOrderTraversal(rootNode, testPreOrderList);
       InOrderTraversal(rootNode, testInOrderList);
       PostOrderTraversal(rootNode, testPostOrderList);
       if(testPreOrderList.equals(PreOrderList)
        && testInOrderList.equals(InOrderList)
        && testPostOrderList.equals(PostOrderList)){
            return true;
        }
        return false;
   }

   // logic create stack pair pop and push and add in respective list
    private void getPreInPostOrderTraversal(List<Integer>PreOrderList,
                                            List<Integer>InOrderList,
                                            List<Integer>PostOrderList){
        if(rootNode==null){
            return;
        }
        Stack<Pair>pairStack=new Stack<>();
        pairStack.push(new Pair(rootNode,1));
       while (!pairStack.isEmpty()){
            Pair topPair=pairStack.pop();
            if(topPair.freq==1){
                PreOrderList.add(topPair.CurrentNode.data);
                topPair.freq++;
                pairStack.push(topPair);
                if(topPair.CurrentNode.leftChild!=null){
                    pairStack.push(new Pair(topPair.CurrentNode.leftChild,1));// we have to create new pair to push
                }
            }else if(topPair.freq==2){
                InOrderList.add(topPair.CurrentNode.data);
                topPair.freq++;
                pairStack.push(topPair);
                if( topPair.CurrentNode.rightChild!=null){
                    pairStack.push(new Pair(topPair.CurrentNode.rightChild,1));
                }
            }else{
                PostOrderList.add(topPair.CurrentNode.data);
            }
       }
    }

    public static void main(String[] args) {
        PreInPostOrderTraversal preInPostOrderTraversal=new PreInPostOrderTraversal();
        System.out.println("Inserting number is: ");
        for(int i=0;i<10;i++){
            int randNumber=(int)(Math.random()*100);
            preInPostOrderTraversal.insertNode(randNumber);
            System.out.print(randNumber+" ");
        }
        System.out.println();

        // to store pre,in,post order data
        List<Integer> PreOrderList=new ArrayList<>();
        List<Integer> InOrderList=new ArrayList<>();
        List<Integer> PostOrderList=new ArrayList<>();
        preInPostOrderTraversal.getPreInPostOrderTraversal(PreOrderList,
                                                           InOrderList,
                                                           PostOrderList);

        // to store pre,in,post order data to verify

        List<Integer> testPreOrderList=new ArrayList<>();
        List<Integer> testInOrderList=new ArrayList<>();
        List<Integer> testPostOrderList=new ArrayList<>();

       boolean output= preInPostOrderTraversal.verifyOutput(
                                            testPreOrderList,
                                            testInOrderList,
                                            testPostOrderList,
                                            PreOrderList,
                                            InOrderList,
                                            PostOrderList
                                             );

        if(output){
            System.out.println("test successful: ");
            System.out.println("PreOrder"+PreOrderList);
            System.out.println("InOrder "+InOrderList);
            System.out.println("PostOrder"+PostOrderList);

        }else{
            System.out.println("Test is failed , Error in logic");
        }
    }
}
