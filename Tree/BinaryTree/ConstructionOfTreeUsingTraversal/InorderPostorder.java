package com.company.Newton_School.AdvanceDataStructure.Tree.Binary_Tree.ConstructionOfTreeUsingTraversal;

public class InorderPostorder {
    class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }
    public void InorderTraversal(Node root){
        if(root!=null){
            InorderTraversal(root.leftChild);
            System.out.print(root.data+" ");
            InorderTraversal(root.rightChild);
        }
    }

    public void PostorderTraversal(Node root){
        if(root!=null){
            PostorderTraversal(root.leftChild);
            PostorderTraversal(root.rightChild);
            System.out.print(root.data+" ");
        }
    }


public int searchIndex(int inorderStart, int inorderEnd, int inorder[], int key){
        int position=-1;
        for(int i=inorderStart;i<=inorderEnd;i++){
            if(inorder[i]==key){
                position=i;
                break;
            }
        }
        return position;
}


        public Node BuildingTreeUsingInorderAndPostorder(int inorderStart, int inorderEnd,int postorderStart,
                                                         int postorderEnd,int inorder[],int postorder[]){
        if(inorderStart>inorderEnd){
            return null;
        }

        int currentData=postorder[postorderEnd];
        Node currentNode=new Node(currentData);
        if(inorderStart==inorderEnd){
            return currentNode;
        }

        int inorderIndex=searchIndex(inorderStart,inorderEnd,inorder,currentData);

          // only this point is important-->
            /*
            for rightChild--> postStart=postEnd-rightSubtreeLength, postEnd=postEnd-1
            for leftChild--> postStart=postStart, postEnd=postStart-leftSubtreeLength-1
            rightSubtreeLength=inorderIndex-inorderEnd
            leftSubtreeLength=inorderIndex-inorderStart

             */
        currentNode.rightChild=BuildingTreeUsingInorderAndPostorder(inorderIndex+1,inorderEnd,
                postorderEnd-inorderEnd+inorderIndex,postorderEnd-1,inorder,postorder);
        currentNode.leftChild=BuildingTreeUsingInorderAndPostorder(inorderStart,inorderIndex-1,
                    postorderStart,postorderStart-inorderStart+inorderIndex-1,inorder,postorder);

            return currentNode;
        }


    public static void main(String[] args) {
        int inorder[]={4,2,5,1,6,3,7};
        int postorder[]={4,5,2,6,7,3,1};
        int length=inorder.length;
        InorderPostorder inorderPostorder=new InorderPostorder();
        Node root=inorderPostorder.BuildingTreeUsingInorderAndPostorder( 0,length-1,
                                                      0,length-1,inorder,postorder);
        System.out.println("Inorder Traversal of built tree: ");
        inorderPostorder.InorderTraversal(root);

        System.out.println();

        System.out.println("Postorder Traversal of built tree: ");
        inorderPostorder.PostorderTraversal(root);

    }
}
