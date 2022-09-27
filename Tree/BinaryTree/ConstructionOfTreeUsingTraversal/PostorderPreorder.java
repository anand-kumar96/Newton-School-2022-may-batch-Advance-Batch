package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.ConstructionOfTreeUsingTraversal;

public class PostorderPreorder {
     int  preorderIndex;
    class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }
    public void PreorderTraversal(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            PreorderTraversal(root.leftChild);
            PreorderTraversal(root.rightChild);
        }
    }

    public void PostorderTraversal(Node root){
        if(root!=null){
            PostorderTraversal(root.leftChild);
            PostorderTraversal(root.rightChild);
            System.out.print(root.data+" ");
        }
    }

    public int serachInPostorder(int postorder[],int Start,int End,int key){
        int position=-1;
        for(int i=Start;i<=End;i++){
            if(postorder[i]==key){
                position=i;
                break;
            }
        }
        return position;
    }
    public Node BuildingTreeUsingPostorderAndPreorder(int postorder[],int preorder[],int PostorderStart,int PostorderEnd,int size){
        if(preorderIndex>=size || PostorderStart>PostorderEnd){
            return null;
        }
        int CurrentData=preorder[preorderIndex];
        Node CurrentNode=new Node(CurrentData);
        preorderIndex++;

        if(PostorderStart==PostorderEnd){
            return  CurrentNode;
        }
        int postorderIndex=serachInPostorder(postorder,PostorderStart,PostorderEnd,preorder[preorderIndex]);
        CurrentNode.leftChild=BuildingTreeUsingPostorderAndPreorder(postorder,preorder,PostorderStart,postorderIndex,size);
        CurrentNode.rightChild=BuildingTreeUsingPostorderAndPreorder(postorder, preorder, postorderIndex+1, PostorderEnd-1, size);

        return CurrentNode;
    }
    public static void main(String[] args) {
        int postorder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        int preorder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int length=postorder.length;
        PostorderPreorder postorderPreorder=new PostorderPreorder();
        postorderPreorder.preorderIndex=0;
        Node root=postorderPreorder.BuildingTreeUsingPostorderAndPreorder(postorder,preorder,0,length-1,length);
        System.out.println("Postorder Traversal of built tree: ");
        postorderPreorder.PostorderTraversal(root);

        System.out.println();

        System.out.println("Preorder Traversal of built tree: ");
        postorderPreorder.PreorderTraversal(root);

    }
}


