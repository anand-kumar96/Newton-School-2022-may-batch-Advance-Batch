import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private void preorderTraversal(Node rootNode) {
        if(rootNode != null) {
            System.out.print(rootNode.data + " ");
            preorderTraversal(rootNode.leftChild);
            preorderTraversal(rootNode.rightChild);
        }
    }

    private int searchInInorder(int inorder[], int inorderStart, int inorderEnd, int key) {
        int position = -1;

        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == key) {
                position = i;
                break;
            }
        }

        return position;
    }

    private Node buildTreeUsingmain(int inorder[], 
                                                   int postorder[],
                                                   int inorderStart,
                                                   int inorderEnd,
                                                   int postorderStart,
                                                   int postorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        int currentRootNodeData = postorder[postorderEnd];
        Node currentRootNode = new Node(currentRootNodeData);

        if(inorderStart == inorderEnd) {
            return currentRootNode;
        }

        int inorderIndex = searchInInorder(inorder, inorderStart, inorderEnd, currentRootNodeData);

        currentRootNode.rightChild = buildTreeUsingmain(inorder, postorder,
                inorderIndex + 1, inorderEnd, postorderEnd - inorderEnd + inorderIndex, postorderEnd - 1);

        currentRootNode.leftChild = buildTreeUsingmain(inorder, postorder,
                inorderStart, inorderIndex - 1, postorderStart, postorderStart - inorderStart + inorderIndex - 1);

        return currentRootNode;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());

        String inorderString[] = bufferedReader.readLine().split(" ");
        String postorderString[] = bufferedReader.readLine().split(" ");

        int inorder[] = new int[N];
        int postorder[] = new int[N];
        
        for(int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(inorderString[i]);
        }

        for(int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(postorderString[i]);
        }
        
        Main main = new Main();

        Node root = main.buildTreeUsingmain(inorder, postorder,
                0, N - 1, 0, N - 1);
        
        main.preorderTraversal(root);
    }
}


/*
Tree from Inorder and Postorder
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given inorder and postorder traversals of a Binary Tree. The task is to construct the binary tree from these traversals. It is given that 1 is the root of the tree.
Input
The first line of input contains a single integer N, denoting the number of nodes in the tree. The next line contains N integers denoting the inorder traversal of the tree. The next line contains N integers denoting the postorder traversal of the tree.

Constraints
1 <= N <= 100000
Output
Print the preorder traversal of the given tree.
Example
Sample Input 1:
8
4 8 2 5 1 6 3 7
8 4 5 2 6 7 3 1

Sample Output 1:
1 2 4 8 5 3 6 7

Explanation:
For the given inorder and postorder traversal, the resultant binary tree will be
1
/ \
2 3
/ \ / \
4 5 6 7
\
8

Sample Input 2:
5
9 5 2 3 4
5 9 3 4 2

Sample Output 2:
2 9 5 4 3

Explanation:
For the given inorder and postorder traversal, the resultant binary tree will be
2
/ \
9 4
\ /
5 3
*/
