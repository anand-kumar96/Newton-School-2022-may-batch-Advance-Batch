/*
// Information about the class
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
public static Node findLeftMost(Node node){
    while(node.left != null){
        node = node.left;
    }
    return node;
}
public static Node deleteInBST(Node root, int value){
        if(root == null){
            return null;
        }
        if(root.data > value){
            root.left = deleteInBST(root.left, value);
        }
        else if(root.data < value){
            root.right = deleteInBST(root.right, value);
        }
        else{
            // root.data == value
            /*
                1. if root has 2 children
                2. if root has 1 child
                3. if root has no child
            */
            if(root.left != null && root.right != null){
                //2 children case
                //find sucessor
                Node successor = findLeftMost(root.right);
                root.data = successor.data;
                root.right = deleteInBST(root.right, successor.data);
            } 
            else if(root.left != null){
                //1 child case --> Left child
                root = root.left;
            }
            else if(root.right != null){
                //1 child case --> Right Child
                root = root.right;
            }
            else{
                //no child
                root = null;
            }
        }
        return root;
}

/*
Deletion in BST
medium
Problem Statement
Given a Binary Search Tree (BST) and a node x, your task is to delete the node 'x' from the BST.
If no node with value x exists then, do not make any changes
Input
User Task:
Since this will be a functional problem. You don't have to take input. You just have to complete the function deletInBST() that takes "root" node and the value to be deleted as parameter. The printing is done by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 10^3
1 <= node values <= 10^4
1 <= K <= 10^3

Sum of "N" over all testcases does not exceed 10^5
Output
Return the node of BST after deletion.
Example
Input:
2
3
2 1 3 N N N N
2
9
1 N 2 N 8 5 11 4 7 9 12
9

Output:
1 3
1 2 4 5 7 8 11 12

Explanation:-
Fortest1:-
before deletion:-
2
/ \
1 3

after deletion:-
1
\
3
*/
