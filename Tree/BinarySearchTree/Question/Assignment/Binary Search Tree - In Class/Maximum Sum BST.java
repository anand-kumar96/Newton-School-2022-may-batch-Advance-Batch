import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    class TreeNode {
        int data;
        TreeNode  left;
        TreeNode right;
        TreeNode(int data) {
            this.data=data;
        }
        TreeNode(int data, TreeNode left,  TreeNode right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
       int maximumSum = 0;
        TreeNode root;
   class NodeWrapper {
        TreeNode node;
        boolean isdataidBST;
        int minimum;
        int maximum;
        int sum;

        NodeWrapper(TreeNode node) {
            this.node = node;
            this.isdataidBST = true;
            this.minimum = node.data;
            this.maximum = node.data;
            this.sum = node.data;
        }
    }

    private NodeWrapper maxSumBSTHelper(TreeNode currentNode) {
        if(currentNode == null) {
            return null;
        }

        NodeWrapper leftSubtree = maxSumBSTHelper(currentNode.left);
        NodeWrapper rightSubtree = maxSumBSTHelper(currentNode.right);

        NodeWrapper currentNodeWrapper = new NodeWrapper(currentNode);

        if(leftSubtree != null) {
            currentNodeWrapper.isdataidBST = leftSubtree.isdataidBST && currentNode.data > leftSubtree.maximum;
            currentNodeWrapper.minimum = Math.min(leftSubtree.minimum, currentNode.data);
            currentNodeWrapper.maximum = Math.max(leftSubtree.maximum, currentNode.data);
            currentNodeWrapper.sum += leftSubtree.sum;

        }

        if(rightSubtree != null) {
            currentNodeWrapper.isdataidBST =  (currentNodeWrapper.isdataidBST) && (rightSubtree.isdataidBST && currentNode.data < rightSubtree.minimum);
            currentNodeWrapper.minimum = Math.min(currentNodeWrapper.minimum, rightSubtree.minimum);
            currentNodeWrapper.maximum = Math.max(currentNodeWrapper.maximum, rightSubtree.maximum);
            currentNodeWrapper.sum += rightSubtree.sum;
        }

        if(currentNodeWrapper.isdataidBST) {
            maximumSum = Math.max(maximumSum, currentNodeWrapper.sum);
        }

        return currentNodeWrapper;
    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);

        return maximumSum;
    }
    private TreeNode insert(TreeNode currentNode, int data) {
        if(currentNode == null) {
            TreeNode newNode = new TreeNode(data);
            currentNode = newNode;
        }
        else {
            if(data <= currentNode.data) {
                currentNode.left = insert(currentNode.left, data);
            }
            else {
                currentNode.right = insert(currentNode.right, data);
            }
        }

        return currentNode;
    }

    public static void main (String[] args) {
        Main tree=new Main();
         Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            int data=sc.nextInt();
            tree.root=tree.insert(tree.root,data);
        }
        System.out.println(tree.maximumSum);
    }
}

/*
Maximum Sum BST
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the root of Full binary tree, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree.
Input
First line contain root node of tree.

Constraints:
1 <= N <= 103
1 <= node value <= 1000000
Output
Print maximum sum of BST.
Example
Sample Input 1:
7
1 2 3 4 5 6 7

Sample Output 1:
7
*/
