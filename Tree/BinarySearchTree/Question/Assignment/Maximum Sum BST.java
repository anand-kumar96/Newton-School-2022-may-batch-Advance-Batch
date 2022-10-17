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
// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static class pair {
        int min;
        int max;
        int val;
         pair(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }
    public static int maxSumBST(Node root) {
        int[] result = {0};
        traverse(root, result);
        return result[0];
    }
    
    private static pair traverse(Node root, int[] result) {
        if (root == null) {
            return new pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        pair left = traverse(root.left, result);
        pair right = traverse(root.right, result);
        if (root.data > left.max && root.data < right.min) {
            int curSum = left.val + right.val + root.data;
            result[0] = Math.max(curSum, result[0]);
            return new pair(Math.min(root.data, left.min), Math.max(root.data, right.max), curSum);
        }
        return new pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void buildTree(int data){
        Node newNode=new Node(data);
          if(root==null){
           root=newNode;
           return;
       } 
       Queue<Node>q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        Node temp=q.poll();
        if(temp.left==null){
            temp.left=newNode;
            break;
        }else{
            q.add(temp.left);
        }
        if(temp.right==null){
            temp.right=newNode;
            break;
        }else{
            q.add(temp.right);
        }
       }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int data=sc.nextInt(); 
           buildTree(data);
        }
        System.out.println(maxSumBST(root));
    }
}

// method 03
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
  
    static class pair {
        int min;
        int max;
        int val;
        public pair(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }
    public static int maxSumBST(Node root) {
        int[] result = {0};
        traverse(root, result);
        return result[0];
    }
    
    private static pair traverse(Node root, int[] result) {
        if (root == null) {
            return new pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        pair left = traverse(root.left, result);
        pair right = traverse(root.right, result);
        if (root.data > left.max && root.data < right.min) {
            int curSum = left.val + right.val + root.data;
            result[0] = Math.max(curSum, result[0]);
            return new pair(Math.min(root.data, left.min), Math.max(root.data, right.max), curSum);
        }
        return new pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    static int count;
    public static void buildTree(int arr[]){
        if(count == 0){
            root = new Node(arr[count]);
            count++;
        }
        int n = arr.length;

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while(count < n-1){
            Node curr = qu.poll();

            if(count <= n-1){
                if(arr[count] != -1){
                    Node newNode = new Node(arr[count]);
                    curr.left = newNode;
                    qu.add(curr.left);
                }
                count++;
            }

            if(count <= n-1){
                if(arr[count] != -1){
                    Node newNode = new Node(arr[count]);
                    curr.right = newNode;
                    qu.add(curr.right);
                }
                count++;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }
        count = 0;
        buildTree(arr);
        System.out.println(maxSumBST(root));
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
