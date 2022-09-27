package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.ConstructionOfTreeUsingTraversal;

public class InorderPreorder {
    static int preorderIndex;
    class Node{
        Node leftChild;
        Node rightChild;
        char data;
        Node(char data){
            this.data=data;
            leftChild=rightChild=null;
        }
    }
    public void InoderTraversal(Node root){
        if(root!=null){
            InoderTraversal(root.leftChild);
            System.out.print(root.data+" ");
            InoderTraversal(root.rightChild);
        }
    }

    public void PreoderTraversal(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            PreoderTraversal(root.leftChild);
            PreoderTraversal(root.rightChild);
        }
    }




    public int searchInorder(int inorderStart,int inorderEnd,char[] inorder,char key){
        int position=-1;
        for(int i=inorderStart;i<=inorderEnd;i++){
            if(inorder[i]==key){
                position=i;
                break;
            }
        }
        return position;
    }

    public Node BuildingTreeUsingInorderAndPreorder(int inorderStart,int inorderEnd,char[] inorder,char[]preorder){
        if(inorderStart>inorderEnd){
            return null;
        }
        char currentData=preorder[preorderIndex];
        Node currentNode=new Node(currentData);
        preorderIndex++;
        if(inorderStart==inorderEnd){
            return currentNode;
        }
        int inorderIndex=searchInorder(inorderStart,inorderEnd,inorder,currentData);
        currentNode.leftChild=BuildingTreeUsingInorderAndPreorder(inorderStart,inorderIndex-1,inorder,preorder);
        currentNode.rightChild=BuildingTreeUsingInorderAndPreorder(inorderIndex+1,inorderEnd,inorder,preorder);

    return currentNode;
    }
    public static void main(String[] args) {
        char inorder[] = {'D', 'B', 'E', 'A', 'F', 'C'};
        char preorder[] = {'A', 'B', 'D', 'E', 'C', 'F'};
        int length=inorder.length;
        InorderPreorder inorderPreorder=new InorderPreorder();
        inorderPreorder.preorderIndex=0;
        Node root=inorderPreorder.BuildingTreeUsingInorderAndPreorder(0,length-1,inorder,preorder);
        System.out.println("Inorder Traversal of built tree: ");
        inorderPreorder.InoderTraversal(root);
        System.out.println();
        System.out.println("Preorder Traversal of built tree: ");
        inorderPreorder.PreoderTraversal(root);
    }

}
